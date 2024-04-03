-- Inserting Categories
INSERT INTO category (name) VALUES ('Electronics');
INSERT INTO category (name) VALUES ('Books');
INSERT INTO category (name) VALUES ('Home Appliances');

-- Inserting Products
-- Assuming the categories Electronics, Books, and Home Appliances have IDs 1, 2, and 3 respectively.
INSERT INTO product (name, price, rating, category_id) VALUES ('Laptop', 999.99, 5, 1);
INSERT INTO product (name, price, rating, category_id) VALUES ('E-Reader', 129.99, 4, 2);
INSERT INTO product (name, price, rating, category_id) VALUES ('Microwave', 89.99, 4, 3);

-- Inserting Users
INSERT INTO user (email, password, first_name, last_name) VALUES ('john.doe@example.com', 'password123', 'John', 'Doe');
INSERT INTO user (email, password, first_name, last_name) VALUES ('jane.doe@example.com', 'password123', 'Jane', 'Doe');

-- Inserting Addresses
-- Assuming the users John Doe and Jane Doe have IDs 1 and 2 respectively.
INSERT INTO address (street, zip, city, id) VALUES ('123 Main St', '12345', 'Anytown', 1);
INSERT INTO address (street, zip, city, id) VALUES ('456 Elm St', '54321', 'Anycity', 2);

-- Inserting Reviews
-- Assuming the products Laptop, E-Reader, and Microwave have IDs 1, 2, and 3 respectively.
-- Assuming the users John Doe and Jane Doe have IDs 1 and 2 respectively.
INSERT INTO review (comment, user_id, product_id) VALUES ('Great laptop!', 1, 1);
INSERT INTO review (comment, user_id, product_id) VALUES ('Love my E-Reader for daily reading.', 2, 2);
