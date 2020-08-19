-- Syntax of column's definition:
-- column_name data_type(length) [NOT NULL] [DEFAULT value] [AUTO_INCREMENT] column_constraint;
-- column_constraints include UNIQUE, CHECK, PRIMARY KEY, and AUTO_INCREMENT

-- Set primary key for multiple columns: PRIMARY KEY (column_1, column_2, ...)

CREATE TABLE IF NOT EXISTS orders (
   order_id VARCHAR(255) PRIMARY KEY,
   order_date DATETIME NOT NULL,
   required_date DATETIME NOT NULL,
   shipped_date DATETIME NOT NULL,
   status varchar(250)
);

CREATE TABLE IF NOT EXISTS products (
    product_id VARCHAR(255) PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    quantity_in_stock INT,
    price DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS order_items (
    order_id VARCHAR(255) NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL NOT NULL,
    discount DECIMAL DEFAULT 0.0,
    PRIMARY KEY (order_id, product_id)
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- INSERT INTO orders (order_id, order_date, required_date, shipped_date, status)
-- VALUES
-- (1, '2020-08-15', '2020-08-20', '2020-07-17', 'pending'),
-- (2, '2020-08-12', '2020-08-27', '2020-07-20', 'pending'),
-- (3, '2020-08-18', '2020-08-20', '2020-07-19', 'successful')
-- ;

-- INSERT INTO products(product_id, product_name, description, quantity_in_stock, price)
-- VALUES
-- (1, 'sauce bottle', 'good', 10000, 30000),
-- (2, 'book', 'good', 3000, 100000),
-- (3, 'coca cola', 'good', 2000, 16000)
-- ;

-- INSERT INTO order_items(order_id, product_id, quantity, price, discount)
-- VALUES
-- (1, 2, 4, 400000, 0),
-- (1, 3, 2, 32000, 0),
-- (2, 1, 2, 60000, 0),
-- (3, 2, 10, 3000000, 0)
-- ;


