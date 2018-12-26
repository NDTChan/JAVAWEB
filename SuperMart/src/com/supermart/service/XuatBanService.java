package com.supermart.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import org.aspectj.weaver.ast.Var;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.VatTu;
import com.supermart.models.VatTuChungTu;
import com.supermart.models.VatTuChungTuChiTiet;

@Component
@Transactional
public class XuatBanService {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	VatTuService _vatTuService;
//	Session session;

	public List<VatTuChungTu> list() {
		String queryString = "FROM VatTuChungTu WHERE LoaiChungTu = 'XBAN'";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

	public List<VatTuChungTu> list(int first, int max, String keySearch) {
		Query query;
		String queryString = "";
		if (keySearch != null) {
			queryString = "FROM VatTuChungTu WHERE MaChungTu LIKE :keySearch AND LoaiChungTu = 'XBAN'";
			query = sessionFactory.getCurrentSession().createQuery(queryString);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			queryString = "FROM VatTuChungTu WHERE LoaiChungTu = 'XBAN'";
			query = sessionFactory.getCurrentSession().createQuery(queryString);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public long Count(String keySearch) {
		Query query;
		String queryString = "";
		if (keySearch != null) {
			queryString = "FROM VatTuChungTu WHERE MaChungTu LIKE :keySearch AND LoaiChungTu = 'XBAN'";
			query = sessionFactory.getCurrentSession().createQuery(queryString);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			queryString = "FROM VatTuChungTu WHERE LoaiChungTu = 'XBAN'";
			query = sessionFactory.getCurrentSession().createQuery(queryString);
		}
		return query.list().size();
	}

	public String GetNewCode() {
		Query query;
		String queryString = "";
		queryString = "FROM VatTuChungTu WHERE LoaiChungTu = 'XBAN'";
		query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<VatTuChungTu> lst = query.list();
		if (lst.size() > 0) {
			ArrayList<Integer> lstInt = new ArrayList<Integer>();
			for (VatTuChungTu item : lst) {
				lstInt.add(Integer.parseInt(item.MaChungTu.substring(4)));
			}
			Collections.sort(lstInt);
			return String.format("XBAN" + String.valueOf(lstInt.get(lstInt.size() - 1) + 1));
		}
		return "XBAN1";
	}

	public boolean InsertData(XuatBanVm param) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			VatTuChungTu data = new VatTuChungTu();
			data.MaChungTu = param.MaChungTu;
			data.LoaiChungTu = "XBAN";
			data.MaKhachHang = param.MaKhachHang;
			data.NgayChungTu = new Date();
			data.TrangThai = 0;
			session.saveOrUpdate(data);
			if (param.Details != null && !param.Details.isEmpty()) {
				for (XuatBanChiTietVm item : param.Details) {
					VatTuChungTuChiTiet vatTuChungTuChiTiet = new VatTuChungTuChiTiet();
					vatTuChungTuChiTiet.DonGia = item.DonGia;
					vatTuChungTuChiTiet.MaChungTu = item.MaChungTu;
					vatTuChungTuChiTiet.MaVatTu = item.MaVatTu;
					vatTuChungTuChiTiet.SoLuong = item.SoLuong;
					vatTuChungTuChiTiet.ThanhTien = item.ThanhTien;
					session.saveOrUpdate(vatTuChungTuChiTiet);
					VatTu vatTu = _vatTuService.GetDataByMaVatTu(vatTuChungTuChiTiet.MaVatTu);
					vatTu.SoLuong -= vatTuChungTuChiTiet.SoLuong;
					session.saveOrUpdate(vatTu);
				}
			}
			session.getTransaction().commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public XuatBanVm getByID(int id) {
		XuatBanVm xuatBanVm = (XuatBanVm) sessionFactory.getCurrentSession().get(VatTuChungTuChiTiet.class, id);
		if (xuatBanVm != null) {
			Query query;
			String queryString = "";
			queryString = "FROM VatTuChungTuChiTiet WHERE MaChungTu = '" + xuatBanVm.MaChungTu + "'";
			query = sessionFactory.getCurrentSession().createQuery(queryString);
			List<VatTuChungTuChiTiet> lst = query.list();
			for (VatTuChungTuChiTiet vatTuChungTuChiTiet : lst) {
				VatTu vatTu = _vatTuService.GetDataByMaVatTu(vatTuChungTuChiTiet.MaVatTu);
				XuatBanChiTietVm xuatBanChiTietVm = new XuatBanChiTietVm();
				xuatBanChiTietVm.Id = vatTuChungTuChiTiet.Id;
				xuatBanChiTietVm.MaChungTu = vatTuChungTuChiTiet.MaChungTu;
				xuatBanChiTietVm.MaVatTu = vatTuChungTuChiTiet.MaChungTu;
				xuatBanChiTietVm.TenVatTu = vatTu.TenVatTu;
				xuatBanChiTietVm.SoLuong = vatTuChungTuChiTiet.SoLuong;
				xuatBanChiTietVm.DonGia = vatTuChungTuChiTiet.DonGia;
				xuatBanChiTietVm.ThanhTien = vatTuChungTuChiTiet.ThanhTien;
				xuatBanVm.Details.add(xuatBanChiTietVm);
			}
			return xuatBanVm;
		}
		return null;
	}
	
	public boolean delete(int id) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			XuatBanVm xuatBanVm = getByID(id);
			VatTuChungTu vatTuChungTu = new VatTuChungTu();
			vatTuChungTu.Id = id;
			vatTuChungTu.MaChungTu = xuatBanVm.MaChungTu;
			vatTuChungTu.LoaiChungTu = xuatBanVm.LoaiChungTu;
			vatTuChungTu.MaKhachHang = xuatBanVm.MaKhachHang;
			vatTuChungTu.NgayChungTu = xuatBanVm.NgayChungTu;
			vatTuChungTu.NoiDung = xuatBanVm.NoiDung;
			vatTuChungTu.TrangThai = xuatBanVm.TrangThai;
			for (XuatBanChiTietVm xuatBanChiTietVm : xuatBanVm.Details) {
				VatTuChungTuChiTiet vatTuChungTuChiTiet = new VatTuChungTuChiTiet();
				vatTuChungTuChiTiet.Id = xuatBanChiTietVm.Id;
				vatTuChungTuChiTiet.MaChungTu = xuatBanChiTietVm.MaChungTu;
				vatTuChungTuChiTiet.MaVatTu = xuatBanChiTietVm.MaChungTu;
				vatTuChungTuChiTiet.SoLuong = xuatBanChiTietVm.SoLuong;
				vatTuChungTuChiTiet.DonGia = xuatBanChiTietVm.DonGia;
				vatTuChungTuChiTiet.ThanhTien = xuatBanChiTietVm.ThanhTien;
				session.delete(vatTuChungTuChiTiet);
			}
			session.delete(vatTuChungTu);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
