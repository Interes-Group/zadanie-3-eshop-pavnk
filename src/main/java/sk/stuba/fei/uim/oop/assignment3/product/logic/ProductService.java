package sk.stuba.fei.uim.oop.assignment3.product.logic;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;
    @Override
    public Product create(ProductRequest request) throws NotFoundException {
        return this.repository.save(new Product(request));
    }

}
