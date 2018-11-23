-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2018 at 05:24 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `deposit`
--

CREATE TABLE `deposit` (
  `AccNo` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `DateD` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deposit`
--

INSERT INTO `deposit` (`AccNo`, `Amount`, `DateD`) VALUES
(1, 0, '2018-11-21'),
(1, 200, '2018-11-21'),
(1, 100, '2018-11-21'),
(2, 500, '2018-11-21'),
(3, 1000, '2018-11-21'),
(1, 50, '2018-11-21'),
(1, 500, '2018-11-21'),
(4, 2000, '2018-11-21'),
(5, 2500, '2018-11-21'),
(9, 300, '2018-11-21'),
(6, 1250, '2018-11-21'),
(7, 4000, '2018-11-21'),
(8, 400, '2018-11-21'),
(1, 100, '2018-11-21'),
(1, 20, '2018-11-21'),
(10, 20, '2018-11-22'),
(2, 20, '2018-11-22'),
(5, 20, '2018-11-22'),
(11, 600, '2018-11-22');

-- --------------------------------------------------------

--
-- Table structure for table `personal`
--

CREATE TABLE `personal` (
  `AccNo` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Address` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personal`
--

INSERT INTO `personal` (`AccNo`, `Name`, `Address`) VALUES
(1, 'Sam', 'London'),
(2, 'Matt', 'Bristol'),
(3, 'Izy', 'London'),
(4, 'Dave', 'Essex'),
(5, 'Tim', 'Derby'),
(6, 'Rob', 'Cardiff'),
(7, 'Jen', 'London'),
(8, 'Eoin', 'Dublin'),
(9, 'Tony', 'Manchester'),
(10, 'Scott', 'Glasgow'),
(11, 'Fred', 'Newcastle'),
(12, 'George', 'Norwich');

-- --------------------------------------------------------

--
-- Table structure for table `withdraw`
--

CREATE TABLE `withdraw` (
  `AccNo` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `DateW` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `withdraw`
--

INSERT INTO `withdraw` (`AccNo`, `Amount`, `DateW`) VALUES
(1, 0, '2018-11-21'),
(1, 100, '2018-11-21'),
(1, 100, '2018-11-21'),
(1, 50, '2018-11-21'),
(1, 20, '2018-11-21'),
(4, 1200, '2018-11-21'),
(7, 120, '2018-11-22'),
(4, 400, '2018-11-22'),
(9, 30, '2018-11-22'),
(7, 400, '2018-11-22'),
(5, 2000, '2018-11-22'),
(7, 400, '2018-11-22');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`AccNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `personal`
--
ALTER TABLE `personal`
  MODIFY `AccNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
