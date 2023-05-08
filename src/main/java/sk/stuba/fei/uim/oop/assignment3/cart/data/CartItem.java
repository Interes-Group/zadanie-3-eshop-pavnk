package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private long productId;
    private int amount;

    public void increaseAmount(int increasedAmount) {
        this.amount += increasedAmount;
    }

    public void decreaseAmount(int decreasedAmount) {
        this.amount -= decreasedAmount;
        if (amount < 0) {
            amount = 0;
        }
    }
}