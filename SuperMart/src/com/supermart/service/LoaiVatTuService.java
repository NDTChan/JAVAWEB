package com.supermart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.LoaiVatTu;

@Component 
@Transactional
public class LoaiVatTuService {
	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<LoaiVatTu> list()
	{
		String hql="FROM LoaiVatTu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(query.list());
		return query.list();
	}
	
	public List<LoaiVatTu> list(int first, int max)
	{
		String hql="FROM LoaiVatTu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
	public LoaiVatTu getById(int id)
	{
		return (LoaiVatTu)sessionFactory.getCurrentSession().get(LoaiVatTu.class, id);
	}
	
	public void add(LoaiVatTu emp)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(emp);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void update(int id, String maLoaiVatTu, String tenLoaiVatTu,int trangthai)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		LoaiVatTu lvt=getById(id);
		lvt.setMaLoaiVatTu(maLoaiVatTu);
		lvt.setTenLoaiVatTu(tenLoaiVatTu);
		lvt.setTrangThai(trangthai);
		sessionFactory.getCurrentSession().update(lvt);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void delete(int id)
	{
		LoaiVatTu lvt=getById(id);
		sessionFactory.getCurrentSession().delete(lvt);
	}
}
