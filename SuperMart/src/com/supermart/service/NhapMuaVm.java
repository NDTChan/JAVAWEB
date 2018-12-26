package com.supermart.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.supermart.models.VatTuChungTuChiTiet;

public class NhapMuaVm {
	public String LoaiChungTu;
	public String MaChungTu;
	public Date NgayChungTu;
	public String MaNhaCungCap;
	public String NoiDung;
	public int TrangThai;
	public List<VatTuChungTuChiTiet> Details;
	
	public void setDetails(List<VatTuChungTuChiTiet> details) {
		Details = details;
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
	
}

