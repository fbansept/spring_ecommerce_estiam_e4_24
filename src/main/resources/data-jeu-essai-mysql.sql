INSERT INTO user (email, password) VALUES
('admin@gmail.com', 'root'),
('seller1@gmail.com', 'root'),
('seller2@gmail.com', 'root'),
('customer@gmail.com', 'root');

INSERT INTO admin (id) VALUES
(1);

INSERT INTO customer (code, id) VALUES
('tata456', 4);

INSERT INTO seller (group_name, id) VALUES
('amazon', 2),
('fnac', 3);

INSERT INTO product (name, description) VALUES
("Playstation 5","La PlayStation 5 (abrégée officiellement PS5) est la console de jeux vidéo de salon de neuvième génération développée par Sony Interactive Entertainment."),
("XBox One", "La Xbox One est une console de jeux vidéo de huitième génération développée par Microsoft. Dévoilée le 21 mai 2013 , elle succède à la Xbox 360");

INSERT INTO product_offer (seller_id, product_id ,quantity, price, discount, percent_discount, discount_code) VALUES
(2,1,100, 440.99, 10, true, 'PS5123'),
(3,1,200, 410.80, 0 ,false, null),
(2,2,50, 350.99, 50 ,false, 'XBOX123');

INSERT INTO cart_line (customer_id, seller_id, product_id, quantity) VALUES
(4, 2, 1, 2);