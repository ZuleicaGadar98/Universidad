
/* PRÁCTICA #1 */ 

select concat (c.first_name, "  ", c.last_name) as Nombre_Cliente, f.title, cat.name Categoria, vc.Veces_Rentado
from customer c
inner join rental as r on c.customer_id = r.customer_id 
inner join inventory as i on i.inventory_id = r.inventory_id
inner join film as f on i.film_id = f.film_id
inner join film_category as fc on fc.film_id = f.film_id
inner join category as cat on cat.category_id = fc.category_id

inner join (
select count(r.rental_id) Veces_Rentado,i.film_id IdPelicula
from rental r
inner join inventory i on r.inventory_id=i.inventory_id
group by i.film_id 
having count(r.rental_id)>30) as vc
on i.film_id = vc.IdPelicula;


/* PRÁCTICA #2 */

select f.title pelicula, count(r.rental_id) rentas
from film f
inner join inventory i on f.film_id = i.film_id
inner join rental r on i.inventory_id = r.inventory_id
group by f.title
having rentas > (select avg(tab1.rentas)
from film f
inner join
(select ff.film_id idpelicula, count(r.rental_id) rentas
from film ff
inner join inventory i on ff.film_id = i.film_id
inner join rental r on i.inventory_id = r.inventory_id
group by ff.film_id) as tab1 on tab1.idpelicula = f.film_id)
order by rentas;

describe actor;
select * from actor;

