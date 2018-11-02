package com.supermart.models;

import java.io.Serializable;

public class NhaCungCap implements Serializable {

	private static final long serialVersionUID = 6329454289569501949L;
	private int Id;
	private String MaNhaCungCap;
	private String TenNhaCungCap;
	private String DiaChi;
	private String DienThoai;
	private String Email;
	private int TrangThai;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMaNhaCungCap() {
		return MaNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}
	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
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
	public int getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public NhaCungCap(int id, String maNhaCungCap, String tenNhaCungCap, String diaChi, String dienThoai, String email,
			int trangThai) {
		super();
		Id = id;
		MaNhaCungCap = maNhaCungCap;
		TenNhaCungCap = tenNhaCungCap;
		DiaChi = diaChi;
		DienThoai = dienThoai;
		Email = email;
		TrangThai = trangThai;
	}
	public NhaCungCap() {
		super();
	}
		
}
