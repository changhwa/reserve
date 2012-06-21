users table 생성 쿼리입니다.

create table users (
no INT NOT NULL AUTO_INCREMENT,
user_id VARCHAR(30) NOT NULL,
password VARCHAR(50) NOT NULL,
name VARCHAR(50) NOT NULL,
phone VARCHAR(30),
jumin VARCHAR(30),
address VARCHAR(50),
sex BIT,
hint TINYINT,
answer VARCHAR(100),
receive_mail BIT,
receive_sms BIT,
passport_number VARCHAR(30),
passport_date DATE,
passport_country TINYINT,
mileage DOUBLE,
job VARCHAR(30)
);