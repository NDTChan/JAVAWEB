package com.supermart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
@Transactional
public class HomeComonService {

	@Autowired 
	private SessionFactory sessionFactory;
	
	public List<VatTuVm.Dto> GetListMerchansediseNew(int first, int max){
		String hql = "FROM VatTu";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
}
