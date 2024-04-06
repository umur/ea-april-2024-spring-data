-- Populate address table
INSERT INTO address (id, city, street, zip)
VALUES
    (1, 'New York', 'Broadway', '10001'),
    (2, 'Los Angeles', 'Hollywood Blvd', '90001'),
    (3, 'Chicago', 'Michigan Ave', '60601'),
    (4, 'Houston', 'Main St', '77002'),
    (5, 'San Francisco', 'Market St', '94102');

-- Populate category table
INSERT INTO category (id, name)
VALUES
    (1, 'Electronics'),
    (2, 'Clothing'),
    (3, 'Books'),
    (4, 'Home & Kitchen'),
    (5, 'Sports');

-- Populate product table
INSERT INTO product (price, rating, category_id, id, name)
VALUES
    (999.99, 4, 1, 1, 'Laptop'),
    (49.99, 3, 2, 2, 'T-Shirt'),
    (29.99, 5, 3, 3, 'Novel'),
    (39.99, 4, 4, 4, 'Coffee Maker'),
    (99.99, 4, 5, 5, 'Running Shoes');

-- Populate user table
INSERT INTO user (address_id, id, email, first_name, last_name, password)
VALUES
    (1, 1, 'john@example.com', 'John', 'Doe', 'password123'),
    (2, 2, 'jane@example.com', 'Jane', 'Smith', 'abc@123'),
    (3, 3, 'mike@example.com', 'Mike', 'Johnson', 'securepwd'),
    (4, 4, 'emily@example.com', 'Emily', 'Brown', 'qwerty'),
    (5, 5, 'chris@example.com', 'Chris', 'Davis', 'pass123');

-- Populate review table
INSERT INTO review (id, product_id, user_id, comment)
VALUES
    (1, 1, 1, 'Great laptop, fast delivery!'),
    (2, 2, 2, 'Nice quality t-shirt.'),
    (3, 3, 3, 'Interesting plot, loved it.'),
    (4, 4, 4, 'Makes delicious coffee.'),
    (5, 5, 5, 'Very comfortable shoes for running.');
