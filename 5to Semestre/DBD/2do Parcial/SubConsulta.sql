
-- EJERCICIO #1 --
/* Consulta que regrese ID del producto, nombre, peso y precio unitario, para aquellos con peso sea el minimo en art. comprados */

select p.product_id ID, p.name Producto, p.weight Peso, p.unit_price Precio from product p
where p.weight=(select min(weight) from product);

-- EJERCICO #2 --
/* Consulta con subquery */

select p.name, p.unit_price, 
(select count(coi.product_id) from customerorderitem coi where p.product_id=coi.product_id) Ventas,
ifnull((select avg(coi.price) from customerorderitem coi where coi.product_id=p.product_id),0) Promedio
from product p
group by p.name;

-- EJERCICO #3 --
/* Consulta con subconsulta escalar */

select p.name Producto, p.unit_price Precio_Unitario, avg(coi.price) Precio_promedio 
from product p
left join customerorderitem coi on p.product_id = coi.product_id
group by p.name, p.unit_price; 

-- EJERCICO #4 --
/* Consulta con subquery */

select p2.name Producto, p2.unit_price, c.name Categoria,

ifnull((select avg(p.unit_price) 
from product p 
inner join product2category pc on p.product_id =  pc.product_id
where pc.category_id = pc2.category_id),0) Promedio

from product p2
inner join product2category pc2 on p2.product_id =  pc2.product_id
inner join category c on pc2.category_id = c.category_id
group by p2.name;

-- EJERCICO #5 --
/* Consulta con subconsulta conrrelacionadas */

select p.name, p.unit_price from product p
where p.unit_price = (select min(coi.price) from customerorderitem coi);