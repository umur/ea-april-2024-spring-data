use lab3;
INSERT INTO lab3.category (id, name) VALUES (1, 'Food');
INSERT INTO lab3.category (id, name) VALUES (2, 'Beverage');

INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (4.99, 9.00, 1, 1, 'Pizza');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (1.99, 9.00, 1, 2, 'Hot dog');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (17.89, 9.00, 1, 3, 'Burger');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (8.99, 9.00, 1, 4, 'Pasta');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (15.99, 9.00, 1, 5, 'Chicken Nuggets');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (6.49, 9.00, 1, 6, 'Sausage');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (4.99, 9.00, 1, 7, 'Cheese');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (24.99, 9.00, 1, 8, 'Lasagna');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (2.99, 9.00, 2, 9, 'Fresh Milk');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (4.99, 9.00, 2, 10, 'Organic Milk');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (2.99, 9.00, 2, 11, 'Chocolate Milk');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (12.99, 9.00, 2, 12, 'Pepsi');
INSERT INTO lab3.product (price, rating, category_id, id, name) VALUES (6.99, 9.00, 2, 13, 'Water');

INSERT INTO lab3.address (id, street, city, zip) VALUES (1, '304 W Hempstead ave', 'Fairfield', '52556');
INSERT INTO lab3.address (id, street, city, zip) VALUES (2, '1000 N 4th Street', 'Fairfield', '52557');

INSERT INTO lab3.user (id, email, password, first_name, last_name, address_id) VALUES
    (1, 'user1@test.com', '1234', 'User', 'One', 1),
    (2, 'user2@test.com', '1234', 'User', 'Two', 2);

INSERT INTO review (id, id_user, id_product, comment) VALUES (1, 1, 1, 'Yummy');
INSERT INTO review (id, id_user, id_product, comment) VALUES (2, 1, 2, 'Must Try');
INSERT INTO review (id, id_user, id_product, comment) VALUES (3, 1, 3, 'Die die must try');
INSERT INTO review (id, id_user, id_product, comment) VALUES (4, 2, 1, 'Not bad');
