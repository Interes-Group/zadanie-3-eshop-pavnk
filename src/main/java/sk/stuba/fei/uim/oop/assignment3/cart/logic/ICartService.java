package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductIdAmountRequest;

public interface ICartService {
    Cart create();
    Cart getById(long id) throws NotFoundException;
    void delete(long id) throws NotFoundException;
    Cart addToCart(long id, ProductIdAmountRequest body) throws NotFoundException, IllegalOperationException;
}
