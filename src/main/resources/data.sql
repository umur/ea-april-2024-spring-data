-- Populate address table
INSERT INTO address (city, street, zip)
VALUES
    ('New York', 'Broadway', '10001'),
    ('Los Angeles', 'Hollywood Blvd', '90001'),
    ('Chicago', 'Michigan Ave', '60601'),
    ('Houston', 'Main St', '77002'),
    ('San Francisco', 'Market St', '94102');

-- Populate category table
INSERT INTO category (name)
VALUES
    ('Electronics'),
    ('Clothing'),
    ('Books'),
    ('Home & Kitchen'),
    ('Sports');

-- Populate product table
INSERT INTO product (price, rating, category_id, name)
VALUES
    (999.99, 4, 1, 'Laptop'),
    (49.99, 3, 2, 'T-Shirt'),
    (29.99, 5, 3, 'Novel'),
    (39.99, 4, 4, 'Coffee Maker'),
    (99.99, 4, 5, 'Running Shoes');

-- Populate user table
INSERT INTO user (address_id, email, first_name, last_name, password)
VALUES
    (1, 'john@example.com', 'John', 'Doe', 'password123'),
    (2, 'jane@example.com', 'Jane', 'Smith', 'abc@123'),
    (3, 'mike@example.com', 'Mike', 'Johnson', 'securepwd'),
    (4, 'emily@example.com', 'Emily', 'Brown', 'qwerty'),
    (5, 'chris@example.com', 'Chris', 'Davis', 'pass123');

-- Populate review table
INSERT INTO review (product_id, user_id, comment)
VALUES
    (1, 1, 'Great laptop, fast delivery!'),
    (2, 2, 'Nice quality t-shirt.'),
    (3, 3, 'Interesting plot, loved it.'),
    (4, 4, 'Makes delicious coffee.'),
    (5, 5, 'Very comfortable shoes for running.');
