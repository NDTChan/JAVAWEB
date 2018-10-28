package com.supermart.service;

import java.util.List;
import javax.transaction.Transactional;
import com.supermart.models.*;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class AuthService {
	private static Logger log = Logger.getLogger(AuthService.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean findUser(String uname, String upwd) {
		boolean isValidUser = false;
		String sqlQuery = "from User u where u.Username='" + uname + "' and u.Password='" + upwd + "'";
		try {
			List<User> userObj = sessionFactory.getCurrentSession().createQuery(sqlQuery).list();
			if (userObj != null && userObj.size() > 0) {
				log.info("Id= " + userObj.get(0).getId() + ", FullName= " + userObj.get(0).getFullName()
						+ ", Password= " + userObj.get(0).getPassword());
				isValidUser = true;
			}
		} catch (Exception e) {
			isValidUser = false;
			log.error("An error occurred while fetching the user details from the database", e);
		}
		return isValidUser;
	}

}
