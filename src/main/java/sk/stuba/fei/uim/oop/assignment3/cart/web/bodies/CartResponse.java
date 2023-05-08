package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CartResponse {
    private long id;
    private List<CartItemResponse> shoppingCart;
    private boolean payed;

    public CartResponse(Cart cart){
        this.id = cart.getId();
        //TODO
        //this.shoppingCart = convertToCartItemResponses(cart.getShoppingList());
        this.payed = cart.isPayed();
    }

}