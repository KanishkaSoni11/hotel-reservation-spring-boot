CREATE DATABASE  IF NOT EXISTS `hotel_reservation_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel_reservation_system`;
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
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `bill_paid_trigger` AFTER DELETE ON `bill_details` FOR EACH ROW begin
		declare  v_room_number int;
        declare  v_res_id int;
        declare count_num_rooms int;
        declare room_nums int;

        select room_number into v_room_number from bill_details where room_number = old.room_number;

		select reservation_number into v_res_id from reservation_assignment where room_number = old.room_number;

        select count(*) into count_num_rooms from reservation_assignment where reservation_number = v_res_id;

			delete from order_details where room_number = old.room_number;
          if(count_num_rooms = 0) then
			 delete from reservation where reservation_number = v_res_id;
        end if;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
                            `customer_id` int NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(60) NOT NULL,
                            `last_name` varchar(60) NOT NULL,
                            `street` varchar(50) NOT NULL,
                            `state` varchar(20) NOT NULL,
                            `zipcode` int NOT NULL,
                            `email_id` varchar(100) NOT NULL,
                            `contact_no` int NOT NULL,
                            `identification_number` varchar(50) NOT NULL,
                            `password` varchar(20) DEFAULT NULL,
                            PRIMARY KEY (`customer_id`),
                            UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_item`
--

DROP TABLE IF EXISTS `food_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_item` (
                             `item_id` int NOT NULL AUTO_INCREMENT,
                             `item_name` varchar(20) NOT NULL,
                             `item_desc` varchar(50) NOT NULL,
                             `item_available` tinyint(1) NOT NULL,
                             `cost` decimal(10,2) NOT NULL,
                             PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_item`
--

LOCK TABLES `food_item` WRITE;
/*!40000 ALTER TABLE `food_item` DISABLE KEYS */;
INSERT INTO `food_item` VALUES (3,'Chicken Burger','Crispy seasoned chicken breast, topped cheese',1,25.00),(5,'Veg Pizza ','Vegetarian Pizza with Garlic Bread',1,29.00),(6,'Salmon ','Grilled Salmon with Mashed Potatoes',1,27.00),(7,'Beef Burger','Beef Burger with Rings',1,23.00),(9,'Ramen','Chicken Ramen',1,19.00),(10,'Pasta','Shrimp Scampi Pasta with Caesar salad',1,17.00);
/*!40000 ALTER TABLE `food_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
                                 `order_id` int NOT NULL AUTO_INCREMENT,
                                 `total_cost` decimal(10,2) NOT NULL,
                                 `room_number` int NOT NULL,
                                 `order_status` varchar(10) NOT NULL,
                                 PRIMARY KEY (`order_id`),
                                 KEY `room_number` (`room_number`),
                                 CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`room_number`) REFERENCES `room` (`room_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
                               `reservation_number` int NOT NULL AUTO_INCREMENT,
                               `number_of_rooms` int NOT NULL,
                               `number_of_guests` int NOT NULL,
                               `type_of_room` varchar(40) NOT NULL,
                               `date_of_reservation` date NOT NULL,
                               `date_from` date NOT NULL,
                               `date_to` date NOT NULL,
                               PRIMARY KEY (`reservation_number`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `room_assigment_trigger` AFTER INSERT ON `reservation_assignment` FOR EACH ROW begin
    update room set availability_status = 'Not Available' where room_number = new.room_number;
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
INSERT INTO `room` VALUES (1,'KING','Available',250.00),(2,'KING','Available',250.00),(3,'KING','Available',250.00),(4,'KING','Available',250.00),(5,'KING','Available',250.00),(6,'KING','Available',250.00),(7,'KING','Available',250.00),(8,'KING','Available',250.00),(9,'KING','Available',250.00),(10,'KING','Available',250.00),(11,'KING','Available',250.00),(12,'KING','Available',250.00),(13,'KING','Available',250.00),(14,'KING','Available',250.00),(15,'KING','Available',250.00),(16,'SUITE','Available',350.00),(17,'SUITE','Available',350.00),(18,'SUITE','Available',350.00),(19,'SUITE','Available',350.00),(20,'SUITE','Available',350.00),(21,'SUITE','Available',350.00),(22,'SUITE','Available',350.00),(23,'SUITE','Available',350.00),(24,'SUITE','Available',350.00),(25,'SUITE','Available',350.00),(26,'SUITE','Available',350.00),(27,'SUITE','Available',350.00),(28,'SUITE','Available',350.00),(29,'SUITE','Available',350.00),(30,'SUITE','Available',350.00);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
                         `staff_id` int NOT NULL AUTO_INCREMENT,
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
                         PRIMARY KEY (`staff_id`),
                         UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (113,'Emma','James','Boylston','MA',2215,'ema@gmail.com',888777334,200000.00,'2022-01-01','pass'),(114,'John','Wick','Boylston','MA',2215,'john@gmail.com',999444555,250000.00,'2022-04-01','pass');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hotel_reservation_system'
--

--
-- Dumping routines for database 'hotel_reservation_system'
--
/*!50003 DROP FUNCTION IF EXISTS `isReservationPossible` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `isReservationPossible`(
to_date date,
from_date date,
num_rooms int,
p_room_type varchar(20)) RETURNS int
    DETERMINISTIC
begin
	declare result boolean;
    declare count_rooms int;
select count(*) into count_rooms from
    (
        select r.*, ra.reservation_number from room r
                                                   left join reservation_assignment ra
                                                             on r.room_number = ra.room_number
        where lower(r.room_type) = lower(p_room_type)
    ) as t
        left join reservation res on
            res.reservation_number = t.reservation_number
where t.room_number not in (
    select room_number from reservation res join
                            reservation_assignment ra
                            on res.reservation_number = ra.reservation_number
    where res.date_to >= to_date
      and res.date_from <= from_date
);

if (num_rooms <= count_rooms) then
	set result = 1;
end if;
if (num_rooms > count_rooms) then
	set result = 0;
end if;
return result;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `num_genres` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `num_genres`(isbn_p char(13)) RETURNS int
    READS SQL DATA
    DETERMINISTIC
begin
	declare  num_genre_isbn int;
select count(*) into num_genre_isbn
from book_genre where isbn =  isbn_p;

return num_genre_isbn;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `sum_bill_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `sum_bill_details`(p_room_number int) RETURNS int
    READS SQL DATA
    DETERMINISTIC
begin
	declare  v_sum int;
select sum(cost)into v_sum from bill_details
where room_number = p_room_number;

return v_sum;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `active_reservation_proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `active_reservation_proc`()
begin
select  c.first_name,r3.date_from, r3.date_to, r3.type_of_room, r1.reservation_number, r1.room_number,c.customer_id
from reservation_assignment r1 join reservation_placed r2 on
        r1.reservation_number = r2.reservation_id
                               join reservation r3 on r3.reservation_number = r1.reservation_number
                               join customer c
                                    on c.customer_id = r2.customer_id
where r1.res_status = "Checked-in";
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
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
/*!50003 DROP PROCEDURE IF EXISTS `bill_paid` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bill_paid`(
in p_room_number int, in p_customer_id int)
begin
declare count_num_rooms int;
declare  v_res_id int;
select reservation_number into v_res_id from reservation_assignment where room_number = p_room_number;

delete from reservation_assignment where room_number = p_room_number;
delete from bill_details where room_number = p_room_number;
select * from customer where customer_id = p_customer_id;



select count(*) into count_num_rooms from reservation_assignment where reservation_number = v_res_id;


if(count_num_rooms = 0) then
delete from reservation where reservation_number = v_res_id;
end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkout_customer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkout_customer`(in p_customer_id int,
in p_room_number int)
begin

update reservation_assignment set res_status = "Check-out" where room_number  = p_room_number;
-- delete from bill_details where room_number = p_room_number;
-- delete from order_details where room_number = p_room_number;
select * from customer where customer_id = p_customer_id;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `completed_food_orders` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `completed_food_orders`(in p_staff_id int,
in p_order_id int)
begin
insert into order_staff_link values (p_order_id, p_staff_id);
update order_details set  order_status = "Completed" where order_id = p_order_id;
select * from order_details where order_id = p_order_id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_reservation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `create_reservation`(
p_from_date date,
p_to_date date,
p_num_room int,
p_num_guests int,
p_date_of_res date,
p_room_type varchar(100),
customer_id int)
begin
	declare max_id int;
select max(reservation_number) into max_id from reservation;
insert into reservation values (max_id + 1, p_num_room, p_num_guests, p_room_type, p_date_of_res, p_from_date, p_to_date);
insert into reservation_placed values (customer_id, max_id + 1);
select * from reservation where reservation_number = max_id + 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `customer_order_history` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `customer_order_history`(
in p_customer_id int)
begin
select od.order_id, od.room_number, fi.item_name, ofl.quantity, od.order_status  from order_details od
                                                                                          join order_food_link ofl
                                                                                               on od.order_id = ofl.order_id
                                                                                          join food_item fi
                                                                                               on fi.item_id = ofl.item_id
where od.room_number in (
    select room_number from reservation_assignment ra
                                join reservation_placed rp
                                     on ra.reservation_number = rp.reservation_id
    where rp.customer_id = p_customer_id
);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_available_rooms_staff` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_available_rooms_staff`(in p_room_type varchar (10),
                                           in p_date_from date,
                                           in p_date_to date)
begin
select room_number, room_type, availability_status, cost
from room
where room_number not in
      (select r1.room_number
       from reservation_assignment r1
                join reservation r3
                     on r3.reservation_number = r1.reservation_number
                            and date_from between p_date_from and p_date_to
                         OR date_to between p_date_from and p_date_to)
  and room_type = p_room_type;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_order_details` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_order_details`(
p_room_number int)
begin
	declare max_id int;
select max(order_id) into max_id from order_details;
insert into order_details values (max_id + 1, 0, p_room_number, 'PENDING');
select * from order_details where order_id = max_id + 1;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pending_food_orders` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pending_food_orders`()
begin
select o1.order_id, o1.room_number, f.item_name, o2.quantity from order_details o1 join  order_food_link o2
                                                                                         on o1.order_id = o2.order_id
                                                                                   join food_item f on f.item_id = o2.item_id
where o1.order_status = "Pending";
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `staff_check_in` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `staff_check_in`(
in p_reservation_number int,
in p_staff_id int,
in p_room_number int,
in p_res_status varchar(10)
)
begin
	declare v_room_cost decimal(12,2);

select cost into v_room_cost from room where room_number = p_room_number;
insert into reservation_assignment values(p_reservation_number, p_staff_id, p_room_number, p_res_status);
insert into bill_details (room_number, cost, bill_description, payment_method, payment_details, bill_date) values(
                                                                                                                     p_room_number, v_room_cost, "Room Cost", "Credit Card", "XXXX-XXXX-XXXX-XXXX", sysdate());
select * from reservation_assignment where reservation_number = p_reservation_number and room_number = p_room_number;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `staff_room_proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `staff_room_proc`()
begin
declare num_rooms int;

select first_name, date_from, date_to, type_of_room, reservation_number, (number_of_rooms- (
    select count(*) from reservation_assignment r1 where r1.reservation_number =  reservation.reservation_number)) as number_of_rooms
from reservation
         join
     reservation_placed on reservation_placed.reservation_id = reservation.reservation_number
         join customer on customer.customer_id = reservation_placed.customer_id
where reservation_number not in (select reservation_number from reservation_assignment
                                 where  res_status ='Check-out');
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_order_cost_bill` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_order_cost_bill`(
p_order_id int,
p_room_number int,
p_bill_date date)
begin
	declare food_total_cost int;
    declare bill_desc varchar(300);
    set bill_desc = concat('Food bill for order ', p_order_id);
select  sum(ofl.quantity * fi.cost) into food_total_cost from order_food_link ofl
                                                                  join food_item fi
                                                                       on ofl.item_id = fi.item_id
where ofl.order_id = p_order_id;
update order_details set total_cost = food_total_cost where order_id = p_order_id;
insert into bill_details (room_number, cost, bill_description, payment_method, payment_details, bill_date)
values (p_room_number, food_total_cost, bill_desc,'Cash', 'Cash', p_bill_date);
select * from order_details where order_id = p_order_id;
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

-- Dump completed on 2023-04-21 15:52:31
