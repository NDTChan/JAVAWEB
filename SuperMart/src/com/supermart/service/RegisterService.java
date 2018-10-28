package com.supermart.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.supermart.models.User;

@Component
@Transactional
public class RegisterService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void register(User user)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public boolean checkExistUser (User user) {
		String sqlQuery = "from User u where u.Username='" + user.getUsername() + "'";
		try {
			List<User> userObj = sessionFactory.getCurrentSession().createQuery(sqlQuery).list();
			System.out.println(userObj.size());
			return userObj != null && userObj.size() > 0 ? true : false;
		} catch (Exception e) {
			System.out.println('1');
			return false;
		}
	}
}
