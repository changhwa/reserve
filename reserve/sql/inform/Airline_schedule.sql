CREATE TABLE `airline_schedule` (
  `airline_schedule` int(11) NOT NULL AUTO_INCREMENT,
  `from_airport` int(11) DEFAULT NULL,
  `to_airport` int(11) DEFAULT NULL,
  `take_off_time` time DEFAULT NULL,
  `duration_time` time NOT NULL,
  `aircraft` int(11) DEFAULT NULL,
  PRIMARY KEY (`airline_schedule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='운항정보';
