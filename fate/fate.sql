-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.3.31-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- fate 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `fate` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `fate`;

-- 테이블 fate.authority 구조 내보내기
CREATE TABLE IF NOT EXISTS `authority` (
  `authority_idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '권한 번호',
  `authority` varchar(50) DEFAULT NULL COMMENT '권한',
  `authority_name` varchar(50) DEFAULT NULL COMMENT '권한 이름',
  PRIMARY KEY (`authority_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='권한';

-- 테이블 데이터 fate.authority:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`authority_idx`, `authority`, `authority_name`) VALUES
	(1, 'ADMIN', '관리자'),
	(2, 'USER', '사용자');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;

-- 테이블 fate.authority_hierarchy 구조 내보내기
CREATE TABLE IF NOT EXISTS `authority_hierarchy` (
  `child_authority` varchar(50) DEFAULT NULL,
  `parent_authority` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='권한 계층';

-- 테이블 데이터 fate.authority_hierarchy:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `authority_hierarchy` DISABLE KEYS */;
/*!40000 ALTER TABLE `authority_hierarchy` ENABLE KEYS */;

-- 테이블 fate.board_reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_reply` (
  `reply_idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '댓글 번호',
  `board_idx` int(11) DEFAULT NULL COMMENT '게시글 번호',
  `content` varchar(50) DEFAULT NULL COMMENT '댓글 내용',
  `register` varchar(50) DEFAULT NULL COMMENT '작성자',
  `regist_dt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '등록일자',
  `update_dt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '수정일자',
  PRIMARY KEY (`reply_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='게시글 댓글';

-- 테이블 데이터 fate.board_reply:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `board_reply` DISABLE KEYS */;
INSERT INTO `board_reply` (`reply_idx`, `board_idx`, `content`, `register`, `regist_dt`, `update_dt`) VALUES
	(1, 1, '댓글 테스트', '1', '2022-09-27 15:25:07', '2022-09-27 15:25:07');
/*!40000 ALTER TABLE `board_reply` ENABLE KEYS */;

-- 테이블 fate.customer 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '고객 번호',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '고객 이름',
  `phone` varchar(50) DEFAULT NULL COMMENT '전화번호',
  `address` varchar(100) DEFAULT NULL COMMENT '주소',
  `joindate` varchar(50) DEFAULT NULL COMMENT '가입일자',
  `grade` varchar(50) DEFAULT NULL COMMENT '고객 등급',
  `city` varchar(50) DEFAULT NULL COMMENT '도시 등급',
  `content` mediumtext DEFAULT NULL COMMENT '내용',
  PRIMARY KEY (`customer_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8 COMMENT='고객';

-- 테이블 데이터 fate.customer:~130 rows (대략적) 내보내기
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customer_idx`, `customer_name`, `phone`, `address`, `joindate`, `grade`, `city`, `content`) VALUES
	(1, '테스트1', NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '테스트2', NULL, NULL, NULL, NULL, NULL, NULL),
	(3, '테스트3', NULL, NULL, NULL, NULL, NULL, NULL),
	(4, '테스트4', NULL, NULL, NULL, NULL, NULL, NULL),
	(5, '테스트5', NULL, NULL, NULL, NULL, NULL, NULL),
	(6, '테스트6', NULL, NULL, NULL, NULL, NULL, NULL),
	(7, '테스트7', NULL, NULL, NULL, NULL, NULL, NULL),
	(8, '테스트8', NULL, NULL, NULL, NULL, NULL, NULL),
	(9, '테스트9', NULL, NULL, NULL, NULL, NULL, NULL),
	(10, '테스트10', NULL, NULL, NULL, NULL, NULL, NULL),
	(11, '테스트11', NULL, NULL, NULL, NULL, NULL, NULL),
	(12, '테스트12', NULL, NULL, NULL, NULL, NULL, NULL),
	(13, '테스트13', NULL, NULL, NULL, NULL, NULL, NULL),
	(14, '테스트14', NULL, NULL, NULL, NULL, NULL, NULL),
	(15, '테스트15', NULL, NULL, NULL, NULL, NULL, NULL),
	(16, '테스트16', NULL, NULL, NULL, NULL, NULL, NULL),
	(17, '테스트17', NULL, NULL, NULL, NULL, NULL, NULL),
	(18, '테스트18', NULL, NULL, NULL, NULL, NULL, NULL),
	(19, '테스트19', NULL, NULL, NULL, NULL, NULL, NULL),
	(20, '테스트20', NULL, NULL, NULL, NULL, NULL, NULL),
	(21, '테스트21', NULL, NULL, NULL, NULL, NULL, NULL),
	(22, '테스트22', NULL, NULL, NULL, NULL, NULL, NULL),
	(23, '테스트23', NULL, NULL, NULL, NULL, NULL, NULL),
	(24, '테스트24', NULL, NULL, NULL, NULL, NULL, NULL),
	(25, '테스트25', NULL, NULL, NULL, NULL, NULL, NULL),
	(26, '테스트26', NULL, NULL, NULL, NULL, NULL, NULL),
	(27, '테스트27', NULL, NULL, NULL, NULL, NULL, NULL),
	(28, '테스트28', NULL, NULL, NULL, NULL, NULL, NULL),
	(29, '테스트29', NULL, NULL, NULL, NULL, NULL, NULL),
	(30, '테스트30', NULL, NULL, NULL, NULL, NULL, NULL),
	(31, '테스트31', NULL, NULL, NULL, NULL, NULL, NULL),
	(32, '테스트32', NULL, NULL, NULL, NULL, NULL, NULL),
	(33, '테스트33', NULL, NULL, NULL, NULL, NULL, NULL),
	(34, '테스트34', NULL, NULL, NULL, NULL, NULL, NULL),
	(35, '테스트35', NULL, NULL, NULL, NULL, NULL, NULL),
	(36, '테스트36', NULL, NULL, NULL, NULL, NULL, NULL),
	(37, '테스트37', NULL, NULL, NULL, NULL, NULL, NULL),
	(38, '테스트38', NULL, NULL, NULL, NULL, NULL, NULL),
	(39, '테스트39', NULL, NULL, NULL, NULL, NULL, NULL),
	(40, '테스트40', NULL, NULL, NULL, NULL, NULL, NULL),
	(41, '테스트41', NULL, NULL, NULL, NULL, NULL, NULL),
	(42, '테스트42', NULL, NULL, NULL, NULL, NULL, NULL),
	(43, '테스트43', NULL, NULL, NULL, NULL, NULL, NULL),
	(44, '테스트44', NULL, NULL, NULL, NULL, NULL, NULL),
	(45, '테스트45', NULL, NULL, NULL, NULL, NULL, NULL),
	(46, '테스트46', NULL, NULL, NULL, NULL, NULL, NULL),
	(47, '테스트47', NULL, NULL, NULL, NULL, NULL, NULL),
	(48, '테스트48', NULL, NULL, NULL, NULL, NULL, NULL),
	(49, '테스트49', NULL, NULL, NULL, NULL, NULL, NULL),
	(50, '테스트50', NULL, NULL, NULL, NULL, NULL, NULL),
	(51, '테스트51', NULL, NULL, NULL, NULL, NULL, NULL),
	(52, '테스트52', NULL, NULL, NULL, NULL, NULL, NULL),
	(53, '테스트53', NULL, NULL, NULL, NULL, NULL, NULL),
	(54, '테스트54', NULL, NULL, NULL, NULL, NULL, NULL),
	(55, '테스트55', NULL, NULL, NULL, NULL, NULL, NULL),
	(56, '테스트56', NULL, NULL, NULL, NULL, NULL, NULL),
	(57, '테스트57', NULL, NULL, NULL, NULL, NULL, NULL),
	(58, '테스트58', NULL, NULL, NULL, NULL, NULL, NULL),
	(59, '테스트59', NULL, NULL, NULL, NULL, NULL, NULL),
	(60, '테스트60', NULL, NULL, NULL, NULL, NULL, NULL),
	(61, '테스트61', NULL, NULL, NULL, NULL, NULL, NULL),
	(62, '테스트62', NULL, NULL, NULL, NULL, NULL, NULL),
	(63, '테스트63', NULL, NULL, NULL, NULL, NULL, NULL),
	(64, '테스트64', NULL, NULL, NULL, NULL, NULL, NULL),
	(65, '테스트65', NULL, NULL, NULL, NULL, NULL, NULL),
	(66, '테스트66', NULL, NULL, NULL, NULL, NULL, NULL),
	(67, '테스트67', NULL, NULL, NULL, NULL, NULL, NULL),
	(68, '테스트68', NULL, NULL, NULL, NULL, NULL, NULL),
	(69, '테스트69', NULL, NULL, NULL, NULL, NULL, NULL),
	(70, '테스트70', NULL, NULL, NULL, NULL, NULL, NULL),
	(71, '테스트71', NULL, NULL, NULL, NULL, NULL, NULL),
	(72, '테스트72', NULL, NULL, NULL, NULL, NULL, NULL),
	(73, '테스트73', NULL, NULL, NULL, NULL, NULL, NULL),
	(74, '테스트74', NULL, NULL, NULL, NULL, NULL, NULL),
	(75, '테스트75', NULL, NULL, NULL, NULL, NULL, NULL),
	(76, '테스트76', NULL, NULL, NULL, NULL, NULL, NULL),
	(77, '테스트77', NULL, NULL, NULL, NULL, NULL, NULL),
	(78, '테스트78', NULL, NULL, NULL, NULL, NULL, NULL),
	(79, '테스트79', NULL, NULL, NULL, NULL, NULL, NULL),
	(80, '테스트80', NULL, NULL, NULL, NULL, NULL, NULL),
	(81, '테스트81', NULL, NULL, NULL, NULL, NULL, NULL),
	(82, '테스트82', NULL, NULL, NULL, NULL, NULL, NULL),
	(83, '테스트83', NULL, NULL, NULL, NULL, NULL, NULL),
	(84, '테스트84', NULL, NULL, NULL, NULL, NULL, NULL),
	(85, '테스트85', NULL, NULL, NULL, NULL, NULL, NULL),
	(86, '테스트86', NULL, NULL, NULL, NULL, NULL, NULL),
	(87, '테스트87', NULL, NULL, NULL, NULL, NULL, NULL),
	(88, '테스트88', NULL, NULL, NULL, NULL, NULL, NULL),
	(89, '테스트89', NULL, NULL, NULL, NULL, NULL, NULL),
	(90, '테스트90', NULL, NULL, NULL, NULL, NULL, NULL),
	(91, '테스트91', NULL, NULL, NULL, NULL, NULL, NULL),
	(92, '테스트92', NULL, NULL, NULL, NULL, NULL, NULL),
	(93, '테스트93', NULL, NULL, NULL, NULL, NULL, NULL),
	(94, '테스트94', NULL, NULL, NULL, NULL, NULL, NULL),
	(95, '테스트95', NULL, NULL, NULL, NULL, NULL, NULL),
	(96, '테스트96', NULL, NULL, NULL, NULL, NULL, NULL),
	(97, '테스트97', NULL, NULL, NULL, NULL, NULL, NULL),
	(98, '테스트98', NULL, NULL, NULL, NULL, NULL, NULL),
	(99, '테스트99', NULL, NULL, NULL, NULL, NULL, NULL),
	(100, '테스트100', NULL, NULL, NULL, NULL, NULL, NULL),
	(101, '테스트101', NULL, NULL, NULL, NULL, NULL, NULL),
	(102, '테스트102', NULL, NULL, NULL, NULL, NULL, NULL),
	(103, '테스트103', NULL, NULL, NULL, NULL, NULL, NULL),
	(104, '테스트104', NULL, NULL, NULL, NULL, NULL, NULL),
	(105, '테스트105', NULL, NULL, NULL, NULL, NULL, NULL),
	(106, '테스트106', NULL, NULL, NULL, NULL, NULL, NULL),
	(107, '테스트107', NULL, NULL, NULL, NULL, NULL, NULL),
	(108, '테스트108', NULL, NULL, NULL, NULL, NULL, NULL),
	(109, '테스트109', NULL, NULL, NULL, NULL, NULL, NULL),
	(110, '테스트110', NULL, NULL, NULL, NULL, NULL, NULL),
	(111, '테스트111', NULL, NULL, NULL, NULL, NULL, NULL),
	(112, '테스트112', NULL, NULL, NULL, NULL, NULL, NULL),
	(113, '테스트113', NULL, NULL, NULL, NULL, NULL, NULL),
	(114, '테스트114', NULL, NULL, NULL, NULL, NULL, NULL),
	(115, '테스트115', NULL, NULL, NULL, NULL, NULL, NULL),
	(116, '테스트116', NULL, NULL, NULL, NULL, NULL, NULL),
	(117, '테스트117', NULL, NULL, NULL, NULL, NULL, NULL),
	(118, '테스트118', NULL, NULL, NULL, NULL, NULL, NULL),
	(119, '테스트119', NULL, NULL, NULL, NULL, NULL, NULL),
	(120, '테스트120', NULL, NULL, NULL, NULL, NULL, NULL),
	(121, '테스트121', NULL, NULL, NULL, NULL, NULL, NULL),
	(122, '테스트122', NULL, NULL, NULL, NULL, NULL, NULL),
	(123, '테스트123', NULL, NULL, NULL, NULL, NULL, NULL),
	(124, '테스트124', NULL, NULL, NULL, NULL, NULL, NULL),
	(125, '테스트125', NULL, NULL, NULL, NULL, NULL, NULL),
	(126, '테스트126', NULL, NULL, NULL, NULL, NULL, NULL),
	(127, '테스트127', NULL, NULL, NULL, NULL, NULL, NULL),
	(128, '테스트128', NULL, NULL, NULL, NULL, NULL, NULL),
	(129, '테스트129', NULL, NULL, NULL, NULL, NULL, NULL),
	(130, '테스트130', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 테이블 fate.groups 구조 내보내기
CREATE TABLE IF NOT EXISTS `groups` (
  `group_id` varchar(50) DEFAULT NULL COMMENT '권한 그룹 ID',
  `group_name` varchar(50) DEFAULT NULL COMMENT '권한 그룹명'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='권한 그룹 테이블';

-- 테이블 데이터 fate.groups:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;

-- 테이블 fate.groups_authority 구조 내보내기
CREATE TABLE IF NOT EXISTS `groups_authority` (
  `group_id` varchar(50) DEFAULT NULL COMMENT '권한 그룹 ID',
  `authority` varchar(50) DEFAULT NULL COMMENT '권한'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='권한 그룹별 사용자 테이블';

-- 테이블 데이터 fate.groups_authority:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `groups_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups_authority` ENABLE KEYS */;

-- 테이블 fate.groups_user 구조 내보내기
CREATE TABLE IF NOT EXISTS `groups_user` (
  `group_id` varchar(50) DEFAULT NULL COMMENT '권한 그룹 ID',
  `member_id` varchar(50) DEFAULT NULL COMMENT '로그인 ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='권한 그룹별 사용자 테이블';

-- 테이블 데이터 fate.groups_user:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `groups_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups_user` ENABLE KEYS */;

-- 프로시저 fate.insertCustomer 구조 내보내기
DELIMITER //
CREATE PROCEDURE `insertCustomer`()
BEGIN
    DECLARE i INT DEFAULT 1; -- ⓑ i변수 선언, defalt값으로 1설정
    WHILE (i <= 130) DO -- ⓒ for문 작성(i가 1000이 될 때까지 반복)
        INSERT INTO customer (customer_name) VALUE (CONCAT("테스트",i)); -- ⓓ 테이블에 i값 넣어주기
        SET i = i + 1; -- ⓔ i값에 1더해주고 WHILE문 처음으로 이동
    END WHILE;
END//
DELIMITER ;

-- 테이블 fate.menu 구조 내보내기
CREATE TABLE IF NOT EXISTS `menu` (
  `menu_idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '메뉴 번호',
  `menu_pattern` varchar(50) NOT NULL COMMENT '메뉴 패턴',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '메뉴 이름',
  `sort_order` int(11) DEFAULT NULL COMMENT '정렬 순서',
  PRIMARY KEY (`menu_idx`) USING BTREE,
  UNIQUE KEY `UNIQUE` (`menu_pattern`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='메뉴관리';

-- 테이블 데이터 fate.menu:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- 테이블 fate.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
  `product_idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '제품 번호',
  `product_name` varchar(50) DEFAULT NULL COMMENT '제품 이름',
  `tel` varchar(50) DEFAULT NULL COMMENT '연락처',
  `address` varchar(50) DEFAULT NULL COMMENT '주소',
  `joindate` varchar(50) DEFAULT NULL COMMENT '가입일자',
  PRIMARY KEY (`product_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='제품';

-- 테이블 데이터 fate.product:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_idx`, `product_name`, `tel`, `address`, `joindate`) VALUES
	(1, '양말', '0101234567', '경기도 안양시', '2021-12-13');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- 테이블 fate.product_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `product_file` (
  `file_idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '파일 번호',
  `product_idx` int(11) DEFAULT NULL COMMENT '제품 번호',
  `original_file_name` varchar(50) DEFAULT NULL COMMENT '원래 파일 이름',
  `stored_file_name` varchar(50) DEFAULT NULL COMMENT '저장된 파일 이름',
  `file_size` varchar(50) DEFAULT NULL COMMENT '파일 사이즈',
  `del_yn` char(3) DEFAULT 'N' COMMENT '삭제 구분',
  PRIMARY KEY (`file_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='제품 첨부파일';

-- 테이블 데이터 fate.product_file:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `product_file` DISABLE KEYS */;
INSERT INTO `product_file` (`file_idx`, `product_idx`, `original_file_name`, `stored_file_name`, `file_size`, `del_yn`) VALUES
	(1, 1, '182A61164CF25AA90E.jpg', '0e3d182c5c7a43be8661e30ac7ef5c49.jpg', '177340', 'N'),
	(2, 1, '155407214CF11D9407.jpg', '18cb3217d0d249b0adba8347cd1e3f88.jpg', '123941', 'N');
/*!40000 ALTER TABLE `product_file` ENABLE KEYS */;

-- 테이블 fate.secured_resource 구조 내보내기
CREATE TABLE IF NOT EXISTS `secured_resource` (
  `resource_idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '리소스 번호',
  `resource_name` varchar(100) DEFAULT NULL COMMENT '리소스 이름',
  `resource_pattern` varchar(100) DEFAULT NULL COMMENT '리소스 패턴',
  `resource_type` varchar(100) DEFAULT 'URL' COMMENT '리소스 타입',
  `sort_order` int(11) DEFAULT NULL COMMENT '순서',
  PRIMARY KEY (`resource_idx`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='리소스 테이블';

-- 테이블 데이터 fate.secured_resource:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `secured_resource` DISABLE KEYS */;
INSERT INTO `secured_resource` (`resource_idx`, `resource_name`, `resource_pattern`, `resource_type`, `sort_order`) VALUES
	(1, '관리자', '/admin/**', 'URL', 0);
/*!40000 ALTER TABLE `secured_resource` ENABLE KEYS */;

-- 테이블 fate.secured_resource_authority 구조 내보내기
CREATE TABLE IF NOT EXISTS `secured_resource_authority` (
  `resource_idx` int(11) DEFAULT NULL COMMENT '리소스 번호',
  `authority` varchar(100) DEFAULT NULL COMMENT '권한'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='리소스에 따른 접근 권한 테이블';

-- 테이블 데이터 fate.secured_resource_authority:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `secured_resource_authority` DISABLE KEYS */;
INSERT INTO `secured_resource_authority` (`resource_idx`, `authority`) VALUES
	(1, 'ADMIN');
/*!40000 ALTER TABLE `secured_resource_authority` ENABLE KEYS */;

-- 테이블 fate.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(50) NOT NULL COMMENT '회원 ID',
  `password` varchar(200) DEFAULT NULL COMMENT '비밀번호',
  `user_name` varchar(200) DEFAULT NULL COMMENT '회원이름',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원 테이블';

-- 테이블 데이터 fate.user:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `password`, `user_name`) VALUES
	('test', '$2a$10$EWSlUMDC01HAStcHkr8wo.m/m1mR8.mfQeYYDre2uDfJe6Bc0TVme', '테스트'),
	('wndaud2412', '$2a$10$6UaQsFGpDMSNjjk5l8yLpO/ly9hY1OMvo2d30RyKT7xrHu2AChoZW', '양승민');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 fate.user_authority 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_authority` (
  `user_id` varchar(50) DEFAULT NULL COMMENT '회원 ID',
  `authority` varchar(50) DEFAULT NULL COMMENT '권한'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원 권한';

-- 테이블 데이터 fate.user_authority:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` (`user_id`, `authority`) VALUES
	('wndaud2412', 'ADMIN'),
	('2', 'USER'),
	('test', 'USER'),
	('3', 'USER');
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
