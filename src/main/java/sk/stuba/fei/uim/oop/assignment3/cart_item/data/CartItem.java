package sk.stuba.fei.uim.oop.assignment3.cart_item.data;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import javax.persistence.*;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int amount;
}