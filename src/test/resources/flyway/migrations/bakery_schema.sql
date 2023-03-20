DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
customer_id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(45) NOT NULL,
last_name varchar(45) NOT NULL,
phone varchar(20)
);


CREATE TABLE items (
item_id int PRIMARY KEY AUTO_INCREMENT,
item_name enum('CAKE', 'COOKIES', 'CUPCAKES', 'DESSERT_BARS') NOT NULL,
item_price decimal(5, 2) NOT NULL,
order_id int unsigned NOT NULL,
FOREIGN KEY (order_id) REFERENCES orders (order_id)
);

CREATE TABLE orders (
order_id int PRIMARY KEY AUTO_INCREMENT,
customer_id int NOT NULL,
order_date datetime default current_timestamp,
FOREIGN KEY (customer_id) REFERENCES customers (customer_id) ON DELETE CASCADE
);

CREATE TABLE order_items (
order_id INT NOT NULL,
item_id INT NOT NULL,
quantity INT NOT NULL,
PRIMARY KEY (order_id, item_id),
FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE, 
FOREIGN KEY (item_id) REFERENCES items (item_id) ON DELETE CASCADE
);
