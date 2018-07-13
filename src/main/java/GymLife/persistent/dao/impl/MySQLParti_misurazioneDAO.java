package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.Parti_misurazione;
import GymLife.persistent.dao.Parti_misurazioneDAO;
import java.util.ArrayList;


public class MySQLParti_misurazioneDAO extends SessionFactoryHibernate implements Parti_misurazioneDAO  {
	
        public Parti_misurazione getParti_misurazione(String nome) {
		return (Parti_misurazione) getSession().createQuery("from Parti_misurazione u where u.nome = :nome")
				.setParameter("nome", nome).uniqueResult();
	}
}

