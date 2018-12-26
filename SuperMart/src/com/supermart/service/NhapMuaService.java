package com.supermart.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.DonViTinh;
import com.supermart.models.LoaiVatTu;
import com.supermart.models.VatTu;
import com.supermart.models.VatTuChungTu;
import com.supermart.models.VatTuChungTuChiTiet;
import com.supermart.service.VatTuVm.Dto;

@Component
@Transactional
public class NhapMuaService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<VatTuChungTu> list() {
		String hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<VatTuChungTu> list(int first, int max, String keySearch) {
		Query query;
		String hql = "";
		if (keySearch != null) {
			hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA' AND MaChungTu LIKE :keySearch";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA'";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
	
	public NhapMuaVm GetItemById(int id){
		NhapMuaVm result = new NhapMuaVm();
		ModelMapper modelMapper = new ModelMapper();
		Query query;
		String hql = "";
		VatTuChungTu vt = (VatTuChungTu)sessionFactory.getCurrentSession().get(VatTuChungTu.class, id);
		result = modelMapper.map(vt, NhapMuaVm.class);
		result.Details = new ArrayList<VatTuChungTuChiTiet>();
		if(result != null) {
			hql = "FROM VatTuChungTuChiTiet WHERE MaChungTu = :machungtu";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("machungtu", result.MaChungTu);
			List<VatTuChungTuChiTiet> list = query.list();
			result.Details.addAll(list);
		}
		return result;
	}

	public long Count(String keySearch) {
		Query query;
		String hql = "";
		if (keySearch != null) {
			hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA' AND MaChungTu LIKE :keySearch";
			query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("keySearch", "%" + keySearch + "%");
		} else {
			hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA'";
			query = sessionFactory.getCurrentSession().createQuery(hql);
		}
		return query.list().size();
	}

	public String getNewMaChungTu() {
		String hql = "FROM VatTuChungTu WHERE LoaiChungTu = 'NMUA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		ArrayList<Integer> listIndex = new ArrayList<Integer>();
		List<VatTuChungTu> listVtct = query.list();
		if (listVtct.size() > 0) {
			for (int i = 0; i < listVtct.size(); i++) {
				listIndex.add(Integer.parseInt(listVtct.get(i).MaChungTu.substring(5)));
			}
			Collections.sort(listIndex);
			return "NMUA" + (listIndex.get(listIndex.size() - 1) + 1);
		} else {
			return "NMUA1";
		}
	}
	
	public boolean InsertData(NhapMuaVm param) {
		try {
			Session session= sessionFactory.openSession();
			session.beginTransaction();
			VatTuChungTu data = new VatTuChungTu();
			data.MaChungTu = param.MaChungTu;
			data.LoaiChungTu = "NMUA";
			data.MaNhaCungCap = param.MaNhaCungCap;
			data.NgayChungTu = new Date();
			data.TrangThai = 0;
			session.saveOrUpdate(data);
			if (param.Details != null && !param.Details.isEmpty()) {
				for (VatTuChungTuChiTiet item : param.Details) {
					session.saveOrUpdate(item);
				}
			}
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean UpdateData(NhapMuaVm param) {
		try {
			Session session= sessionFactory.openSession();
			session.beginTransaction();
			VatTuChungTu data = new VatTuChungTu();
			data.MaChungTu = param.MaChungTu;
			data.MaNhaCungCap = param.MaNhaCungCap;
			data.NgayChungTu = new Date();
			data.TrangThai = 0;
			session.update(data);
			if (param.Details != null && !param.Details.isEmpty()) {
				for (VatTuChungTuChiTiet item : param.Details) {
					session.update(item);
				}
			}
			session.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
