INSERT INTO user (email, password) VALUES
('toto@gmail.com', 'root'),
('tata@gmail.com', 'root'),
('titi@gmail.com', 'root'),
('tutu@gmail.com', 'root');

INSERT INTO customer (code, id) VALUES
('toto123', 1),
('tata456', 2);

INSERT INTO seller (group_name, id) VALUES
('amazon', 1),
('leboncoin', 3),
('fnac', 4);

INSERT INTO product (name) VALUES
("pizza"),
("nachos");

INSERT INTO product_offer (seller_id, product_id ,quantity,  price) VALUES
(3,1,100, 23.99),
(4,1,200, 9.80);

INSERT INTO cart_line (customer_id, seller_id, product_id, quantity) VALUES
(1, 3, 1, 20);