-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: website
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertable` (
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photoName` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `personID` bigint(20) NOT NULL,
  `addressID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`personID`),
  KEY `FKgj1pgukc4me4gr3hj6g6uk592` (`addressID`),
  CONSTRAINT `FKgj1pgukc4me4gr3hj6g6uk592` FOREIGN KEY (`addressID`) REFERENCES `addresstable` (`addressID`),
  CONSTRAINT `FKgqih14oq5pbdva17jqyu84ekl` FOREIGN KEY (`personID`) REFERENCES `persontable` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES ('admin@gmail.com','Male','8572507875','images/joe.jpg','user','admin','admin',1,1),('mishal.s@husky.neu.edu','Male','8572507875','images/12419364_10153773219825185_2329086872763096092_o (2).jpg','user','sm','sm',2,2),('cb@gmail.com','Male','8572507875','images/lady3.jpg','user','cb','cb',3,3),('ak@gmail.com','Male','8572507875','images/toni.jpg','user','ak','ak',4,4),('dk@gmail.com','Female','8572507875','images/12931252_971178669630644_4259525510456979157_n.jpg','user','dk','dk',5,5),('nf@gmail.com','Male','8572507875','images/tdgm7.jpg','user','nf','nf',6,6),('kunal@gmail.com','Male','8572507503','images/lady4.jpg','user','kr','kr',7,7),('st@gmail.com','Male','8572507875','images/t8mne.jpg','user','st','st',8,8);
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  8:47:23
