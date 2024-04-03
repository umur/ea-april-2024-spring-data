INSERT INTO address(street, city, zip) VALUES ('1000 N 4th', 'FF', '55275');
INSERT INTO address(street, city, zip) VALUES ('831 8th', 'FF', '55275');

INSERT INTO category(name) VALUES ('Electric');
INSERT INTO category(name) VALUES ('Wood');

INSERT INTO product(name, price, rating, category_id) VALUES ("AAA", 100.0, 5, 1);
INSERT INTO product(name, price, rating, category_id) VALUES ("BBB", 190, 4, 2);
INSERT INTO product(name, price, rating, category_id) VALUES ("B test", 150, 3, 2);

INSERT INTO `user` (`address_id`, `id`, `email`, `first_name`, `last_name`, `password`) VALUES ('1', '1', 'test@gmail.com', 'A', 'B', '123');
INSERT INTO `user` (`address_id`, `id`, `email`, `first_name`, `last_name`, `password`) VALUES ('2', '2', 'test2@gmail.com', 'test2', 'B', '456');

INSERT INTO `review` (`id`, `product_id`, `user_id`, `comment`) VALUES ('1', '1', '1', 'Good');
INSERT INTO `review` (`id`, `product_id`, `user_id`, `comment`) VALUES ('2', '1', '1', 'Interesting');
INSERT INTO `review` (`id`, `product_id`, `user_id`, `comment`) VALUES ('3', '2', '2', 'Not bad');
