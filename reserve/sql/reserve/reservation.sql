CREATE TABLE `reservation` (
  `reservationCode` int(11) NOT NULL AUTO_INCREMENT,
  `airinformCode` int(11) NOT NULL,
  `seatName` varchar(4) NOT NULL,
  `reservationDate` varchar(18) NOT NULL,
  `reservationFlag` int(1) NOT NULL DEFAULT '0',
  `userId` varchar(30) NOT NULL,
  PRIMARY KEY (`reservationCode`),
  KEY `airinformCode` (`airinformCode`),
  KEY `userId` (`userId`),
  CONSTRAINT `FK_airinformCode_reservation` FOREIGN KEY (`airinformCode`) REFERENCES `airinform` (`airinformCode`),
  CONSTRAINT `FK_reservation_userId` FOREIGN KEY (`userId`) REFERENCES `member` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8