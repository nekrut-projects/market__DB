package ru.gb.market.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Factory {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init(){
        sessionFactory = new Configuration()
                .configure("configs/market.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void shutdown(){
        sessionFactory.close();
    }
}
