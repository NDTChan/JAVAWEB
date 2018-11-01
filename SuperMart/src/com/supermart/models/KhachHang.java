package com.supermart.models;

import java.io.Serializable;

public class KhachHang implements Serializable {

	public static final long serialVersionUID = 6329454289569501949L;
	public int Id;
	public String MaKhachHang;
	public String TenKhachHang;
	public String DiaChi;
	public String DienThoai;
	public String Email;
	
	public KhachHang() {
		super();
	}
	
	public KhachHang(int id, String maKhachHang, String tenKhachHang, String diaChi, String dienThoai, String email) {
		super();
		Id = id;
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		DiaChi = diaChi;
		DienThoai = dienThoai;
		Email = email;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getDienThoai() {
		return DienThoai;
	}
	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
