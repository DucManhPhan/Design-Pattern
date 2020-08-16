-- Syntax of column's definition:
-- column_name data_type(length) [NOT NULL] [DEFAULT value] [AUTO_INCREMENT] column_constraint;
-- column_constraints include UNIQUE, CHECK, PRIMARY KEY, and AUTO_INCREMENT

-- Set primary key for multiple columns: PRIMARY KEY (column_1, column_2, ...)

CREATE TABLE IF NOT EXISTS orders (
   order_id INT PRIMARY KEY,
   order_date DATETIME NOT NULL,
   required_date DATETIME NOT NULL,
   shipped_date DATETIME NOT NULL,
   status varchar(250)
);

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    quantity_in_stock INT,
    price DECIMAL NOT NULL
);

CREATE TABLE IF NOT EXISTS order_items (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL NOT NULL,
    discount DECIMAL DEFAULT 0.0,
    PRIMARY KEY (order_id, product_id)
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);
