
/* EJERCICIO #1 */
select c.customer_id ID, c.first_name Nombre, c.last_name Apellido
from customer c 
left join customerorder co on c.customer_id=co.customer_id
where co.customer_id is null;

/* EJERCICIO #2 */
Select os.order_status_id ID, os.description estatus, count(co.status) ordenes
from orderstatus os 
inner join customerorder co on os.order_status_id=co.status
group by os.order_status_id, os.description
order by count(co.status);

/* EJERCICIO #3 */
select p.product_id ID, p.name Nombre_Producto, sm.name Descripcion, co.status Estatus
from product p 
inner join customerorderitem coi on p.product_id=coi.product_id
inner join customerorder co on coi.order_id=co.order_id
inner join shippingmethod sm on co.shipping_method = sm.shipping_method_id
where sm.name = 'Medium Weight Shipments' and co.status='CM';

/* EJERCICIO #4*/
select ca.category_id ID, ca.name Categoria, count(co.order_id) 'Producto_Vendido'
from category ca 
inner join product2category pc on ca.category_id=pc.category_id
inner join customerorderitem coi on pc.product_id=coi.product_id
inner join customerorder co on coi.order_id=co.order_id
group by ca.category_id, ca.name 
order by ca.category_id;

/* Ejercicio #5 */

(select first_name, last_name, login, password from customerserviceemployee)

union( select first_name, last_name, login, password from warehouseemployee)

union( select first_name, last_name, login, password from customer);