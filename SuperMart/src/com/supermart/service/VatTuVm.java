package com.supermart.service;

public class VatTuVm {
	public class Dto {
		private String MaVatTu;
		private String TenVatTu;
		private String BarCode;
		private String MaLoaiVatTu;
		private String MaNhaCungCap;
		private String MaDonViTinh;
		private double GiaMua;
		private double GiaBan;
		private double SoLuong;
		private double ThanhTien;
		public double getThanhTien() {
			return ThanhTien;
		}
		public void setThanhTien(double thanhTien) {
			ThanhTien = thanhTien;
		}
		private String Anh;
		private int TrangThai;
		public String getMaVatTu() {
			return MaVatTu;
		}
		public void setMaVatTu(String maVatTu) {
			MaVatTu = maVatTu;
		}
		public String getTenVatTu() {
			return TenVatTu;
		}
		public void setTenVatTu(String tenVatTu) {
			TenVatTu = tenVatTu;
		}
		public String getBarCode() {
			return BarCode;
		}
		public void setBarCode(String barCode) {
			BarCode = barCode;
		}
		public String getMaLoaiVatTu() {
			return MaLoaiVatTu;
		}
		public void setMaLoaiVatTu(String maLoaiVatTu) {
			MaLoaiVatTu = maLoaiVatTu;
		}
		public String getMaNhaCungCap() {
			return MaNhaCungCap;
		}
		public void setMaNhaCungCap(String maNhaCungCap) {
			MaNhaCungCap = maNhaCungCap;
		}
		public String getMaDonViTinh() {
			return MaDonViTinh;
		}
		public void setMaDonViTinh(String maDonViTinh) {
			MaDonViTinh = maDonViTinh;
		}
		public double getGiaMua() {
			return GiaMua;
		}
		public void setGiaMua(double giaMua) {
			GiaMua = giaMua;
		}
		public double getGiaBan() {
			return GiaBan;
		}
		public void setGiaBan(double giaBan) {
			GiaBan = giaBan;
		}
		public double getSoLuong() {
			return SoLuong;
		}
		public void setSoLuong(double soLuong) {
			SoLuong = soLuong;
		}
		public String getAnh() {
			return Anh;
		}
		public void setAnh(String anh) {
			Anh = anh;
		}
		public int getTrangThai() {
			return TrangThai;
		}
		public void setTrangThai(int trangThai) {
			TrangThai = trangThai;
		}
	}
	
}
