INSERT INTO user (id, password, email, first_name, last_name) VALUES (1, '1', 'sonny@miu', 'Sonny', 'Truong');
INSERT INTO user (id, password, email, first_name, last_name) VALUES (2, '2', 'katty@miu.com', 'Katty', 'Do');

INSERT INTO category (id, name) VALUES (1, 'Groceries');
INSERT INTO category (id, name) VALUES (2, 'Electronics');
INSERT INTO category (id, name) VALUES (3, 'Clothing');

INSERT INTO product (id, name, price, rating, category_id) VALUES (1, 'Apple', 1.99, 4.8, 1);
INSERT INTO product (id, name, price, rating, category_id) VALUES (2, 'Grape', 2.99, 4.0, 1);
INSERT INTO product (id, name, price, rating, category_id) VALUES (3, 'Smartphone', 699.99, 4.5, 2);
INSERT INTO product (id, name, price, rating, category_id) VALUES (4, 'Laptop', 1299.99, 4.8, 2);
INSERT INTO product (id, name, price, rating, category_id) VALUES (5, 'T-shirt', 19.99, 4.2, 3);
INSERT INTO product (id, name, price, rating, category_id) VALUES (6, 'Jeans', 39.99, 4.0, 3);

INSERT INTO review (id, comment, product_id) VALUES (1, 'Fresh Apple', 1);
INSERT INTO review (id, comment, product_id) VALUES (2, 'Sweet Grape', 2);
INSERT INTO review (id, comment, product_id) VALUES (3, 'Great smartphone!', 3);
INSERT INTO review (id, comment, product_id) VALUES (4, 'Love this laptop!', 4);
INSERT INTO review (id, comment, product_id) VALUES (5, 'Nice fit and comfortable.', 5);
INSERT INTO review (id, comment, product_id) VALUES (6, 'Good quality jeans.', 6);

INSERT INTO address (id, street, city, zip) VALUES (1, '1000 N 4th St', 'Fairfield', '52557');
INSERT INTO address (id, street, city, zip) VALUES (2, '123 Main St', 'Ottumwa', '67890');

UPDATE user SET address_id = 1 WHERE id = 1;
UPDATE user SET address_id = 2 WHERE id = 2;
