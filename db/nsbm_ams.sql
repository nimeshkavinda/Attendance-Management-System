-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2020 at 02:13 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

--
-- Dumping data for table `degree_module`
--

INSERT INTO `degree_module` (`did`, `mid`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 5),
(2, 16),
(2, 17),
(3, 4),
(3, 18),
(3, 19),
(4, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10),
(5, 20),
(6, 21),
(6, 22),
(6, 23),
(7, 13),
(7, 14),
(7, 15),
(8, 11),
(8, 12),
(8, 24);

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

-- --------------------------------------------------------

--
-- Table structure for table `lecture_hall`
--

CREATE TABLE `lecture_hall` (
  `lhid` varchar(10) NOT NULL,
  `size` int(11) NOT NULL,
  `mid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lecture_hall`
--

INSERT INTO `lecture_hall` (`lhid`, `size`, `mid`) VALUES
('1', 150, NULL),
('10', 150, NULL),
('11', 150, NULL),
('12', 150, NULL),
('13', 150, NULL),
('14', 150, NULL),
('15', 150, NULL),
('16', 400, NULL),
('17', 400, NULL),
('18', 400, NULL),
('19', 400, NULL),
('2', 150, NULL),
('20', 400, NULL),
('21', 400, NULL),
('22', 400, NULL),
('23', 400, NULL),
('24', 400, NULL),
('25', 400, NULL),
('26', 800, NULL),
('27', 800, NULL),
('28', 800, NULL),
('29', 800, NULL),
('3', 150, NULL),
('30', 800, NULL),
('4', 150, NULL),
('5', 150, NULL),
('6', 150, NULL),
('7', 150, NULL),
('8', 150, NULL),
('9', 150, NULL);

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
(1, 'International Business'),
(2, 'Operations Management'),
(3, 'Business Ethics'),
(4, 'Management Accounting'),
(5, 'International Marketing'),
(6, 'SE with Java'),
(7, 'Web Development Platforms'),
(8, 'Databases'),
(9, 'Network Security'),
(10, 'Internet of Things'),
(11, 'Design Communication'),
(12, 'Building Science'),
(13, 'Algorithms'),
(14, 'Operating Systems'),
(15, 'Engineering Mathematics'),
(16, 'Digital Marketing'),
(17, 'Advertising'),
(18, 'Financial Accounting'),
(19, 'Taxation'),
(20, 'Servers and Datacenters'),
(21, 'Incident Prevention'),
(22, 'Network Monitoring'),
(23, 'Penetration Testing'),
(24, 'Design Culture');

-- --------------------------------------------------------

--
-- Table structure for table `module_date`
--

CREATE TABLE `module_date` (
  `mdid` int(11) NOT NULL,
  `date` varchar(30) NOT NULL,
  `mid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `module_date`
--

INSERT INTO `module_date` (`mdid`, `date`, `mid`) VALUES
(6, '2020/11/29', 6),
(7, '2020/11/29', 6),
(8, '2020/11/29', 6),
(9, '2020/11/29', 1),
(10, '2020/11/29', 3),
(11, '2020/11/29', 1),
(12, '2020/11/29', 1),
(13, '2020/11/29', 1),
(14, '2020/11/29', 1),
(15, '2020/11/30', 6),
(16, '2020/11/30', 6);

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
  `faculty` varchar(30) NOT NULL,
  `batch` varchar(30) NOT NULL,
  `did` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Dumping data for table `time_table`
--

INSERT INTO `time_table` (`mid`, `day`, `time`) VALUES
(1, 'Mon', '9:00AM'),
(1, 'Sun', '9:00AM'),
(1, 'Thu', '1:00PM'),
(2, 'Fri', '9:00AM'),
(2, 'Tue', '1:00PM'),
(3, 'Sat', '1:00PM'),
(3, 'Wed', '9:00AM'),
(4, 'Mon', '9:00AM'),
(4, 'Sun', '9:00AM'),
(4, 'Thu', '1:00PM'),
(5, 'Mon', '9:00AM'),
(5, 'Sun', '9:00AM'),
(5, 'Thu', '1:00PM'),
(6, 'Mon', '9:00AM'),
(6, 'Sun', '9:00AM'),
(6, 'Thu', '1:00PM'),
(7, 'Fri', '9:00AM'),
(7, 'Tue', '1:00PM'),
(8, 'Sat', '1:00PM'),
(8, 'Wed', '9:00AM'),
(9, 'Mon', '9:00AM'),
(9, 'Sun', '9:00AM'),
(9, 'Thu', '1:00PM'),
(10, 'Fri', '9:00AM'),
(10, 'Tue', '1:00PM'),
(11, 'Mon', '9:00AM'),
(11, 'Sun', '9:00AM'),
(11, 'Thu', '1:00PM'),
(12, 'Fri', '9:00AM'),
(12, 'Tue', '1:00PM'),
(13, 'Mon', '9:00AM'),
(13, 'Sun', '9:00AM'),
(13, 'Thu', '1:00PM'),
(14, 'Fri', '9:00AM'),
(14, 'Tue', '1:00PM'),
(15, 'Sat', '1:00PM'),
(15, 'Wed', '9:00AM'),
(16, 'Fri', '9:00AM'),
(16, 'Tue', '1:00PM'),
(17, 'Sat', '1:00PM'),
(17, 'Wed', '9:00AM'),
(18, 'Fri', '9:00AM'),
(18, 'Tue', '1:00PM'),
(19, 'Sat', '1:00PM'),
(19, 'Wed', '9:00AM'),
(20, 'Sat', '1:00PM'),
(20, 'Wed', '9:00AM'),
(21, 'Mon', '9:00AM'),
(21, 'Sun', '9:00AM'),
(21, 'Thu', '1:00PM'),
(22, 'Fri', '9:00AM'),
(22, 'Tue', '1:00PM'),
(23, 'Sat', '1:00PM'),
(23, 'Wed', '9:00AM'),
(24, 'Sat', '1:00PM'),
(24, 'Wed', '9:00AM');

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
-- Indexes for table `lecture_hall`
--
ALTER TABLE `lecture_hall`
  ADD PRIMARY KEY (`lhid`),
  ADD KEY `mid` (`mid`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `module_date`
--
ALTER TABLE `module_date`
  ADD PRIMARY KEY (`mdid`),
  ADD KEY `mid` (`mid`);

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
  MODIFY `atdid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `empid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `module_date`
--
ALTER TABLE `module_date`
  MODIFY `mdid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

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
-- Constraints for table `lecture_hall`
--
ALTER TABLE `lecture_hall`
  ADD CONSTRAINT `lecture_hall_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `module` (`mid`) ON UPDATE CASCADE;

--
-- Constraints for table `module_date`
--
ALTER TABLE `module_date`
  ADD CONSTRAINT `module_date_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `module` (`mid`) ON UPDATE CASCADE;

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
