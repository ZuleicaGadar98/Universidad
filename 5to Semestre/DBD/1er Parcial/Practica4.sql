
-- PRACTRICA #4 -- 
/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `practica`(in cust_id smallint(5))
BEGIN
declare antiguedad float default 0;
select datediff(current_date(), date(create_date))/365 into antiguedad 
from customer
where customer_id=cust_id;
select antiguedad;
END
*/
call practica(3);

-- PRACTICA #5 --

show tables;
describe empleado;
select * from empleado;
select * from puesto;
select * from departamento;

call nuevo("Zuleica Gadar", "ANALISTA", "2019-10-18", "OPERACIONES");

-- PRACTICA #6 --

/* CREATE DEFINER=`root`@`localhost` PROCEDURE `rental_re`(in cust smallint(5), rent int(11) )
BEGIN
declare nombre_cliente varchar(45);
declare apellido_cliente varchar(45);
declare id_pelicula smallint(5) default 0;
declare titulo varchar(255);
declare costo decimal(5,2);

select c.customer_id, c.first_name, c.last_name ,r.rental_id, f.film_id, f.title, p.amount 
	into cust,nombre_cliente,apellido_cliente,rent,id_pelicula,titulo,costo
			from customer c
				join rental r on r.customer_id = c.customer_id
				join payment p on r.rental_id = p.rental_id
				join inventory i on i.inventory_id = r.inventory_id
				join film f on f.film_id = i.film_id
			where c.customer_id = cust and r.rental_id = rent;
        
select cust, nombre_cliente, apellido_cliente, rent, id_pelicula, titulo, costo;
END
*/

show tables;
select * from customer;
select * from rental;

call rental_re (130, 1);

-- PRACTICA #7 --
create table ticket
(ticket_id int not null auto_increment,
ticket_date datetime,
customer_id int,
rental_id int,
fee float,
paid smallint,
primary key(ticket_id));

/* CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_ticket`( in rent int(11), dd datetime)
BEGIN
declare c_id int default 0;
declare r_id int default 0;
declare fe int default 0.0;
declare pago float default 0.0;
select c.customer_id, r.rental_id, (datediff(date_add(date(r.rental_date), 
interval f.rental_duration day), r.return_date)*(-1))*f.rental_rate fee into c_id,r_id,fe
from rental r
	join customer c	on r.customer_id = c.customer_id
	join inventory i on i.inventory_id = r.inventory_id
	join film f	on i.film_id = f.film_id
    where r.rental_id=rent;
    set pago=fe*(-0.5);

insert into ticket values (0, dd, c_id, rent,fe, pago);

END*/

call customer_ticket(52,"2005-05-31");
select * from ticket;



