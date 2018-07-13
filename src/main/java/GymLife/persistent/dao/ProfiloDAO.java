package GymLife.persistent.dao;

import GymLife.persistent.entity.Massimale;
import GymLife.persistent.entity.Misurazione;
import GymLife.persistent.entity.Storico_allenamento;
import GymLife.persistent.entity.Storico_esercizio;


import java.util.ArrayList;

public interface ProfiloDAO {

    public ArrayList<Massimale> getMassimaliProfilo(int user, String esercizio);

    public ArrayList<Misurazione> getMisurazioniProfilo(int user, String parte);

    public ArrayList<Misurazione> getPesoProfilo(int user, String parte);

    public ArrayList<Storico_allenamento> getIntensitaProfilo(int user);

    public ArrayList<Storico_esercizio> getChiusuraProfilo(int user);

}
