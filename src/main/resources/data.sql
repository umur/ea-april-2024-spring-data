INSERT INTO address (street, zip, city) VALUES ('123 Main St', '12345', 'Springfield');
INSERT INTO address (street, zip, city) VALUES ('456 Elm St', '67890', 'Shelby ville');

INSERT INTO user (first_name, last_name, email, password, address_id) VALUES ('John', 'Doe', 'john.doe@example.com', 'password', 1);
INSERT INTO user (first_name, last_name, email, password, address_id) VALUES ('Jane', 'Doe', 'jane.doe@example.com', 'password', 2);

INSERT INTO category (name) VALUES ('Electronics');
INSERT INTO category (name) VALUES ('Books');
INSERT INTO category (name) VALUES ('Cat');

INSERT INTO product (name, price, rating, category_id) VALUES ('iPhone', 699.99, '4.5', 1);
INSERT INTO product (name, price, rating, category_id) VALUES ('Harry Potter', 19.99, '4.8', 2);
INSERT INTO product (name, price, rating, category_id) VALUES ('Russian Blue', 1000.00, '5.0', 3);
INSERT INTO product (name, price, rating, category_id) VALUES ('British Shorthair', 2000.00, '5.0', 3);

INSERT INTO review (comment, reviewed_product_id, submitted_user_id) VALUES ('Great product!', 1, 1);
INSERT INTO review (comment, reviewed_product_id, submitted_user_id) VALUES ('Loved this book!', 2, 2);
INSERT INTO review (comment, reviewed_product_id, submitted_user_id) VALUES ('I love this cat so much.', 4, 1);