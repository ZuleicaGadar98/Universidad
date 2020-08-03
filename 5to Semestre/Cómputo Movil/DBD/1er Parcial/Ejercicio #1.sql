#Consulta de información 
select f.film_id ,f.title,i.inventory_id 
from film f, inventory i 
where f.film_id=i.film_id;