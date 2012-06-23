CREATE TABLE `airplane_inform` (
  `airplaneCode` int(11) NOT NULL AUTO_INCREMENT,
  `airplaneName` varchar(30) DEFAULT NULL,
  `airplaneCompany` varchar(30) DEFAULT NULL,
  `seatCode` int(11) DEFAULT NULL,
  PRIMARY KEY (`airplaneCode`),
  KEY `seatCode` (`seatCode`),
  CONSTRAINT `FK_airplane_inform_seatCode` FOREIGN KEY (`seatCode`) REFERENCES `seat_inform` (`seatCode`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8