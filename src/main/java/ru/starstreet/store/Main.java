package ru.starstreet.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.starstreet.store");
        StoreDaoService service = context.getBean(StoreDaoService.class);

        System.out.println(service.getProductListByCustomerId(1L));

        System.out.println(service.getCustomerListByProductId(2L));
    }
}
