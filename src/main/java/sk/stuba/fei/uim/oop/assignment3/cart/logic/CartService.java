package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository repository;

    @Autowired
    private ICartService cartService;

    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }
}
