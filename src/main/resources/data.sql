-- Sample data for Address
INSERT INTO address (id, street, zip, City) VALUES
                                                (1, '123 Main St', 12345, 'City1'),
                                                (2, '456 Elm St', 54321, 'City2'),
                                                (3, '789 Oak St', 67890, 'City3'),
                                                (4, '101 Pine St', 13579, 'City4'),
                                                (5, '202 Maple St', 97531, 'City5');

-- Sample data for Category
INSERT INTO category (id, name) VALUES
                                    (1, 'Electronics'),
                                    (2, 'Clothing'),
                                    (3, 'Books'),
                                    (4, 'Furniture'),
                                    (5, 'Toys');

-- Sample data for Product
INSERT INTO product (id, name, price, rating, category_id) VALUES
                                                               (1, 'Laptop', 999.99, 4.5, 1),
                                                               (2, 'T-shirt', 19.99, 4.2, 2),
                                                               (3, 'Novel', 12.99, 4.7, 3),
                                                               (4, 'Sofa', 799.99, 4.0, 4),
                                                               (5, 'Action Figure', 14.99, 4.8, 5);

-- Sample data for Review
-- INSERT INTO review (id, comment) VALUES
--                                      (1, 'Great product!'),
--                                      (2, 'Not as expected.'),
--                                      (3, 'Highly recommended.'),
--                                      (4, 'Very comfortable.'),
--                                      (5, 'Kids love it.');

-- Sample data for User
INSERT INTO user (id, firstname, lastname, email, password, address_id) VALUES
                                                                            (1, 'John', 'Doe', 'john@example.com', 'password123', 1),
                                                                            (2, 'Jane', 'Smith', 'jane@example.com', 'password456', 2),
                                                                            (3, 'Alice', 'Johnson', 'alice@example.com', 'password789', 3),
                                                                            (4, 'Bob', 'Brown', 'bob@example.com', 'passwordabc', 4),
                                                                            (5, 'Emily', 'Davis', 'emily@example.com', 'passwordxyz', 5);
