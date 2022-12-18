package ru.starstreet.store;

import java.util.List;

public interface iStoreDao {
    List<Product> getProductListByCustomerId(Long customer_id);
    List<Customer> getCustomerListByProductId(Long prod_id);
}
