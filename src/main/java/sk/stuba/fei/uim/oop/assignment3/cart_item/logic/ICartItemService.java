package sk.stuba.fei.uim.oop.assignment3.cart_item.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

public interface ICartItemService {
    CartItem getCardItemById(long id) throws NotFoundException;
    void saveCartItem(CartItem cartItem);
}
