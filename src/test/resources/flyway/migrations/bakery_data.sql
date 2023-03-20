INSERT INTO items (item_name, item_flavor, item_price) VALUES ('CAKE', 'VANILLA', 19.99);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('CAKE', 'CHOCOLATE', 19.99); 
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('CAKE', 'MARBLE', 19.99);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('CAKE', 'ALMOND', 24.99);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('CAKE', 'RED VELVET', 24.99);   
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('COOKIES', 'CHOCOLATE CHIP', 1.00);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('COOKIES', 'SUGAR', 1.00);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('COOKIES', 'OATMEAL RAISIN', 1.00);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('COOKIES', 'DOUBLE CHOCOLATE', 1.00);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('CUPCAKES', 'VANILLA', 1.50);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('CUPCAKES', 'CHOCOLATE', 1.50);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('DESSERT_BARS', 'BROWNIES', 1.25);
INSERT INTO items (item_name, item_flavor, item_price) VALUES ('DESSERT_BARS', 'RICE KRISPIE TREAT', 1.25);

INSERT INTO customers (first_name, last_name, phone) VALUES ('AMELIA', 'EARHEART', '123-4567');
INSERT INTO customers (first_name, last_name, phone) VALUES ('JOHN' , 'SMITH', '321-0990');
INSERT INTO customers (first_name, last_name, phone) VALUES ('MARIA', 'RODRIGUEZ', '555-0000');

INSERT INTO orders (customer_id, order_date) VALUES (1, '2023-03-01');
INSERT INTO orders (customer_id, order_date) VALUES (2, '2023-03-08');
INSERT INTO orders (customer_id, order_date) VALUES (3, '2023-03-15');

INSERT INTO order_items (order_id, item_id, quantity) VALUES (1, 1, 1);
INSERT INTO order_items (order_id, item_id, quantity) VALUES (4, 11, 12);
INSERT INTO order_items (order_id, item_id, quantity) VALUES (2, 7, 24);
INSERT INTO order_items (order_id, item_id, quantity) VALUES (3, 12, 6);
INSERT INTO order_items (order_id, item_id, quantity) VALUES (3, 13, 6);

