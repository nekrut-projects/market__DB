DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Product_1', 100), ('Product_2', 20), ('Product_3', 440),
                                           ('Product_4', 78), ('Product_5', 12), ('Product_6', 2);
