-- PRACTICA #8 --

/* 
CREATE DEFINER=`root`@`localhost` PROCEDURE `VentaRenta`(inicio datetime, final datetime)
BEGIN
declare id_staff int;
declare venta1 int default 0;
declare venta2 int default 0;
declare done int default 0;

declare rentas cursor for
select staff_id from rental;
declare continue handler for SQLSTATE '02000' set done = 1;

open rentas;
	while not done do
		fetch rentas into id_staff;
			if id_staff=1 then
				set venta1=venta1+1;
			else
				set venta2=venta2+1;
			end if;
	end while;
close rentas;

SELECT venta1, venta2;
END
*/

call VentaRenta('2000-05-24', '2015-05-24');