package com.supermart.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.Nullable;
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
		return query.list();
	}
	
	public List<DonViTinh> list(int first, int max, String keySearch)
	{
		Query query;
		String hql = "";
		if(keySearch !=null) {
			hql="FROM DonViTinh dvt WHERE dvt.TenDonViTinh LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			hql="FROM DonViTinh";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
	
	public long Count(String keySearch) {
		
		Query query;
		String hql = "";
		if(keySearch !=null) {
			hql="FROM DonViTinh dvt WHERE dvt.TenDonViTinh LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			hql="FROM DonViTinh";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		return query.list().size();
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
	
	public String getNewMaDonVi() {
		String hql = "FROM DonViTinh";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		ArrayList<Integer> listIndex = new ArrayList<Integer>();
		List<DonViTinh> listDvt = query.list();
		if (listDvt.size() > 0) {
			for (int i = 0; i < listDvt.size(); i++) {
				//System.out.println(listDvt.get(i).MaDonViTinh.substring(3));
				listIndex.add(Integer.parseInt(listDvt.get(i).MaDonViTinh.substring(3)));
			}
			Collections.sort(listIndex);
			return "DVT" + (listIndex.get(listIndex.size() - 1) + 1);
		} else {
			return "DVT1";
		}
	}

}
