-- EJEMPLO 1 --

CREATE TABLE account
(acct_num INT AUTO_INCREMENT,
amount DECIMAL(10,2),
Primary key (acct_num)
);

CREATE TRIGGER ins_sum BEFORE INSERT ON account
FOR EACH ROW SET @sum = @sum + NEW.amount;
SET @sum = 0;
INSERT INTO account VALUES(137,14.98),(141,1937.50),(97,-100.00);
SELECT @sum AS 'Total amount inserted';

-- EJEMPLO 2 --

create table test1 (a1 INT);
create table test2 (a2 INT);
create table test3 (a3 INT NOT NULL AUTO_INCREMENT PRIMARY KEY);
create table test4 (a4 INT NOT NULL AUTO_INCREMENT PRIMARY KEY, b4 INT DEFAULT 0);

delimiter //
CREATE TRIGGER testref BEFORE INSERT ON test1
FOR EACH ROW BEGIN
	INSERT INTO test2 SET a2 = NEW.a1;
	DELETE FROM test3 WHERE a3 = NEW.a1;
	UPDATE test4 SET b4 = b4 + 1 WHERE a4 = NEW.a1;
END;
//

select * from test4;

INSERT INTO test3 (a3) VALUES
(NULL), (NULL), (NULL), (NULL), (NULL), (NULL), (NULL), (NULL), (NULL), (NULL);

INSERT INTO test4 (a4) VALUES
(0), (0), (0), (0), (0), (0), (0), (0), (0), (0);

-- EJEMPLO 3 --

DROP TABLE IF EXISTS empleados;

CREATE TABLE empleados
(id_empleado int not null auto_increment,
nombre varchar(100),
seccion varchar(100),
PRIMARY KEY(id_empleado));

INSERT INTO empleados VALUES
(0,'Ivan Pérez','Líder de proyecto'),
(0,'Susana Bautista','Administrador de base de datos'),
(0,'Max Zavala','Analista'),
(0,'Javier Medina','Programador');

DROP TABLE IF EXISTS auditoria_empleados;

CREATE TABLE auditoria_empleados
(id_audit_emp int not null auto_increment,
nombre varchar(100),
anterior_seccion varchar(100),
usuario varchar(40),
modificado datetime,
primary key(id_audit_emp));

DROP TRIGGER IF EXISTS trigger_auditoria_empleados;

CREATE TRIGGER trigger_auditoria_empleados AFTER UPDATE ON empleados
FOR EACH ROW
INSERT INTO auditoria_empleados
VALUES (0,OLD.nombre, OLD.seccion, CURRENT_USER(), NOW());


-- EJEMPLO 4 --

DROP TRIGGER IF EXISTS actualizar_orden;

delimiter //
CREATE TRIGGER actualizar_orden AFTER UPDATE on product
FOR EACH ROW
BEGIN
	DECLARE done INT DEFAULT 0;
	DECLARE orden int;
	DECLARE producto int;
	DECLARE productos CURSOR FOR
		SELECT coi.order_id, coi.product_id
		FROM customerorderitem coi
		INNER JOIN customerorder co ON co.order_id=coi.order_id
		WHERE coi.product_id=NEW.product_id and co.status='CM';
		
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=1;
			OPEN productos;
			productos_loop:LOOP
			FETCH productos into orden, producto;
				IF done=1 THEN
					LEAVE productos_loop;
				END IF;
			update customerorderitem set price=NEW.unit_price where order_id=orden and product_id=producto;
			END LOOP;
	CLOSE productos;
END;
//
