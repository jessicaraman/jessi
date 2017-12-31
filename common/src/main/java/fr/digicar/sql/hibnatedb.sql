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

CREATE TABLE parking_spots (
  id         INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  nb_spot    VARCHAR(40)  NOT NULL,
  nb_parking INT(5)       NOT NULL,
  status     VARCHAR(40)  NOT NULL,
  electricPlug BOOLEAN NOT NULL,
  location   VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;