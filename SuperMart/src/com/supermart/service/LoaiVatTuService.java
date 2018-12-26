package com.supermart.service;

import java.util.ArrayList;
import java.util.Collections;
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
		return query.list();
	}
	
	public List<LoaiVatTu> list(int first, int max, String keySearch)
	{
		Query query;
		String hql = "";
		if(keySearch !=null) {
			hql ="FROM LoaiVatTu kh WHERE kh.TenLoaiVatTu LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			hql ="FROM LoaiVatTu";
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
			hql="FROM LoaiVatTu kh WHERE kh.TenLoaiVatTu LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			hql ="FROM LoaiVatTu";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		return query.list().size();
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
	
	public String getNewMaLoaiVatTu() {
		String hql = "FROM LoaiVatTu";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		ArrayList<Integer> listIndex = new ArrayList<Integer>();
		List<LoaiVatTu> listLvt = query.list();
		if (listLvt.size() > 0) {
			for (int i = 0; i < listLvt.size(); i++) {
				listIndex.add(Integer.parseInt(listLvt.get(i).MaLoaiVatTu.substring(3)));
			}
			Collections.sort(listIndex);
			return "LVT" + (listIndex.get(listIndex.size() - 1) + 1);
		} else {
			return "LVT1";
		}
	}
}
