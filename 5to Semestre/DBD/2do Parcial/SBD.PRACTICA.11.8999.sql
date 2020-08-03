select * from customer;

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `multa`()
BEGIN

declare fin int default 0;
declare id int;
declare nom varchar(200);
declare ape varchar(200);
declare ga_rentas int default 0;
declare ga_multas int default 0;

declare multas cursor for
	Select c.customer_id, c.first_name, c.last_name, sum(p.amount), sum(t.paid)
		from customer c 
			left join payment p on p.customer_id=c.customer_id
			left join ticket t on t.customer_id=c.customer_id
		group by c.customer_id, c.first_name, c.last_name
		order by sum(p.amount), sum(t.paid);
        
declare continue handler for SQLSTATE '02000' set fin = 1;

drop temporary table if exists ponce;

create temporary table ponce(idcliente int,
c_nombre varchar(200),
c_apellido varchar(200),
g_rentas int,
g_multas int);

open multas;
repeat
	fetch multas into id, nom, ape, ga_rentas, ga_multas;
		set id = id;
		set nom = nom;
		set ape = ape;
		set ga_rentas = ga_rentas;
		set ga_multas = ga_multas;
	insert into ponce values(id, nom, ape, ga_rentas, ga_multas);
 until fin end repeat;
 
close multas;

 select idcliente, c_nombre, c_apellido, ifnull(g_rentas,0), ifnull(g_multas,0) from ponce;
END
*/

call multa ();