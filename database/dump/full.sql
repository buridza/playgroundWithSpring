CREATE DATABASE  IF NOT EXISTS `playground` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `playground`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: playground
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apartment` int(11) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `house` int(11) NOT NULL,
  `street` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q0uja26qgu1atulenwup9rxyr` (`email`),
  UNIQUE KEY `UK_5vxwyorsr92jce3ore6h93k6q` (`login`),
  UNIQUE KEY `UK_tc6ucnxokji3104152s2rx919` (`apartment`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,77,'Vitebsk161',208,'volnaya203','petya@gmail.com215','proGame245','Ivan566','123458'),(2,1521,'Vitebsk425',884,'volnaya993','petya@gmail.com805','proGame1180','Ivan1096','12345495'),(4,1338,'Vitebsk1012',1191,'volnaya1348','petya@gmail.com69','proGame843','Ivan417','12345732'),(5,161,'Vitebsk1204',331,'volnaya520','petya@gmail.com239','proGame1034','Ivan1403','1234597'),(6,1030,'Vitebsk1078',85,'volnaya293','petya@gmail.com550','proGame75','Ivan35','12345608'),(7,507,'Vitebsk1121',1386,'volnaya1500','petya@gmail.com598','proGame522','Ivan198','12345304'),(8,401,'Vitebsk893',765,'volnaya816','petya@gmail.com698','proGame957','Ivan36','12345504'),(9,602,'Vitebsk757',566,'volnaya1132','petya@gmail.com509','proGame1449','Ivan169','12345598'),(10,594,'Vitebsk1307',1103,'volnaya138','petya@gmail.com908','proGame212','Ivan1424','12345248'),(11,180,'Vitebsk745',1515,'volnaya811','petya@gmail.com399','proGame1444','Ivan253','123451436'),(12,410,'Vitebsk747',590,'volnaya911','petya@gmail.com449','proGame543','Ivan1193','123451489'),(13,1272,'Vitebsk278',460,'volnaya1112','petya@gmail.com1220','proGame602','Ivan207','123451248'),(14,205,'Vitebsk222',1460,'volnaya1234','petya@gmail.com1072','proGame415','Ivan424','12345760'),(15,246,'Vitebsk521',4,'volnaya867','petya@gmail.com163','proGame1504','Ivan807','12345758'),(16,684,'Vitebsk461',858,'volnaya973','petya@gmail.com132','proGame915','Ivan718','12345321'),(17,9,'Vitebsk1454',241,'volnaya85','petya@gmail.com1125','proGame1281','Ivan775','12345181'),(18,946,'Vitebsk1051',105,'volnaya757','petya@gmail.com1142','proGame1146','Ivan786','12345103'),(19,147,'Vitebsk1351',1111,'volnaya1016','petya@gmail.com503','proGame881','Ivan1390','12345491'),(20,233,'Vitebsk988',1143,'volnaya1027','petya@gmail.com1078','proGame898','Ivan1478','12345892'),(21,286,'Vitebsk826',1032,'volnaya414','petya@gmail.com250','proGame1054','Ivan70','123451219'),(22,844,'Vitebsk922',504,'volnaya1436','petya@gmail.com901','proGame3','Ivan1402','123451180'),(23,947,'Vitebsk1187',564,'volnaya524','petya@gmail.com1024','proGame1299','Ivan244','123451010'),(24,503,'Vitebsk889',1211,'volnaya928','petya@gmail.com992','proGame1267','Ivan178','12345999'),(25,1197,'Vitebsk1205',679,'volnaya1047','petya@gmail.com41','proGame645','Ivan1234','123451280'),(26,997,'Vitebsk129',296,'volnaya1504','petya@gmail.com1260','proGame521','Ivan453','123451279'),(28,130,'Vitebsk397',820,'volnaya45','petya@gmail.com106','proGame890','Ivan327','12345651'),(29,1062,'Vitebsk1514',561,'volnaya1003','petya@gmail.com864','proGame382','Ivan63','12345937'),(30,690,'Vitebsk1400',1008,'volnaya485','petya@gmail.com629','proGame411','Ivan142','12345435'),(31,1294,'Vitebsk811',1389,'volnaya177','petya@gmail.com827','proGame1043','Ivan75','12345341'),(32,1288,'Vitebsk700',278,'volnaya347','petya@gmail.com1452','proGame249','Ivan1220','12345738'),(33,228,'Vitebsk1232',727,'volnaya1288','petya@gmail.com262','proGame217','Ivan176','123451083'),(34,1253,'Vitebsk711',812,'volnaya1103','petya@gmail.com943','proGame1308','Ivan1399','12345371'),(35,717,'Vitebsk706',1010,'volnaya1491','petya@gmail.com1375','proGame325','Ivan1330','12345528'),(36,1024,'Vitebsk242',379,'volnaya1288','petya@gmail.com466','proGame856','Ivan775','123451095'),(37,1484,'Vitebsk518',1025,'volnaya1086','petya@gmail.com692','proGame9','Ivan189','123451139'),(38,399,'Vitebsk59',739,'volnaya646','petya@gmail.com465','proGame834','Ivan713','123451025');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `role` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKtluph2wqiq84w6u7ta2vuok9i` FOREIGN KEY (`id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `name` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKieyg2wm3ghe8uuq6goaxrsv2j` (`name`),
  KEY `FK8mcrcg5xhas54mvi7m906ux6q` (`user_id`),
  CONSTRAINT `FK8mcrcg5xhas54mvi7m906ux6q` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKieyg2wm3ghe8uuq6goaxrsv2j` FOREIGN KEY (`name`) REFERENCES `game` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends`
--

DROP TABLE IF EXISTS `friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends`
--

LOCK TABLES `friends` WRITE;
/*!40000 ALTER TABLE `friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friends_user`
--

DROP TABLE IF EXISTS `friends_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friends_user` (
  `Friends_id` bigint(20) NOT NULL,
  `friend_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Friends_id`,`friend_id`),
  UNIQUE KEY `UK_lm4wjvv21pik48jdmfcraxol` (`friend_id`),
  CONSTRAINT `FK2fnkl1v0rpmerk18cr3g73fnh` FOREIGN KEY (`Friends_id`) REFERENCES `friends` (`id`),
  CONSTRAINT `FKc1qwc5omle14ipsf0gqvonch2` FOREIGN KEY (`friend_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friends_user`
--

LOCK TABLES `friends_user` WRITE;
/*!40000 ALTER TABLE `friends_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `friends_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age_restrictions` int(11) DEFAULT NULL,
  `cost` int(11) NOT NULL,
  `language` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `numberOfPlayers` int(11) NOT NULL,
  `rules` varchar(255) NOT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jare70vqqti665ds3b2eh7rk8` (`name`),
  UNIQUE KEY `UK_p17lg038mtvypkydhtivwhijp` (`rules`),
  KEY `FK73upu9etxwgmxn02cxoordiql` (`game_id`),
  CONSTRAINT `FK73upu9etxwgmxn02cxoordiql` FOREIGN KEY (`game_id`) REFERENCES `provider` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,289,174,0,'Pasians718',938,'kill all1477',1),(2,1078,1132,2,'Pasians1431',516,'kill all57',2),(3,278,259,0,'Pasians578',77,'kill all1237',4),(4,707,1317,2,'Pasians1320',574,'kill all302',5),(5,372,642,2,'Pasians1088',493,'kill all395',6),(6,779,370,1,'Pasians987',1337,'kill all309',7),(7,374,901,1,'Pasians761',487,'kill all1000',8),(8,867,1197,1,'Pasians152',1050,'kill all1125',9),(9,414,752,0,'Pasians936',1000,'kill all837',10),(10,134,1398,1,'Pasians553',522,'kill all1424',11),(11,1231,1390,0,'Pasians1200',392,'kill all800',12),(12,1268,459,2,'Pasians1033',392,'kill all494',13),(13,514,292,2,'Pasians887',391,'kill all242',14),(14,1417,1075,0,'Pasians1208',950,'kill all156',15),(15,1093,1424,2,'Pasians533',1341,'kill all683',16),(16,824,1395,1,'Pasians1452',469,'kill all759',17),(17,853,1149,0,'Pasians970',713,'kill all971',18),(18,880,201,1,'Pasians175',1242,'kill all438',19),(19,996,624,0,'Pasians1158',849,'kill all913',20),(20,349,293,1,'Pasians427',493,'kill all730',21),(21,1209,439,2,'Pasians219',1062,'kill all614',22),(22,579,876,1,'Pasians600',1169,'kill all555',23),(23,1236,66,1,'Pasians992',686,'kill all1168',24),(24,740,761,1,'Pasians1324',461,'kill all127',25),(25,1319,379,2,'Pasians770',536,'kill all63',26),(26,1512,505,0,'Pasians664',830,'kill all1440',28),(27,623,1312,2,'Pasians1173',433,'kill all180',29),(28,253,719,0,'Pasians732',598,'kill all631',30),(29,652,595,1,'Pasians669',519,'kill all141',31),(30,745,764,0,'Pasians796',404,'kill all226',32),(31,1452,769,0,'Pasians1034',730,'kill all820',33),(32,683,386,1,'Pasians826',1478,'kill all500',34),(33,1490,75,0,'Pasians1064',483,'kill all1269',35),(34,1029,1180,2,'Pasians1068',1367,'kill all938',36),(35,885,899,2,'Pasians1441',427,'kill all294',37),(36,503,726,1,'Pasians1054',1025,'kill all1317',38);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provider` (
  `interbranchTurnover` bigint(20) NOT NULL,
  `paymentAccount` varchar(255) NOT NULL,
  `receiver` varchar(50) NOT NULL,
  `taxpayerIdentificationNumber` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q2hqotp3t0pc71mnb06osnd0l` (`paymentAccount`),
  UNIQUE KEY `UK_kyeemswc6d4ltfdh1i171lyh0` (`receiver`),
  UNIQUE KEY `UK_jpxtg69fu3jb4rcikbnymrfrv` (`taxpayerIdentificationNumber`),
  CONSTRAINT `FKjgaibru8sinhqpy81qsoc8fji` FOREIGN KEY (`id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
INSERT INTO `provider` VALUES (1511,'paym602','bank1444',54896,1),(2391,'paym1165','bank1506',54559,2),(2117,'paym1292','bank1313',54838,4),(1787,'paym1420','bank865',54907,5),(2161,'paym1227','bank649',54547,6),(1933,'paym644','bank750',54683,7),(2085,'paym1013','bank765',55358,8),(1746,'paym1046','bank546',54429,9),(1833,'paym388','bank158',54755,10),(1693,'paym1302','bank64',54419,11),(1724,'paym497','bank1433',54596,12),(1760,'paym1115','bank1316',54711,13),(2766,'paym323','bank383',54435,14),(1528,'paym358','bank32',54805,15),(2769,'paym182','bank849',54590,16),(2531,'paym127','bank1266',54649,17),(1753,'paym837','bank1004',54844,18),(2898,'paym692','bank817',54299,19),(2674,'paym1338','bank1020',54495,20),(2947,'paym1452','bank29',55524,21),(1869,'paym215','bank848',54567,22),(2820,'paym318','bank1288',54408,23),(1572,'paym720','bank1026',54774,24),(2557,'paym447','bank1310',55632,25),(2629,'paym1364','bank275',55506,26),(1639,'paym1056','bank0',55113,28),(1590,'paym973','bank1459',54943,29),(2656,'paym462','bank616',54607,30),(2663,'paym878','bank510',54822,31),(1734,'paym1445','bank628',55269,32),(1741,'paym1269','bank1270',55055,33),(2088,'paym432','bank1440',54708,34),(1772,'paym1153','bank621',55689,35),(2481,'paym1015','bank1029',54989,36),(1686,'paym848','bank1420',55535,37),(2168,'paym1446','bank842',55499,38);
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `paymentStatus` bit(1) NOT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5e0jstakygpy2nx3pvdxa7iqv` (`game_id`),
  KEY `FKac24e0rjfu5fa672i91ux9ecm` (`user_id`),
  CONSTRAINT `FK5e0jstakygpy2nx3pvdxa7iqv` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`),
  CONSTRAINT `FKac24e0rjfu5fa672i91ux9ecm` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `date` date NOT NULL,
  `language` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  `friend_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp5x50yylankvc0ss0qsms6agq` (`friend_id`),
  CONSTRAINT `FKkvg9g7pkj980rhuprss0mtwa` FOREIGN KEY (`id`) REFERENCES `account` (`id`),
  CONSTRAINT `FKp5x50yylankvc0ss0qsms6agq` FOREIGN KEY (`friend_id`) REFERENCES `friends` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2018-02-14 23:14:40
