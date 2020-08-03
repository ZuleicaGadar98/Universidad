-- PRACTICA 9 --

create table Rental2 like rental;
insert into Rental2 select * from rental;

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `RentaRemplazo`(x1 int, x2 int)
BEGIN
    declare fin int default 0;
    declare rents int default 0;
    
    declare basic cursor for
    	select r.rental_id 
			from rental r
				inner join inventory i on i.inventory_id = r.inventory_id
				inner join film f on f.film_id = i.film_id
			where f.replacement_cost > x2 and f.rental_rate < x1;
    
    declare continue handler for SQLSTATE '02000' set fin = 1;
    
    open basic;
    
    repeat
		fetch basic into rents;
			delete from rental2 where rental_id = rents;
		until fin end repeat;
    
    close basic;
END
*/
select * from rental2; 
call RentaRemplazo (1,20);