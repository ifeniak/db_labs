-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab1` ;
USE `lab1` ;

-- -----------------------------------------------------
-- Table `lab1`.`model`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `height` DOUBLE NULL,
  `length` DOUBLE NULL,
  `width` DOUBLE NULL,
  `destination` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`country` (
  `name` VARCHAR(45) NOT NULL,
  `gdp` INT NULL,
  `size` DOUBLE NULL,
  `population` VARCHAR(45) NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`airline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`airline` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NULL,
  `capitalization` VARCHAR(45) NULL,
  `country_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_airline_country1_idx` (`country_name` ASC) VISIBLE,
  CONSTRAINT `fk_airline_country1`
    FOREIGN KEY (`country_name`)
    REFERENCES `lab1`.`country` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`nongovernmental_territories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`nongovernmental_territories` (
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL,
  `danger_level` VARCHAR(45) NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  `nongovernmental_territories` VARCHAR(45) NULL,
  `country_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_nongovernmental_territories1_idx` (`nongovernmental_territories` ASC) VISIBLE,
  INDEX `fk_location_country1_idx` (`country_name` ASC) VISIBLE,
  CONSTRAINT `fk_location_nongovernmental_territories1`
    FOREIGN KEY (`nongovernmental_territories`)
    REFERENCES `lab1`.`nongovernmental_territories` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_country1`
    FOREIGN KEY (`country_name`)
    REFERENCES `lab1`.`country` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`plane`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`plane` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `speed` DOUBLE NOT NULL,
  `model_id` INT NOT NULL,
  `airline_id` INT NOT NULL,
  `kilometrage` INT NOT NULL,
  `aircraft_registration` VARCHAR(7) NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_plane_model1_idx` (`model_id` ASC) VISIBLE,
  INDEX `fk_plane_airline1_idx` (`airline_id` ASC) VISIBLE,
  INDEX `fk_plane_location1_idx` (`location_id` ASC) VISIBLE,
  CONSTRAINT `fk_plane_model1`
    FOREIGN KEY (`model_id`)
    REFERENCES `lab1`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plane_airline1`
    FOREIGN KEY (`airline_id`)
    REFERENCES `lab1`.`airline` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plane_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `lab1`.`location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`city` (
  `name` VARCHAR(45) NOT NULL,
  `population` INT NULL,
  `status` VARCHAR(45) NULL,
  `country_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `fk_city_country1_idx` (`country_name` ASC) VISIBLE,
  CONSTRAINT `fk_city_country1`
    FOREIGN KEY (`country_name`)
    REFERENCES `lab1`.`country` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`airport`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`airport` (
  `name` VARCHAR(45) NOT NULL,
  `quality` VARCHAR(45) NULL,
  `planes_capacity` INT NULL,
  `city_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  INDEX `fk_airport_city1_idx` (`city_name` ASC) VISIBLE,
  CONSTRAINT `fk_airport_city1`
    FOREIGN KEY (`city_name`)
    REFERENCES `lab1`.`city` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `airport_departure` VARCHAR(45) NOT NULL,
  `airport_arrival` VARCHAR(45) NOT NULL,
  `time_departure` DATETIME NULL,
  `time_arrival` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_flight_airport1_idx` (`airport_departure` ASC) VISIBLE,
  INDEX `fk_flight_airport2_idx` (`airport_arrival` ASC) VISIBLE,
  CONSTRAINT `fk_flight_airport1`
    FOREIGN KEY (`airport_departure`)
    REFERENCES `lab1`.`airport` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_airport2`
    FOREIGN KEY (`airport_arrival`)
    REFERENCES `lab1`.`airport` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`route` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `length` INT NULL,
  `duration` DOUBLE NULL,
  `danger_level` INT NULL,
  `is_direct` TINYINT NULL,
  `flight_id` INT NOT NULL,
  PRIMARY KEY (`id`, `flight_id`),
  INDEX `fk_route_flight1_idx` (`flight_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `lab1`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab1`.`plane_flight_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1`.`plane_flight_history` (
  `plane_id` INT NOT NULL,
  `flight_id` INT NOT NULL,
  PRIMARY KEY (`plane_id`, `flight_id`),
  INDEX `fk_plane_has_flight_flight1_idx` (`flight_id` ASC) VISIBLE,
  INDEX `fk_plane_has_flight_plane1_idx` (`plane_id` ASC) VISIBLE,
  CONSTRAINT `fk_plane_has_flight_plane1`
    FOREIGN KEY (`plane_id`)
    REFERENCES `lab1`.`plane` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plane_has_flight_flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `lab1`.`flight` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
