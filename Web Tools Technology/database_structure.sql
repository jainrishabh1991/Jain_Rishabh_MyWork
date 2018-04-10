-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema crowdfunding
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema crowdfunding
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crowdfunding` DEFAULT CHARACTER SET utf8 ;
USE `crowdfunding` ;

-- -----------------------------------------------------
-- Table `crowdfunding`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`category` (
  `category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `category_UNIQUE` (`category` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`location` (
  `location_id` INT(11) NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`location_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`role` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(255) NOT NULL,
  `role_desc` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `roleName_UNIQUE` (`role_name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`user` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `f_name` VARCHAR(255) NULL DEFAULT NULL,
  `l_name` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `email_id` VARCHAR(255) NULL DEFAULT NULL,
  `created_on` DATE NULL DEFAULT NULL,
  `dob` DATE NULL DEFAULT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC),
  INDEX `user_fk_1_idx` (`role_id` ASC),
  CONSTRAINT `user_fk_1`
    FOREIGN KEY (`role_id`)
    REFERENCES `crowdfunding`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`project` (
  `project_id` INT(11) NOT NULL,
  `category_id` INT(11) NULL DEFAULT NULL,
  `location_id` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `website` VARCHAR(255) NULL DEFAULT NULL,
  `goal_amt` INT(11) NULL DEFAULT NULL,
  `start_date` DATE NULL DEFAULT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `image_link` VARCHAR(255) NULL DEFAULT NULL,
  `status` INT(11) NULL DEFAULT NULL,
  `received_amt` INT(11) NULL DEFAULT NULL,
  `backers_count` INT(11) NULL DEFAULT NULL,
  `is_enabled` INT(11) NULL DEFAULT NULL,
  `reason` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE INDEX `project_id_UNIQUE` (`project_id` ASC),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC),
  UNIQUE INDEX `website_UNIQUE` (`website` ASC),
  INDEX `project_fk_1_idx` (`user_id` ASC),
  INDEX `project_fk_2_idx` (`location_id` ASC),
  INDEX `project_fk_3_idx` (`category_id` ASC),
  CONSTRAINT `project_fk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `crowdfunding`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_fk_2`
    FOREIGN KEY (`location_id`)
    REFERENCES `crowdfunding`.`location` (`location_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_fk_3`
    FOREIGN KEY (`category_id`)
    REFERENCES `crowdfunding`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`reward`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`reward` (
  `reward_id` INT(11) NOT NULL,
  `project_id` INT(11) NULL DEFAULT NULL,
  `text` VARCHAR(255) NULL DEFAULT NULL,
  `min_amt` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`reward_id`),
  UNIQUE INDEX `reward_id_UNIQUE` (`reward_id` ASC),
  INDEX `reward_fk_1_idx` (`project_id` ASC),
  CONSTRAINT `reward_fk_1`
    FOREIGN KEY (`project_id`)
    REFERENCES `crowdfunding`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`service` (
  `service_id` INT(11) NOT NULL,
  `project_id` INT(11) NULL DEFAULT NULL,
  `text` VARCHAR(255) NULL DEFAULT NULL,
  `max_amt` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  INDEX `service_fk_1_idx` (`project_id` ASC),
  CONSTRAINT `service_fk_1`
    FOREIGN KEY (`project_id`)
    REFERENCES `crowdfunding`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`startup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`startup` (
  `startup_id` INT(11) NOT NULL,
  `category_id` INT(11) NULL DEFAULT NULL,
  `location_id` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `company_name` VARCHAR(255) NULL DEFAULT NULL,
  `about` VARCHAR(1000) NULL DEFAULT NULL,
  `contact_person` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`startup_id`),
  UNIQUE INDEX `company_name_UNIQUE` (`company_name` ASC),
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC),
  INDEX `startup_fk_1_idx` (`category_id` ASC),
  INDEX `startup_fk_2_idx` (`location_id` ASC),
  INDEX `startup_fk_3_idx` (`user_id` ASC),
  CONSTRAINT `startup_fk_1`
    FOREIGN KEY (`category_id`)
    REFERENCES `crowdfunding`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `startup_fk_2`
    FOREIGN KEY (`location_id`)
    REFERENCES `crowdfunding`.`location` (`location_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `startup_fk_3`
    FOREIGN KEY (`user_id`)
    REFERENCES `crowdfunding`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`servicebid`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`servicebid` (
  `service_bid_id` INT(11) NOT NULL,
  `service_id` INT(11) NULL DEFAULT NULL,
  `startup_id` INT(11) NULL DEFAULT NULL,
  `bid_amt` INT(11) NULL DEFAULT NULL,
  `is_assigned` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`service_bid_id`),
  INDEX `servicebid_fk_1_idx` (`service_id` ASC),
  INDEX `servicebid_fk_2_idx` (`startup_id` ASC),
  CONSTRAINT `servicebid_fk_1`
    FOREIGN KEY (`service_id`)
    REFERENCES `crowdfunding`.`service` (`service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `servicebid_fk_2`
    FOREIGN KEY (`startup_id`)
    REFERENCES `crowdfunding`.`startup` (`startup_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crowdfunding`.`testimonial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdfunding`.`testimonial` (
  `testimonial_id` INT(11) NOT NULL,
  `project_id` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `testimonial` VARCHAR(255) NULL DEFAULT NULL,
  `post_date` DATE NULL DEFAULT NULL,
  `rating` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`testimonial_id`),
  INDEX `testimonial_fk_1_idx` (`project_id` ASC),
  INDEX `testimonial_fk_2_idx` (`user_id` ASC),
  CONSTRAINT `testimonial_fk_1`
    FOREIGN KEY (`project_id`)
    REFERENCES `crowdfunding`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `testimonial_fk_2`
    FOREIGN KEY (`user_id`)
    REFERENCES `crowdfunding`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
