package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductIdAmountRequest;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService service;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addList(){
        return new ResponseEntity<>(new CartResponse(this.service.create()), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse getCart(@PathVariable("id") long cartId) throws NotFoundException {
        return new CartResponse(this.service.getById(cartId));
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long cartId) throws NotFoundException {
        this.service.delete(cartId);
    }
    @PostMapping(value = "/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse addToCart(@PathVariable("id") Long cartId, @RequestBody ProductIdAmountRequest body) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addToCart(cartId,body));
    }

}
