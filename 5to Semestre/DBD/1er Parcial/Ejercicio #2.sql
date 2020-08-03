/* Punto 1 */ 
select f.film_id, f.title, count(i.film_id) as cant
from inventory i, film f
where f.film_id = i.film_id
order by cant desc;
 
/* Punto 2 */
select s.store_id, cu.first_name, cu.last_name, cu.email, a.address_id, a.address,uci.city_id, ci.city,uco.country_id, co.country
from store s, customer cu, address a, city ci, country co
where s.store_id = cu.store_id and a.address_id = s.address_id and ci.city_id = a.city_id and co.country_id = ci.country_id
order by store_id, last_name, first_name;

/* Punto 3 */
select s.staff_id, concat(first_name,' ',`last_name`) nombre,count(r.rental_id) rentas , r.rental_date
from staff s, rental r
where s.staff_id=r.staff_id and date(r.rental_date) between '2005-06-01' and '2005-06-30' 
group by s.staff_id
order by rentas desc;

/* Punto 4 */
select s.staff_id, concat(first_name,' ',`last_name`) nombre,count(r.rental_id) rentas , sum(p.amount) as Importe
from staff s, rental r, payment p
where s.staff_id=r.staff_id and date(r.rental_date) between '2005-06-01' and '2005-06-30'
and r.rental_id=p.rental_id and  date(p.payment_date) between '2005-06-01' and '2005-06-30'
group by s.staff_id
order by rentas desc;

/* Punto 5 */
select re.rental_id, f.title, f.rental_duration, date (re.rental_date), date (re.return_date) as return_date, 
date (re.return_date) - date (re.rental_date)days, 
date (re.return_date) - date(re.rental_date) - f.rental_duration retraso
from rental re, film f, inventory
where re.inventory_id=inventory.inventory_id and f.film_id = inventory.film_id and date(re.return_date)-date(re.rental_date) >f.rental_duration
order by retraso desc;

/* Punto 6 */
select concat (ac.first_name, "", ac.last_name) as Actor_Name
from customer, actor ac
where ac.first_name = customer.first_name and ac.last_name = customer.last_name;

/* Punto 7 */
/* Profe este punto no supe como hacerlo */

/* Punto 8 */
select re.rental_id, re.rental_date, concat (cu.first_name, "", cu.last_name) as custumer_name,
i.inventory_id, f.title, ca.name, pa.amount, concat(st.first_name, "", st.last_name) as staff_name
from rental re, customer cu, inventory i, film f, category ca, film_category filmc, payment pa, staff st
where re.customer_id = cu.customer_id and re.inventory_id = i.inventory_id and i.film_id = f.film_id
and filmc.film_id = f.film_id and filmc.category_id = ca.category_id and re.rental_id = pa.rental_id and st.staff_id = pa.staff_id;

/* Punto 9 */
create table rental_copy1 select * from rental;

/* Punto 10 */
create table rental_copy2 select * from rental limit 0;

/* Punto 11 */
update rental copy1 set return_date = return_date + 11;
update rental copy1 set rental_date = rental_date + 11;

/* Punto 12 */
delete from rental_copy1 where customer_id between 101 and 300;

/* Punto 13 */
insert into rental_copy2 ()
select re.*
from rental re, inventory, film f
where re.inventory_id = inventory.inventory_id and f.film_id = inventory.film_id and date (re.return_date) - date (re.rental_date) > f.rental_duration;
