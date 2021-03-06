-- Bước 1:
create database demo;

use demo;

-- Bước 2:
create table products (
id int,
product_Code int,
product_Name varchar(45),
product_Price double,
product_Amount int,
product_Description varchar(255),
product_Status bit(1),
primary key (id)
);

insert into products values
(1, 111, 'coffee1', 10,50,'black coffee',1), 
(2, 222, 'coffee2', 15,30,'Milk coffee',1), 
(3, 333, 'yogurt', 20,20,'cool',1), 
(4, 444, 'peach tea', 20,0,'best seller',0), 
(5, 555, 'drink bottle', 10,100,'very fast',1);

-- Bước 3:
Explain select * from products where id = 5;

alter table products add unique idx_products (id);

alter table products add index idx_product_code (id, product_code);

Explain select * from products where product_code = 333 and id = 3;

-- Bước 3:
create view product_view as
select  product_Code, product_Name, product_Price, product_Status 
from products;

select * from product_view where product_status = 0;

create or replace view product_view as
select product_Name, product_Price, product_amount
from products
where product_status = 1;

select * from product_view;

drop view product_view;

-- Bước 4:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
drop procedure if exists display_all_product //
create procedure display_all_product()
begin

select * from products;

end //
DELIMITER;
CALL display_all_product();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //

drop procedure if exists add_new_product //

CREATE PROCEDURE add_new_product (
id int,
product_code int,
product_Name varchar(45),
product_Price double,
product_Amount int,
product_Description varchar(255),
product_Status bit(1)
)
BEGIN
insert into products values 
(id,product_Code, product_Name, product_Price,product_Amount,product_Description, product_Status);
END //
DELIMITER;

CALL add_new_product(6,666,'Milk Tea', 25,10,'very good',1);

CALL display_all_product();

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //

drop procedure if exists edit_product_by_id //

CREATE PROCEDURE edit_product_by_id

(id int,
price double
)

BEGIN

set sql_safe_updates = 0;
update products set products.product_price = price
where products.id = id;
set sql_safe_updates = 1;

END //

DELIMITER ;

CALL edit_product_by_id(6,35);

CALL display_all_product();

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //

drop procedure if exists delete_product_by_id //

CREATE PROCEDURE delete_product_by_id

(id int)

BEGIN

delete from products
where products.id = id;

END //

DELIMITER ;

CALL delete_product_by_id(3);

CALL display_all_product();

