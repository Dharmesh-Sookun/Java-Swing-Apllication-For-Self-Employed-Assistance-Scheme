-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mra_seas
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applicant_details`
--

DROP TABLE IF EXISTS `applicant_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicant_details` (
  `applicant_nid` varchar(14) NOT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `other_names` varchar(255) DEFAULT NULL,
  `monthly_income` double DEFAULT NULL,
  `married` varchar(1) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `house_num` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `locality` varchar(255) DEFAULT NULL,
  `mauritius_postal_region` varchar(255) DEFAULT NULL,
  `village_town` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `business_place` varchar(255) DEFAULT NULL,
  `business_start_date` date DEFAULT NULL,
  `telephone_num` varchar(255) DEFAULT NULL,
  `mobile_num` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `spouse_nid` varchar(14) DEFAULT NULL,
  `spouse_name` varchar(255) DEFAULT NULL,
  `spouse_passport_num` varchar(255) DEFAULT NULL,
  `spouse_occupation` varchar(255) DEFAULT NULL,
  `bank_acc_num` varchar(30) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `account_holder_name` varchar(255) DEFAULT NULL,
  `applied` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`applicant_nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant_details`
--

LOCK TABLES `applicant_details` WRITE;
/*!40000 ALTER TABLE `applicant_details` DISABLE KEYS */;
INSERT INTO `applicant_details` VALUES ('S2906991902882','Sookun','Dharmesh Kumar',30000,'N','1999-06-29','56','Delphinum','Riviere du Poste','Riviere Du Poste','Riviere du Poste','R05623','Artist','Curepipe','2017-04-04','6178479','58108134','test@gmail.com','','','','','000235689','AfrAsia Bank Limited','Sookun Dharmesh Kumar','Y');
/*!40000 ALTER TABLE `applicant_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-20 15:22:48
