
DELETE FROM db_product.user;

INSERT INTO db_product.user (id, email, first_name, last_name, password)
VALUES (1, 'lucas@admin', 'Lucas', 'Barros', '123'),
       (2, 'felipe@admin', 'Felipe', 'Rodrigues', '234'),
       (3, 'raul@admin', 'Raul', 'Sanches', '345');

DELETE FROM db_product.address;

INSERT INTO db_product.address (id, street, zip, city, user_id)
VALUES (1, '1000 N 4th Str', '52557', 'Fairfield', 1),
       (2, '2000 N 5th Str', '52557', 'Itapeva', 2),
       (3, '3000 N 6th Str', '52557', 'Des Moines', 3);

DELETE FROM db_product.category;

INSERT INTO db_product.category (id, name)
VALUES (1, 'Gas'),
       (2, 'Liquid'),
       (3, 'Solid');

DELETE FROM db_product.product;

INSERT INTO db_product.product (id, price, rating, category_id, name)
VALUES (1, 5, 4, 1, 'Deodorant'),
       (2, 9.9, 3.5, 2, 'Soda'),
       (3, 45, 2, 2, 'Water'),
       (4, 19.9, 3, 3, 'Snack'),
       (5, 7, 4.5, 1, 'Air');

DELETE FROM db_product.review;

INSERT INTO db_product.review (id, product_id, user_id, comment)
VALUES (1, 1, 1, 'Very good!'),
       (2, 1, 2, 'Not so good.'),
       (3, 2, 3, 'This soda tastes awesome'),
       (4, 3, 3, 'I returned the bottle of water when I used it'),
       (5, 3, 1, 'The water does not taste so good')