package GymLife.persistent.dao.impl;


import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.dao.MisurazioneDAO;
import GymLife.persistent.entity.Misurazione;


public class MySQLMisurazioneDAO extends SessionFactoryHibernate implements MisurazioneDAO{
	
	@Transactional
	public void addMisurazione(Misurazione misurazione) {
        getSession().save(misurazione);
        getSession().flush();        	
	}
	
}