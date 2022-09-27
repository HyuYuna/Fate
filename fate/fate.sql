-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.2.38-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.2.0.6213
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

-- 테이블 데이터 fate.board_reply:~0 rows (대략적) 내보내기
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='고객';

-- 테이블 데이터 fate.customer:~1 rows (대략적) 내보내기
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customer_idx`, `customer_name`, `phone`, `address`, `joindate`, `grade`, `city`, `content`) VALUES
	(1, '양호', '01012345576', '경기도 안양시', '2022', 'A', 'C', '<p><img src="/getImage.do?fileNm=0de6b321ba5841ee8440bc58788b7dd9..jpg" style="width: 450px;"><br></p>');
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

-- 테이블 데이터 fate.user:~1 rows (대략적) 내보내기
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

-- 테이블 데이터 fate.user_authority:~1 rows (대략적) 내보내기
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
