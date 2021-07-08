package ru.gb.market.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class Cart {
    private List<Product> selectedProducts;

    public Product getProductById(long id) {
        for (Product p: selectedProducts) {
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Not found product by this ID");
    }

    public void addProduct(Product product){
        selectedProducts.add(product);
    }

    public List<Product> getSelectedProducts() {
        return Collections.unmodifiableList(selectedProducts);
    }

    @PostConstruct
    public void init() {
        this.selectedProducts = new ArrayList<>();
    }

    public void deleteProduct(Product product) {
        selectedProducts.remove(product);
    }
}
