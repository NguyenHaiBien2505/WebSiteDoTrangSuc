CREATE DATABASE  IF NOT EXISTS `diamonshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `diamonshop`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: diamonshop
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `chitietphieunhap`
--

DROP TABLE IF EXISTS `chitietphieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietphieunhap` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `receipt_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `receipt_id` (`receipt_id`),
  CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `hanghoa` (`product_id`),
  CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`receipt_id`) REFERENCES `phieunhap` (`receipt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietphieunhap`
--

LOCK TABLES `chitietphieunhap` WRITE;
/*!40000 ALTER TABLE `chitietphieunhap` DISABLE KEYS */;
INSERT INTO `chitietphieunhap` VALUES 
(1,5,13,90,'2024-12-24',120000),
(2,5,14,12000,'2024-12-18',12000),
(3,6,14,5,'2025-01-07',12000000),
(4,7,15,0,'2024-12-19',12000000),
(5,8,15,0,'2024-12-25',10000000),
(6,9,15,12,'2025-01-02',10000000),
(7,5,16,0,'2024-12-18',10000),
(8,5,17,1000,'2024-12-18',12000),
(9,5,18,1000,'2024-12-18',12000),
(10,10,18,10,'2024-12-31',1234590);
/*!40000 ALTER TABLE `chitietphieunhap` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `hanghoa`
--

DROP TABLE IF EXISTS `hanghoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hanghoa` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `hanghoa_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `loai` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hanghoa`
--

LOCK TABLES `hanghoa` WRITE;
/*!40000 ALTER TABLE `hanghoa` DISABLE KEYS */;
INSERT INTO `hanghoa` VALUES 
(5,'Nhẫn Cưới Vàng Trắng 18K Moissanite NC0311','Tuyệt','Vàng Trắng',1),
(6,'Dây chuyền Vàng trắng Ý 18K PNJ 0000W061289','Tốt','Bạch Kim',2),
(7,'Bông tai Vàng trắng 10K đính đá ECZ PNJ XMXMW000142','Tuyệt','Bạch Kim',3),
(8,'Vòng tay bạc Ý đính đá PNJSilver XMXMK060002','Tuyệt','Bạc',4),
(9,'Day-Date 40','Tuyệt','Bạch Kim - Kim Cương',5),
(10,'Đồng hồ Nam Orient Phiên bản đặc biệt 2025 RA-AS0105S30B','Tuyệt','Vàng',4);
/*!40000 ALTER TABLE `hanghoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai`
--

DROP TABLE IF EXISTS `loai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai`
--

LOCK TABLES `loai` WRITE;
/*!40000 ALTER TABLE `loai` DISABLE KEYS */;
INSERT INTO `loai` VALUES (1,'Nhẫn'),(2,'Dây Chuyền'),
(3,'Hoa Tai'), (4, 'Đồng Hồ'), (5, 'Vòng Tay');
/*!40000 ALTER TABLE `loai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `receipt_id` int NOT NULL AUTO_INCREMENT,
  `create_at` date DEFAULT NULL,
  `supplier` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`receipt_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` VALUES 
(13,'2024-12-10','Nhà cung cấp X','Ngoonnn','SUCCESS',2),
(14,'2024-12-10','Nhà cung cấp Long Thành','Số 1 Việt Nam','REJECTED',2),
(15,'2024-12-11','Nhà phân phối Thế Cường','Số 1 Việt Nam','SUCCESS',2),
(16,'2024-12-11','Nhà phân phối Thế Cường','Số 1 Việt Nam','SUCCESS',4),
(17,'2024-12-12','Nhà phân phối Thế Cường','Số 1 Việt Nam','SUCCESS',4),
(18,'2024-12-12','Nhà phân phối Thế Cường','Số 1 Việt Nam','SUCCESS',2);
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES 
(1,'admin','admin','John Doen','admin@gmail.com','123456789','QUANTRI','2024-12-04 05:21:02','2024-12-11 02:44:13'),
(2,'nhanvien','nhanvien','Jonny Depth','jonny@gmail.com','0987654324','NHANVIEN','2024-12-05 09:55:12','2024-12-07 05:00:05'),
(3,'khachhang','khachhang','Stark Depth','stark@gmail.com','0987654324','KHACHHANG','2024-12-05 09:55:12','2024-12-07 05:00:05'),
(4,'quanly','quanly','Tom Harley','mark123@gmail.com','0978720123','QUANLY','2024-12-05 14:36:50','2024-12-07 15:55:33'),
(5,'user','user','Ant Ben','ben@gmail.com','0978720503','NHANVIEN','2024-12-06 14:20:40','2024-12-06 14:20:40');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'diamonshop'
--

--
-- Dumping routines for database 'diamonshop'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-12  7:20:30
