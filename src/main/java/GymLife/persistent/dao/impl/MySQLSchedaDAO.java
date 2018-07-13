package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.Scheda;
import GymLife.persistent.entity.Giornata_scheda;
import GymLife.persistent.dao.SchedaDAO;
import GymLife.persistent.entity.Esercizio_giornata;
import java.util.ArrayList;


public class MySQLSchedaDAO extends SessionFactoryHibernate implements SchedaDAO  {
	
        
        @Override
	@Transactional
	public ArrayList<Esercizio_giornata>  getSchedeArray( String regime ,int n_giorni, String difficolta) {
		@SuppressWarnings("unchecked")
		ArrayList<Esercizio_giornata> listResult = ((ArrayList<Esercizio_giornata>) getSession().createQuery("from Esercizio_giornata e join fetch e.scheda s where s.regime LIKE :regime and s.n_giorni >= :n_giorni and s.difficolta LIKE :difficolta")
                        .setParameter("regime", regime).setParameter("n_giorni", n_giorni).setParameter("difficolta", difficolta).list());
			
		if(listResult == null || listResult.isEmpty()) return null;
		return listResult;
	}
        
          public Scheda getScheda(int id) {
		return (Scheda) getSession().createQuery("from Scheda s where s.id = :id")
				.setParameter("id", id).uniqueResult();
	}
        
}

