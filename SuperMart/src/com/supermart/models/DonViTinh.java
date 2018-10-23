package com.supermart.models;

import java.io.Serializable;

public class DonViTinh implements Serializable{

	private static final long serialVersionUID = 6329454289569501949L;
	private int Id;
	private String MaDonViTinh;
	private String TenDonViTinh;
	private int TrangThai;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMaDonViTinh() {
		return MaDonViTinh;
	}
	public void setMaDonViTinh(String maDonViTinh) {
		MaDonViTinh = maDonViTinh;
	}
	public String getTenDonViTinh() {
		return TenDonViTinh;
	}
	public void setTenDonViTinh(String tenDonViTinh) {
		TenDonViTinh = tenDonViTinh;
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
	
}



