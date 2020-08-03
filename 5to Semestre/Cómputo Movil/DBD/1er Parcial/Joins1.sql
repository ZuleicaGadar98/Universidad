/* Consulta #1*/
select e.*
from EMPLEADO e
inner join DEPARTAMENTO d ON e.DEPTO=d.IDDEPTO
where e.depto=30;

/* Consulta #2 */
select p.name, p.sku, coi.price, coi.weight
from customer c
inner join customerorder co on c.customer_id = co.customer_id
inner join customerorderitem coi on co.order_id = coi.order_id
inner join product p on coi.product_id = p.product_id;

/* Agregando las foreign key */
alter table  product2category add foreign key (category_id)
references category (category_id);

alter table customerorder add foreign key (status)
references orderstatus (order_status_id);

alter table customerorder add foreign key (shipping_method)
references shippingmethod (shipping_method_id);

alter table empleado add foreign key (puesto)
references puesto (iDpuesto);

alter table  product2category add foreign key (product_id)
references product (product_id);

/* Ejercicio #1 */

select p.name , p.sku, coi.price, coi.weight, co.order_id, co.ordered_on
from customer c 
inner join customerorder co on c.customer_id=co.customer_id
inner join customerorderitem coi on co.order_id=coi.order_id
inner join product p on coi.product_id=p.product_id
where c.customer_id=1 and date(co.ordered_on)= '2004-12-08';

/* Consulta #3 */
select * from empleado a left outer join departamento b on a.DEPTO = b.IdDepto;

select * from departamento a left outer join empleado b on b.depto= a.IdDepto;

select * from empleado e right outer join departamento d on e.depto= d.IdDepto;

/* Ejercicio #2 */
select * from customer a left outer join customerorder b on a.customer_id=b.customer_id;

select * from product a left outer join customerorderitem b on a.product_id = b.product_id;

select * from empleado a left outer join puesto b on a.puesto = b.puesto;

/* Ejercicio #3 intersección */ 

select p.product_id,p.name,count(coi.product_id) Veces_x_compra, 
sum(coi.quantity) Cantidad_x_comprada,(sum(coi.quantity)*p.unit_price) Costo
from product p 
inner join customerorderitem coi on p.product_id=coi.product_id
inner join customerorder co on coi.order_id=co.order_id
group by p.product_id
order by name;

/* Ejercicio #3 izquierda */

select p.product_id,p.name,count(coi.product_id) Vecesxcompra, 
sum(coi.quantity) Cantidadxcomprada,(sum(coi.quantity)*p.unit_price) Costo
from product p 
left outer join customerorderitem coi on p.product_id=coi.product_id
left outer join customerorder co on coi.order_id=co.order_id
group by p.product_id
order by product_id;

/* Consulta #4 */ 

select p.product_id, p.name,  COUNT(*) as "#Ordenes",
sum(coi.quantity) "CantidadTotal"
from product p
inner join customerorderitem coi on p.product_id = coi.product_id
group by p.name;

select p.product_id, p.name,  COUNT(*) as "#Ordenes",
sum(coi.quantity) "CantidadTotal"
from product p
left join customerorderitem coi on p.product_id = coi.product_id
group by p.name
order by product_id;

/* Consulta para que no salga nulo */

select p.product_id, p.name,  COUNT(*) as "#Ordenes",
sum(ifnull(coi.quantity, 0)) "CantidadTotal"
from product p
left join customerorderitem coi on p.product_id = coi.product_id
group by p.name
order by product_id;

describe category;
select * from category
order by category_id;

/* Arbol de categoría */
select  ca.category_id, ca.name Category, ifnull(c.name, "Root") Root
from category ca
left join category c on ca.parent_id = c.category_id;

/* Consulta #5 */

select p.name as "Product", "2005- January" as "Date", 
sum(coi.quantity) as "Total Purchased"
from customerorder co
inner join customerorderitem coi on co.order_id = coi.order_id
inner join Product p on coi.product_id = p.product_id
where co.ordered_on between '2005-01-01' and '2005-01-31'
group by p.name
order by sum(coi.quantity);

/* CREACION DE TABLAS */

SELECT * FROM customerorder;

create table CustomerOrder2004 
select * from customerorder 
where ordered_on between '2004-01-01' and '2004-12-31';

select * from CustomerOrder2004;

select * from customerorderitem;

create table CustomerOrderItem2004
select coi.*from customerorder co
inner join customerorderitem coi on co.order_id = coi.order_id
where ordered_on between '2004-01-01' and '2004-12-31';

/* Union joins */

select p.name as "Product", "2004-December" as "Date", 
sum(coi.quantity) as "Total Purchased" 
from CustomerOrder2004 co 
inner join CustomerOrderItem2004 coi on co.order_id = coi.order_id
inner join Product p on coi.product_id = p.product_id
where co.ordered_on between '2004-12-01' and '2004-12-31'
group by p.name;

(select p.name as "Product", "2005- January" as "Date", 
sum(coi.quantity) as "Total Purchased"
from customerorder co
inner join customerorderitem coi on co.order_id = coi.order_id
inner join Product p on coi.product_id = p.product_id
where co.ordered_on between '2005-01-01' and '2005-01-31'
group by p.name
order by sum(coi.quantity)
)
union(
select p.name as "Product", "2004-December" as "Date", 
sum(coi.quantity) as "Total Purchased" 
from CustomerOrder2004 co 
inner join CustomerOrderItem2004 coi on co.order_id = coi.order_id
inner join Product p on coi.product_id = p.product_id
where co.ordered_on between '2004-12-01' and '2004-12-31'
group by p.name
order by sum(coi.quantity)
);

/* USO DE LOS UNION JOINS */

select * from empleado;


/* Consulta #1 */
select e.noEmpleado, e.nombre as "Nombre empleado", p.puesto, d.ubicacion
from empleado e
inner join puesto p on e.puesto =  p.IdPuesto
inner join departamento d on e.depto =  d.IdDepto
where d.Ubicacion= "New York";

/*  Consulta #2*/
select e.noEmpleado, e.nombre as "Nombre empleado", p.puesto, d.ubicacion
from empleado e
inner join puesto p on e.puesto =  p.IdPuesto
inner join departamento d on e.depto =  d.IdDepto
where p.puesto= "Vendedor";

/* Union de ambas consultas */

(select e.noEmpleado, e.nombre as "Nombre empleado", p.puesto, d.ubicacion
from empleado e
inner join puesto p on e.puesto = p.IdPuesto
inner join departamento d on e.depto =  d.IdDepto
where d.Ubicacion= "New York")

union(
select e.noEmpleado, e.nombre as "Nombre empleado", p.puesto, d.ubicacion
from empleado e
inner join puesto p on e.puesto =  p.IdPuesto
inner join departamento d on e.depto =  d.IdDepto
where p.puesto= "Vendedor");

/* Ejercicio #2 */

select p.sku, p.name, p.description, c.name, p.unit_price
from product p
inner join product2category pc on p.product_id =  pc.product_id
inner join category c on pc. category_id = c.category_id
where c.name= "Tennis Equipment";

select p.sku, p.name, p.description, c.name, p.unit_price
from product p
inner join product2category pc on p.product_id =  pc.product_id
inner join category c on pc. category_id = c.category_id
where p.unit_price >= "40";

(select p.sku, p.name, p.description, c.name, p.unit_price
from product p
inner join product2category pc on p.product_id =  pc.product_id
inner join category c on pc. category_id = c.category_id
where c.name= "Tennis Equipment")

union (select p.sku, p.name, p.description, c.name, p.unit_price
from product p
inner join product2category pc on p.product_id =  pc.product_id
inner join category c on pc. category_id = c.category_id
where p.unit_price >= "40");


/* Subquerys  */

select IdPuesto from puesto where salario > 2000;

select * 
from empleado
where puesto = (select IdPuesto from puesto where salario = 800);