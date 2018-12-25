package com.supermart.models;

import java.io.Serializable;
import java.util.Date;

public class VatTuChungTu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int Id;
	public String LoaiChungTu;
	public String MaChungTu;
	public Date NgayChungTu;
	public String MaKhachHang;
	public String MaNhaCungCap;
	public String NoiDung;
	public int TrangThai;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLoaiChungTu() {
		return LoaiChungTu;
	}

	public void setLoaiChungTu(String loaiChungTu) {
		LoaiChungTu = loaiChungTu;
	}

	public String getMaChungTu() {
		return MaChungTu;
	}

	public void setMaChungTu(String maChungTu) {
		MaChungTu = maChungTu;
	}

	public Date getNgayChungTu() {
		return NgayChungTu;
	}

	public void setNgayChungTu(Date ngayChungTu) {
		NgayChungTu = ngayChungTu;
	}

	public String getMaKhachHang() {
		return MaKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		MaKhachHang = maKhachHang;
	}

	public String getMaNhaCungCap() {
		return MaNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
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

	public VatTuChungTu() {
		// TODO Auto-generated constructor stub
	}

	public VatTuChungTu(int id, String loaiChungTu, String maChungTu, Date ngayChungTu, String maKhachHang,
			String maNhaCungCap, String noiDung, int trangThai) {
		Id = id;
		LoaiChungTu = loaiChungTu;
		MaChungTu = maChungTu;
		NgayChungTu = ngayChungTu;
		MaKhachHang = maKhachHang;
		MaNhaCungCap = maNhaCungCap;
		NoiDung = noiDung;
		TrangThai = trangThai;
	}
}
