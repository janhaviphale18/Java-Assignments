CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(50),
    quantity INT,
    price DOUBLE
);

INSERT IGNORE INTO products VALUES
(101, 'Laptop', 10, 55000),
(102, 'Mouse', 25, 500),
(103, 'Keyboard', 15, 1200),
(104, 'Monitor', 8, 12000);

SELECT * FROM products;