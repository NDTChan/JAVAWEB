package com.supermart.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.supermart.models.LoaiVatTu;
import com.supermart.models.VatTu;

@Component 
@Transactional
public class HomeComonService {

	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<DtoHome> GetListMerchansediseNew(int first, int max){
		String hql = "select vt, lvt from VatTu as vt , LoaiVatTu as lvt where vt.MaLoaiVatTu = lvt.MaLoaiVatTu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<DtoHome> dtoList = new ArrayList<DtoHome>();
		List<Object[]> lista = query.list();
		for(Object[] row:lista) {
			VatTu vattu = (VatTu) row[0];
			LoaiVatTu loaiVatTu = (LoaiVatTu) row[1];
			DtoHome dto = new DtoHome();
			dto.vatTu = vattu;
			dto.loaiVatTu = loaiVatTu;
			dtoList.add(dto);
	    }
		return dtoList;
	}
	
}
