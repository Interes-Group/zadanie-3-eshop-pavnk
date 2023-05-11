package sk.stuba.fei.uim.oop.assignment3.cart_item.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductResponse;

@Getter
@Setter
public class CartItemResponse {
    private Long productId;
    private int amount;

    public CartItemResponse(){

    }
    public CartItemResponse(Long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }
}