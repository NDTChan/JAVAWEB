package com.supermart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.VatTu;

@Component
@Transactional
public class VatTuService {

	@Autowired
	private SessionFactory sessionFactory;

//	Session session;

	public List<VatTu> list() {
		String sql = "FROM VatTu";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		return query.list();
	}

	public List<VatTu> list(int first, int max, String keySearch) {
		Query query;
		String sql = "";
		if (keySearch != null) {
			sql = "FROM VatTu kh WHERE kh.TenVatTu LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			sql = "FROM VatTu";
			query = sessionFactory.getCurrentSession().createQuery(sql);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public long Count(String keySearch) {
		Query query;
		String sql = "";
		if (keySearch != null) {
			sql = "FROM VatTu kh WHERE kh.TenVatTu LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			sql = "FROM VatTu";
			query = sessionFactory.getCurrentSession().createQuery(sql);
		}
		return query.list().size();
	}

	public VatTu getById(int id) {
		return (VatTu) sessionFactory.getCurrentSession().get(VatTu.class, id);
	}

	public void add(VatTu vt) {
//		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(vt);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public VatTu GetDataByMaVatTu(String MaVatTu) {
		String sql = "FROM VatTu WHERE MaVatTu = '" + MaVatTu + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		if (query.list().size() > 0) {
			return (VatTu) query.list().get(0);
		}
		return null;
	}
	
	public List<VatTu> GetInfoMerchandiseByCode(String MaVatTu) {
		String sql = "FROM VatTu WHERE MaVatTu LIKE :MaVatTu";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("MaVatTu", "%" + MaVatTu + "%");
		return query.list();
	}

	public void update(int id, VatTu model) {
//		sessionFactory.getCurrentSession().beginTransaction();
		ModelMapper modelMapper = new ModelMapper();
		VatTu vt = getById(id);
		if (vt != null) {
			vt.setAnh(model.getAnh());
			vt.setGiaBan(model.getGiaBan());
			vt.setGiaMua(model.getGiaMua());
			vt.setMaDonViTinh(model.getMaDonViTinh());
			vt.setMaLoaiVatTu(model.getMaLoaiVatTu());
			vt.setSoLuong(model.getSoLuong());
			vt.setTenVatTu(model.getTenVatTu());
			vt.setTrangThai(model.getTrangThai());
			sessionFactory.getCurrentSession().update(vt);
		}

//		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public void delete(int id) {
		VatTu vt = getById(id);
		sessionFactory.getCurrentSession().delete(vt);
	}

}
