
/* CREACIÓN DE VISTAS */

create view vw_product as 
select product_id, name, unit_price 
from product;
select * from vw_product;

create view vw_producto2 as 
select product_id,name,unit_price
from product
where unit_price < 45;
select * from vw_producto2;

create view vw_producto3 (id, nombre, precio) as
select product_id, name, unit_price
from product 
where unit_price < 45;
select * from vw_producto3;

/* COLUMNAS */