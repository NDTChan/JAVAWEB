package com.supermart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.KhachHang;

@Component 
@Transactional
public class KhachHangService {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
//	Session session;
	
	public List<KhachHang> list()
	{
		String vqh="FROM KhachHang";
		Query query=sessionFactory.getCurrentSession().createQuery(vqh);
		return query.list();
	}
	
	public List<KhachHang> list(int first, int max, String keySearch)
	{
		Query query;
		String vqh = "";
		if(keySearch !=null) {
			vqh ="FROM KhachHang kh WHERE kh.TenKhachHang LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(vqh);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			vqh ="FROM KhachHang";
			query = sessionFactory.getCurrentSession().createQuery(vqh);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
	
	public long Count(String keySearch) {
		Query query;
		String vqh = "";
		if(keySearch !=null) {
			vqh="FROM KhachHang kh WHERE kh.TenKhachHang LIKE :keySearch ";
			query = sessionFactory.getCurrentSession().createQuery(vqh);
			query.setParameter("keySearch", "%" + keySearch + "%");
		}
		else {
			vqh ="FROM KhachHang";
			query = sessionFactory.getCurrentSession().createQuery(vqh);
		}
		return query.list().size();
	}
	
	public KhachHang getById(int id)
	{
		return (KhachHang)sessionFactory.getCurrentSession().get(KhachHang.class, id);
	}
	
	public void add(KhachHang kh)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(kh);
	}
	public void update(int id, String maKhachHang, String tenKhachHang, String diaChi, String dienThoai, String email)
	{
		KhachHang kh = getById(id);
		kh.setMaKhachHang(maKhachHang);
		kh.setTenKhachHang(tenKhachHang);
		kh.setDiaChi(diaChi);
		kh.setDienThoai(dienThoai);
		kh.setEmail(email);
		sessionFactory.getCurrentSession().update(kh);
	}
	public void delete(int id)
	{
		KhachHang kh = getById(id);
		sessionFactory.getCurrentSession().delete(kh);
	}

}
