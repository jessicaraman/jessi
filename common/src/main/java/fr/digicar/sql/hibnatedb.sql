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
  id            INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  nb_spot       VARCHAR(40)  NOT NULL,
  nb_parking    INT(5)       NOT NULL,
  electric_plug BOOLEAN      NOT NULL,
  location      VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE tarifs (
  id             INT(12) AUTO_INCREMENT
    PRIMARY KEY,
  libelle        VARCHAR(123),
  prix_km        FLOAT,
  prix_heure     FLOAT,
  frais_mensuels INT(231)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



CREATE TABLE car_type
(
  id                  INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  name                VARCHAR(25) NOT NULL
)

  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE fuel_type
(
  id                  INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  name                VARCHAR(20) NOT NULL
)

  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE transmission_mode
(
  id                  INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  name                VARCHAR(20) NOT NULL
)

  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
CREATE TABLE car
(
  id                  INT(6) AUTO_INCREMENT,
  registration_number VARCHAR(40),
  mark                VARCHAR(40),
  transmission_id     INT(6),
  name_model          VARCHAR(40),
  nb_places           VARCHAR(2),
  nb_doors            VARCHAR(2),
  type_id             INT(6),
  comfort             INT(2),
  kilometers          INT(10),
  release_date        DATE,
  fuel_type_id        INT(6),

  CONSTRAINT pk_car PRIMARY KEY (id),
  CONSTRAINT `fk_transmission_id`  FOREIGN KEY (transmission_id) REFERENCES transmission_mode (id)  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_car_type`  FOREIGN KEY (type_id) REFERENCES car_type (id)  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fuel_type_id`  FOREIGN KEY (fuel_type_id) REFERENCES fuel_type (id)  ON DELETE NO ACTION ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;




#----------------------------------------------------
#                 populate data
#----------------------------------------------------

insert into car_type VALUES(DEFAULT,"Citadine");
insert into car_type VALUES(DEFAULT,"Cross-over");
insert into car_type VALUES(DEFAULT,"4X4");
insert into car_type VALUES(DEFAULT,"Berline familiale");
insert into car_type VALUES(DEFAULT,"Voiture de sport");
insert into car_type VALUES(DEFAULT,"Voiture de collection ");

insert into transmission_mode VALUES(DEFAULT,"manuelle");
insert into transmission_mode VALUES(DEFAULT,"automatique");

insert into fuel_type VALUES(DEFAULT,"essence");
insert into fuel_type VALUES(DEFAULT,"diesel");
insert into fuel_type VALUES(DEFAULT,"electrique");