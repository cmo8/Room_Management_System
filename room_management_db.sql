-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 15, 2013 at 04:56 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `room_management_db`
--
CREATE DATABASE IF NOT EXISTS `room_management_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `room_management_db`;

-- --------------------------------------------------------

--
-- Table structure for table `available_rooms`
--

CREATE TABLE IF NOT EXISTS `available_rooms` (
  `Index` int(11) NOT NULL AUTO_INCREMENT,
  `Building` text NOT NULL,
  `RoomNumber` int(4) NOT NULL,
  `RoomType` text NOT NULL,
  PRIMARY KEY (`Index`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

-- --------------------------------------------------------

--
-- Table structure for table `reserved_rooms`
--

CREATE TABLE IF NOT EXISTS `reserved_rooms` (
  `ReservationNumber` int(11) NOT NULL AUTO_INCREMENT,
  `Building` text NOT NULL,
  `RoomNumber` int(4) NOT NULL,
  `Day` int(2) NOT NULL,
  `Month` int(2) NOT NULL,
  `Year` int(4) NOT NULL,
  `StartTime` int(4) NOT NULL COMMENT '24 Hour',
  `EndTime` int(4) NOT NULL COMMENT '24 Hour',
  `UserName` text NOT NULL,
  PRIMARY KEY (`ReservationNumber`),
  KEY `Reservation Number` (`ReservationNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
