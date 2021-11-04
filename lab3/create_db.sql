CREATE DATABASE IF NOT EXISTS `planes` ;
USE `planes` ;

DROP TABLE IF EXISTS `plane_flight_history`;
DROP TABLE IF EXISTS `location`;
DROP TABLE IF EXISTS `nongovernmental_territories`;
DROP TABLE IF EXISTS `route`;
DROP TABLE IF EXISTS `flight`;
DROP TABLE IF EXISTS `airport`;
DROP TABLE IF EXISTS `city`;
DROP TABLE IF EXISTS `plane`;
DROP TABLE IF EXISTS `airline`;
DROP TABLE IF EXISTS `country`;
DROP TABLE IF EXISTS `model`;

CREATE TABLE `model` (
  `id`			INT 		AUTO_INCREMENT PRIMARY KEY,
  `name` 		VARCHAR(45) NOT NULL,
  `height` 		DOUBLE 		NULL,
  `length` 		DOUBLE 		NULL,
  `width` 		DOUBLE 		NULL,
  `destination` VARCHAR(45) NULL,
  `color` 		VARCHAR(45) NULL
)ENGINE = InnoDB;

CREATE TABLE `country` (
  `name`		VARCHAR(45)	PRIMARY KEY,
  `gdp`			INT 		NULL,
  `size`		DOUBLE 		NULL,
  `population`	VARCHAR(45)	NULL
)ENGINE = InnoDB;

CREATE TABLE `airline` (
  `id` 				INT 		AUTO_INCREMENT PRIMARY KEY,
  `name` 			VARCHAR(45) NULL,
  `capitalization` 	VARCHAR(45) NULL,
  `country_name` 	VARCHAR(45) NOT NULL,
   INDEX `fk_airline_country1_idx` (`country_name` ASC) VISIBLE
)ENGINE = InnoDB;

ALTER TABLE `airline`
  ADD CONSTRAINT `fk_airline_country1`
  FOREIGN KEY 	(`country_name`)
  REFERENCES	`country` (`name`);

CREATE TABLE `plane` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `model_id` INT NOT NULL,
  `airline_id` INT NOT NULL,
  `kilometrage` INT NULL,
  `aircraft_registration` VARCHAR(7) NOT NULL
)ENGINE = InnoDB;

ALTER TABLE `plane`
  ADD CONSTRAINT `fk_plane_model1`
  FOREIGN KEY (`model_id`)
  REFERENCES `model` (`id`),
  
  ADD CONSTRAINT `fk_plane_airline1`
  FOREIGN KEY (`airline_id`)
  REFERENCES `airline` (`id`),
  
  ADD INDEX `fk_plane_model1_idx` (`model_id`),
  ADD INDEX `fk_plane_airline1_idx` (`airline_id`);
  
CREATE TABLE `city` (
  `name` 			VARCHAR(45) PRIMARY KEY,
  `population` 		INT 		NULL,
  `status` 			VARCHAR(45) NULL,
  `country_name` 	VARCHAR(45) NOT NULL,
  INDEX `fk_city_country1_idx` (`country_name`),
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`country_name`)
    REFERENCES `country` (`name`)
)ENGINE = InnoDB;

CREATE TABLE `airport` (
  `name` 			VARCHAR(45) PRIMARY KEY,
  `quality` 		VARCHAR(45) NULL,
  `planes_capacity` INT 		NULL,
  `city_name` 		VARCHAR(45) NOT NULL,
  INDEX `fk_airport_city1_idx` (`city_name`),
  CONSTRAINT `fk_airport_city1`
    FOREIGN KEY (`city_name`)
    REFERENCES `city` (`name`)
)ENGINE = InnoDB;

CREATE TABLE `flight` (
  `id` 					INT 		AUTO_INCREMENT PRIMARY KEY,
  `name` 				VARCHAR(45) NOT NULL,
  `airport_departure` 	VARCHAR(45) NOT NULL,
  `airport_arrival` 	VARCHAR(45) NOT NULL,
  INDEX `fk_flight_airport1_idx` (`airport_departure`),
  INDEX `fk_flight_airport2_idx` (`airport_arrival`),
  CONSTRAINT `fk_flight_airport1`
    FOREIGN KEY (`airport_departure`)
    REFERENCES `airport` (`name`),
  CONSTRAINT `fk_flight_airport2`
    FOREIGN KEY (`airport_arrival`)
    REFERENCES `airport` (`name`)
)ENGINE = InnoDB;

CREATE TABLE `route` (
  `id` 				INT 		NOT NULL AUTO_INCREMENT,
  `name` 			VARCHAR(45) NOT NULL,
  `length` 			INT 		NULL,
  `duration` 		DOUBLE 		NULL,
  `danger_level` 	INT 		NULL,
  `is_direct` 		BOOLEAN 	NULL,
  `flight_id` INT NOT NULL,
  PRIMARY KEY (`id`, `flight_id`),
  INDEX `fk_route_flight1_idx` (`flight_id`),
  CONSTRAINT `fk_route_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `flight` (`id`))
ENGINE = InnoDB;

CREATE TABLE `nongovernmental_territories` (
  `name` 			VARCHAR(45) NOT NULL,
  `type` 			VARCHAR(45) NULL,
  `danger_level` 	VARCHAR(45) NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;

CREATE TABLE `location` (
  `id` 							INT 		NOT NULL AUTO_INCREMENT,
  `speed` 						DOUBLE 		NULL,
  `latitude` 					DOUBLE 		NULL UNIQUE,
  `longitude` 					DOUBLE 		NULL UNIQUE,
  `governmental_territories` 	VARCHAR(45) NULL,
  `nongovernmental_territories` VARCHAR(45) NULL,
  `plane_id` 					INT 		NOT NULL UNIQUE,
  PRIMARY KEY (`id`),
  INDEX `fk_location_country1_idx` (`governmental_territories`),
  INDEX `fk_location_nongovernmental_territories1_idx` (`nongovernmental_territories`),
  INDEX `fk_location_plane1_idx` (`plane_id`),
  CONSTRAINT `fk_location_country1`
    FOREIGN KEY (`governmental_territories`)
    REFERENCES `country` (`name`),
  CONSTRAINT `fk_location_nongovernmental_territories1`
    FOREIGN KEY (`nongovernmental_territories`)
    REFERENCES `nongovernmental_territories` (`name`),
  CONSTRAINT `fk_location_plane1`
    FOREIGN KEY (`plane_id`)
    REFERENCES `plane` (`id`)
)ENGINE = InnoDB;

CREATE TABLE `plane_flight_history` (
  `plane_id` 	INT NOT NULL,
  `flight_id` 	INT NOT NULL,
  PRIMARY KEY (`plane_id`, `flight_id`),
  UNIQUE INDEX `fk_plane_has_flight_idx` (`flight_id`, `plane_id`),
  CONSTRAINT `fk_plane_has_flight_plane1`
    FOREIGN KEY (`plane_id`)
    REFERENCES `plane` (`id`),
  CONSTRAINT `fk_plane_has_flight_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `flight` (`id`)
)ENGINE = InnoDB;
