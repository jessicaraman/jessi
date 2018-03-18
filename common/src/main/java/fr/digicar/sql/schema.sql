CREATE TABLE car
(
  id                  INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  registration_number VARCHAR(40) NULL,
  mark                VARCHAR(40) NULL,
  transmission_id     INT(6)      NULL,
  name_model          VARCHAR(40) NULL,
  nb_places           VARCHAR(2)  NULL,
  nb_doors            VARCHAR(2)  NULL,
  type_id             INT(6)      NULL,
  comfort             INT(2)      NULL,
  kilometers          INT(10)     NULL,
  release_date        DATE        NULL,
  fuel_type_id        INT(6)      NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE INDEX transmission_id
  ON car (transmission_id);

CREATE INDEX type_id
  ON car (type_id);

CREATE INDEX fuel_type_id
  ON car (fuel_type_id);

CREATE TABLE car_type
(
  id   INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(25) NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

ALTER TABLE car
  ADD CONSTRAINT car_ibfk_2
FOREIGN KEY (type_id) REFERENCES car_type (id);

CREATE TABLE fuel_type
(
  id   INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(20) NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

ALTER TABLE car
  ADD CONSTRAINT car_ibfk_3
FOREIGN KEY (fuel_type_id) REFERENCES fuel_type (id);

CREATE TABLE parking_spots
(
  id            INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  nb_spot       INT          NOT NULL,
  nb_parking    VARCHAR(40)  NOT NULL,
  electric_plug TINYINT(1)   NOT NULL,
  location      VARCHAR(100) NOT NULL,
  longitude     INT          NULL,
  latitude      INT          NULL,
  longueur      INT(4)       NULL,
  largeur       INT(4)       NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE TABLE retard_calcule
(
  id_retard            INT AUTO_INCREMENT
    PRIMARY KEY,
  immatriculation      VARCHAR(40) NOT NULL,
  mark                 VARCHAR(40) NULL,
  model                VARCHAR(40) NULL,
  heure_retour_prevu   DATETIME    NULL,
  heure_retour_calcule DATETIME    NULL,
  penality             DOUBLE      NULL,
  first_name           VARCHAR(40) NULL,
  last_name            VARCHAR(40) NULL,
  phone_number         VARCHAR(15) NULL,
  tag_appel            TINYINT(1)  NULL,
  id_session           INT         NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE session_en_cours
(
  id_session          INT AUTO_INCREMENT
    PRIMARY KEY,
  id_reservation      INT        NOT NULL,
  id_car              INT        NOT NULL,
  id_place_depart     INT        NULL,
  id_place_arrivee    INT        NULL,
  heure_depart_reel   DATETIME   NULL,
  heure_arrivee_prevu DATETIME   NULL,
  heure_arrivee_reel  DATETIME   NULL,
  tarif               DOUBLE     NULL,
  id_user             INT        NOT NULL,
  tag                 TINYINT(1) NOT NULL,
  penality            DOUBLE     NULL,
  CONSTRAINT session_en_cours_car_id_fk
  FOREIGN KEY (id_car) REFERENCES car (id)
)
  ENGINE = InnoDB;

CREATE INDEX session_en_cours_car_id_fk
  ON session_en_cours (id_car);

CREATE INDEX session_en_cours_users_id_fk
  ON session_en_cours (id_user);

CREATE TABLE tarifs
(
  id             INT(12) AUTO_INCREMENT
    PRIMARY KEY,
  libelle        VARCHAR(123) NULL,
  prix_km        FLOAT        NULL,
  prix_heure     FLOAT        NULL,
  frais_mensuels INT(231)     NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE TABLE transmission_mode
(
  id   INT(6) AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(20) NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

ALTER TABLE car
  ADD CONSTRAINT car_ibfk_1
FOREIGN KEY (transmission_id) REFERENCES transmission_mode (id);

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
  zip_code       VARCHAR(10)  NOT NULL,
  city           VARCHAR(100) NOT NULL,
  signup_date    DATE         NOT NULL,
  status         VARCHAR(10)  NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

ALTER TABLE session_en_cours
  ADD CONSTRAINT session_en_cours_users_id_fk
FOREIGN KEY (id_user) REFERENCES users (id);

-- table occupation
CREATE TABLE occupation (
  car_id           INT(6),
  parking_spots_id INT(6),
  id               INT(6),
  PRIMARY KEY (id),
  FOREIGN KEY (car_id) REFERENCES car (id),
  FOREIGN KEY (parking_spots_id) REFERENCES parking_spots (id)
);
ALTER TABLE occupation
  MODIFY id INT(6) AUTO_INCREMENT PRIMARY KEY;

-- table availability
CREATE TABLE availability (
  id            INT(6),
  date          DATE,
  id_occupation INT(6),
  start_time    TIME,
  end_time      TIME,
  status        INT(1),

  PRIMARY KEY (id),
  FOREIGN KEY (id_occupation) REFERENCES occupation (id)
);
ALTER TABLE availability
  MODIFY id INT(6) AUTO_INCREMENT;

CREATE TABLE history_delays
(
  delay_id         INT AUTO_INCREMENT
    PRIMARY KEY,
  duration         INT  NOT NULL,
  session_end_date DATE NOT NULL
)
  ENGINE = InnoDB;


