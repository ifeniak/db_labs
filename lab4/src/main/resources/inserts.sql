USE planes;

DELETE FROM `plane_flight_history`;
DELETE FROM `location`;
DELETE FROM `nongovernmental_territories`;
DELETE FROM `route`;
DELETE FROM `flight`;
DELETE FROM `airport`;
DELETE FROM `city`;
DELETE FROM `plane`;
DELETE FROM `airline`;
DELETE FROM `country`;
DELETE FROM `model`;

ALTER TABLE `plane_flight_history` 			AUTO_INCREMENT = 1;
ALTER TABLE `location` 						AUTO_INCREMENT = 1;
ALTER TABLE `nongovernmental_territories` 	AUTO_INCREMENT = 1;
ALTER TABLE `route` 						AUTO_INCREMENT = 1;
ALTER TABLE `flight` 						AUTO_INCREMENT = 1;
ALTER TABLE `airport` 						AUTO_INCREMENT = 1;
ALTER TABLE `city` 							AUTO_INCREMENT = 1;
ALTER TABLE `plane` 						AUTO_INCREMENT = 1;
ALTER TABLE `airline` 						AUTO_INCREMENT = 1;
ALTER TABLE `country` 						AUTO_INCREMENT = 1;
ALTER TABLE `model` 						AUTO_INCREMENT = 1;

INSERT INTO `model` (`name`, `height`, `length`, `width`, `destination`, `color`)
VALUES
    ('Kalki', 300, 600, 200, 'fighter', 'white'),
    ('ELpH', NULL, NULL, NULL, 'fighter', 'violet'),
    ('Staircase', NULL, 400, 5000, 'civil', NULL),
    ('Coil', 455, NULL, 5000, NULL, NULL),
    ('Current', 987, 456, 1000, 'civil', 'black'),
    ('Tripple Sun', 987, 456, 2000, 'civil', 'black'),
    ('Ostia', 987, 456, 3000, 'civil', 'black'),
    ('Firemind', 987, 456, NULL, 'civil', 'black'),
    ('Azrael', 987, 456, NULL, 'bomber', 'black'),
    ('Death', 987, 456, 1233, 'fighter', 'black');

INSERT INTO`country` (`name`, `gdp`, `size`, `population`)
VALUES
    ('Ukraine', 45665, 600000, 46685000),
    ('Norway', 99999, 400000, 27793000),
    ('Nauru', 23004, 213, 21034),
    ('Korea', 32423, NULL, 6567678),
    ('Canada', NULL, 38409, NULL),
    ('China', 2425, NULL, 342326),
    ('Germany', 3424, 3423, 556458),
    ('Japan', 3943290, 35435, 4553538),
    ('Ethiopia', 423478, 32432, NULL),
    ('Palestine', 34324, 231432221, 23131231),
    ('Russia', 743932, 321313, 32323235),
    ('France', 23423, 3424, NULL);


INSERT INTO `airline` (`name`, `capitalization`, `country_name`)
VALUES
    ('Tibetian airlines', 123546, 'China'),
    ('Nauru airlienes', 23243, 'Nauru'),
    ('Galizien airlines', 5465321, 'Ukraine'),
    ('Tottenkopf airlines', 213123, 'Germany'),
    ('Drevlian airlines', 2342384, 'Ukraine'),
    ('Tmutarakan airlines', 342234, 'Ukraine'),
    ('Rossenval airlines', NULL, 'France'),
    ('Black September', NULL, 'Palestine'),
    ('Norsk', 612665, 'Norway'),
    ('Nihilian', 34234, 'Germany');

INSERT INTO `plane` (`name`, `model_id`, `airline_id`, `kilometrage`, `aircraft_registration`)
VALUES
    ('Himmler', 1, 3, 43242, '0004563'),
    ('Hering', 4, 5, 32145, '94995'),
    ('Borman', 2, 4,656543, '5435514'),
    ('Ribbentrop', 4, 6, 3434, '3456000'),
    ('Rommel', 6, 8, NULL, '034244'),
    ('Rem', 4, 9, 5435, '5405904'),
    ('Eicke', 5, 3, 534567, '00005'),
    ('Ahnenerbe', 7, 7, NULL, '434345'),
    ('Muller', 5, 9, 445646, '1110110'),
    ('Shellenberg', 1, 1, 34424, '11111');

INSERT INTO `city` (`name`, `population`, `status`, `country_name`)
VALUES
    ('Kolomyia', 60666, 'non-capital', 'Ukraine'),
    ('Addis', 453245, 'capital', 'Ethiopia'),
    ('Marsel', 342345, 'capital', 'France'),
    ('Paris', 23423354, 'non-capital', 'France'),
    ('Lviv', 435543, 'non-capital', 'Ukraine'),
    ('Novgorod', 324324, 'non-capital', 'Russia'),
    ('Wewelsburg', 4325435, 'non-capital', 'Germany'),
    ('Daegu', NULL, 'non-capital', 'Korea'),
    ('Trondheim', NULL, NULL, 'Norway'),
    ('Jerusalem', 43543443, NULL, 'Palestine');

INSERT INTO `airport` (`name`, `quality`, `planes_capacity`, `city_name`)
VALUES
    ('Istr', 'perfect', 30940, 'Kolomyia'),
    ('De Golle', 'good', NULL, 'Paris'),
    ('Varg', NULL, 2345, 'Daegu'),
    ('Abbath', 'nice', 45345, 'Kolomyia'),
    ('Evronimus', 'bad', NULL, 'Jerusalem'),
    ('Hellhammer', 'good', NULL, 'Lviv'),
    ('Famine', NULL, NULL, 'Marsel'),
    ('Nergal', NULL, 324345, 'Wewelsburg'),
    ('Annenerbe', NULL, NULL, 'Lviv'),
    ('Morok', 'nice', 24554, 'Novgorod');

INSERT INTO `flight` (`name`, `airport_departure`, `airport_arrival`)
VALUES
    ('first', 'De Golle', 'Abbath'),
    ('second', 'Hellhammer', 'Annenerbe'),
    ('third', 'Nergal', 'Morok'),
    ('forth', 'Evronimus', 'Nergal'),
    ('fifth', 'De Golle', 'Istr'),
    ('sixth', 'Istr', 'Evronimus'),
    ('seventh', 'De Golle', 'Annenerbe'),
    ('eight', 'Morok', 'Hellhammer'),
    ('ninth', 'Nergal', 'Annenerbe'),
    ('tenth', 'Istr', 'Varg');

INSERT INTO `route` (`name`, `length`, `duration`, `danger_level`, `is_direct`, `flight_id`)
VALUES
    ('first_a', 34235, 45.56, 7, TRUE, 1),
    ('second_a', 456789, 45345.6, 2, TRUE, 2),
    ('third_a', 7866, NULL, 4, TRUE, 3),
    ('fifth_a', 78561, NULL, 9, TRUE, 4),
    ('sixth_a', 761003, 4572.3, NULL, TRUE, 5),
    ('seventh_a', 749, 7891.1, 2, TRUE, 6),
    ('eightth_a', NULL, 45.6, NULL, TRUE, 7),
    ('ninth_a', 4572, NULL, 1, TRUE, 8),
    ('tenth_a', 7891, 1510.4, 8, TRUE, 9),
    ('fifth_b', 100561, NULL, 2, FALSE, 5),
    ('tenth_b', 78914, 15104.4, 1, FALSE, 10);

INSERT INTO `nongovernmental_territories` (`name`, `type`, `danger_level`)
VALUES
    ('Azatoth', NULL, 100),
    ('Cadath', 'place', 95),
    ('Insmaut', 'city', 70),
    ('Black Sea', 'sea', 5),
    ('Red Sea', 'sea', NULL),
    ('White Sea', 'sea', 8),
    ('Dead Sea', 'lake', 2),
    ('Sargasian Sea', 'sea', 9),
    ('Athlantics', 'ocean', NULL),
    ('Arctic', NULL, NULL);

INSERT INTO `location` (`speed`, `latitude`, `longitude`, `governmental_territories`, `nongovernmental_territories`, `plane_id`)
VALUES
    (1235.4, 1244.4, 12.235, 'Russia', 'Azatoth', 3),
    (12354.2135, 1234.125, 1213.235, NULL, 'Arctic', 4),
    (1234.235, 123.235, 134.2, NULL, 'Athlantics', 1),
    (132.1235, 12.1235, 12.33, NULL, NULL, 2),
    (132.556, 123.1245, NULL, NULL, 'Cadath', 5),
    (456.0125, 234.5, 24.5, 'Canada', 'Insmaut', 6),
    (123.2365, 12.236, 123.4, NULL, 'Sargasian Sea', 7),
    (2445.6, 121.34, 60.2435, 'Russia', 'White Sea', 8),
    (32434, 355.56, 24, 'Palestine', 'Dead Sea', 9),
    (2434.345, 455.67, 883.4, 'Russia', 'Azatoth', 10);

INSERT INTO `plane_flight_history` (`plane_id`, `flight_id`)
VALUES
    (1, 4),
    (3, 4),
    (4, 6),
    (2, 9),
    (5, 1),
    (1, 9),
    (7, 9),
    (8, 1),
    (9, 9);

