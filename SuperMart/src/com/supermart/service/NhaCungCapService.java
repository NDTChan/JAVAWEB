package com.supermart.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.NhaCungCap;

@Component 
@Transactional
public class NhaCungCapService {
	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<NhaCungCap> list()
	{
		String hql="FROM NhaCungCap";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	public List<NhaCungCap> list(int first, int max, String keySearch)
	{
		Query query;
		String hql = "";
		if(keySearch !=null) {
			hql ="FROM NhaCungCap kh WHERE kh.TenNhaCungCap LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			hql ="FROM NhaCungCap";
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
			hql="FROM NhaCungCap kh WHERE kh.TenNhaCungCap LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			hql ="FROM NhaCungCap";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		return query.list().size();
	}
	
	public NhaCungCap getById(int id)
	{
		return (NhaCungCap)sessionFactory.getCurrentSession().get(NhaCungCap.class, id);
	}
	
	public void add(NhaCungCap emp)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(emp);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void update(int id, String maNhaCungCap, String tenNhaCungCap,String diaChi,String dienThoai,String email,int trangThai)
	{
//		sessionFactory.getCurrentSession().beginTransaction();
		NhaCungCap ncc=getById(id);
		ncc.setMaNhaCungCap(maNhaCungCap);
		ncc.setTenNhaCungCap(tenNhaCungCap);
		ncc.setDiaChi(diaChi);
		ncc.setDienThoai(dienThoai);
		ncc.setEmail(email);
		ncc.setTrangThai(trangThai);
		sessionFactory.getCurrentSession().update(ncc);
//		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	public void delete(int id)
	{
		NhaCungCap ncc=getById(id);
		sessionFactory.getCurrentSession().delete(ncc);
	}
	
	public String getNewMaNhaCungCap() {
		String hql = "FROM NhaCungCap";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		ArrayList<Integer> listIndex = new ArrayList<Integer>();
		List<NhaCungCap> ListNcc = query.list();
		if (ListNcc.size() > 0) {
			for (int i = 0; i < ListNcc.size(); i++) {
				listIndex.add(Integer.parseInt(ListNcc.get(i).MaNhaCungCap.substring(3)));
			}
			Collections.sort(listIndex);
			return "NCC" + (listIndex.get(listIndex.size() - 1) + 1);
		} else {
			return "NCC1";
		}
	}
}
