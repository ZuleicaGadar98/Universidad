Drop table if exists cuenta;

CREATE TABLE cuenta(
numero_cuenta int PRIMARY KEY ,
saldo float
);

INSERT INTO cuenta VALUES(1, 100);
INSERT INTO cuenta VALUES(2, 200);

Drop table if exists retiro;

CREATE TABLE retiro(
numero_retiro int PRIMARY KEY AUTO_INCREMENT,
fecha_retiro datetime,
cuenta int,
retiro float,
Comsion float,
foreign key (cuenta) REFERENCES
cuenta (numero_cuenta)
);

delimiter //
CREATE TRIGGER `Retiros` BEFORE INSERT ON `retiro` 
FOR EACH ROW BEGIN
	declare saldos int default (select saldo from cuenta where numero_cuenta = new.cuenta);
	
	if (saldos - new.retiro - new.comsion) < 20 
		then SIGNAL sqlstate '45001' set message_text = "imposible realizar el retiro";
	else 
		update cuenta set saldos = saldos - new.retiro - new.comsion 
		where numero_cuenta = new.cuenta;
	end if;
END;
// 

-- PRACTICA 14 --

delimiter //
CREATE  TRIGGER `Rental` AFTER INSERT ON `rental` 
FOR EACH ROW BEGIN
	declare nuevo int default 0;

	select (datediff(date_add(date(new.rental_date), interval f.rental_duration day), new.return_date) * (-1)) into nuevo
		from rental r
		inner join inventory i on i.inventory_id = r.inventory_id
		inner join film f on f.film_id = i.film_id
	where r.rental_id = new.rental_id;

	if (nuevo > 0) 
		then insert into ticket values (0, new.return_date, new.customer_id, new.rental_id, 0.5*nuevo, 0);
	end if;
END;
// 

-- PRACTICA 15 --
delimiter //

CREATE TRIGGER `Empleado` AFTER UPDATE ON `empleado` 
FOR EACH ROW BEGIN
	if old.antiguedad != new.antiguedad
		then update trabaja_en set sueldo = (sueldo/100)*(select factor_compensacion from antiguedad where antiguedad = new.antiguedad) + sueldo
		where nss = new.nss;
	end if;
END;
//

select * from empleado;
select * from departamento;