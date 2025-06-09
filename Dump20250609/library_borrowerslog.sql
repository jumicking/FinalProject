-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `borrowerslog`
--

DROP TABLE IF EXISTS `borrowerslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrowerslog` (
  `idBorrowerslog` int NOT NULL AUTO_INCREMENT,
  `date` varchar(125) NOT NULL,
  `bookreference` varchar(125) NOT NULL,
  `bookname` varchar(125) NOT NULL,
  `borrowersname` varchar(125) NOT NULL,
  `borrowerscontact` varchar(125) NOT NULL,
  `Remarks` varchar(125) NOT NULL,
  PRIMARY KEY (`idBorrowerslog`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowerslog`
--

LOCK TABLES `borrowerslog` WRITE;
/*!40000 ALTER TABLE `borrowerslog` DISABLE KEYS */;
INSERT INTO `borrowerslog` VALUES (1,'2025-06-06 01:54:11','1000','The Ocean','Jumayca Rose','090909','Out'),(2,'2025-06-06 01:56:33','1000','The Ocean','Jumayca Rose','090909','Out'),(3,'2025-06-06 02:01:56','1000','The Ocean','Jumayca Rose','090909','Out'),(4,'2025-06-06 02:05:22','1000','The Ocean','Jumayca Rose','090909','Out : Return as you like'),(5,'2025-06-06 02:24:00','20','The Test','Jumayca Rose','090909','Out : Please return ASAP');
/*!40000 ALTER TABLE `borrowerslog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-09 18:56:42
