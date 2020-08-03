-- PRACTICA #10 --
/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `RentaPelicula`(fi datetime,ff datetime)
BEGIN
declare done int default 0;
declare rents int default 0;
declare id int default 0;
declare titulo varchar(255);

declare pelicula cursor for
	select f.film_id ID, f.title Titulo, count(r.rental_id) Rentas from rental r
			inner join inventory i on i.inventory_id = r.inventory_id
			inner join film f on f.film_id = i.film_id
		where r.rental_date between fi and ff
	group by f.film_id,f.title
	order by count(rent);
	
declare continue handler for SQLSTATE '02000' set done = 1;
 open pelicula;
	repeat
		fetch pelicula into id,titulo,rents;
			set id=id;
			set titulo=titulo;
			set rents=rents;
		select id, titulo, rents;
	until done end repeat;
close pelicula;
 
END
*/

call RentaPelicula ('2005-05-24','2005-05-25');
select * from rental
orde;