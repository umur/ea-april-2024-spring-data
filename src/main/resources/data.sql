INSERT INTO category (id, name) VALUES (1, 'Electronics');
INSERT INTO category (id, name) VALUES (2, 'Clothing');

INSERT INTO product (id, name, price, rating, category_id) VALUES (1, 'Laptop', 1000.00, 4.5, 1);
INSERT INTO product (id, name, price, rating, category_id) VALUES (2, 'T-shirt', 20.00, 3.8, 2);

INSERT INTO user (id, email, password, first_name, last_name) VALUES (1, 'user1@example.com', 'password123', 'John', 'Doe');
INSERT INTO user (id, email, password, first_name, last_name) VALUES (2, 'user2@example.com', 'secret456', 'Jane', 'Smith');

INSERT INTO address (id, street, zip, city, user_id) VALUES (1, '123 Main St', '12345', 'New York', 1);
INSERT INTO address (id, street, zip, city, user_id) VALUES (2, '456 Elm St', '67890', 'Los Angeles', 2);

INSERT INTO review (id, comment, user_id, product_id) VALUES (1, 'Great product!', 1, 1);
INSERT INTO review (id, comment, user_id, product_id) VALUES (2, 'Nice fit.', 2, 2);

