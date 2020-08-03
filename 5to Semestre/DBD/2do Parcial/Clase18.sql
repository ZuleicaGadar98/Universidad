
-- WHILE -- 
/* Se realizo un procedure, para poder utilizar el while (se realiza en el 4 icono de derecha a izquiera)*/
/* 
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_while`()
BEGIN
declare count int default 0;
while count<10 do
set count = count+1;
end while;
select count;
END
*/
call test_while();