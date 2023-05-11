package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart_item.logic.ICartItemService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartAddRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

import java.util.Objects;


@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository repository;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICartItemService cartItemService;
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
    public Cart addToCart(long id, CartAddRequest body) throws NotFoundException, IllegalOperationException {
        Cart c = this.getIfNotPayed(id);
        Product p = this.productService.getByProductId(body.getProductId());
        boolean itemExists = false;
        CartItem i = null;
        for (CartItem cartItem : c.getShoppingList()) {
            if (Objects.equals(cartItem.getProduct().getId(), body.getProductId())) {
                itemExists = true;
                i = cartItem;
                break;
            }
        }
        if (itemExists) {
            if(p.getAmount()<body.getAmount()){
                throw new IllegalOperationException();
            } else {
                i.setAmount(i.getAmount()+ body.getAmount());
                p.setAmount(p.getAmount()- body.getAmount());
                this.cartItemService.saveCartItem(i);
                this.productService.saveProduct(p);
            }
        } else {
            if(p.getAmount()<body.getAmount()){
                throw new IllegalOperationException();
            } else {
                CartItem newCartItem = new CartItem();
                newCartItem.setProduct(p);
                newCartItem.setAmount(body.getAmount());
                p.setAmount(p.getAmount()- body.getAmount());
                this.productService.saveProduct(p);
                c.getShoppingList().add(newCartItem);
                this.cartItemService.saveCartItem(newCartItem);
            }
        }

        return this.repository.save(c);
    }

    @Override
    public double payCart(long id) throws NotFoundException, IllegalOperationException {
        Cart cart = getIfNotPayed(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }
        cart.setPayed(true);
        repository.save(cart);

        return calculateCartPrice(cart);
    }
    private double calculateCartPrice(Cart cart) {
        double totalPrice = 0.0;
        for (CartItem cartItem : cart.getShoppingList()) {
            double productPrice = cartItem.getProduct().getPrice();
            int quantity = cartItem.getAmount();
            totalPrice += productPrice * quantity;
        }
        return totalPrice;
    }
    private Cart getIfNotPayed(long id) throws NotFoundException, IllegalOperationException {
        Cart c = this.getById(id);
        if (c.isPayed()) {
            throw new IllegalOperationException();
        }
        return c;
    }
}
