-- PRACTICA #12 --

/* 
CREATE DEFINER=`root`@`localhost` PROCEDURE `12parte1`(idcu int, out results numeric)
BEGIN

	select sum(p.unit_price * coi.quantity) into results
		from product p
			inner join customerorderitem coi on coi.product_id = p.product_id
			inner join customerorder co on co.order_id = coi.order_id
            
		where coi.order_id = idcu;
END
*/

/* 
CREATE DEFINER=`root`@`localhost` PROCEDURE `12parte2`(ido int)
BEGIN
	declare total int default 0;
    
    call 12parte1(ido, @shipy);
    
		select co.shipping_price into total
			from customerorder co
		where co.order_id = ido;
		
    select round(total + @shipy, 2) Total;
END
*/

call 12parte2 (1);