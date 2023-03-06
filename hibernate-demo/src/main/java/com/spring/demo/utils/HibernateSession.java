
package com.spring.demo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

public abstract class HibernateSession {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {

		return getSessionFactory().getCurrentSession();
	}

	protected HibernateTemplate getHibernateTemplate() {

		return new HibernateTemplate(getSessionFactory());
	}

	protected SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}
