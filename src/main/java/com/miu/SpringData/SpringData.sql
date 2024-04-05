-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: realstate
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `street` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `zip` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (3,'123 Main St','Anytown','12345'),(4,'456 Elm St','Smallville','54321'),(5,'789 Oak St','Bigtown','98765'),(6,'321 Maple St','Hometown','56789'),(7,'456 Elm St','Smallville','54321'),(8,'654 Pine St','Villageton','34567'),(9,'876 Cedar St','Metropolis','23456'),(10,'210 Birch St','Cityville','65432'),(11,'543 Spruce St','Townsville','87654'),(12,'987 Walnut St','Suburbia','23451'),(13,'1011 Cedar St','Ruraltown','78901'),(14,'1213 Ash St','Countryside','34512'),(15,'1415 Poplar St','Farmland','67890'),(16,'1617 Pine St','Beachtown','12378'),(17,'1819 Elm St','Mountaintop','87645'),(18,'2021 Oak St','Valleyville','56789'),(19,'2223 Maple St','Rivercity','90123'),(20,'2425 Cedar St','Lakeview','45678'),(21,'2627 Birch St','Desertville','23456'),(22,'2829 Spruce St','Harbortown','78901'),(23,'3031 Walnut St','Mountainview','34567'),(24,'4th street 1000','fairfield','52557');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (3,'book'),(4,'Electronics'),(5,'Clothing'),(6,'Books'),(7,'Home & Garden'),(8,'Toys & Games'),(9,'Sports & Outdoors'),(10,'Health & Beauty'),(11,'Automotive'),(12,'Food & Drink'),(13,'Music'),(14,'Food & Drink');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,'Smartphone',599.99,4.5,4),(4,'T-shirt',19.99,4.2,5),(5,'Book',29.99,4.8,6),(6,'Lawn Mower',299.99,4,7),(7,'Board Game',39.99,4.6,8),(8,'Soccer Ball',19.99,4.4,9),(9,'Shampoo',9.99,4.7,10),(10,'The Great Gatsby',12.99,4.7,6),(11,'To Kill a Mockingbird',10.99,4.8,6);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(45) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `review_user_id_fk` (`user_id`),
  KEY `review_product_id_fk` (`product_id`),
  CONSTRAINT `review_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `review_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'comment 1 changed',9,9),(2,'comment 2',9,9),(3,'comment 2',9,9);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(320) NOT NULL,
  `password` varchar(128) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `address_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_address_id_fk` (`address_id`),
  CONSTRAINT `user_address_id_fk` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (9,'user1@example.com','password1','John','Doe',13),(10,'user2@example.com','password2','Jane','Smith',3),(11,'user3@example.com','password3','Michael','Johnson',17),(12,'user4@example.com','password4','Emily','Brown',16),(13,'user5@example.com','password5','David','Davis',15),(14,'user6@example.com','password6','Sarah','Wilson',18),(15,'user7@example.com','password7','Matthew','Taylor',14),(16,'user8@example.com','password8','Emma','Martinez',19),(17,'user9@example.com','password9','James','Anderson',8),(18,'user10@example.com','password10','Olivia','Garcia',5);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-04 22:33:02
