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
('model6', 987, 456, 2000, 'civil', 'black'),
('model7', 987, 456, 3000, 'civil', 'black'),
('model8', 987, 456, NULL, 'civil', 'black'),
('model9', 987, 456, NULL, 'civil', 'black'),
('model10', 987, 456, 1233, 'civil', 'black');

INSERT INTO`country` (`name`, `gdp`, `size`, `population`)
VALUES
('Ukraine', 45665, 600000, 45000000),
('Norway', 99999, 400000, 2300000),
('Nauru', 23004, 213, 21034),
('Korea', 32423, NULL, 6565767),
('Canada', NULL, 38409, NULL),
('France', 2425, NULL, 342342),
('Germany', 3424, 3423, 565645),
('Japan', 3943290, 35435, 4535353),
('Ethiopia', 423478, 32432, NULL),
('Palestina', 34324, 231432221, 2313231231);

-- INSERT INTO `airline` (`id`, `name`, `capitalization`, `country_name`)
