# springboot-practice

This Repo has basic Rest-api jdbc template integration with spring boot

If you are trying to run this in your local you have to setup connection to mysql. The schema is added below.

DB-1
SCHEMA :
CREATE DATABASE `student` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `dataentry` (
  `ID` int NOT NULL,
  `NAME` varchar(300) DEFAULT NULL,
  `AGE` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `YEAR` tinyint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT : 
INSERT INTO student.dataentry VALUES (2,'IRON MAN',25,'ironman@gmail.com',now() - interval 25 year,3);
INSERT INTO student.dataentry VALUES (1,'CAPTAIN AMERICA',25,'capAmerica@gmail.com',now() - interval 25 year,2);

DB-2
SCHEMA :
CREATE DATABASE `passouts` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `allPassouts` (
  `ID` int NOT NULL,
  `NAME` varchar(300) DEFAULT NULL,
  `AGE` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT: INSERT INTO passouts.allpassouts VALUES (1,'RMIZ',25,'rrdemo@gmail.com','7.89');

