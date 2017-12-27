CREATE TABLE users
(
  id             INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  gender         VARCHAR(40)  NOT NULL,
  first_name     VARCHAR(40)  NOT NULL,
  last_name      VARCHAR(40)  NOT NULL,
  birthdate      DATE         NULL,
  email          VARCHAR(40)  NOT NULL,
  password       VARCHAR(40)  NOT NULL,
  phone_number   VARCHAR(20)  NULL,
  address_line_1 VARCHAR(250) NOT NULL,
  address_line_2 VARCHAR(250) NULL,
  zip_code       VARCHAR(10)  NULL,
  city           VARCHAR(100) NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

