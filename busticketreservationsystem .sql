-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2017 at 06:09 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `busticketreservationsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_login`
--

CREATE TABLE `admin_login` (
  `name` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(10) NOT NULL,
  `nic_number` varchar(15) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `password` varchar(150) NOT NULL,
  `permissions` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_login`
--

INSERT INTO `admin_login` (`name`, `email`, `phone`, `nic_number`, `user_name`, `password`, `permissions`) VALUES
('admin', 'admin@groupc ', 123456789, '987654321V', 'admin', 'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec', ' -0- -1- -2- -3- -4- -5- -6- -7- -8- -9- -10- -11- -12- -13- ');

-- --------------------------------------------------------

--
-- Table structure for table `booking_data`
--

CREATE TABLE `booking_data` (
  `booking_number` varchar(20) NOT NULL,
  `bus_number` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(50) NOT NULL,
  `start` varchar(50) NOT NULL,
  `end` varchar(50) NOT NULL,
  `seat_number` int(2) NOT NULL,
  `email` varchar(100) NOT NULL,
  `booked_in` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bus_data`
--

CREATE TABLE `bus_data` (
  `bus_name` varchar(100) NOT NULL,
  `bus_number` varchar(20) NOT NULL,
  `number_of_seats` int(2) NOT NULL,
  `transport_license_number` varchar(50) NOT NULL,
  `hotlint` int(100) NOT NULL,
  `seat_configuration` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bus_turns`
--

CREATE TABLE `bus_turns` (
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `rout_number` varchar(20) NOT NULL,
  `rout_from` varchar(50) NOT NULL,
  `rout_to` varchar(50) NOT NULL,
  `bus_number` varchar(20) NOT NULL,
  `bus_turn_id` varchar(50) NOT NULL,
  `is_filled` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `company_data`
--

CREATE TABLE `company_data` (
  `refund_Percentage` int(3) NOT NULL,
  `hotline` int(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `company_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company_data`
--

INSERT INTO `company_data` (`refund_Percentage`, `hotline`, `email`, `company_name`) VALUES
(50, 112345678, 'grouc@gmail.com', 'Group C bus ticket reservation Pvt Ltd');

-- --------------------------------------------------------

--
-- Table structure for table `counting`
--

CREATE TABLE `counting` (
  `bookings` int(11) NOT NULL,
  `number_of_turns_added` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `counting`
--

INSERT INTO `counting` (`bookings`, `number_of_turns_added`) VALUES
(0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `customer_login`
--

CREATE TABLE `customer_login` (
  `customer_name` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(10) NOT NULL,
  `nic_number` varchar(15) NOT NULL,
  `password` varchar(150) NOT NULL,
  `gender` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `daily_transactions`
--

CREATE TABLE `daily_transactions` (
  `date` varchar(20) NOT NULL,
  `credit` decimal(10,2) NOT NULL,
  `debit` decimal(10,2) NOT NULL,
  `balance` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deleted_bookings`
--

CREATE TABLE `deleted_bookings` (
  `booking_number` varchar(20) NOT NULL,
  `bus_number` varchar(20) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(50) NOT NULL,
  `start` varchar(50) NOT NULL,
  `end` varchar(50) NOT NULL,
  `seat_number` int(2) NOT NULL,
  `email` varchar(100) NOT NULL,
  `booked_in` varchar(20) NOT NULL,
  `deleted_in` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rout_data`
--

CREATE TABLE `rout_data` (
  `rout_number` varchar(20) NOT NULL,
  `rout` varchar(50) NOT NULL,
  `total_distance` int(100) NOT NULL,
  `total_bus_fee` int(100) NOT NULL,
  `total_travel_time_in_minutes` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_login`
--
ALTER TABLE `admin_login`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `bus_data`
--
ALTER TABLE `bus_data`
  ADD PRIMARY KEY (`bus_number`);

--
-- Indexes for table `bus_turns`
--
ALTER TABLE `bus_turns`
  ADD PRIMARY KEY (`bus_turn_id`);

--
-- Indexes for table `customer_login`
--
ALTER TABLE `customer_login`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `daily_transactions`
--
ALTER TABLE `daily_transactions`
  ADD PRIMARY KEY (`date`);

--
-- Indexes for table `rout_data`
--
ALTER TABLE `rout_data`
  ADD PRIMARY KEY (`rout_number`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
