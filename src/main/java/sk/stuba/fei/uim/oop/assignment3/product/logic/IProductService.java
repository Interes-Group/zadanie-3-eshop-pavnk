package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;


import java.util.List;

public interface IProductService {
    Product create(ProductRequest request) throws NotFoundException;
    List<Product> getAllProducts();
    Product getByProductId(long id) throws NotFoundException;
    Product update(long id, ProductRequest request) throws NotFoundException;
    void delete(long id) throws NotFoundException;
    int getAmount(long id) throws NotFoundException;
    int addAmount(long id, int addedNumber) throws NotFoundException;
}
