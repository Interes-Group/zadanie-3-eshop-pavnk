package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

@Getter
@Setter
public class CartItemResponse {
    private long productId;
    private int amount;

    public CartItemResponse(CartItem cartItem) {
        this.productId = cartItem.getProductId();
        this.amount = cartItem.getAmount();
    }
}