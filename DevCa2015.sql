-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 06, 2015 at 06:17 AM
-- Server version: 5.5.41-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `DevCa2015`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE IF NOT EXISTS `brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `play_evolutions`
--

CREATE TABLE IF NOT EXISTS `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text,
  `revert_script` text,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `play_evolutions`
--

INSERT INTO `play_evolutions` (`id`, `hash`, `applied_at`, `apply_script`, `revert_script`, `state`, `last_problem`) VALUES
(1, '57f6232858d6add89b6d9d0308fe0309860dd91c', '2015-03-06 07:26:50', 'create table brand (\nid                        bigint auto_increment not null,\nname                      varchar(255),\nconstraint pk_brand primary key (id))\n;\n\ncreate table product (\nid                        bigint auto_increment not null,\nname                      varchar(255),\nprice                     integer,\nstore_id                  bigint,\nconstraint pk_product primary key (id))\n;\n\ncreate table product_size (\nid                        bigint auto_increment not null,\ndescription               varchar(255),\nconstraint pk_product_size primary key (id))\n;\n\ncreate table store (\nid                        bigint auto_increment not null,\nname                      varchar(255),\naddress                   varchar(255),\naddress2                  varchar(255),\nparish                    varchar(255),\nlatitude                  double,\nlongitude                 double,\ntype                      varchar(255),\ntown                      varchar(255),\ntelenum                   varchar(255),\nconstraint pk_store primary key (id))\n;\n\nalter table product add constraint fk_product_store_1 foreign key (store_id) references store (id) on delete restrict on update restrict;\ncreate index ix_product_store_1 on product (store_id);', 'SET FOREIGN_KEY_CHECKS=0;\n\ndrop table brand;\n\ndrop table product;\n\ndrop table product_size;\n\ndrop table store;\n\nSET FOREIGN_KEY_CHECKS=1;', 'applied', '');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_product_store_1` (`store_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5645635 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `store_id`) VALUES
(76323, 'ackee', 400, 1),
(321321, 'eggs', 200, 0),
(324621, 'chicken back', 230, 0),
(5645634, 'saltfish', 325, 0);

-- --------------------------------------------------------

--
-- Table structure for table `product_size`
--

CREATE TABLE IF NOT EXISTS `product_size` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE IF NOT EXISTS `store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `parish` varchar(255) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `telenum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`id`, `name`, `address`, `address2`, `parish`, `latitude`, `longitude`, `type`, `town`, `telenum`) VALUES
(0, 'XXTRA\r\n', 'Red Hills Mall\r\n', 'Havendale\r\n', 'St. Andrew\r\n', 18.035147, -76.811833, 'Supermarket', 'RED HILLS ROAD\r\n\r\n', '876-931-7733\r\n'),
(1, 'Papine Market\r\n', 'Chandos Place\r\n', 'Papine\r\n', '\r\nSt. Andrew\r\n', 18.014704, -76.742417, 'Supermarket\r\n', NULL, '876-555-5555\r\n');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_product_store_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
