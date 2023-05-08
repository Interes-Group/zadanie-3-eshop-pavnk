package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductIdAmountRequest;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository repository;
    @Autowired
    private IProductService productService;
    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }
    @Override
    public Cart getById(long id) throws NotFoundException {
        Cart c = this.repository.findCartById(id);
        if(c == null) {
            throw new NotFoundException();
        }
        return c;
    }
    @Override
    public void delete(long id) throws NotFoundException {
        this.repository.delete(this.getById(id));
    }
    @Override
    public Cart addToCart(long id, ProductIdAmountRequest body) throws NotFoundException, IllegalOperationException {
        Cart c = this.getIfNotPayed(id);
        Product p = this.productService.getByProductId(body.getProductId());
        if(p.getAmount() == 0){
            throw new IllegalOperationException();
        }
        if(!c.getShoppingList().contains(p)){
            c.getShoppingList().add(p);
        } else {
            p.setAmount(p.getAmount()-body.getAmount());
        }
        return this.repository.save(c);
    }
    private Cart getIfNotPayed(long id) throws NotFoundException, IllegalOperationException {
        Cart c = this.getById(id);
        if (c.isPayed()) {
            throw new IllegalOperationException();
        }
        return c;
    }
}
