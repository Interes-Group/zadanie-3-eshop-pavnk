package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.cart_item.data.CartItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<CartItem> shoppingList;

    private boolean payed;

    public Cart(){
        this.shoppingList = new ArrayList<>();
    }
}
