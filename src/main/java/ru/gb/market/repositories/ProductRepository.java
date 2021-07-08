package ru.gb.market.repositories;

import org.springframework.stereotype.Component;
import ru.gb.market.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void init(){
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(int id){
        for (Product p : products) {
            if (id == p.getId()) {
                return p;
            }
        }
        throw new RuntimeException();
    }

    public void addProduct(String title, int price) {
        int id = products.size();
        products.add(new Product(id + 1, title, price));
    }
}
