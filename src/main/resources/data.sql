INSERT INTO cart(cart_id) values
(1001),
(1002),
(1003);

 

INSERT INTO line_item(item_id,product_id,product_name,quantity,price,fk) values
(101,001,'Biscuit',5,25.00,1001),
(102,002,'Shampoo',2,10.00,1002),
(103,003,'Juice',3,30.00,1003);