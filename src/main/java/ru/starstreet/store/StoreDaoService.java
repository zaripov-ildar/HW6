package ru.starstreet.store;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreDaoService implements iStoreDao {
    private SessionFactoryUtils service;

    @Autowired
    public void setService(SessionFactoryUtils service) {
        this.service = service;
    }

    @Override
    public List<Product> getProductListByCustomerId(Long customer_id) {
        try (Session session = service.getSession()) {
            session.beginTransaction();
            List<Product> products = session.get(Customer.class, customer_id)
                    .getOrders()
                    .stream()
                    .map(Order::getProduct)
                    .toList();

//            List<Product> products = session.createQuery("from Product p " +
//                            "where p.id in (select o.product.id from Order o  where o.customer.id = :id)")
//                    .setParameter("id", customer_id).getResultList();


            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Customer> getCustomerListByProductId(Long product_id) {
        try (Session session = service.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.get(Product.class, product_id)
                    .getOrders()
                    .stream()
                    .map(Order::getCustomer)
                    .toList();
            session.getTransaction().commit();
            return customers;
        }
    }
}
