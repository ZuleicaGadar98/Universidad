CREATE DATABASE  IF NOT EXISTS `empresa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `empresa`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: empresa
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `antiguedad`
--

DROP TABLE IF EXISTS `antiguedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antiguedad` (
  `antiguedad` int(3) unsigned NOT NULL DEFAULT '0',
  `factor_compensacion` float DEFAULT NULL,
  PRIMARY KEY (`antiguedad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antiguedad`
--

LOCK TABLES `antiguedad` WRITE;
/*!40000 ALTER TABLE `antiguedad` DISABLE KEYS */;
INSERT INTO `antiguedad` VALUES (1,0),(2,0.5),(3,1),(4,2),(5,5),(6,5.5),(7,6),(8,7.5),(9,8),(10,10);
/*!40000 ALTER TABLE `antiguedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id_depto` int(2) NOT NULL DEFAULT '0',
  `nombre` varchar(20) DEFAULT 'NULL',
  `nssgted` varchar(12) DEFAULT '0',
  PRIMARY KEY (`id_depto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Dirección','888665555'),(4,'Administración','987654321'),(5,'Investigación','333445555');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `nss` varchar(12) NOT NULL DEFAULT '0',
  `nombre` varchar(30) DEFAULT 'NULL',
  `fecha_nac` varchar(10) DEFAULT 'NULL',
  `direccion` varchar(40) DEFAULT 'NULL',
  `id_depto` int(2) DEFAULT '0',
  `antiguedad` int(3) unsigned NOT NULL,
  PRIMARY KEY (`nss`),
  KEY `fk_deptoemp` (`id_depto`),
  KEY `fk_antemp_idx` (`antiguedad`),
  CONSTRAINT `fk_antemp` FOREIGN KEY (`antiguedad`) REFERENCES `antiguedad` (`antiguedad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_deptoemp` FOREIGN KEY (`id_depto`) REFERENCES `departamento` (`id_depto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('123456789','Silva Jose B','09/01/1955','Fresnos 731 Ensenada Mx',5,2),('333445555','Vizcarra Manuel','01/12/1945','Valle 638, Ensenada Mx',5,4),('453453453','Esparza, Josefa','31/07/1962','Rosas 5631, Ensenada Mx',5,5),('666884444','Nieto, Ramon','15/09/1952','espiga 957, Ensenada Mx',5,7),('776655442','Salcedo, Oscar','18/11/1970','Geranios 156, Ensenada Mx',1,8),('888665555','Botello, Jaime','11/11/1927','Sorgo 450, Ensenada Mx',1,9),('987654321','Valdez, Jazmin','22/06/1931','Bravo 291, Tecate',4,10),('987987987','Jabbr, Ahmed','23/03/1959','dalias 980, Ensenada Mx',4,10),('999887777','Zapata, Alicia','19/07/1958','Castillo 3321',4,10),('999999999','Cervantes, Selene','03/02/1977','Castillo 450, Ensenada Mx',1,10);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `id_proyecto` int(2) NOT NULL DEFAULT '0',
  `nombre` varchar(20) DEFAULT 'NULL',
  `ubicacion` varchar(20) DEFAULT 'NULL',
  `id_depto` int(2) DEFAULT '0',
  PRIMARY KEY (`id_proyecto`),
  KEY `fk_deptoproy` (`id_depto`),
  CONSTRAINT `fk_deptoproy` FOREIGN KEY (`id_depto`) REFERENCES `departamento` (`id_depto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'productox','Tecate',5),(2,'productoy','Mexicali',5),(3,'productoz','Ensenada',5),(10,'automatizacion','Tijuana',4),(20,'reorganizacion','Ensenada',1),(30,'nuevasprestaciones','Tijuana',4);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puesto` (
  `id_puesto` smallint(5) unsigned NOT NULL DEFAULT '0',
  `nombre` varchar(30) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  PRIMARY KEY (`id_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (100,'Gerente',40000),(200,'Jefe Departamento',20000),(300,'Líder de Proyecto',25000),(400,'Investigador',18000),(500,'Vendedor',15000),(600,'Asistente Administrativo',12000);
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabaja_en`
--

DROP TABLE IF EXISTS `trabaja_en`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabaja_en` (
  `nss` varchar(12) NOT NULL DEFAULT '0',
  `id_proyecto` int(2) NOT NULL DEFAULT '0',
  `horas` float DEFAULT NULL,
  `id_puesto` smallint(5) unsigned DEFAULT NULL,
  `sueldo` float DEFAULT NULL,
  PRIMARY KEY (`nss`,`id_proyecto`),
  KEY `fk_proytben` (`id_proyecto`),
  KEY `fk_puestotben` (`id_puesto`),
  CONSTRAINT `fk_emptben` FOREIGN KEY (`nss`) REFERENCES `empleado` (`nss`),
  CONSTRAINT `fk_proytben` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id_proyecto`),
  CONSTRAINT `fk_puestotben` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabaja_en`
--

LOCK TABLES `trabaja_en` WRITE;
/*!40000 ALTER TABLE `trabaja_en` DISABLE KEYS */;
INSERT INTO `trabaja_en` VALUES ('123456789',2,7.5,300,2127.04),('333445555',2,10,400,1929.59),('333445555',3,10,400,1929.59),('333445555',10,10,400,1929.59),('333445555',20,10,400,1929.59),('453453453',2,20,400,3613.29),('666884444',3,40,400,6819.88),('776655442',20,40,200,7880.35),('888665555',20,10,600,1794.68),('987654321',20,15,600,2680.06),('987654321',30,20,600,3411.56),('987987987',10,35,600,5606.07),('987987987',30,5,600,1217.05),('999887777',10,10,200,2780.93),('999887777',30,30,200,6724.28),('999999999',20,40,100,14591.9);
/*!40000 ALTER TABLE `trabaja_en` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicacion_depto`
--

DROP TABLE IF EXISTS `ubicacion_depto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubicacion_depto` (
  `id_depto` int(2) NOT NULL DEFAULT '0',
  `ubicacion` smallint(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_depto`,`ubicacion`),
  KEY `fk_depubi2` (`ubicacion`),
  CONSTRAINT `fk_depubi1` FOREIGN KEY (`id_depto`) REFERENCES `departamento` (`id_depto`),
  CONSTRAINT `fk_depubi2` FOREIGN KEY (`ubicacion`) REFERENCES `ubicaciones` (`id_ubicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicacion_depto`
--

LOCK TABLES `ubicacion_depto` WRITE;
/*!40000 ALTER TABLE `ubicacion_depto` DISABLE KEYS */;
INSERT INTO `ubicacion_depto` VALUES (1,1),(5,1),(4,2),(5,3),(5,4);
/*!40000 ALTER TABLE `ubicacion_depto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicaciones`
--

DROP TABLE IF EXISTS `ubicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubicaciones` (
  `id_ubicacion` smallint(6) NOT NULL DEFAULT '0',
  `ubicacion` varchar(50) NOT NULL DEFAULT 'NA',
  PRIMARY KEY (`id_ubicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicaciones`
--

LOCK TABLES `ubicaciones` WRITE;
/*!40000 ALTER TABLE `ubicaciones` DISABLE KEYS */;
INSERT INTO `ubicaciones` VALUES (1,'ENSENADA'),(2,'TIJUANA'),(3,'MEXICALI'),(4,'TECATE'),(5,'ROSARITO');
/*!40000 ALTER TABLE `ubicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'empresa'
--

--
-- Dumping routines for database 'empresa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-06 13:56:13
