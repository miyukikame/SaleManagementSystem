CREATE SCHEMA IF NOT EXISTS pe_2021;
USE pe_2021;

DROP TABLE IF EXISTS `ORDERS`;

CREATE TABLE `ORDERS` (
  `Order_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Product_ID` int(10) unsigned NOT NULL,
  `Quantity` int(10) unsigned NOT NULL,
  `Price` int(10) unsigned NOT NULL,
  `Order_date` date NOT NULL,
  `User_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Order_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

LOCK TABLES `ORDERS` WRITE;

UNLOCK TABLES;


DROP TABLE IF EXISTS `PRODUCTS`;

CREATE TABLE `PRODUCTS` (
  `Product_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Price` decimal(10,0) unsigned NOT NULL,
  `Quantity` int(10) unsigned NOT NULL,
  `Type` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Product_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;


LOCK TABLES `PRODUCTS` WRITE;
INSERT INTO `PRODUCTS` VALUES (1,'third product','does nothing',11,23,1),(2,'test','test',50,30,1),(3,'phone','iphone',500,2,1),(4,'noch ein produkt','nichts',10,3,1),(5,'essen','essen',15,50,2);
UNLOCK TABLES;


DROP TABLE IF EXISTS `USERS`;

CREATE TABLE `USERS` (
  `Users_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `user_password` varchar(150) NOT NULL,
  PRIMARY KEY (`Users_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


LOCK TABLES `USERS` WRITE;

UNLOCK TABLES;

