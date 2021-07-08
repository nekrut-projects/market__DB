package ru.gb.market.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.market.model.Factory;
import ru.gb.market.model.Product;

import java.util.List;

@Component
public class ProductDao {
    private Factory factory;

    @Autowired
    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Product findById(long id){
        try(Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.find(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll(){
        try(Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }

    }
    public void deleteById(long id){
        try(Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Product product) {
        try(Session session = factory.getSession()) {
            session.beginTransaction();
            if (product.getId() == 0) {
                session.save(product);
            } else {
                session.saveOrUpdate(product);
            }
            session.getTransaction().commit();
        }
    }
}
