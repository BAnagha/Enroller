-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 06:45 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enroller`
--

-- --------------------------------------------------------

--
-- Table structure for table `addsalary`
--

CREATE TABLE `addsalary` (
  `email` varchar(255) DEFAULT NULL,
  `month` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `amount` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `addsalary`
--

INSERT INTO `addsalary` (`email`, `month`, `year`, `amount`) VALUES
('zinidevaza@mailinator.net', 'November', '2018', '3432'),
('winypasyvy@mailinator.net', 'February', '2018', '12334324'),
('hulugi@mailinator.com', 'October', '2018', '132423'),
('juxa@mailinator.net', 'December', '2018', '214234'),
('gefineleh@mailinator.net', 'April', '2018', '132443535'),
('okokok@okok.com', 'April', '2019', '1200'),
('okokok@okok.com', 'April', '2019', '800'),
('test@test.com', 'May', '2019', '200');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(6) NOT NULL DEFAULT 'WORKER'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `emp_id`, `username`, `password`, `role`) VALUES
(1, 30, 'admin', 'password', 'ADMIN'),
(2, 0, 'bhupi', 'null', 'WORKER'),
(3, 0, 'bhupi1', '123456', 'WORKER'),
(4, 0, 'bhupi3', '123456', 'WORKER'),
(5, 31, 'abc@abc.com', 'password', 'WORKER'),
(6, 34, 'aryastark@got.com', 'Qwerty', 'WORKER'),
(7, 35, 'threeeyed@raven.com', 'Qwerty@1234', 'WORKER'),
(8, 36, 'jon@snow.com', 'Qwerty@1234', 'WORKER'),
(9, 37, 'sansa@stark.com', 'Lady1234', 'WORKER');

-- --------------------------------------------------------

--
-- Table structure for table `available_shifts`
--

CREATE TABLE `available_shifts` (
  `id` int(11) NOT NULL,
  `shift_id` int(11) NOT NULL,
  `count_of_worker_positions` int(5) NOT NULL,
  `count_of_main_positions` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `did` int(11) NOT NULL,
  `dname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`did`, `dname`) VALUES
(1, 'Cs'),
(2, 'Medical');

-- --------------------------------------------------------

--
-- Table structure for table `eleave`
--

CREATE TABLE `eleave` (
  `lid` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `des` varchar(45) DEFAULT NULL,
  `fdate` varchar(45) DEFAULT NULL,
  `tdate` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `eleave`
--

INSERT INTO `eleave` (`lid`, `email`, `des`, `fdate`, `tdate`, `status`) VALUES
(1, 'zyqebab@mailinator.net', 'fgegege', '04/22/2019', '06/22/2019', 'Approved'),
(2, 'test@test.com', 'Medical', '04-05-2019', '04-07-2019', 'Request');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` bigint(10) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hourly_wage` int(11) NOT NULL,
  `maritalStatus` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`eid`, `fname`, `lname`, `dob`, `gender`, `doj`, `address`, `phone`, `email`, `hourly_wage`, `maritalStatus`) VALUES
(28, 'John', 'Doe', '1993-06-04', 'Male', '2019-02-13', '112 W Oak Street, Normal, IL', 2147483647, 'johndoe@erty.com', 8, '567887'),
(29, 'Jenny', 'Doe', '1995-05-04', 'Female', '2019-02-05', '112 W Oak Street, Normal, IL', 2147483647, 'jennydoe@erty.com', 8, '567887'),
(30, 'Josh', 'Doe', '1990-03-27', 'Male', '2019-03-30', '112 W Oak Street, Normal, IL', 2147483647, 'joshdoe@erty.com', 10, '567887'),
(31, 'Anagha', 'Bhide', '1993-02-12', 'Female', '2019-02-12', 'Normal', 3333444434, 'abc@abc.com', 0, 'Qwerty'),
(32, 'Shashank', 'Sethi', '1994-10-19', 'Male', '2019-02-15', 'rferttg', 2233223323, 'fbfbfb@fbfb.com', 10, 'Qwerty'),
(33, 'Test', 'Test', '1993-04-13', 'Male', '2019-04-01', '112 Oak Street', 2223332323, 'test@test.com', 16, 'Qwerty'),
(34, 'Arya', NULL, '1995-06-24', '', '1995-06-24', 'Winterfell', 1111222233, 'aryastark@got.com', 14, NULL),
(35, 'Three eyed', 'Raven', '1995-06-24', 'Male', '2019-02-15', 'Winterfell', 1231434343, 'threeeyed@raven.com', 11, NULL),
(36, 'Jon', 'Snow', '1995-06-24', 'Male', '2019-02-15', 'Winterfell', 1212121212, 'jon@snow.com', 15, NULL),
(37, 'Sansa', 'Stark', '2019-05-08', 'Female', '2019-05-08', 'Winterfell', 1212123434, 'sansa@stark.com', 15, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee_shift`
--

CREATE TABLE `employee_shift` (
  `id` int(11) NOT NULL COMMENT 'is for employee_shift',
  `shift_id` int(11) NOT NULL COMMENT 'foreign key from shift table',
  `emp_id` int(11) NOT NULL COMMENT 'id of employee',
  `is_subletted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee_shift`
--

INSERT INTO `employee_shift` (`id`, `shift_id`, `emp_id`, `is_subletted`) VALUES
(1, 2, 28, 0),
(3, 1, 29, 0),
(4, 5, 30, 0),
(5, 5, 31, 1),
(24, 2, 31, 1),
(25, 5, 31, 0),
(26, 4, 31, 0),
(27, 8, 31, 0),
(28, 7, 31, 0),
(29, 11, 37, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee_subletted_shifts`
--

CREATE TABLE `employee_subletted_shifts` (
  `id` int(11) NOT NULL,
  `shift_id` int(11) NOT NULL,
  `sublet_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `date_of_sublet` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee_subletted_shifts`
--

INSERT INTO `employee_subletted_shifts` (`id`, `shift_id`, `sublet_id`, `emp_id`, `date_of_sublet`) VALUES
(4, 5, 2, 31, '2019-05-12');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `pid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `cost` varchar(255) DEFAULT NULL,
  `assignTo` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`pid`, `name`, `status`, `des`, `cost`, `assignTo`, `department`) VALUES
(1, 'Gage Ortiz', 'Approved', 'Laboriosam qui voluptatem iure atque maiores sunt doloribus possimus architecto earum harum', 'Ipsum mollit mollitia qui culpa proident molestias sed similique accusamus in aspernatur culpa animi incidunt enim consectetur rerum id sint', NULL, NULL),
(2, 'Kirby Puckett', 'Approved', 'Assumenda in consequatur Saepe magnam accusamus', 'Corporis necessitatibus culpa beatae aut elit enim quia sed quia nulla', NULL, NULL),
(3, 'Burke Diaz', 'Pending', 'Suscipit sequi ut ut alias id tempora sapiente ipsum facilis veniam quisquam sit tempor et beatae dolor deserunt laboriosam aut', 'Aut illum eum nostrum dolore molestiae molestiae aut exercitation consequatur nulla quasi aute omnis repellendus Fuga Culpa laboris corporis', NULL, NULL),
(4, 'Allen Burns', 'Pending', 'Et deserunt ducimus Nam delectus nemo', 'Ipsa magna est nostrud aut Nam similique ad error saepe fugiat aut ducimus deleniti', 'zyqebab@mailinator.net', 'Cs');

-- --------------------------------------------------------

--
-- Table structure for table `shifts`
--

CREATE TABLE `shifts` (
  `id` int(11) NOT NULL COMMENT 'id of a shift',
  `shift_venue_id` int(11) NOT NULL COMMENT 'venue id of a shift',
  `day` varchar(10) NOT NULL COMMENT 'day of shift',
  `start_time` time NOT NULL COMMENT 'start time of shift',
  `end_time` time NOT NULL COMMENT 'end time of shift',
  `available_positions` int(11) NOT NULL COMMENT 'number of workers needed for the shift',
  `total_positions` int(11) NOT NULL COMMENT 'number of main workers neededfor the shift'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table for shift data';

--
-- Dumping data for table `shifts`
--

INSERT INTO `shifts` (`id`, `shift_venue_id`, `day`, `start_time`, `end_time`, `available_positions`, `total_positions`) VALUES
(1, 3, 'monday', '07:30:00', '10:45:00', 2, 3),
(2, 3, 'tuesday', '10:45:00', '13:15:00', 3, 5),
(3, 3, 'wednesday', '13:15:00', '15:30:00', 3, 3),
(4, 4, 'wednesday', '12:30:00', '15:30:00', 3, 4),
(5, 5, 'monday', '10:00:00', '13:30:00', 4, 7),
(6, 5, 'thursday', '13:30:00', '16:00:00', 3, 3),
(7, 4, 'Monday', '03:30:00', '06:00:00', 8, 0),
(8, 4, 'Thursday', '00:30:00', '04:00:00', 1, 0),
(9, 5, 'Friday', '00:45:00', '03:00:00', 6, 0),
(10, 4, 'Sunday', '03:00:00', '06:00:00', 6, 0),
(11, 3, 'Monday', '10:00:00', '12:30:00', 2, 9),
(12, 5, 'Friday', '15:30:00', '18:00:00', 2, 0),
(13, 7, 'Friday', '12:45:00', '15:00:00', 6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `spring_session`
--

CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `spring_session_attributes`
--

CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `sublets`
--

CREATE TABLE `sublets` (
  `id` int(11) NOT NULL,
  `shift_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `date_of_sublet` date NOT NULL,
  `taken` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sublets`
--

INSERT INTO `sublets` (`id`, `shift_id`, `emp_id`, `date_of_sublet`, `taken`) VALUES
(2, 5, 31, '2019-05-12', 1),
(3, 2, 31, '2019-05-08', 0);

-- --------------------------------------------------------

--
-- Table structure for table `timesheet`
--

CREATE TABLE `timesheet` (
  `email` varchar(255) DEFAULT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `hours` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `timesheet`
--

INSERT INTO `timesheet` (`email`, `tittle`, `des`, `hours`, `date`) VALUES
('wokabyma@mailinator.net', 'Commodo laborum ut voluptas adipisci sequi nisi quae distinctio Labore mollitia duis eos dicta hic nulla inventore', 'Assumenda quo maxime tenetur asperiores odit nulla facilis libero alias magni id ut et pariatur Suscipit', '12', '25-Jul-1982'),
('zyqebab@mailinator.net', 'jjjjjjjjjjjj', 'jjjjjhj', '78', 'Thu Jan 17 16:48:38 IST 2019'),
('qukozimyxa@mailinator.com', 'dgfhd', 'ghfghfgh', '78', 'Thu Jan 17 18:03:13 IST 2019');

-- --------------------------------------------------------

--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `id` int(11) NOT NULL COMMENT 'id of venue',
  `v_code` varchar(7) NOT NULL COMMENT 'code of the venue',
  `v_name` varchar(150) DEFAULT NULL COMMENT 'name of the venue',
  `v_address` varchar(150) DEFAULT NULL COMMENT 'address of the venue'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='table for venue';

--
-- Dumping data for table `venue`
--

INSERT INTO `venue` (`id`, `v_code`, `v_name`, `v_address`) VALUES
(3, 'V_WAT_1', 'Watterson Dining Commons', '301 S. Fell Avenue, Normal IL 61761'),
(4, 'V_BON_1', 'Bone Pizza Hut Express', '200 N. University Street, Normal IL 61761'),
(5, 'V_BON_4', 'Starbucks', '347 S. University Street, Normal IL 61761'),
(7, 'V_TRI_1', 'Tri Towers', '342, Raab Road, Normal IL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `emp_id` (`emp_id`);

--
-- Indexes for table `available_shifts`
--
ALTER TABLE `available_shifts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `shift_id` (`shift_id`) USING BTREE;

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`did`);

--
-- Indexes for table `eleave`
--
ALTER TABLE `eleave`
  ADD PRIMARY KEY (`lid`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eid`),
  ADD UNIQUE KEY `eid_UNIQUE` (`eid`);

--
-- Indexes for table `employee_shift`
--
ALTER TABLE `employee_shift`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_shift_id` (`shift_id`),
  ADD KEY `fk_emp_id` (`emp_id`) USING BTREE;

--
-- Indexes for table `employee_subletted_shifts`
--
ALTER TABLE `employee_subletted_shifts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `shift_id` (`shift_id`),
  ADD UNIQUE KEY `subet_id` (`sublet_id`),
  ADD UNIQUE KEY `emp_id` (`emp_id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `shifts`
--
ALTER TABLE `shifts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `shift_venue_id` (`shift_venue_id`);

--
-- Indexes for table `spring_session`
--
ALTER TABLE `spring_session`
  ADD PRIMARY KEY (`PRIMARY_ID`),
  ADD UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  ADD KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  ADD KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`);

--
-- Indexes for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`);

--
-- Indexes for table `sublets`
--
ALTER TABLE `sublets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `shift_id` (`shift_id`),
  ADD KEY `emp_id` (`emp_id`);

--
-- Indexes for table `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `v_code` (`v_code`);
ALTER TABLE `venue` ADD FULLTEXT KEY `v_name` (`v_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `available_shifts`
--
ALTER TABLE `available_shifts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `did` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `eleave`
--
ALTER TABLE `eleave`
  MODIFY `lid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `eid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `employee_shift`
--
ALTER TABLE `employee_shift`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'is for employee_shift', AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `employee_subletted_shifts`
--
ALTER TABLE `employee_subletted_shifts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `shifts`
--
ALTER TABLE `shifts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id of a shift', AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `sublets`
--
ALTER TABLE `sublets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `venue`
--
ALTER TABLE `venue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id of venue', AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `available_shifts`
--
ALTER TABLE `available_shifts`
  ADD CONSTRAINT `available_shifts_ibfk_1` FOREIGN KEY (`shift_id`) REFERENCES `shifts` (`id`);

--
-- Constraints for table `employee_shift`
--
ALTER TABLE `employee_shift`
  ADD CONSTRAINT `fk_emp_if` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`eid`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_shift_id` FOREIGN KEY (`shift_id`) REFERENCES `shifts` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `employee_subletted_shifts`
--
ALTER TABLE `employee_subletted_shifts`
  ADD CONSTRAINT `employee_subletted_shifts_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `sublets` (`emp_id`),
  ADD CONSTRAINT `employee_subletted_shifts_ibfk_2` FOREIGN KEY (`sublet_id`) REFERENCES `sublets` (`id`),
  ADD CONSTRAINT `employee_subletted_shifts_ibfk_3` FOREIGN KEY (`shift_id`) REFERENCES `sublets` (`shift_id`);

--
-- Constraints for table `shifts`
--
ALTER TABLE `shifts`
  ADD CONSTRAINT `shifts_ibfk_1` FOREIGN KEY (`shift_venue_id`) REFERENCES `venue` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;

--
-- Constraints for table `sublets`
--
ALTER TABLE `sublets`
  ADD CONSTRAINT `sublets_ibfk_1` FOREIGN KEY (`shift_id`) REFERENCES `shifts` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `sublets_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `employee_shift` (`emp_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
