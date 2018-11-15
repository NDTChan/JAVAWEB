package com.supermart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.NhomVatTu;

@Component 
@Transactional
public class NhomVatTuService {
	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<NhomVatTu> list()
	{
		String sql="FROM NhomVatTu";
		Query query=sessionFactory.getCurrentSession().createQuery(sql);
		return query.list();
	}
	
	public List<NhomVatTu> list(int first, int max, String keySearch)
	{
		Query query;
		String sql = "";
		if(keySearch !=null) {
			sql ="FROM NhomVatTu kh WHERE kh.TenNhomVatTu LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			sql ="FROM NhomVatTu";
			query = sessionFactory.getCurrentSession().createQuery(sql);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
	
	public long Count(String keySearch) {
		Query query;
		String sql = "";
		if(keySearch !=null) {
			sql="FROM NhomVatTu kh WHERE kh.TenNhomVatTu LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			sql ="FROM NhomVatTu";
			query = sessionFactory.getCurrentSession().createQuery(sql);
		}
		return query.list().size();
	}
	
	public NhomVatTu getById(int id)
	{
		return (NhomVatTu)sessionFactory.getCurrentSession().get(NhomVatTu.class, id);
	}
	
	public void add(NhomVatTu emp)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(emp);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void update(int id, String maNhomVatTu, String tenNhomVatTu, int trangthai, String maLoaiVatTu)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		NhomVatTu nvt=getById(id);
		nvt.setMaNhomVatTu(maNhomVatTu);
		nvt.setMaLoaiVatTu(maLoaiVatTu);
		nvt.setTenNhomVatTu(tenNhomVatTu);
		nvt.setTrangThai(trangthai);
		sessionFactory.getCurrentSession().update(nvt);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void delete(int id)
	{
		NhomVatTu nvt=getById(id);
		sessionFactory.getCurrentSession().delete(nvt);
	}
}
