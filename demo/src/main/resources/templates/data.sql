-- Drop table if it exists
DROP TABLE IF EXISTS address;

-- Create addresses table
CREATE TABLE address (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         street VARCHAR(255) NOT NULL,
                         zip VARCHAR(10) NOT NULL,
                         city VARCHAR(255) NOT NULL,
                         id_user INT,
                         FOREIGN KEY (id_user) REFERENCES `user`(id)
);

-- Insert 10 addresses
INSERT INTO address (street, zip, city, id_user)
VALUES
    ('123 Main St', '12345', 'Springfield', 1),
    ('456 Elm St', '23456', 'Rivertown', 2),
    ('789 Oak St', '34567', 'Lakeside', 3),
    ('321 Pine St', '45678', 'Hilltop', 4),
    ('543 Maple St', '56789', 'Meadowville', 5),
    ('876 Cedar St', '67890', 'Harbor City', 6),
    ('234 Birch St', '78901', 'Oceanview', 7),
    ('567 Walnut St', '89012', 'Mountainville', 8),
    ('890 Cherry St', '90123', 'Valleytown', 9),
    ('111 Spruce St', '01234', 'Lakewood', 10);

--Category
-- Drop table if it exists
DROP TABLE IF EXISTS category;

-- Create categories table
CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

-- Insert 10 categories
INSERT INTO category (name)
VALUES
    ('Category 1'),
    ('Category 2'),
    ('Category 3'),
    ('Category 4'),
    ('Category 5'),
    ('Category 6'),
    ('Category 7'),
    ('Category 8'),
    ('Category 9'),
    ('Category 10');

-- Product
-- Drop table if it exists
DROP TABLE IF EXISTS product;

-- Create products table
CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         rating INT NOT NULL,
                         id_category INT,
                         FOREIGN KEY (id_category) REFERENCES category(id)
);

-- Insert 10 products
INSERT INTO product (name, price, rating, id_category)
VALUES
    ('Product 1', 10.99, 4, 1),
    ('Product 2', 20.49, 3, 2),
    ('Product 3', 15.75, 5, 1),
    ('Product 4', 30.00, 4, 3),
    ('Product 5', 25.99, 5, 2),
    ('Product 6', 12.50, 3, 1),
    ('Product 7', 18.99, 4, 3),
    ('Product 8', 22.25, 5, 2),
    ('Product 9', 29.99, 3, 1),
    ('Product 10', 35.50, 4, 3);

--Review
-- Drop table if it exists
DROP TABLE IF EXISTS review;

-- Create reviews table
CREATE TABLE review (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        comment VARCHAR(255) NOT NULL,
                        id_product INT,
                        id_user INT,
                        FOREIGN KEY (id_product) REFERENCES product(id),
                        FOREIGN KEY (id_user) REFERENCES `user`(id)
);

-- Insert review entries
INSERT INTO review (comment, id_product, id_user)
VALUES
    ('Review 1', 1, 1),
    ('Review 2', 2, 2),
    ('Review 3', 3, 3),
    ('Review 4', 4, 4),
    ('Review 5', 5, 5),
    ('Review 6', 6, 6),
    ('Review 7', 7, 7),
    ('Review 8', 8, 8),
    ('Review 9', 9, 9),
    ('Review 10', 10, 10);

-- User
-- Drop table if it exists
DROP TABLE IF EXISTS `user`;

-- Create users table
CREATE TABLE `user` (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        firstName VARCHAR(255) NOT NULL,
                        lastName VARCHAR(255) NOT NULL
);

-- Insert user entries
INSERT INTO `user` (email, password, firstName, lastName)
VALUES
    ('user1@example.com', 'password1', 'John', 'Doe'),
    ('user2@example.com', 'password2', 'Jane', 'Smith'),
    ('user3@example.com', 'password3', 'Alice', 'Johnson'),
    ('user4@example.com', 'password4', 'Bob', 'Brown'),
    ('user5@example.com', 'password5', 'Emily', 'Davis'),
    ('user6@example.com', 'password6', 'David', 'Wilson'),
    ('user7@example.com', 'password7', 'Sarah', 'Martinez'),
    ('user8@example.com', 'password8', 'Michael', 'Anderson'),
    ('user9@example.com', 'password9', 'Laura', 'Taylor'),
    ('user10@example.com', 'password10', 'Chris', 'Thomas');
