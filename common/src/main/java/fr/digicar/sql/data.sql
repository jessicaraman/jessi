#----------------------------------------------------
#                 POPULATE DATA
#----------------------------------------------------



#---------------Car----------------------------------
INSERT INTO `car`
(`id`, `registration_number`, `mark`, `transmission_id`, `name_model`, `nb_places`, `nb_doors`, `type_id`, `comfort`, `kilometers`, `release_date`, `fuel_type_id`) VALUES

(5, 'AV-868-AwA', 'MAZDA', 1, 'MAZDA3', '3', '3', 2, 2, 100000, '2018-10-30', 1),

(6, 'UA-101-AA', 'MAZDA', 1, 'MAZDA3', '3', '3', 2, 2, 100000, '2018-01-30', 1),

(7, 'ZA-333-EB', 'MAZDA', 2, 'MAZDA3', '3', '3', 1, 2, 90000, '2018-01-30', 3),

(8, 'MA-653-ZP', 'MAZDA', 2, 'MAZDA3', '5', '5', 5, 3, 185078, '2018-09-30', 1),

(9, 'QP-952-MS', 'Peugeot', 1, 'Peugeot207', '5', '5', 5, 3, 100078, '2018-12-30', 1),

(10, 'QP-025-Mk', 'Peugeot', 1, 'Peugeot207', '5', '5', 5, 3, 10000, '2018-01-30', 1),

(11, 'os-025-Mk', 'Peugeot', 1, 'Peugeot207', '5', '5', 4, 5, 2, '2018-11-30', 1),

(12, 'pp-948-uo', 'Clio', 2, 'Clio2', '5', '5', 1, 4, 41, '2018-01-30', 1),

(13, 'AA-209-uo', 'Clio', 2, 'Clio2', '5', '5', 5, 4, 41, '2018-01-30', 1);

#---------------car_type----------------------------------

INSERT INTO digicar.car_type VALUES (DEFAULT, 'Citadine');
INSERT INTO digicar.car_type VALUES (DEFAULT, 'Cross-over');
INSERT INTO digicar.car_type VALUES (DEFAULT, '4X4');
INSERT INTO digicar.car_type VALUES (DEFAULT, 'Berline familiale');
INSERT INTO digicar.car_type VALUES (DEFAULT, 'Voiture de sport');
INSERT INTO digicar.car_type VALUES (DEFAULT, 'Voiture de collection ');

#---------------transmission_mode----------------------------------

INSERT INTO digicar.transmission_mode VALUES (DEFAULT, 'manuelle');
INSERT INTO digicar.transmission_mode VALUES (DEFAULT, 'automatique');

#---------------fuel_type----------------------------------

INSERT INTO digicar.fuel_type VALUES (DEFAULT, 'essence');
INSERT INTO digicar.fuel_type VALUES (DEFAULT, 'diesel');
INSERT INTO digicar.fuel_type VALUES (DEFAULT, 'electrique');