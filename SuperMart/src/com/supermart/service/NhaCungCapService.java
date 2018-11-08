package com.supermart.service;

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
		System.out.println(query.list());
		return query.list();
	}
	
	public List<NhaCungCap> list(int first, int max)
	{
		String hql="FROM NhaCungCap";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
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
}
