package com.supermart.models;

import java.io.Serializable;

public class VatTuChungTuChiTiet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6842984477720662057L;
	public int Id;
	public String MaChungTu;
	public String MaVatTu;
	public double SoLuong;
	public double DonGia;
	public double ThanhTien;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
