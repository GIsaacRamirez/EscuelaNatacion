-- MySQL dump 10.13  Distrib 5.6.27, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: escuelanatacion
-- ------------------------------------------------------
-- Server version	5.6.27-2

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
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clase` (
  `IdClase` int(11) NOT NULL,
  `IdInstructor` int(11) DEFAULT NULL,
  `HoraInicio` time DEFAULT NULL,
  `HoraFinal` time DEFAULT NULL,
  `Precio` decimal(12,2) DEFAULT NULL,
  `Cupo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdClase`),
  KEY `IdInstructor` (`IdInstructor`),
  CONSTRAINT `clase_ibfk_1` FOREIGN KEY (`IdInstructor`) REFERENCES `empleado` (`IdEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claseDia`
--

DROP TABLE IF EXISTS `claseDia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `claseDia` (
  `IdClase` int(11) DEFAULT NULL,
  `Dia` varchar(15) DEFAULT NULL,
  `IdClaseDia` int(11) NOT NULL,
  PRIMARY KEY (`IdClaseDia`),
  KEY `IdClase` (`IdClase`),
  CONSTRAINT `claseDia_ibfk_1` FOREIGN KEY (`IdClase`) REFERENCES `clase` (`IdClase`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claseDia`
--

LOCK TABLES `claseDia` WRITE;
/*!40000 ALTER TABLE `claseDia` DISABLE KEYS */;
/*!40000 ALTER TABLE `claseDia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `IdCliente` int(11) NOT NULL,
  `ApellidoPaterno` varchar(35) NOT NULL,
  `ApellidoMaterno` varchar(35) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `NumeroInterior` varchar(7) DEFAULT NULL,
  `Calle` varchar(50) DEFAULT NULL,
  `Colonia` varchar(40) DEFAULT NULL,
  `Municipio` varchar(40) DEFAULT NULL,
  `Entidad` varchar(40) DEFAULT 'Jalisco',
  `Status` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdCliente`),
  UNIQUE KEY `IdEmpleado` (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Ferreira','Arias','Fernando','','','','','Tlaquepaque','JALISCO',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `IdEmpleado` int(11) NOT NULL,
  `ApellidoPaterno` varchar(35) NOT NULL,
  `ApellidoMaterno` varchar(35) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `NumeroInterior` varchar(7) DEFAULT NULL,
  `Calle` varchar(50) DEFAULT NULL,
  `Colonia` varchar(40) DEFAULT NULL,
  `Municipio` varchar(40) DEFAULT NULL,
  `Entidad` varchar(40) DEFAULT 'Jalisco',
  `Status` tinyint(1) NOT NULL,
  `Instructor` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`IdEmpleado`),
  UNIQUE KEY `IdEmpleado` (`IdEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'R','S','G','3','165','Francisco','S','T','Jalisco',1,NULL),(2,'Ramírez','Ramírez','Guillermo Isaac','3','185','Francisco','S','T','Jalisco',1,NULL);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroClase`
--

DROP TABLE IF EXISTS `registroClase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registroClase` (
  `IdClaseDia` int(11) DEFAULT NULL,
  `IdCliente` int(11) DEFAULT NULL,
  KEY `IdClaseDia` (`IdClaseDia`),
  KEY `IdCliente` (`IdCliente`),
  CONSTRAINT `registroClase_ibfk_1` FOREIGN KEY (`IdClaseDia`) REFERENCES `claseDia` (`IdClaseDia`),
  CONSTRAINT `registroClase_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroClase`
--

LOCK TABLES `registroClase` WRITE;
/*!40000 ALTER TABLE `registroClase` DISABLE KEYS */;
/*!40000 ALTER TABLE `registroClase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `Usuario` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `IdEmpledo` int(11) DEFAULT NULL,
  `Tipo` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Usuario`),
  KEY `IdEmpledo` (`IdEmpledo`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IdEmpledo`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('membrillo','auge',2,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-24 17:20:08
