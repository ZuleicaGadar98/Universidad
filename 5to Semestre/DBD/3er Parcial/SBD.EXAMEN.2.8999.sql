-- EJERCICIO 1 -- 

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `Rental_Bonus`(fecha1 datetime, fecha2 datetime)
BEGIN

declare done int default 0;
declare id int;
declare nombre varchar(200);
declare apellido varchar(200);
declare rentas decimal (5,2) default 0;
declare bono decimal (5,2) default 0;

declare inicio cursor for
	select c.customer_id, c.first_name, c.last_name, sum(p.amount) from customer c 
			inner join rental r on r.customer_id = c.customer_id
			inner join payment p on p.rental_id = r.rental_id
		where r.rental_date between fecha1 and fecha2
	group by c.customer_id;
    
declare continue handler for SQLSTATE '02000' set done = 1;

drop temporary table if exists tempo;

	create temporary table tempo(id_cliente int,
		nom_cliente varchar(200),
		ape_cliente varchar(200),
		monto_rentas decimal (5,2),
		bono_cliente decimal (5,2));
open inicio;

repeat
fetch inicio into id, nombre, apellido, rentas;
	set id = id;
	set nombre = nombre;
	set apellido = apellido;
	set rentas = rentas;
		if rentas between 50 and 100 then
			set bono = rentas*0.025;
            
			ELSEIF rentas between 100 and 150 then
				set bono = rentas*0.05;
			
            ELSEIF rentas between 150 and 200 then
				set bono = rentas*0.075;
			
            ELSEIF rentas>200 then
				set bono = rentas*0.1;
		end if;
        
insert into tempo values(id, nombre, apellido, rentas, bono);
until done end repeat;

close inicio;

select * from tempo;

END
*/

call Rental_Bonus ("2005-05-26", "2005-07-28");

-- EJERCICIO 2 --

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `RentCate_1`(ID int, out prome decimal(11, 6), out nombre varchar(25))
BEGIN
select sum(f.rental_rate)/count(f.film_id), c.name into prome, nombre
  from film f
	  inner join film_category fc on fc.film_id = f.film_id
	  inner join category c on c.category_id = fc.category_id
	where c.category_id = ID
  group by c.category_id;
END
*/

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `RentCate_2`(f1 datetime, f2 datetime)
BEGIN

declare prom decimal (11,6) default 0;
declare conta int default 0;
declare nom varchar(25) default "";
declare done int default 0;
declare id int default 0;

declare nuevo cursor for
select category_id from category;

declare continue handler for SQLSTATE '02000' set done = 1;
  
drop temporary table if exists temp;
  
create temporary table temp (
id int, 
nombre varchar(25), 
count int, 
prom_cat decimal(8, 2));
  
open nuevo;
  repeat
    fetch nuevo into id;
		call RentCate_1(id, prom, nom);
			select count(c.category_id) into conta
				from rental r
				inner join inventory i on r.inventory_id = i.inventory_id
				inner join film f on i.film_id = f.film_id
				inner join film_category fc on fc.film_id = f.film_id
				inner join category c on c.category_id = fc.category_id
				inner join payment p on p.rental_id = r.rental_id
			where (r.rental_date between f1 and f2) and c.category_id = id
		group by c.category_id;
	insert into temp values (id, nom, conta, (prom*conta));
  until done end repeat;
close nuevo;

select * from temp;
END
*/

call RentCate_2 ("2005-05-26", "2008-05-26");

-- EJERCICIO 3 --

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `category_film`(in id_pelicula int, cat varchar(100))
BEGIN

declare categoria int(3);

select category_id into categoria from category where name = cat;

	IF NOT EXISTS (SELECT film_id FROM film WHERE film_id = id_pelicula) then 
		select 'El ID ', id_pelicula ,' que ha ingresado no existe, favor de poner un ID existente';
        
			elseif NOT EXISTS (SELECT name FROM category WHERE name = cat ) then 
				select 'La categoría ', cat ,' que ha ingresada no existe, favor de poner una categoría existente';
                
			elseif EXISTS (SELECT category_id FROM film_category WHERE film_id = id_pelicula) then 
				select 'La pelicula con el ID ', id_pelicula ,' ya está dentro de una categoría';
                
	else
		insert into film_category(film_id, category_id) values(id_pelicula, categoria);
        
select '¡¡¡ Agregación Exitosa !!!';

end if;
END
*/

select * from category;
call category_film(3,"Children");

-- EJERCICIO 4 --

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `new_actor`(nombre varchar(100), apellido varchar(100))
BEGIN
	IF NOT EXISTS (SELECT first_name,last_name FROM actor WHERE first_name = nombre AND last_name = apellido) then 
		INSERT into actor(first_name, last_name) VALUES (nombre, apellido);
			select'Ingreso exitoso';
				else
					select'Actor existente';
	end if;
END
*/

call new_actor("Zuleica", "Gadar");

-- EJERCICIO 5 --

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `Aumentos`(cate varchar(100), aumen decimal(4,2))
BEGIN

declare done int default 0;
declare id int;
declare peli varchar(200);
declare cost decimal (4,2) default 0;
declare new_cost decimal (4,2) default 0;

declare inicio cursor for
	select f.film_id, f.title, f.rental_rate from film f 
		inner join film_category fc on fc.film_id = f.film_id
		inner join category c on fc.category_id = c.category_id
	where c.name = cate;

declare continue handler for SQLSTATE '02000' set done = 1;

drop temporary table if exists tem;

create temporary table tem(id_pelicula int,
pelicula varchar(200),
costo decimal (4,2),
aumento decimal (4,2),
nuevo_costo decimal (4,2));

open inicio;
	repeat
		fetch inicio into id, peli, cost;
			set id = id;
			set peli = peli;
			set cost = cost;
			set new_cost = cost + (cost*aumen);
		insert into tem values(id, peli, cost, aumen, new_cost);
	until done end repeat;
close inicio;

select * from tem;
END
*/

select * from category;
call Aumentos("Animation", 0.3);