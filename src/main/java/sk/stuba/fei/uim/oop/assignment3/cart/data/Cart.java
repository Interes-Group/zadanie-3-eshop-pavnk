package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Product> shoppingList;

    private boolean payed;

    public Cart(){
        this.shoppingList = new ArrayList<>();
    }
}
