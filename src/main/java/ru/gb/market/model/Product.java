package ru.gb.market.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Product() {
    }

    public Product(long id, String title, int price) {
        this.title = title;
        this.id = id;
        this.price = price;
    }

    public Product(String title, int price) {
        this.title = title;
        this.id = 0;
        this.price = price;
    }
}
