package com.supermart.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.DonViTinh;
import com.supermart.models.VatTuChungTu;
import com.supermart.models.VatTuChungTuChiTiet;

@Component
@Transactional
public class NhapMuaService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<VatTuChungTu> list() {
		String hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<VatTuChungTu> list(int first, int max, String keySearch) {
		Query query;
		String hql = "";
		if (keySearch != null) {
			hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA' AND MaChungTu LIKE :keySearch";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA'";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public long Count(String keySearch) {
		Query query;
		String hql = "";
		if (keySearch != null) {
			hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA' AND MaChungTu LIKE :keySearch";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			hql = "FROM DonViTinh";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		return query.list().size();
	}

}
