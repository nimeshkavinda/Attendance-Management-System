-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2020 at 12:30 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nsbm_ams`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `atdid` int(11) NOT NULL,
  `stdid` int(10) UNSIGNED ZEROFILL NOT NULL,
  `date` varchar(30) NOT NULL,
  `day` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`atdid`, `stdid`, `date`, `day`) VALUES
(12, 0007608418, '2020/11/25 14:30:44', 'Wed'),
(13, 0007608418, '2020/11/25 16:04:34', 'Wed'),
(14, 0007608418, '2020/11/25 16:06:06', 'Wed'),
(15, 0007608418, '2020/11/25 16:07:06', 'Wed'),
(16, 0007608418, '2020/11/25 16:07:54', 'Wed'),
(17, 0007608418, '2020/11/25 16:25:37', 'Wed');

-- --------------------------------------------------------

--
-- Table structure for table `degree`
--

CREATE TABLE `degree` (
  `did` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `degree`
--

INSERT INTO `degree` (`did`, `name`) VALUES
(1, 'Business Management'),
(2, 'Marketing Management'),
(3, 'Accounting and Finance'),
(4, 'Software Engineering'),
(5, 'Computer Networks'),
(6, 'Computer Security'),
(7, 'Computer System Engineering'),
(8, 'Interior Design');

-- --------------------------------------------------------

--
-- Table structure for table `degree_module`
--

CREATE TABLE `degree_module` (
  `did` int(11) NOT NULL,
  `mid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empid` int(11) NOT NULL,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `access_lvl` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empid`, `fname`, `lname`, `email`, `mobile`, `password`, `access_lvl`) VALUES
(8, 'test', 'test', 'a@test.com', '0', 'a', 1),
(14, 'Nimesh', 'K', 'a@nsbm.lk', '', 'a', 0);

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `mid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`mid`, `name`) VALUES
(1, 'SOFT255SL'),
(2, 'PUSL2002');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stdid` int(10) UNSIGNED ZEROFILL NOT NULL,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `nic` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `province` varchar(20) NOT NULL,
  `batch` varchar(20) NOT NULL,
  `faculty` varchar(20) NOT NULL,
  `did` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stdid`, `fname`, `lname`, `dob`, `gender`, `nic`, `email`, `mobile`, `address`, `city`, `province`, `batch`, `faculty`, `did`) VALUES
(0007608418, 'Nimesh', 'Kavinda', '03/08/2000', 'male', '200006800341', 'a@test.com', '0716956139', '148/A, Horana Road', 'Padukka', 'Western Province', '19.2', 'Faculty of Computing', 1);

-- --------------------------------------------------------

--
-- Table structure for table `time_table`
--

CREATE TABLE `time_table` (
  `mid` int(11) NOT NULL,
  `day` varchar(3) NOT NULL,
  `time` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`atdid`),
  ADD KEY `stdid` (`stdid`);

--
-- Indexes for table `degree`
--
ALTER TABLE `degree`
  ADD PRIMARY KEY (`did`);

--
-- Indexes for table `degree_module`
--
ALTER TABLE `degree_module`
  ADD PRIMARY KEY (`did`,`mid`),
  ADD KEY `mid` (`mid`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empid`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stdid`),
  ADD KEY `did` (`did`);

--
-- Indexes for table `time_table`
--
ALTER TABLE `time_table`
  ADD PRIMARY KEY (`mid`,`day`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `atdid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `empid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`stdid`) REFERENCES `student` (`stdid`) ON UPDATE CASCADE;

--
-- Constraints for table `degree_module`
--
ALTER TABLE `degree_module`
  ADD CONSTRAINT `degree_module_ibfk_1` FOREIGN KEY (`did`) REFERENCES `degree` (`did`) ON UPDATE CASCADE,
  ADD CONSTRAINT `degree_module_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `module` (`mid`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`did`) REFERENCES `degree` (`did`) ON UPDATE CASCADE;

--
-- Constraints for table `time_table`
--
ALTER TABLE `time_table`
  ADD CONSTRAINT `time_table_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `module` (`mid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
