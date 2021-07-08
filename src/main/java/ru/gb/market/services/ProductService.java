package ru.gb.market.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.market.model.Product;
import ru.gb.market.repositories.ProductDao;
import ru.gb.market.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    public void addProduct(String title, int price) {
        productDao.saveOrUpdate(new Product(title, price));
    }

    public void addProduct(long id, String title, int price) {
        productDao.saveOrUpdate(new Product(id, title, price));
    }

    public Product findProductById(long id) {
        return productDao.findById(id);
    }

    public void deleteProductById(long id) {
        productDao.deleteById(id);
    }
}
