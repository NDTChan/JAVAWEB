package com.supermart.models;

import java.io.Serializable;

public class VatTu implements Serializable {
	private static final long serialVersionUID = 6329454289569501949L;
	private int Id;
	private String MaVatTu;
	private String TenVatTu;
	private String BarCode;
	private String MaLoaiVatTu;
	private String MaNhaCungCap;
	private String MaDonViTinh;
	private double GiaMua;
	private double GiaBan;
	private double SoLuong;
	private String Anh;
	private int TrangThai;
	
	public VatTu() {
		super();
	}
	public VatTu(int id, String maVatTu, String tenVatTu, String barCode, String maLoaiVatTu, String maNhaCungCap,
			String maDonViTinh, double giaMua, double giaBan, double soLuong, String anh, int trangThai) {
		super();
		Id = id;
		MaVatTu = maVatTu;
		TenVatTu = tenVatTu;
		BarCode = barCode;
		MaLoaiVatTu = maLoaiVatTu;
		MaNhaCungCap = maNhaCungCap;
		MaDonViTinh = maDonViTinh;
		GiaMua = giaMua;
		GiaBan = giaBan;
		SoLuong = soLuong;
		Anh = anh;
		TrangThai = trangThai;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
