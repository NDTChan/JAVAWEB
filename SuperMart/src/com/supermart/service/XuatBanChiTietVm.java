package com.supermart.service;

public class XuatBanChiTietVm {
	public int Id;
	public String MaChungTu;
	public String MaVatTu;
	public String TenVatTu;
	public double SoLuong;
	public double DonGia;
	public double ThanhTien;
	
	public String getTenVatTu() {
		return TenVatTu;
	}
	public void setTenVatTu(String tenVatTu) {
		TenVatTu = tenVatTu;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMaChungTu() {
		return MaChungTu;
	}
	public void setMaChungTu(String maChungTu) {
		MaChungTu = maChungTu;
	}
	public String getMaVatTu() {
		return MaVatTu;
	}
	public void setMaVatTu(String maVatTu) {
		MaVatTu = maVatTu;
	}
	public double getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(double soLuong) {
		SoLuong = soLuong;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public double getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(double thanhTien) {
		ThanhTien = thanhTien;
	}
}
