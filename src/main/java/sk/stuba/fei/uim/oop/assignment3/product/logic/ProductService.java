package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;


import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public Product create(ProductRequest request) throws NotFoundException {
        return this.repository.save(new Product(request));
    }
    @Override
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }
    @Override
    public Product getByProductId(long id) throws NotFoundException {
        Product p = this.repository.findProductById(id);
        if(p == null){
            throw new NotFoundException();
        }
        return p;
    }
    @Override
    public Product update(long id, ProductRequest request) throws NotFoundException {
        Product p = this.getByProductId(id);
        if(request.getName() != null){
            p.setName(request.getName());
        }
        if(request.getDescription() != null){
            p.setDescription(request.getDescription());
        }
        return this.repository.save(p);
    }
    @Override
    public void delete(long id) throws NotFoundException {
        Product b = this.getByProductId(id);
        this.repository.delete(b);
    }
    @Override
    public int getAmount(long id) throws NotFoundException {
        return this.getByProductId(id).getAmount();
    }
    @Override
    public int addAmount(long id, int addedNumber) throws NotFoundException {
        Product p = this.getByProductId(id);
        p.setAmount(p.getAmount() + addedNumber);
        this.repository.save(p);
        return p.getAmount();
    }
}
