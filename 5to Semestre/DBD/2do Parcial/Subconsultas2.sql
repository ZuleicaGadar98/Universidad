 select * from customerorder where customer_id =1;
 select * from customerorder where customer_id =1 or customer_id =3;
 select * from customerorder where customer_id in (1,3);
 
 select * from customer where customer_id in (select customer_id from customerorder where status = 'CM');
 select * from customer where customer_id in (select customer_id from customerorder where status in ('CM', 'SH'));

/* EJERCICIO #1 */  
 select r.*, c.first_name, c.last_name
 from rental r
 join customer c on r.customer_id = c.customer_id
 where c.customer_id in (100, 130, 25, 112);
 
 /* EJERCICIO #2 */
select r.*, c.first_name, c.last_name
 from rental r
 join customer c on r.customer_id = c.customer_id
 join address a on c.address_id = a.address_id
 join city ci on ci.city_id = a.city_id
 where ci.city_id = 312;
 
 /* select r.*, c.first_name, c.last_name
 from rental r
 inner join customer c on c.customer_id = r.customer_id
 where r.customer_id in 
 (select c.cutomer_id
 from customer c
 inner join )*/
 
 /* SUBCONSULTAS EXIST */
show tables;
 
 /* TABLAS DERIVADAS */
 
 select p.name FROM product P
 INNER JOIN (
 select coi.product_id, min(price) as 'min_price'
 from customerorderitem coi
 group by coi.product_id
 ) as mp
 on p.product_id = mp.product_id
 where p.unit_price <= mp.min_price;
 
