package sk.stuba.fei.uim.oop.assignment3.cart_item.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.ICartItemRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private ICartItemRepository repository;
    public CartItemService(ICartItemRepository repository) {
        this.repository = repository;
    }
    @Override
    public CartItem getCardItemById(long id) throws NotFoundException {
        CartItem i = this.repository.findCartItemById(id);
        if(i == null){
            throw new NotFoundException();
        }
        return i;
    }

    @Override
    public void saveCartItem(CartItem cartItem) {
        this.repository.save(cartItem);
    }
}
