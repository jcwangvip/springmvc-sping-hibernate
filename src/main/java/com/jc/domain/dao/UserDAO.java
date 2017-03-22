package com.jc.domain.dao;

import java.sql.SQLException;

import com.jc.domain.pojo.User;

public class UserDAO extends HibernateDaoSupport{
	public User login(final String usercode,final String userpswd) throws Exception{
		return (User)this.getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				return session.createCriteria(User.class)
							.add(Restrictions.eq("usercode", usercode))
							.add(Restrictions.eq("userpswd", userpswd))
							.uniqueResult();
			}
			
		});
		
	}
}
