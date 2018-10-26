package com.supermart.service;

import java.util.List;
import com.supermart.models.*;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class AuthService {
	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(AuthService.class);

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean findUser(String uname, String upwd) {
		log.info("Checking the user in the database");
		boolean isValidUser = false;
		String sqlQuery = "from User u where u.name=? and u.password=?";
		try {
			List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, uname, upwd);
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
