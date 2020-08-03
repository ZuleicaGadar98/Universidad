
/* Ejercicio #1 */
select s.first_name Nombre_Staff, s.last_name Apellido_Staff, a.address Direccion_Staff, a.district Distrito_Staff, c.city Ciudad_Staff, co.country Pais_Staff
from staff  s
join address a on a.address_id = s.address_id
join city c on a.city_id=c.city_id
join country co on c.country_id=co.country_id;

/* Ejercicio #2 */
select concat(c.first_name, " ", c.last_name) as Nombre, sum(pa.amount) as Cantidad
from payment as pa
inner join customer as c on c.customer_id = pa.customer_id
group by pa.customer_id
order by sum(pa.amount) desc;

/* Ejercicio #3 */
select f.title
from film as f
inner join language as l on l.language_id = f.language_id
where (f.title like "k%" or f.title like "q%") and l.name = "English";

/* Ejercicio #4 */ 
select f.title, concat(a.first_name, " ", last_name) as Nombre_Actor
from film as f
inner join film_actor as fa on f.film_id = fa.film_id
inner join actor as a on a.actor_id = fa.actor_id
where f.title = "Alone Trip" and fa.actor_id in (select actor_id from actor);
    
/* Ejercicio #5 */
select concat(c.first_name, " ", c.last_name) as Nombre, c.email as Email, f.title as Titulo
from rental as re
inner join customer as c on re.customer_id = c.customer_id
inner join inventory as i on i.inventory_id = re.inventory_id
inner join film as f on i.film_id = f.film_id
where re.return_date is null and datediff(date_add(date(re.rental_date), interval f.rental_duration day), "2006-02-18") < 0;


