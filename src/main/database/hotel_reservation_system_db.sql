-- MySQL dump 10.13  Distrib 8.0.29, for macos12 (x86_64)
--
-- Host: localhost    Database: hotel_reservation_system
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `bill_details`
--

DROP TABLE IF EXISTS `bill_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_details` (
                                `bill_id` int NOT NULL AUTO_INCREMENT,
                                `room_number` int NOT NULL,
                                `cost` decimal(10,2) DEFAULT NULL,
                                `bill_description` varchar(100) DEFAULT NULL,
                                `payment_method` varchar(15) NOT NULL,
                                `payment_details` varchar(100) NOT NULL,
                                `bill_date` date NOT NULL,
                                PRIMARY KEY (`bill_id`),
                                KEY `room_number` (`room_number`),
                                CONSTRAINT `bill_details_ibfk_1` FOREIGN KEY (`room_number`) REFERENCES `room` (`room_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_details`
--

LOCK TABLES `bill_details` WRITE;
/*!40000 ALTER TABLE `bill_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
                            `customer_id` int NOT NULL,
                            `first_name` varchar(60) NOT NULL,
                            `last_name` varchar(60) NOT NULL,
                            `street` varchar(50) NOT NULL,
                            `state` varchar(20) NOT NULL,
                            `zipcode` int NOT NULL,
                            `email_id` varchar(100) NOT NULL,
                            `contact_no` int NOT NULL,
                            `identification_number` varchar(50) NOT NULL,
                            `password` varchar(20) DEFAULT NULL,
                            PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'first','Last','street','state',2215,'a@gmail.com',343333333,'avc','abc');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_item`
--

DROP TABLE IF EXISTS `food_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_item` (
                             `item_id` int NOT NULL,
                             `item_name` varchar(20) NOT NULL,
                             `item_desc` varchar(50) NOT NULL,
                             `item_available` tinyint(1) NOT NULL,
                             `cost` decimal(10,2) NOT NULL,
                             PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_item`
--

LOCK TABLES `food_item` WRITE;
/*!40000 ALTER TABLE `food_item` DISABLE KEYS */;
INSERT INTO `food_item` VALUES (1,'burger','veg burger',1,12.00);
/*!40000 ALTER TABLE `food_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
                                 `order_id` int NOT NULL,
                                 `total_cost` decimal(10,2) NOT NULL,
                                 `room_number` int NOT NULL,
                                 `order_status` varchar(10) NOT NULL,
                                 PRIMARY KEY (`order_id`),
                                 KEY `room_number` (`room_number`),
                                 CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`room_number`) REFERENCES `room` (`room_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_food_link`
--

DROP TABLE IF EXISTS `order_food_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_food_link` (
                                   `order_id` int NOT NULL,
                                   `item_id` int NOT NULL,
                                   `quantity` int NOT NULL,
                                   PRIMARY KEY (`order_id`,`item_id`,`quantity`),
                                   KEY `item_id` (`item_id`),
                                   CONSTRAINT `order_food_link_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                   CONSTRAINT `order_food_link_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `food_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_food_link`
--

LOCK TABLES `order_food_link` WRITE;
/*!40000 ALTER TABLE `order_food_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_food_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_staff_link`
--

DROP TABLE IF EXISTS `order_staff_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_staff_link` (
                                    `order_id` int NOT NULL,
                                    `staff_id` int NOT NULL,
                                    PRIMARY KEY (`order_id`,`staff_id`),
                                    KEY `staff_id` (`staff_id`),
                                    CONSTRAINT `order_staff_link_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                    CONSTRAINT `order_staff_link_ibfk_2` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_staff_link`
--

LOCK TABLES `order_staff_link` WRITE;
/*!40000 ALTER TABLE `order_staff_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_staff_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
                               `reservation_number` int NOT NULL,
                               `number_of_rooms` int NOT NULL,
                               `number_of_guests` int NOT NULL,
                               `type_of_room` varchar(40) NOT NULL,
                               `date_of_reservation` date NOT NULL,
                               `date_from` date NOT NULL,
                               `date_to` date NOT NULL,
                               PRIMARY KEY (`reservation_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (102,1,2,'King','2023-01-01','2023-01-01','2023-01-01');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_assignment`
--

DROP TABLE IF EXISTS `reservation_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation_assignment` (
                                          `reservation_number` int NOT NULL,
                                          `staff_id` int NOT NULL,
                                          `room_number` int NOT NULL,
                                          `res_status` varchar(10) DEFAULT NULL,
                                          PRIMARY KEY (`reservation_number`,`staff_id`,`room_number`),
                                          KEY `staff_id` (`staff_id`),
                                          KEY `room_number` (`room_number`),
                                          CONSTRAINT `reservation_assignment_ibfk_1` FOREIGN KEY (`reservation_number`) REFERENCES `reservation` (`reservation_number`) ON DELETE CASCADE ON UPDATE CASCADE,
                                          CONSTRAINT `reservation_assignment_ibfk_2` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                          CONSTRAINT `reservation_assignment_ibfk_3` FOREIGN KEY (`room_number`) REFERENCES `room` (`room_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_assignment`
--

LOCK TABLES `reservation_assignment` WRITE;
/*!40000 ALTER TABLE `reservation_assignment` DISABLE KEYS */;
INSERT INTO `reservation_assignment` VALUES (102,1,1,'check-in');
/*!40000 ALTER TABLE `reservation_assignment` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `room_ass` AFTER INSERT ON `reservation_assignment` FOR EACH ROW begin
	update room set availability_status = 'not av' where room_number = new.room_number;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `check_out_trigger` AFTER UPDATE ON `reservation_assignment` FOR EACH ROW begin
		-- declare  v_room_number int;
--         declare  v_res_id int;
-- 	    select reservation_number, room_number  into v_res_id, v_room_number from reservation_assignment
--         where res_status = new.res_status;

        delete from reservation where reservation_number = new.reservation_number;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `reservation_placed`
--

DROP TABLE IF EXISTS `reservation_placed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation_placed` (
                                      `customer_id` int NOT NULL,
                                      `reservation_id` int NOT NULL,
                                      PRIMARY KEY (`customer_id`,`reservation_id`),
                                      KEY `reservation_id` (`reservation_id`),
                                      CONSTRAINT `reservation_placed_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_number`) ON DELETE CASCADE ON UPDATE CASCADE,
                                      CONSTRAINT `reservation_placed_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_placed`
--

LOCK TABLES `reservation_placed` WRITE;
/*!40000 ALTER TABLE `reservation_placed` DISABLE KEYS */;
INSERT INTO `reservation_placed` VALUES (1,102);
/*!40000 ALTER TABLE `reservation_placed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
                        `room_number` int NOT NULL,
                        `room_type` varchar(60) NOT NULL,
                        `availability_status` varchar(20) NOT NULL,
                        `cost` decimal(12,2) NOT NULL,
                        PRIMARY KEY (`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'King','not av',100.00);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
                         `staff_id` int NOT NULL,
                         `first_name` varchar(60) NOT NULL,
                         `last_name` varchar(60) NOT NULL,
                         `street` varchar(50) NOT NULL,
                         `state` varchar(20) NOT NULL,
                         `zipcode` int NOT NULL,
                         `email_id` varchar(100) NOT NULL,
                         `contact_no` int NOT NULL,
                         `salary` decimal(12,2) NOT NULL,
                         `joining_date` date NOT NULL,
                         `password` varchar(20) DEFAULT NULL,
                         PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'A','B','123','MA',2215,'a@gmail.com',999999,12345.00,'2022-01-01','abc'),(11,'A','B','123','MA',2215,'a@gmail.com',999999,12345.00,'2022-01-01','abc'),(112,'A','B','123','MA',2215,'a@gmail.com',999999,12345.00,'2022-01-01','xyz');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hotel_reservation_system'
--

--
-- Dumping routines for database 'hotel_reservation_system'
--
/*!50003 DROP PROCEDURE IF EXISTS `add_to_bill_details_proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_to_bill_details_proc`(
in p_room_number int,
in p_payment_method char(15),
in p_payment_details char(100),
in p_bill_date date,
in p_cost decimal(10,2)
)
begin
insert into bill_details (room_number, payment_method,payment_details, bill_date,cost)
values (p_room_number,p_payment_method, p_payment_details,p_bill_date,p_cost  );
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-09 19:07:41
