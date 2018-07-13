package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.Massimale;
import GymLife.persistent.dao.ProfiloDAO;
import GymLife.persistent.entity.Misurazione;
import GymLife.persistent.entity.Storico_allenamento;
import GymLife.persistent.entity.Storico_esercizio;
import java.util.ArrayList;

public class MySQLProfiloDAO extends SessionFactoryHibernate implements ProfiloDAO {

    @Override
    @Transactional
    public ArrayList<Massimale> getMassimaliProfilo(int id, String nome) {
        @SuppressWarnings("unchecked")
        ArrayList<Massimale> listResult = ((ArrayList<Massimale>) getSession().createQuery("from Massimale m join fetch m.user s  join fetch m.esercizio e where s.id = :id and e.nome = :nome")
                .setParameter("id", id).setParameter("nome", nome).list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }

    @Override
    @Transactional
    public ArrayList<Misurazione> getMisurazioniProfilo(int id, String nome) {
        @SuppressWarnings("unchecked")
        ArrayList<Misurazione> listResult = ((ArrayList<Misurazione>) getSession().createQuery("from Misurazione m join fetch m.user s  join fetch m.parte e where s.id = :id and e.nome = :nome")
                .setParameter("id", id).setParameter("nome", nome).list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }

    @Override
    @Transactional
    public ArrayList<Misurazione> getPesoProfilo(int id, String nome) {
        @SuppressWarnings("unchecked")
        ArrayList<Misurazione> listResult = ((ArrayList<Misurazione>) getSession().createQuery("from Misurazione m join fetch m.user s  join fetch m.parte e where s.id = :id and e.nome = :nome")
                .setParameter("id", id).setParameter("nome", nome).list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }

    @Override
    @Transactional
    public ArrayList<Storico_allenamento> getIntensitaProfilo(int id) {
        @SuppressWarnings("unchecked")
        ArrayList<Storico_allenamento> listResult = ((ArrayList<Storico_allenamento>) getSession().createQuery("from Storico_allenamento m join fetch m.user s where s.id = :id")
                .setParameter("id", id).list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }
    
    @Override
    @Transactional
    public ArrayList<Storico_esercizio> getChiusuraProfilo(int id) {
        @SuppressWarnings("unchecked")
        ArrayList<Storico_esercizio> listResult = ((ArrayList<Storico_esercizio>) getSession().createQuery("from Storico_esercizio m join fetch m.user s where s.id = :id")
                .setParameter("id", id).list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }

}
