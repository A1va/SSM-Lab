/*
 Navicat Premium Data Transfer

 Source Server         : Lab_01
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : lab_01

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 10/07/2020 13:29:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68425003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `customerName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credentialsType` int(3) NOT NULL,
  `credentialsNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerType` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `departmentDesc` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for indent
-- ----------------------------
DROP TABLE IF EXISTS `indent`;
CREATE TABLE `indent`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `indentNum` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customerId` int(13) UNSIGNED NOT NULL,
  `receiver` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` timestamp(0) NOT NULL,
  `payType` int(3) NOT NULL,
  `payTime` timestamp(0) NULL DEFAULT NULL,
  `deliveryTime` timestamp(0) NULL DEFAULT NULL,
  `confirmTime` timestamp(0) NULL DEFAULT NULL,
  `indentDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `indentStatus` int(2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customerId_FK`(`customerId`) USING BTREE,
  CONSTRAINT `customerId_FK` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 68536004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for indentitem
-- ----------------------------
DROP TABLE IF EXISTS `indentitem`;
CREATE TABLE `indentitem`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `productId` int(13) UNSIGNED NOT NULL,
  `indentId` int(13) UNSIGNED NOT NULL,
  `customerId` int(13) UNSIGNED NOT NULL,
  `number` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customer_FK`(`customerId`) USING BTREE,
  INDEX `product_FK`(`productId`) USING BTREE,
  INDEX `indent_FK`(`indentId`) USING BTREE,
  CONSTRAINT `customer_FK` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `indent_FK` FOREIGN KEY (`indentId`) REFERENCES `indent` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_FK` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `positionName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `positionDesc` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68408 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `productNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `categoryId` int(13) UNSIGNED NOT NULL,
  `productName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createTime` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `productPrice` decimal(15, 0) NULL DEFAULT NULL,
  `stock` int(5) NULL DEFAULT NULL,
  `productDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productStatus` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `categoryId_FK`(`categoryId`) USING BTREE,
  CONSTRAINT `categoryId_FK` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 684253525 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `permissionId` int(13) UNSIGNED NOT NULL,
  `roleId` int(13) UNSIGNED NOT NULL,
  PRIMARY KEY (`permissionId`, `roleId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  CONSTRAINT `permissionId_FK` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `positionId` int(13) UNSIGNED NOT NULL,
  `departmentId` int(13) UNSIGNED NOT NULL,
  `staffName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salary` decimal(10, 2) NOT NULL,
  `hireDate` timestamp(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `positionId`(`positionId`) USING BTREE,
  INDEX `departmentId_FK`(`departmentId`) USING BTREE,
  CONSTRAINT `departmentId_FK` FOREIGN KEY (`departmentId`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`positionId`) REFERENCES `position` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6837004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `visitTime` timestamp(0) NULL DEFAULT NULL,
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `executionTime` int(11) NULL DEFAULT NULL,
  `method` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(13) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(110) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `userId` int(13) UNSIGNED NOT NULL,
  `roleId` int(13) UNSIGNED NOT NULL,
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `roleId_FK`(`roleId`) USING BTREE,
  CONSTRAINT `roleId_FK` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userId_FK` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for fillTable
-- ----------------------------
DROP PROCEDURE IF EXISTS `fillTable`;
delimiter ;;
CREATE PROCEDURE `fillTable`(in num int  , in tbName varchar(16))
begin 
-- 获取当前数据库
	select (@dbName:=database());
	set @tbName = tbName;
-- 获取表的字段总数
	set @currSql = "select count(1) from information_schema.COLUMNS where table_name = ? and table_schema = ? into @columnSum";
	prepare stmt from @currSql;
	execute stmt using @tbName , @dbName;
	deallocate prepare stmt;
	
	set @currNum = 0;
	
-- 这里设置随机的字符串
	set @chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	
	while @currNum < num do 
		-- 这里设置sql后面拼接
		set @insertSql = concat("insert into " , @tbName , " values ( ");
		set @columnNum = 1;
		while @columnNum <= @columnSum do
			set @value := '';
			set @currSql = "select (@column := COLUMN_NAME) , (@length := CHARACTER_MAXIMUM_LENGTH) , (@key := COLUMN_KEY) , (@type := DATA_TYPE) from information_schema.COLUMNS where table_name = ? and table_schema = ? limit ?";
			prepare stmt from @currSql;
			execute stmt using @tbName , @dbName , @columnNum;
			deallocate prepare stmt;
			
	-- 根据类型来填充数据
			if right(@type , 3) = 'int' then
				if @type = 'int' then
					set @value = 'default';
				else 
					set @value = floor(rand() * 100);
				end if;
			
			elseif right(@type , 4) = 'char' then
				set @counter = 0;
				while @counter < @length do    
	        		set @value = concat(@value,substr(@chars,ceil(rand()*(length(@chars)-1)),1));  
	    			set @counter = @counter + 1;
	    		end while;
	    		
	    		set @value = concat("'" , @value , "'");
	    		
	    	elseif @type = 'blob' or right(@type , 4) = 'text' then
	    		set @counter = 0;
	    	 	while @counter < 100 do    
	        		set @value = concat(@value,substr(@chars,ceil(rand()*(length(@chars)-1)),1));  
	    			set @counter = @counter + 1;
	    		end while;
	    		
	    		set @value = concat("'" , @value , "'");
	    		
	    	elseif @type = 'float' or @type = 'decimal' then
	    		set @value = round(rand() , 2);
	    	else 
	    		set @value = 'nine';
	    	end if;
	    	
	-- 判断这个数是否是最后一个
			if @columnNum = @columnSum then
				set @insertSql = concat(@insertSql , @value , ' )');
			else 
				set @insertSql = concat(@insertSql , @value , ' , ');
			end if;
			
			set @columnNum = @columnNum + 1;
		end while;
	-- 执行
		prepare stmt from @insertSql;
		execute stmt;
		deallocate prepare stmt;
		
		set @currNum = @currNum + 1;
	
	end while;
	
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
