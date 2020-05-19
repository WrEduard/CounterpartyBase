-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: counterbase
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `counter` (
  `idcounter` int(11) NOT NULL AUTO_INCREMENT,
  `name_counter` varchar(255) NOT NULL,
  `legal_form` varchar(45) NOT NULL,
  `EDRPOU` varchar(10) NOT NULL,
  `director` varchar(100) NOT NULL,
  `cooperation` varchar(255) NOT NULL,
  `responsible_person` varchar(255) NOT NULL,
  `legal_address` mediumtext NOT NULL,
  `mailing_address` mediumtext,
  `date_of_foundation` varchar(10) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `phone_fax` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `person_1` varchar(255) DEFAULT NULL,
  `person_1_position` varchar(255) DEFAULT NULL,
  `person_1_mobile_phone` varchar(45) DEFAULT NULL,
  `person_1_email` varchar(45) DEFAULT NULL,
  `person_2` varchar(255) DEFAULT NULL,
  `person_2_position` varchar(255) DEFAULT NULL,
  `person_2_mobile_phone` varchar(45) DEFAULT NULL,
  `person_2_email` varchar(45) DEFAULT NULL,
  `person_3` varchar(255) DEFAULT NULL,
  `person_3_position` varchar(255) DEFAULT NULL,
  `person_3_mobile_phone` varchar(45) DEFAULT NULL,
  `person_3_email` varchar(45) DEFAULT NULL,
  `bank_details` varchar(255) DEFAULT NULL,
  `IPN` varchar(15) DEFAULT NULL,
  `certificate_PDV` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idcounter`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counter`
--

LOCK TABLES `counter` WRITE;
/*!40000 ALTER TABLE `counter` DISABLE KEYS */;
INSERT INTO `counter` VALUES (1,'Верест','Товариство з обмеженою відповідальністю','23846567','Страхоцінський Віктор Вікторович','М\'ясні та ковбасні вироби','Врублевський Едуард Анатолійович','32460, Хмельницька обл., Дунаєвецький р-н., с. Гірчична, вул. Центральна, 16','32460, Хмельницька обл., Дунаєвецький р-н., с. Гірчична, вул. Центральна, 16','16.10.1997','067 247-47-75','03858 3-16-45','verest@ukrpost.ua','Дзюбецький Валентин Іванович','Начальник відділу постачання','067 744-20-88','verest.postavka@gmail.com','Паньо Степан Васильович','Головний бухгалтер','097 740-80-52','','Вітровчак Богдан Григорович','Начальник відділу реалізації','098 913-20-94','verest.ceh@gmail.com','п/р 26009316610558 в АТ \"Ощадбанк\", МФО 315784','238465622076','200152647');
/*!40000 ALTER TABLE `counter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'counterbase'
--

--
-- Dumping routines for database 'counterbase'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21 10:06:10
