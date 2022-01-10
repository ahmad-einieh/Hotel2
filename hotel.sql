-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2021 at 06:26 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `hotelID` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `name`, `roomNumber`, `hotelID`, `startDate`, `endDate`) VALUES
(1, 'waleed', 2, 1, '2022-01-26', '2022-01-27'),
(2, 'ahmad', 1, 2, '2022-01-26', '2022-01-27'),
(2, 'ali', 2, 1, '2021-12-27', '2021-12-29'),
(3, 'assad', 1, 1, '2022-01-01', '2022-01-04'),
(4, 'assad', 1, 1, '2022-01-05', '2022-01-10'),
(10, 'ahmad', 2, 1, '2021-12-30', '2021-12-31'),
(15, 'ahmad eienih', 1, 1, '2022-02-03', '2022-02-05'),
(17, 'zain', 1, 1, '2022-03-04', '2022-03-06'),
(19, 'zain 2', 1, 1, '2022-03-17', '2022-03-19');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `salary` double NOT NULL,
  `HotelID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`ID`, `name`, `salary`, `HotelID`) VALUES
(1, 'ali', 3000, 1),
(2, 'saad', 4500, 1),
(3, 'ahmad', 7500, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `ID` int(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`ID`, `name`, `location`) VALUES
(1, 'star', 'syria'),
(2, 'flower', 'syria');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `name` varchar(255) NOT NULL,
  `rank` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`name`, `rank`) VALUES
('manger', '10'),
('reciptioner', '2'),
('servicer', '1');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `number` int(11) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(255) NOT NULL,
  `HotelID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`number`, `price`, `type`, `HotelID`) VALUES
(1, 195, 'single', 1),
(1, 200, 'single', 2),
(2, 300, 'double', 1),
(3, 250, 'big single', 1),
(4, 400, 'tow room single', 1),
(5, 550, 'tow room double', 1),
(6, 500, 'one room single and one double', 1);

-- --------------------------------------------------------

--
-- Table structure for table `working as`
--

CREATE TABLE `working as` (
  `EmployeeID` int(11) NOT NULL,
  `RoleName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `working as`
--

INSERT INTO `working as` (`EmployeeID`, `RoleName`) VALUES
(1, 'servicer'),
(2, 'reciptioner'),
(2, 'servicer'),
(3, 'manger');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`,`roomNumber`,`hotelID`,`startDate`,`endDate`),
  ADD UNIQUE KEY `ID_2` (`ID`,`hotelID`),
  ADD KEY `roomID` (`roomNumber`),
  ADD KEY `hotelID` (`hotelID`,`startDate`,`endDate`),
  ADD KEY `ID` (`ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`,`HotelID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD UNIQUE KEY `ID_2` (`ID`),
  ADD KEY `HotelID` (`HotelID`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`name`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`number`,`HotelID`),
  ADD KEY `number` (`number`,`HotelID`),
  ADD KEY `HotelID` (`HotelID`);

--
-- Indexes for table `working as`
--
ALTER TABLE `working as`
  ADD PRIMARY KEY (`EmployeeID`,`RoleName`),
  ADD KEY `EmployeeID` (`EmployeeID`,`RoleName`),
  ADD KEY `RoleName` (`RoleName`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`ID`),
  ADD CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`roomNumber`) REFERENCES `room` (`number`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`HotelID`) REFERENCES `hotel` (`ID`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`HotelID`) REFERENCES `hotel` (`ID`);

--
-- Constraints for table `working as`
--
ALTER TABLE `working as`
  ADD CONSTRAINT `working as_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`ID`),
  ADD CONSTRAINT `working as_ibfk_2` FOREIGN KEY (`RoleName`) REFERENCES `role` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
