-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2021 at 10:39 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testlatihan`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `companyBudget` (`input_budget_amount` INT)  BEGIN
	SELECT company.company_name AS Company_Name, company.company_address AS Company_Address, budget.budget_amount AS Company_Amount
    FROM company
    INNER JOIN budget ON company.company_id = budget.budget_company_id
    WHERE budget.budget_amount = input_budget_amount;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `companyBudgetAll` ()  BEGIN
	SELECT company.company_name AS Company_Name, company.company_address AS Company_Address, budget.budget_amount AS Company_Amount
    FROM company
    INNER JOIN budget ON company.company_id = budget.budget_company_id
    ORDER BY budget.budget_amount;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showUserData` (`input_user_id` INT)  BEGIN
	SELECT user.user_id AS User_ID, user.user_name AS User_Name, user.user_email AS User_Email, user.user_instagram AS User_Instagram, company.company_name AS Company_Name, company.company_address AS Company_Address
    FROM user
    INNER JOIN company ON user.user_company_id = company.company_id
    WHERE user.user_id = input_user_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showUserDataAll` ()  BEGIN
	SELECT user.user_id AS User_ID, user.user_name AS User_Name, user.user_email AS User_Email, user.user_instagram AS User_Instagram, company.company_name AS Company_Name, company.company_address AS Company_Address
    FROM user
    INNER JOIN company ON user.user_company_id = company.company_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `budget`
--

CREATE TABLE `budget` (
  `budget_id` int(11) NOT NULL,
  `budget_company_id` int(11) NOT NULL,
  `budget_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `budget`
--

INSERT INTO `budget` (`budget_id`, `budget_company_id`, `budget_amount`) VALUES
(1, 1, -3000000),
(2, 2, 1000000),
(3, 3, 6000000),
(4, 4, 3500000),
(5, 5, 4500000),
(6, 6, 6500000),
(7, 7, 5000000),
(8, 8, 1500000),
(9, 9, 5000000),
(10, 10, 1250000);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `company_id` int(11) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `company_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`company_id`, `company_name`, `company_address`) VALUES
(1, 'SOLO_CORP', 'alamat1'),
(2, 'IMAN_CORP', 'alamat2'),
(3, 'CRIMSON_CORP', 'alamat3'),
(4, 'a', 'Jakarta Selatan'),
(5, 'a', 'Jakarta Selatan'),
(6, 'b', 'Jakarta Barat'),
(7, 'c', 'Jakarta Utara'),
(8, 'd', 'Jakarta Utara'),
(9, 'e', 'Jakarta Timur'),
(10, 'f', 'Jakarta Selatan');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `transaction_type` varchar(1) NOT NULL,
  `transaction_user_id` int(11) NOT NULL,
  `transaction_company_id` int(11) NOT NULL,
  `transaction_amount` int(11) NOT NULL,
  `transaction_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `transaction_type`, `transaction_user_id`, `transaction_company_id`, `transaction_amount`, `transaction_date`) VALUES
(10, 's', 1, 2, 10000, '2021-06-24'),
(11, 'r', 1, 2, 10000, '2021-06-24'),
(12, 'r', 1, 2, 1000000, '2021-06-24'),
(13, 'r', 1, 2, 1000000, '2021-06-24'),
(14, 'r', 1, 2, 2000000, '2021-06-24'),
(15, 's', 1, 2, 4000000, '2021-06-24'),
(16, 's', 1, 3, 2000000, '2021-06-24'),
(19, 'r', 10, 6, 1500000, '2021-05-06'),
(20, 's', 10, 6, 1500000, '2021-05-06'),
(21, 'r', 1, 1, 5000000, '2021-05-06'),
(22, 's', 7, 7, 2500000, '2021-05-06');

--
-- Triggers `transaction`
--
DELIMITER $$
CREATE TRIGGER `updateBudget` AFTER INSERT ON `transaction` FOR EACH ROW BEGIN
	UPDATE budget
    SET budget_amount = IF(new.transaction_type = 's', (budget_amount+new.transaction_amount), IF(new.transaction_type = 'r', budget_amount-new.transaction_amount, budget_amount))
    WHERE new.transaction_company_id = budget_company_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_instagram` varchar(255) NOT NULL,
  `user_company_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_instagram`, `user_company_id`) VALUES
(1, 'Sula', 'Sula@gmail.com', '@Sula', 1),
(2, 'Iman', 'Iman@gmail.com', '@Iman', 1),
(3, 'Solo', 'Solo@gmail.com', '@Solo', 2),
(4, 'The', 'The@gmail.com', '@The', 3),
(5, 'Crimson', 'Crimson@gmail.com', '@Crimson', 2),
(6, 'Lieur', 'adadaaja@gmail.com', 'ada6598', 7),
(7, 'Lieur', 'adadaaja@gmail.com', 'ada6598', 7),
(8, 'Aing', 'adadaaja@gmail.com', 'ada6598', 6),
(9, 'Nyari', 'adadaaja@gmail.com', 'ada6598', 4),
(10, 'Join', 'adadaaja@gmail.com', 'ada6598', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `budget`
--
ALTER TABLE `budget`
  ADD PRIMARY KEY (`budget_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `budget`
--
ALTER TABLE `budget`
  MODIFY `budget_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
