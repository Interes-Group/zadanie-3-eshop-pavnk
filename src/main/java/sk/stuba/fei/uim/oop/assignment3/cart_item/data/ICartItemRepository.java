package sk.stuba.fei.uim.oop.assignment3.cart_item.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import java.util.List;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findCartItemById(Long id);
    List<CartItem> findAll();
}
