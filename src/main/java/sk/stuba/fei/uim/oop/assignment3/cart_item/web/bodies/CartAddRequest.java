package sk.stuba.fei.uim.oop.assignment3.cart_item.web.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartAddRequest {
    private Long productId;
    private int amount;

}
