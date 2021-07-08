package ru.gb.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.market.services.CartService;
import ru.gb.market.services.ProductService;

@Controller
public class MainController {
    private ProductService productService;
    private CartService cartService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String showMainPage(Model model){
        model.addAttribute("products", productService.findAllProducts());
        return "index";
    }
}
