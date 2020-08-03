describe payment;
describe staff;

/* Ejercicio #1 */
select s.first_name Nombre_Empleado, s.last_name Apellido_Empleado, sum(p.amount) Monto_total, p.payment_date Fecha 
from staff s 
inner join payment p on s.staff_id=p.staff_id
where p.payment_date between '2005-08-01' and '2005-08-31'
group by concat(first_name ,' ',`last_name`)
order by s.last_name;

/* Ejercicio #2 */
select f.title Titulo_pelicula, count(fa.actor_id) Numero_Actores 
from film f
inner join film_actor fa on fa.film_id = f.film_id 
where f.film_id = fa.film_id
group by f.film_id
order by f.film_id;

/* Ejercicio #3 */
select f.title Titulo_Pelicula, cu.last_name Apellido_Cliente, cu.first_name Nombre_Cliente, count(r.rental_id) Rentas
from film f 
inner join inventory i on f.film_id = i.film_id
inner join rental r on i.inventory_id = r.inventory_id
inner join customer cu on r.customer_id = cu.customer_id
where f.title like 'M%' and cu.last_name like 'B%'
group by cu.last_name
order by f.title;

/* Ejercicio #4 */
select concat(c.last_name, " ", c.first_name) as nombre, f.title, date(r.rental_date), date(r.return_date), 
date(r.return_date) - date(r.rental_date) as days
from customer as c
join rental as r on c.customer_id = r.customer_id
join inventory as i on r.inventory_id = i.inventory_id
join film as f on i.film_id = f.film_id
where date(r.return_date) - date(r.rental_date) > 2
order by f.title;


/* Ejercicio #5 */

select concat(c.first_name, " ", c.last_name) as Nombre_Cliente, cat.name Categoria, count(f.film_id) Peliculas_Rentadas
from customer as c
inner join rental as r on c.customer_id = r.customer_id
inner join inventory as i on i.inventory_id = r.inventory_id
inner join film as f on i.film_id = f.film_id
inner join film_category as fc on fc.film_id = f.film_id
inner join category as cat on cat.category_id = fc.category_id
group by Nombre_Cliente, cat.name;

/* Ejercicio #6 */

(select concat(c.first_name, " ", c.last_name) as nombre
from customer as c
inner join rental as r on c.customer_id = r.customer_id
inner join inventory as i on i.inventory_id = r.inventory_id
inner join film as f on i.film_id = f.film_id
where f.title = "BUCKET BROTHERHOOD"
group by c.customer_id
order by c.last_name
)
union
(select concat(a.first_name, " ", a.last_name) as nombre
from actor as a
join film_actor as fa on fa.actor_id = a.actor_id
join film as f on fa.film_id = f.film_id
where f.title = "BUCKET BROTHERHOOD"
);