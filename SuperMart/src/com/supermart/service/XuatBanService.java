package com.supermart.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
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
				for (VatTuChungTuChiTiet item : param.Details) {
					session.saveOrUpdate(item);
					VatTu vatTu = _vatTuService.GetDataByMaVatTu(item.MaVatTu);
					vatTu.SoLuong -= item.SoLuong;
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
}
