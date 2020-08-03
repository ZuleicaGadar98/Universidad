show tables;
select * from staff;

select * from rental;
 /* 
 CREATE DEFINER=`root`@`localhost` PROCEDURE `Ventas`(inicio datetime, final datetime)
BEGIN
declare id_staff int;
declare fecha datetime;
declare rentas cursor for
select count(rental_id) from rental;
open rentas;
while fecha between inicio and final do
fetch rentas into id_staff;
end while;
close rentas;

END*/

-- EJEMPLO #1 --
/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `cursor_demo`(divisor int)
BEGIN
declare precio float;
declare resultado float;
declare done int default 0;
declare productos cursor for
select unit_price from product;
    
open productos;
	repeat
		fetch productos into precio;
			if not done then
			set resultado=precio/divisor;
			end if;
		select resultado;
	until done end repeat;
close productos;
END 
*/
call cursor_demo(3);

show tables;
select * from rental;

