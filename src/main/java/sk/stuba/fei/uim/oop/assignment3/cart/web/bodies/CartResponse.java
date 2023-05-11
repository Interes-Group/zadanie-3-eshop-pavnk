package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart_item.web.bodies.CartItemResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CartResponse {
    private long id;
    private List<CartItemResponse> shoppingList;
    private boolean payed;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = convertToCartItemResponses(cart.getShoppingList());
        this.payed = cart.isPayed();
    }

    private List<CartItemResponse> convertToCartItemResponses(List<CartItem> cartItems) {
        List<CartItemResponse> itemResponses = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            CartItemResponse cartItemResponse = new CartItemResponse(cartItem.getProduct().getId(), cartItem.getAmount());
            itemResponses.add(cartItemResponse);
        }
        return itemResponses;
    }
}