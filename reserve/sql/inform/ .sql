CREATE TABLE `airport` (
  `IATA` char(3) CHARACTER SET latin1 DEFAULT NULL COMMENT '공항코드',
  `City` varchar(100) DEFAULT NULL COMMENT '도시이름',
  `Contry` varchar(100) DEFAULT NULL COMMENT '국가이름',
  `Latitude` double DEFAULT NULL COMMENT '위도',
  `Longtitude` double DEFAULT NULL COMMENT '경도',
  `Altitude` float DEFAULT NULL COMMENT '고도(feet)',
  `Timezone` float DEFAULT NULL COMMENT '시간대',
  `DST` char(1) CHARACTER SET latin1 DEFAULT NULL COMMENT '썸머타임 적용여부',
  `Queried_number` int(11) DEFAULT NULL COMMENT '검색횟수',
  KEY `IATA` (`IATA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='공항정보';

CREATE TABLE `airport_distance` (
  `first_airport` char(3) CHARACTER SET latin1 NOT NULL COMMENT '첫번째 도시(airport IATA)',
  `second_airport` char(3) CHARACTER SET latin1 NOT NULL COMMENT '두번째 도시(airport IATA)',
  `distance` int(11) NOT NULL COMMENT '거리',
  KEY `airport_distance_index` (`second_airport`,`first_airport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `airline_schedule` (
  `airline_schedule_no` int(11) NOT NULL AUTO_INCREMENT,
  `take_off_airport` char(3) CHARACTER SET latin1 DEFAULT NULL,
  `landing_airport` char(3) CHARACTER SET latin1 DEFAULT NULL,
  `take_off_date` time DEFAULT NULL,
  `landing_date` time NOT NULL,
  `aircraft` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`airline_schedule_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='운항정보';
