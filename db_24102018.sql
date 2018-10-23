-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: qlbh
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `donvitinh`
--

DROP TABLE IF EXISTS `donvitinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `donvitinh` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MaDonViTinh` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenDonViTinh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `MaDonViTinh_UNIQUE` (`MaDonViTinh`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donvitinh`
--

LOCK TABLES `donvitinh` WRITE;
/*!40000 ALTER TABLE `donvitinh` DISABLE KEYS */;
INSERT INTO `donvitinh` VALUES (1,'DVT1','Chiếc',10);
/*!40000 ALTER TABLE `donvitinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `khachhang` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MaKhachHang` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenKhacHang` varchar(555) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DiaChi` varchar(5555) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DienThoai` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `MaKhachHang_UNIQUE` (`MaKhachHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaivattu`
--

DROP TABLE IF EXISTS `loaivattu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loaivattu` (
  `Id` int(11) NOT NULL,
  `MaLoaiVatTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenLoaiVatTu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `MaLoaiVatTu_UNIQUE` (`MaLoaiVatTu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaivattu`
--

LOCK TABLES `loaivattu` WRITE;
/*!40000 ALTER TABLE `loaivattu` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaivattu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nhacungcap` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MaNhaCungCap` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenNhaCungCap` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DiaChi` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DienThoai` varchar(20) DEFAULT NULL,
  `Email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `MaNhaCungCap_UNIQUE` (`MaNhaCungCap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhomvattu`
--

DROP TABLE IF EXISTS `nhomvattu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nhomvattu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MaNhomVatTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenNhomVatTu` varchar(555) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaLoaiVatTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `MaNhomVatTu_UNIQUE` (`MaNhomVatTu`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhomvattu`
--

LOCK TABLES `nhomvattu` WRITE;
/*!40000 ALTER TABLE `nhomvattu` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhomvattu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FullName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `PhoneNumber` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Address` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vattu`
--

DROP TABLE IF EXISTS `vattu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vattu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MaVatTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TenVatTu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Barcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaLoaiVatTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaNhomVatTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaNhaCungCap` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaDonViTinh` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `GiaMua` decimal(18,2) DEFAULT NULL,
  `GiaBan` decimal(18,2) DEFAULT NULL,
  `SoLuong` decimal(18,2) DEFAULT NULL,
  `Anh` varchar(2555) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `MaVatTu_UNIQUE` (`MaVatTu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vattu`
--

LOCK TABLES `vattu` WRITE;
/*!40000 ALTER TABLE `vattu` DISABLE KEYS */;
/*!40000 ALTER TABLE `vattu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vattuchungtu`
--

DROP TABLE IF EXISTS `vattuchungtu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vattuchungtu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LoaiChungTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MaChungTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `NgayChungTu` datetime NOT NULL,
  `MaKhachHang` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MaNhaCungCap` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NoiDung` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  UNIQUE KEY `MaChungTu_UNIQUE` (`MaChungTu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vattuchungtu`
--

LOCK TABLES `vattuchungtu` WRITE;
/*!40000 ALTER TABLE `vattuchungtu` DISABLE KEYS */;
/*!40000 ALTER TABLE `vattuchungtu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vattuchungtuchitiet`
--

DROP TABLE IF EXISTS `vattuchungtuchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vattuchungtuchitiet` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `MaChungTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MaVatTu` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `SoLuong` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ThanhTien` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vattuchungtuchitiet`
--

LOCK TABLES `vattuchungtuchitiet` WRITE;
/*!40000 ALTER TABLE `vattuchungtuchitiet` DISABLE KEYS */;
/*!40000 ALTER TABLE `vattuchungtuchitiet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-24  0:01:40
