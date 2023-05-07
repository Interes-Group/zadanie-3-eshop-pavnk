package sk.stuba.fei.uim.oop.assignment3.product.logic;

import javassist.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

public interface IProductService {
    Product create(ProductRequest request) throws NotFoundException;
}
