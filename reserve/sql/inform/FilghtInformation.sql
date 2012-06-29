CREATE TABLE `airport` (
  `Airport_no` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK값',
  `IATA` char(3) CHARACTER SET latin1 DEFAULT NULL COMMENT '공항코드',
  `City` varchar(100) DEFAULT NULL COMMENT '도시이름',
  `Contry` varchar(100) DEFAULT NULL COMMENT '국가이름',
  `Latitude` double DEFAULT NULL COMMENT '위도',
  `Longtitude` double DEFAULT NULL COMMENT '경도',
  `Altitude` float DEFAULT NULL COMMENT '고도(feet)',
  `Timezone` float DEFAULT NULL COMMENT '시간대',
  `DST` char(1) CHARACTER SET latin1 DEFAULT NULL COMMENT '썸머타임 적용여부',
  `Queried_number` int(11) DEFAULT NULL COMMENT '검색횟수',
  PRIMARY KEY (`Airport_no`),
  KEY `IATA` (`IATA`)
)



CREATE TABLE `airport_distance` (
  `airport_distance` int(11) NOT NULL AUTO_INCREMENT COMMENT 'pk값',
  `first_airport` int(1) NOT NULL COMMENT '첫번째 도시(airport pk값)',
  `second_airport` int(1) NOT NULL COMMENT '두번째 도시(airport pk값)',
  `distance` int(11) NOT NULL COMMENT '거리',
  PRIMARY KEY (`airport_distance`),
  KEY `airport_distance_index` (`second_airport`,`first_airport`)
)


