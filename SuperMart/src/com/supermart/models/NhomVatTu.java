package com.supermart.models;
import java.io.Serializable;
public class NhomVatTu implements Serializable  {

	private static final long serialVersionUID = 6329454289569501949L;
	private int Id;
	public String MaNhomVatTu;
	private String TenNhomVatTu;
	private int TrangThai;
	private String MaLoaiVatTu;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMaNhomVatTu() {
		return MaNhomVatTu;
	}
	public void setMaNhomVatTu(String maNhomVatTu) {
		MaNhomVatTu = maNhomVatTu;
	}
	public String getTenNhomVatTu() {
		return TenNhomVatTu;
	}
	public void setTenNhomVatTu(String tenNhomVatTu) {
		TenNhomVatTu = tenNhomVatTu;
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
	public NhomVatTu(int id, String maNhomVatTu, String tenNhomVatTu, int trangThai, String maLoaiVatTu) {
		
		Id = id;
		MaNhomVatTu = maNhomVatTu;
		TenNhomVatTu = tenNhomVatTu;
		TrangThai = trangThai;
		MaLoaiVatTu = maLoaiVatTu;
	}
	public NhomVatTu() {
		Id = 0;
		MaNhomVatTu = "";
		TenNhomVatTu = "";
		TrangThai = 0;
		
	}
	public String getMaLoaiVatTu() {
		return MaLoaiVatTu;
	}
	public void setMaLoaiVatTu(String maLoaiVatTu) {
		MaLoaiVatTu = maLoaiVatTu;
	}

	
	
	
}
