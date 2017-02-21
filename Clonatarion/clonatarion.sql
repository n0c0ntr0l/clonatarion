-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2017 at 10:10 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `clonatarion`
--

-- --------------------------------------------------------

--
-- Table structure for table `movingunits`
--

CREATE TABLE IF NOT EXISTS `movingunits` (
  `id` int(11) NOT NULL,
  `destinationid` int(11) NOT NULL,
  `eta` int(11) NOT NULL,
  `totalnumberofunits` int(11) NOT NULL,
  `attdef` int(1) NOT NULL,
  KEY `id` (`id`),
  KEY `destinationid` (`destinationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `movingunitsdetailed`
--

CREATE TABLE IF NOT EXISTS `movingunitsdetailed` (
  `playerid` int(5) NOT NULL,
  `unit` varchar(30) NOT NULL,
  `amount` int(20) NOT NULL,
  `amountremaining` int(20) NOT NULL,
  `destinationid` int(5) NOT NULL,
  `eta` int(5) NOT NULL,
  `totaleta` int(5) NOT NULL,
  `ATTDEF` int(1) NOT NULL,
  KEY `unit` (`unit`),
  KEY `playerid` (`playerid`),
  KEY `destinationid` (`destinationid`),
  KEY `eta` (`eta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `playerbattlereports`
--

CREATE TABLE IF NOT EXISTS `playerbattlereports` (
  `playerid` int(11) NOT NULL,
  `ticknumber` int(11) NOT NULL,
  `tickdate` text NOT NULL,
  `ticktime` text NOT NULL,
  `battlereport` text NOT NULL,
  `friendliesDistracted` int(20) NOT NULL,
  `enemiesdistracted` int(20) NOT NULL,
  `friendliesdisabled` int(20) NOT NULL,
  `enemiesdisabled` int(20) NOT NULL,
  `friendsdead` int(20) NOT NULL,
  `enemiesdead` int(20) NOT NULL,
  `friendsbribed` int(20) NOT NULL,
  `enemiesbribed` int(20) NOT NULL,
  `honour` int(20) NOT NULL,
  `fame` int(20) NOT NULL,
  `effectiveness` int(20) NOT NULL,
  `land` int(20) NOT NULL,
  `bounty` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `playeridmain`
--

CREATE TABLE IF NOT EXISTS `playeridmain` (
  `playerid` int(20) NOT NULL,
  `playername` varchar(35) NOT NULL,
  `land` int(20) NOT NULL,
  `score` int(20) NOT NULL,
  PRIMARY KEY (`playername`),
  UNIQUE KEY `playerid` (`playerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `playerunits`
--

CREATE TABLE IF NOT EXISTS `playerunits` (
  `playerid` int(5) NOT NULL,
  `unit` varchar(200) NOT NULL,
  `totalamount` int(20) NOT NULL,
  `numberhome` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

CREATE TABLE IF NOT EXISTS `units` (
  `name` varchar(200) NOT NULL,
  `route` varchar(200) NOT NULL,
  `class` varchar(200) NOT NULL,
  `init` int(20) NOT NULL,
  `health` int(20) NOT NULL,
  `armour` int(20) NOT NULL,
  `hdamage` int(20) NOT NULL,
  `adamage` int(20) NOT NULL,
  `t1` varchar(20) NOT NULL,
  `t2` varchar(20) NOT NULL,
  `t3` varchar(20) NOT NULL,
  `stealth` int(20) NOT NULL,
  `range` int(20) NOT NULL,
  `value` int(20) NOT NULL,
  `build` varchar(20) NOT NULL,
  `eta` int(20) NOT NULL,
  UNIQUE KEY `name` (`name`),
  KEY `name_2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
