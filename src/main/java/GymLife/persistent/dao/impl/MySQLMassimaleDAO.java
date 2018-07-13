package GymLife.persistent.dao.impl;


import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.dao.MassimaleDAO;
import GymLife.persistent.entity.Massimale;


public class MySQLMassimaleDAO extends SessionFactoryHibernate implements MassimaleDAO{
	
	@Transactional
	public void addMassimale(Massimale massimale) {
        getSession().save(massimale);  
        getSession().flush();  
          
	}
	
}

