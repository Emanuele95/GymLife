package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.Massimale;
import GymLife.persistent.dao.ArchivioDAO;
import GymLife.persistent.entity.Giornata_scheda;
import GymLife.persistent.entity.Misurazione;
import GymLife.persistent.entity.Storico_allenamento;
import GymLife.persistent.entity.Storico_esercizio;
import java.util.ArrayList;


public class MySQLArchivioDAO extends SessionFactoryHibernate implements ArchivioDAO  {
	
        
        @Override
	@Transactional
	public ArrayList<Massimale>  getMassimaleArchivio(int id, String data){
		@SuppressWarnings("unchecked")
		ArrayList<Massimale> listResult = ((ArrayList<Massimale>) getSession().createQuery("from Massimale m join fetch m.user s where s.id = :id and m.data= :data")
                 .setParameter("id", id).setParameter("data", data).list());
			
		if(listResult == null || listResult.isEmpty()) return null;
		return listResult;
	}
        
       
        @Override
	@Transactional
	public ArrayList<Misurazione>  getMisurazioneArchivio(int id, String data){
		@SuppressWarnings("unchecked")
		ArrayList<Misurazione> listResult = ((ArrayList<Misurazione>) getSession().createQuery("from Misurazione m join fetch m.user s where s.id = :id and m.data= :data")
                 .setParameter("id", id).setParameter("data", data).list());
			
		if(listResult == null || listResult.isEmpty()) return null;
		return listResult;
	}
        
       
        @Override
	@Transactional
	public ArrayList<Storico_esercizio>  getEsercizioArchivio(int id, int n_allenamento){
		@SuppressWarnings("unchecked")
		ArrayList<Storico_esercizio> listResult = ((ArrayList<Storico_esercizio>) getSession().createQuery("from Storico_esercizio m join fetch m.user s where s.id = :id and m.n_allenamento = :n_allenamento")
                 .setParameter("id", id).setParameter("n_allenamento", n_allenamento).list());
			
		if(listResult == null || listResult.isEmpty()) return null;
		return listResult;
	}
        
        @Override
	@Transactional
	public ArrayList<Storico_allenamento>  getAllenamentoArchivio(int id, String data){
		@SuppressWarnings("unchecked")
		ArrayList<Storico_allenamento> listResult = ((ArrayList<Storico_allenamento>) getSession().createQuery("from Storico_allenamento m join fetch m.user s where s.id = :id and m.data= :data")
                 .setParameter("id", id).setParameter("data", data).list());
			
		if(listResult == null || listResult.isEmpty()) return null;
		return listResult;
	}
}

