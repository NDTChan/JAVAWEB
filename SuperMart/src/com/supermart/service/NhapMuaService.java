package com.supermart.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.supermart.models.VatTu;
import com.supermart.models.VatTuChungTu;
import com.supermart.models.VatTuChungTuChiTiet;

@Component
@Transactional
public class NhapMuaService {

	@Autowired
	private SessionFactory sessionFactory;

//	Session session;

	public List<VatTuChungTu> list() {
		String hql = "FROM VatTu WHERE LoaiChungTu = 'NMUA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println(query.list());
		return query.list();
	}

	public VatTuChungTu getById(int id) {
		return (VatTuChungTu) sessionFactory.getCurrentSession().get(VatTuChungTu.class, id);
	}

	public void add(VatTuChungTu vtct, ArrayList<VatTuChungTuChiTiet> lstVtctct) {
		Session sessionObj = null;
		vtct.LoaiChungTu = "NMUA";
		try {
			sessionObj = sessionFactory.openSession();
			sessionObj.beginTransaction();
			sessionObj.save(vtct);
			for (int i = 0; i < lstVtctct.size(); i++)
			{
				lstVtctct.get(i).MaChungTu = vtct.MaChungTu;
			}
			sessionObj.save(lstVtctct);
			sessionObj.getTransaction().commit();
		} catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
	}

	public void update(VatTuChungTu model) {
		sessionFactory.getCurrentSession().update(model);
	}

	public void delete(int id) {
		VatTuChungTu vtct = getById(id);
		sessionFactory.getCurrentSession().delete(vtct);
	}

}
