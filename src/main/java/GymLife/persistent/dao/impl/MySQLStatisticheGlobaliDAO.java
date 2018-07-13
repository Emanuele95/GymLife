package GymLife.persistent.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import GymLife.persistent.entity.SalvaScheda;
import GymLife.persistent.dao.StatisticheGlobaliDAO;
import GymLife.persistent.entity.Giornata_scheda;
import GymLife.persistent.entity.Scheda;

import GymLife.persistent.entity.User;
import java.util.ArrayList;

public class MySQLStatisticheGlobaliDAO extends SessionFactoryHibernate implements StatisticheGlobaliDAO {

    @Override
    @Transactional
    public ArrayList<Giornata_scheda> getMisurazioniGlobali() {
        @SuppressWarnings("unchecked")
        ArrayList<Giornata_scheda> listResult = ((ArrayList<Giornata_scheda>) getSession().createQuery("from Giornata_scheda")
                .list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }

    @Override
    @Transactional
    public ArrayList<Scheda> getVotazioniGlobali() {
        @SuppressWarnings("unchecked")
        ArrayList<Scheda> listResult = ((ArrayList<Scheda>) getSession().createQuery("from Scheda")
                .list());

        if (listResult == null || listResult.isEmpty()) {
            return null;
        }
        return listResult;
    }
}
