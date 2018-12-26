package com.supermart.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.supermart.models.VatTuChungTuChiTiet;

public class XuatBanVm {
	public int Id;
	public String LoaiChungTu;
	public String MaChungTu;
	public Date NgayChungTu;
	public String MaKhachHang;
	public String NoiDung;
	public int TrangThai;
	public List<XuatBanChiTietVm> Details;
	public List<XuatBanChiTietVm> DeleteList;
	

	public List<XuatBanChiTietVm> getDetails() {
		return Details;
	}

	public void setDetails(List<XuatBanChiTietVm> details) {
		Details = details;
	}

	public List<XuatBanChiTietVm> getDeleteList() {
		return DeleteList;
	}

	public void setDeleteList(List<XuatBanChiTietVm> deleteList) {
		DeleteList = deleteList;
	}

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

	
	public XuatBanVm() {
		Details = new ArrayList<XuatBanChiTietVm>();
		DeleteList = new ArrayList<XuatBanChiTietVm>();
		TrangThai = 0;
	}
}
