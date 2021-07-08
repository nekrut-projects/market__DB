package ru.gb.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.market.model.Cart;
import ru.gb.market.model.Product;

import java.util.List;

@Service
public class CartService {
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getContentsCart() {
        return cart.getSelectedProducts();
    }

    public void deleteProductById(long id) {
        cart.deleteProduct(cart.getProductById(id));
    }

    public void addProduct(Product product) {
        cart.addProduct(product);
    }
}
