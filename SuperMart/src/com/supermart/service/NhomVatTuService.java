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
		String hql="FROM NhomVatTu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(query.list());
		return query.list();
	}
	
	public List<NhomVatTu> list(int first, int max)
	{
		String hql="FROM NhomVatTu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
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
