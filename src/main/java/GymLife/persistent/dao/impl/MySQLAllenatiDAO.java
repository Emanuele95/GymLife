package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.Massimale;
import GymLife.persistent.dao.AllenatiDAO;
import GymLife.persistent.entity.Giornata_scheda;
import GymLife.persistent.entity.Storico_allenamento;
import GymLife.persistent.entity.Storico_esercizio;
import java.util.ArrayList;


public class MySQLAllenatiDAO extends SessionFactoryHibernate implements AllenatiDAO  {
	
        
        @Override
	@Transactional
	public ArrayList<Massimale>  getMassimaliPersonali(int id) {
		@SuppressWarnings("unchecked")
		ArrayList<Massimale> listResult = ((ArrayList<Massimale>) getSession().createQuery("from Massimale m join fetch m.user s where s.id = :id")
                 .setParameter("id", id).list());
			
		if(listResult == null || listResult.isEmpty()) return null;
		return listResult;
	}
        
        @Transactional
	public void addEss(Storico_esercizio esercizio) {
        getSession().save(esercizio);  
        getSession().flush();  
	}
        
        @Transactional
	public void addAllenamento(Storico_allenamento allenamento) {
        getSession().save(allenamento);  
        getSession().flush();  
	}

}

