DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS customers;

CREATE TABLE products(id long AUTO_INCREMENT PRIMARY KEY, name  VARCHAR(50),  price int);
INSERT INTO products(name, price) VALUES ('Milk', 50), ('Bread', 100), ('Ice cream', 70);

CREATE TABLE customers( id long AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50));
INSERT INTO customers(name)VALUES ('Penny'),('Howard'),('Leonard');

CREATE TABLE orders(id long AUTO_INCREMENT PRIMARY KEY,product_id  BIGINT,customer_id BIGINT,price int,FOREIGN KEY (product_id) REFERENCES products (id),    FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO orders(product_id, customer_id, price)VALUES (1, 1, 50),(2, 1, 100),(3, 1, 70),(1, 2, 50),(3, 2, 70),(2, 3, 100);