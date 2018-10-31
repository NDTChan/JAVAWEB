package com.supermart.models;
import java.io.Serializable;
public class LoaiVatTu implements Serializable  {

	private static final long serialVersionUID = 6329454289569501949L;
	private int Id;
	private String MaLoaiVatTu;
	private String TenLoaiVatTu;
	private int TrangThai;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMaLoaiVatTu() {
		return MaLoaiVatTu;
	}
	public void setMaLoaiVatTu(String maLoaiVatTu) {
		MaLoaiVatTu = maLoaiVatTu;
	}
	public String getTenLoaiVatTu() {
		return TenLoaiVatTu;
	}
	public void setTenLoaiVatTu(String tenLoaiVatTu) {
		TenLoaiVatTu = tenLoaiVatTu;
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
	public LoaiVatTu(int id, String maLoaiVatTu, String tenLoaiVatTu, int trangThai) {
		
		Id = id;
		MaLoaiVatTu = maLoaiVatTu;
		TenLoaiVatTu = tenLoaiVatTu;
		TrangThai = trangThai;
	}
	public LoaiVatTu() {
		Id = 0;
		MaLoaiVatTu = "";
		TenLoaiVatTu = "";
		TrangThai = 0;
		
	}

	
	
	
}
