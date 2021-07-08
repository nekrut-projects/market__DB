package ru.gb.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.market.repositories.ProductRepository;
import ru.gb.market.model.Product;
import ru.gb.market.services.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/add_form")
    public String getAddForm(){
        return "add_form";
    }

    @PostMapping(value = "/add")
    public String addProduct(@RequestParam String title, @RequestParam int price){
        productService.addProduct(title, price);
        return "redirect:/add_form";
    }

    @PostMapping(value = "/del_product")
    public String delProduct(@RequestParam long id){
        productService.deleteProductById(id);
        return "redirect:/";
    }
}
