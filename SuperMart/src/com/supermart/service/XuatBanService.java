package com.supermart.service;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.supermart.models.VatTuChungTu;

@Component
@Transactional
public class XuatBanService {
	@Autowired
	private SessionFactory sessionFactory;

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
}
