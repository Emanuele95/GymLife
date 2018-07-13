package GymLife.persistent.dao;

import GymLife.persistent.entity.Giornata_scheda;
import GymLife.persistent.entity.Scheda;

import java.util.ArrayList;

public interface StatisticheGlobaliDAO {

    public ArrayList<Giornata_scheda> getMisurazioniGlobali();

    public ArrayList<Scheda> getVotazioniGlobali();

}
