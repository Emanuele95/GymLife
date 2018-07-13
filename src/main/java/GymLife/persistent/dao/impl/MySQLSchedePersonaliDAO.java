package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.SalvaScheda;
import GymLife.persistent.dao.SchedePersonaliDAO;

import GymLife.persistent.entity.User;
import GymLife.persistent.entity.Votazione;
import java.util.ArrayList;

public class MySQLSchedePersonaliDAO extends SessionFactoryHibernate implements SchedePersonaliDAO {

    @Override
    @Transactional
    public ArrayList<SalvaScheda> getSchedePersonali(int id) {
        @SuppressWarnings("unchecked")
        ArrayList<SalvaScheda> listResult = ((ArrayList<SalvaScheda>) getSession().createQuery("from SalvaScheda u join fetch u.id_utilizzatore s where s.id = :id")
                .setParameter("id", id).list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }

    @Override
    @Transactional
    public ArrayList<Votazione> getVotazioniPersonali(int id, int scheda, int proprietario) {
        @SuppressWarnings("unchecked")
        ArrayList<Votazione> listResult = ((ArrayList<Votazione>) getSession().createQuery("from Votazione u join fetch u.id_votante s where s.id = :id")
                .setParameter("id", id).list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }
    
    
	@Transactional
	public void addVotazione(Votazione votazione) {
        getSession().save(votazione);  
        getSession().flush();  
          
	}
}
