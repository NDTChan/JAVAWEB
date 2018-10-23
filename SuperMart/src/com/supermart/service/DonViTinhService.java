package com.supermart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.DonViTinh;

@Component 
@Transactional
public class DonViTinhService {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
//	Session session;
	
	
	public List<DonViTinh> list()
	{
		String hql="FROM DonViTinh";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(query.list());
		return query.list();
	}
	
	public List<DonViTinh> list(int first, int max)
	{
		String hql="FROM DonViTinh";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
	public DonViTinh getById(int id)
	{
		return (DonViTinh)sessionFactory.getCurrentSession().get(DonViTinh.class, id);
	}
	public void add(DonViTinh emp)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(emp);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void update(int id, String madonvi, String tendonvi,int trangthai)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		DonViTinh dvt=getById(id);
		dvt.setMaDonViTinh(madonvi);
		dvt.setTenDonViTinh(tendonvi);
		dvt.setTrangThai(trangthai);
		sessionFactory.getCurrentSession().update(dvt);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void delete(int id)
	{
		DonViTinh dvt=getById(id);
		sessionFactory.getCurrentSession().delete(dvt);
	}

}
