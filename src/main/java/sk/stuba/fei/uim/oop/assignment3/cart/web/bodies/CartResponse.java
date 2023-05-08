package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CartResponse {
    private long id;
    private List<ProductResponse> shoppingCart;
    private boolean payed;

    public CartResponse(Cart cart){
        //TODO create schema to return product ID and Amount
        this.id = cart.getId();
        this.shoppingCart = cart.getShoppingList().stream().map(ProductResponse::new).collect(Collectors.toList());
        this.payed = cart.isPayed();
    }
}