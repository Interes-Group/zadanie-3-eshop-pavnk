package sk.stuba.fei.uim.oop.assignment3.cart_item.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.ICartItemRepository;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private ICartItemRepository repository;
    public CartItemService(ICartItemRepository repository) {
        this.repository = repository;
    }
    @Override
    public void saveCartItem(CartItem cartItem) {
        this.repository.save(cartItem);
    }
}
