package sk.stuba.fei.uim.oop.assignment3.product.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

@Getter
public class ProductIdAmountResponse {
    private final long productId;
    private final int amount;

    public ProductIdAmountResponse(Product p){
        this.productId = p.getId();
        this.amount = p.getAmount();
    }
}
