package ru.starstreet.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SessionFactoryUtils {
    private SessionFactory factory;

    @PostConstruct
    public void init(){
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
    @PreDestroy
    public void close(){
        if (factory != null){
            factory.close();
        }
    }
    public Session getSession(){
        return factory.getCurrentSession();
    }
}
