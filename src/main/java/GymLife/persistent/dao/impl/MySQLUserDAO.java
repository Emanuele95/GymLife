package GymLife.persistent.dao.impl;


import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.dao.UserDAO;
import GymLife.persistent.entity.User;


public class MySQLUserDAO extends SessionFactoryHibernate implements UserDAO{
	
	@Transactional
	public void addUser(User user) {
        getSession().save(user);        	
	}

	public User getUser(String email) {
		return (User) getSession().createQuery("from User u where u.email = :email")
				.setParameter("email", email).uniqueResult();
	}
	
	public User getUserName(String nome) {
		return (User) getSession().createQuery("from User u where u.nome = :nome")
				.setParameter("nome", nome).uniqueResult();
	}
        
        public User getId(int id) {
		return (User) getSession().createQuery("from User u where u.id = :id")
				.setParameter("id", id).uniqueResult();
	}
    
}
