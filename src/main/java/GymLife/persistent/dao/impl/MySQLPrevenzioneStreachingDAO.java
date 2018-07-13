package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.Esercizio;
import GymLife.persistent.dao.PrevenzioneStreachingDAO;
import java.util.ArrayList;


public class MySQLPrevenzioneStreachingDAO extends SessionFactoryHibernate implements PrevenzioneStreachingDAO  {
	
        
        @Override
	@Transactional
	public ArrayList<Esercizio> getFisioterapiaArray(String muscolo, int corpo_libero, String difficolta, String nome) {
		@SuppressWarnings("unchecked")
		ArrayList<Esercizio> listResult = ((ArrayList<Esercizio>) getSession().createQuery("FROM Esercizio e WHERE e.muscolo LIKE :muscolo AND e.corpo_libero LIKE :corpo_libero AND e.difficolta LIKE :difficolta AND e.nome LIKE :nome AND e.salute = 1")
				.setParameter("muscolo", muscolo).setParameter("corpo_libero", corpo_libero).setParameter("difficolta", difficolta).setParameter("nome", nome).list());
		if(listResult == null || listResult.isEmpty()) return null;
		return listResult;
	}	
}

