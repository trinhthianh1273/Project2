-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2023 at 05:46 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apartment`
--

-- --------------------------------------------------------

--
-- Table structure for table `apartment`
--

CREATE TABLE `apartment` (
  `id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `floor_quanty` int(2) NOT NULL,
  `room_quanty` int(3) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `apartment`
--

INSERT INTO `apartment` (`id`, `name`, `floor_quanty`, `room_quanty`, `createDate`, `updateDate`) VALUES
(1, 'HUD3', 9, 40, '2022-12-07 05:16:24', NULL),
(3, 'HUD4', 9, 40, '2022-12-26 13:37:53', NULL),
(5, 'HUD5', 7, 35, '2022-12-28 06:22:42', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `contract`
--

CREATE TABLE `contract` (
  `id` int(11) NOT NULL,
  `room_id` int(5) NOT NULL,
  `proxy_id` int(11) NOT NULL,
  `renter1` int(11) DEFAULT NULL,
  `renter2` int(11) DEFAULT NULL,
  `renter3` int(11) DEFAULT NULL,
  `bed` int(1) NOT NULL,
  `wardrobe` int(1) NOT NULL,
  `fridge` int(1) NOT NULL,
  `titchen_infrared` int(1) NOT NULL,
  `pot` int(1) NOT NULL,
  `desk` int(1) NOT NULL,
  `small_table` int(1) NOT NULL,
  `chair` int(1) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NULL DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `endDate` timestamp NULL DEFAULT NULL,
  `blank` int(1) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contract`
--

INSERT INTO `contract` (`id`, `room_id`, `proxy_id`, `renter1`, `renter2`, `renter3`, `bed`, `wardrobe`, `fridge`, `titchen_infrared`, `pot`, `desk`, `small_table`, `chair`, `createDate`, `updateDate`, `startDate`, `endDate`, `blank`, `status`) VALUES
(1, 1, 1, 2, 3, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2022-12-31 00:00:00', 1, 1),
(2, 2, 4, 5, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2022-12-31 00:00:00', 2, 1),
(3, 3, 6, 7, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2022-12-31 00:00:00', 3, 1),
(4, 4, 8, 9, 10, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2022-12-31 00:00:00', 1, 1),
(5, 5, 11, 12, 13, 14, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 0, 1),
(6, 6, 15, 16, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 2, 1),
(7, 7, 17, 18, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 2, 1),
(8, 8, 19, 20, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 2, 1),
(9, 9, 21, 22, 23, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 1, 1),
(10, 10, 24, 25, 26, 27, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 0, 1),
(11, 11, 28, 29, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 2, 1),
(12, 12, 30, 31, 32, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-02-01 00:00:00', 1, 1),
(13, 13, 33, NULL, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-04-01 00:00:00', 3, 1),
(14, 14, 34, NULL, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-04-01 00:00:00', 3, 1),
(15, 15, 35, 36, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-04-01 00:00:00', 2, 1),
(16, 16, 37, 38, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-04-01 00:00:00', 2, 1),
(17, 17, 39, 40, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, '2022-12-07 11:13:21', NULL, '2022-10-01 00:00:00', '2023-04-01 00:00:00', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `household_good`
--

CREATE TABLE `household_good` (
  `id` int(5) NOT NULL,
  `category_id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `quanty` int(3) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NULL DEFAULT NULL,
  `not_used` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `household_good`
--

INSERT INTO `household_good` (`id`, `category_id`, `name`, `quanty`, `createDate`, `updateDate`, `not_used`) VALUES
(1, 0, 'bed', 40, '2022-12-07 05:16:24', NULL, NULL),
(2, 0, 'wardrobe', 40, '2022-12-07 05:16:24', NULL, NULL),
(3, 0, 'fridge', 40, '2022-12-07 05:16:24', NULL, NULL),
(4, 0, 'titchen_infrared', 40, '2022-12-07 05:16:24', NULL, NULL),
(5, 0, 'pot', 66, '2022-12-07 05:16:24', NULL, NULL),
(6, 0, 'desk', 54, '2022-12-07 05:16:24', NULL, NULL),
(7, 0, 'small_table', 38, '2022-12-07 05:16:24', NULL, NULL),
(8, 0, 'chair', 58, '2022-12-07 05:16:24', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `login_id` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `permission` int(1) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`id`, `name`, `login_id`, `pass`, `permission`, `createDate`, `updateDate`) VALUES
(1, 'Trinh Thi Anh', 'tta', '12345678', 1, '2022-12-07 05:16:24', NULL),
(2, 'Pham Duc Huy', 'pdh', '12345678', 2, '2022-12-07 05:16:24', NULL),
(3, 'Ly Bao Anh', 'lba', '12345678', 2, '2022-12-07 05:16:24', NULL),
(4, 'Nguyen Duy Anh', 'nda', '12345678', 2, '2022-12-07 05:16:24', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  `year` int(5) NOT NULL,
  `month` int(2) NOT NULL,
  `electricOld` int(11) NOT NULL,
  `electricNew` int(11) NOT NULL,
  `waterOld` int(11) NOT NULL,
  `waterNew` int(11) NOT NULL,
  `service` int(11) NOT NULL,
  `forfeit` int(11) DEFAULT NULL,
  `total_payment` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NULL DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `receipt`
--

INSERT INTO `receipt` (`id`, `contract_id`, `year`, `month`, `electricOld`, `electricNew`, `waterOld`, `waterNew`, `service`, `forfeit`, `total_payment`, `status`, `createDate`, `updateDate`, `description`) VALUES
(1, 1, 2022, 10, 0, 120, 0, 3, 600000, 0, 6140000, 0, '2022-12-25 14:25:38', NULL, NULL),
(2, 2, 2022, 10, 0, 121, 0, 3, 400000, 0, 5944000, 0, '2022-12-25 14:25:38', NULL, NULL),
(3, 3, 2022, 10, 0, 122, 0, 4, 400000, 0, 5968000, 0, '2022-12-25 14:25:38', NULL, NULL),
(4, 4, 2022, 10, 0, 123, 0, 4, 600000, 0, 61172000, 0, '2022-12-25 14:25:38', NULL, NULL),
(5, 5, 2022, 10, 0, 124, 0, 6, 800000, 0, 51416000, 0, '2022-12-25 14:25:38', NULL, NULL),
(6, 6, 2022, 10, 0, 125, 0, 5, 400000, 0, 6000000, 0, '2022-12-25 14:25:38', NULL, NULL),
(7, 7, 2022, 10, 0, 126, 0, 5, 400000, 0, 6004000, 0, '2022-12-25 14:25:38', NULL, NULL),
(8, 8, 2022, 10, 0, 127, 0, 5, 400000, 0, 6008000, 0, '2022-12-25 14:25:38', NULL, NULL),
(9, 9, 2022, 10, 0, 128, 0, 5, 600000, 0, 61212000, 0, '2022-12-25 14:25:38', NULL, NULL),
(10, 10, 2022, 10, 0, 194, 0, 4, 800000, 0, 6656000, 0, '2022-12-25 14:25:38', NULL, NULL),
(11, 11, 2022, 10, 0, 130, 0, 4, 400000, 0, 9000000, 0, '2022-12-25 14:25:38', NULL, NULL),
(12, 12, 2022, 10, 0, 131, 0, 3, 600000, 0, 9184000, 0, '2022-12-25 14:25:38', NULL, NULL),
(13, 13, 2022, 10, 0, 132, 0, 5, 200000, 0, 8828000, 0, '2022-12-25 14:25:38', NULL, NULL),
(14, 14, 2022, 10, 0, 133, 0, 4, 200000, 0, 8812000, 0, '2022-12-25 14:25:38', NULL, NULL),
(15, 15, 2022, 10, 0, 134, 0, 3, 400000, 0, 8942000, 0, '2022-12-25 14:25:38', NULL, NULL),
(16, 16, 2022, 10, 0, 135, 0, 5, 400000, 0, 9040000, 0, '2022-12-25 14:25:38', NULL, NULL),
(17, 17, 2022, 10, 0, 136, 0, 5, 400000, 0, 9044000, 0, '2022-12-25 14:25:38', NULL, NULL),
(18, 1, 2022, 11, 120, 240, 3, 6, 600000, 0, 6140000, 0, '2022-12-25 14:25:38', NULL, NULL),
(19, 2, 2022, 11, 121, 242, 3, 3, 400000, 0, 5944000, 1, '2022-12-25 14:25:38', NULL, NULL),
(20, 3, 2022, 11, 122, 244, 4, 8, 400000, 0, 5968000, 1, '2022-12-25 14:25:38', NULL, NULL),
(21, 4, 2022, 11, 123, 246, 4, 8, 600000, 0, 61172000, 0, '2022-12-25 14:25:38', NULL, NULL),
(22, 5, 2022, 11, 124, 248, 6, 12, 800000, 0, 51416000, 0, '2022-12-25 14:25:38', NULL, NULL),
(23, 6, 2022, 11, 125, 250, 5, 10, 400000, 0, 6000000, 1, '2022-12-25 14:25:38', NULL, NULL),
(24, 7, 2022, 11, 126, 252, 5, 10, 400000, 0, 6004000, 1, '2022-12-25 14:25:38', NULL, NULL),
(25, 8, 2022, 11, 127, 254, 5, 10, 400000, 0, 6008000, 1, '2022-12-25 14:25:38', NULL, NULL),
(26, 9, 2022, 11, 128, 256, 5, 10, 600000, 0, 6121000, 0, '2022-12-25 14:25:38', NULL, NULL),
(27, 10, 2022, 11, 194, 388, 4, 8, 800000, 0, 6656000, 1, '2022-12-25 14:25:38', NULL, NULL),
(28, 11, 2022, 11, 130, 260, 4, 8, 400000, 0, 9000000, 1, '2022-12-25 14:25:38', NULL, NULL),
(29, 12, 2022, 11, 131, 262, 3, 6, 600000, 0, 9184000, 1, '2022-12-25 14:25:38', NULL, NULL),
(30, 13, 2022, 11, 132, 164, 5, 10, 200000, 0, 8828000, 1, '2022-12-25 14:25:38', NULL, NULL),
(31, 14, 2022, 11, 133, 266, 4, 8, 200000, 0, 8812000, 1, '2022-12-25 14:25:38', NULL, NULL),
(32, 15, 2022, 11, 134, 268, 3, 6, 400000, 0, 8942000, 1, '2022-12-25 14:25:38', NULL, NULL),
(33, 16, 2022, 11, 135, 270, 5, 10, 400000, 0, 9040000, 0, '2022-12-25 14:25:38', NULL, NULL),
(34, 17, 2022, 11, 136, 272, 5, 10, 400000, 0, 9044000, 0, '2022-12-25 14:25:38', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `renter`
--

CREATE TABLE `renter` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `status` varchar(30) NOT NULL,
  `dob` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `province` varchar(30) NOT NULL,
  `district` varchar(30) NOT NULL,
  `commune` varchar(30) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NULL DEFAULT NULL,
  `gender` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `renter`
--

INSERT INTO `renter` (`id`, `name`, `phone`, `email`, `status`, `dob`, `province`, `district`, `commune`, `address`, `createDate`, `updateDate`, `gender`) VALUES
(1, 'Trinh Thi Anh', '0941147009', 'phungbaokimanh@gmail.com', '1', '2022-12-08 01:10:04', 'Nam Dinh', 'Xuan Truong', 'Xuan Kien', '', '2022-12-07 05:17:04', NULL, 0),
(2, 'Pham Duc Huy', '0111111111', 'phamduchuy@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(3, 'Ly Bao Anh', '0111111112', 'lybaoanh@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(4, 'Nguyen Duy Anh', '0111111113', 'nguyenduyanhA@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(5, 'Nguyen Duy Anh', '0111111114', 'nguyenduyanhB@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(6, 'Tran Bao Trung', '0111111115', 'tranbaotrung@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(7, 'Nguyen Minh Vu', '0111111116', 'nguyenminhvu@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(8, 'Nguyen Tat Dat', '0111111117', 'nguyentatdat@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(9, 'Nguyen Van Thai', '0111111118', 'nguyenvanthai@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(10, 'Phan Van Truong', '0111111119', 'phanvantruong@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(11, 'Nguyen Ngoc Minh', '0111111120', 'nguyenngocminh@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(12, 'Nguyen Thien Hao', '0111111121', 'nguyenthienhao@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(13, 'Pham Chi Cuong', '0111111122', 'phamchicuong@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(14, 'Le Ngoc Anh Vu', '0111111123', 'lengocanhvu@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(15, 'Vuong Huu Hung', '0111111124', 'vuonghuuhung@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(16, 'Tran Duc Hung', '0111111125', 'tranduchung@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(17, 'Nguyen Dong Duong', '0111111126', 'nguyendongduong@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(18, 'Duong Bach Tuong Quan', '0111111127', 'duongbachtuongquan@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(19, 'Tran Quang', '0111111128', 'tranquang@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(20, 'Do Thi Ngoc Binh', '0111111129', 'dothingocbinh@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(21, 'Vu Thi Thao', '0111111130', 'vuthithao@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(22, 'Nguyen Thanh Quyen', '0111111131', 'nguyenthanhquyen@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(23, 'Pham Mai Anh', '0111111132', 'phammaianh@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(24, 'Do Viet Cuong', '0111111133', 'dovietcuong@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(25, 'Le Thi Hoa', '0111111134', 'lethihoa@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(26, 'Tran Van Tien', '0111111135', 'tranvantien@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(27, 'Ta Thi Hong', '0111111136', 'tathihong@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(28, 'Vương Thi Quyen', '0111111137', 'vuongthiquyen@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(29, 'Dang Van Hung', '0111111138', 'dangvanhung@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(30, 'Tran Duc Xo', '0111111139', 'tranducxo@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(31, 'Khuc Thi Thơ', '0111111140', 'khucthitho@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(32, 'Nguyen Thi Dao', '0111111141', 'nguyenthidao@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(33, 'Nguyen Thanh Long', '0111111142', 'nguyenthanhlong@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(34, 'Pham Thi Hoa', '0111111143', 'phamthihoa@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(35, 'Do Trong Tu', '0111111144', 'dotrongtu@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(36, 'Trinh Thi Luyen', '0111111145', 'trinhthiluyen@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(37, 'Nguyen Thi Minh', '0111111146', 'nguyenthiminh@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(38, 'Le Thi Thuc', '0111111147', 'lethithuc@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0),
(39, 'Nguyen Van Chung', '0111111148', 'nguyenvanchung@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 1),
(40, 'Tran Thi Minh', '0111111149', 'tranthiminh@gmail.com', '1', '2022-12-08 01:10:04', 'Ha Noi', 'Hai Ba Trung', 'Pho Hue', '', '2022-12-07 05:17:04', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` int(5) NOT NULL,
  `apartment_id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `floor` int(2) NOT NULL,
  `member_max` int(1) NOT NULL,
  `rental` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `apartment_id`, `name`, `floor`, `member_max`, `rental`, `status`, `createDate`, `updateDate`) VALUES
(1, 1, '0201', 2, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(2, 1, '0202', 2, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(3, 1, '0203', 2, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(4, 1, '0204', 2, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(5, 1, '0205', 2, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(6, 1, '0301', 3, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(7, 1, '0302', 3, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(8, 1, '0303', 3, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(9, 1, '0304', 3, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(10, 1, '0305', 3, 4, 5000000, 1, '2022-12-07 05:16:24', NULL),
(11, 1, '0401', 4, 4, 8000000, 1, '2022-12-07 05:16:24', NULL),
(12, 1, '0402', 4, 4, 8000000, 1, '2022-12-07 05:16:24', NULL),
(13, 1, '0403', 4, 4, 8000000, 1, '2022-12-07 05:16:24', NULL),
(14, 1, '0404', 4, 4, 8000000, 1, '2022-12-07 05:16:24', NULL),
(15, 1, '0405', 4, 4, 8000000, 1, '2022-12-07 05:16:24', NULL),
(16, 1, '0501', 5, 4, 8000000, 1, '2022-12-07 05:16:24', NULL),
(17, 1, '0502', 5, 4, 8000000, 1, '2022-12-07 05:16:24', NULL),
(18, 1, '0503', 5, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(19, 1, '0504', 5, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(20, 1, '0505', 5, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(21, 1, '0601', 6, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(22, 1, '0602', 6, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(23, 1, '0603', 6, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(24, 1, '0604', 6, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(25, 1, '0605', 6, 4, 8000000, 0, '2022-12-07 05:16:24', NULL),
(26, 1, '0701', 7, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(27, 1, '0702', 7, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(28, 1, '0703', 7, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(29, 1, '0704', 7, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(30, 1, '0705', 7, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(31, 1, '0801', 8, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(32, 1, '0802', 8, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(33, 1, '0803', 8, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(34, 1, '0804', 8, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(35, 1, '0805', 8, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(36, 1, '0901', 9, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(37, 1, '0902', 9, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(38, 1, '0903', 9, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(39, 1, '0904', 9, 4, 9000000, 0, '2022-12-07 05:16:24', NULL),
(40, 1, '0905', 9, 4, 9000000, 0, '2022-12-07 05:16:24', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apartment`
--
ALTER TABLE `apartment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contract`
--
ALTER TABLE `contract`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `room_id` (`room_id`),
  ADD UNIQUE KEY `proxy_id` (`proxy_id`),
  ADD UNIQUE KEY `renter1` (`renter1`),
  ADD UNIQUE KEY `renter2` (`renter2`),
  ADD UNIQUE KEY `renter3` (`renter3`);

--
-- Indexes for table `household_good`
--
ALTER TABLE `household_good`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login_id` (`login_id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `contract_id` (`contract_id`);

--
-- Indexes for table `renter`
--
ALTER TABLE `renter`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone` (`phone`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `apartment_id` (`apartment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apartment`
--
ALTER TABLE `apartment`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `contract`
--
ALTER TABLE `contract`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `household_good`
--
ALTER TABLE `household_good`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `renter`
--
ALTER TABLE `renter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contract`
--
ALTER TABLE `contract`
  ADD CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  ADD CONSTRAINT `contract_ibfk_2` FOREIGN KEY (`proxy_id`) REFERENCES `renter` (`id`),
  ADD CONSTRAINT `contract_ibfk_3` FOREIGN KEY (`renter1`) REFERENCES `renter` (`id`),
  ADD CONSTRAINT `contract_ibfk_4` FOREIGN KEY (`renter2`) REFERENCES `renter` (`id`),
  ADD CONSTRAINT `contract_ibfk_5` FOREIGN KEY (`renter3`) REFERENCES `renter` (`id`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
