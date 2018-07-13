package GymLife.persistent.dao.impl;


import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.dao.SalvaSchedaDAO;
import GymLife.persistent.entity.Giornata_scheda;
import GymLife.persistent.entity.SalvaScheda;


public class MySQLSalvaSchedaDAO extends SessionFactoryHibernate implements SalvaSchedaDAO{
	
	@Transactional
	public void addScheda(SalvaScheda scheda) {
        getSession().save(scheda);  
        getSession().flush();  
          
	}
        
        
        public Giornata_scheda getGiornataScheda(int id) {
		return (Giornata_scheda) getSession().createQuery("from Giornata_scheda s where s.id = :id")
				.setParameter("id", id).uniqueResult();
	}
	
}

