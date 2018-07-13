package GymLife.persistent.dao;

import GymLife.persistent.entity.Esercizio_giornata;
import GymLife.persistent.entity.Scheda;
import java.util.ArrayList;

public interface SchedaDAO {

    public ArrayList<Esercizio_giornata> getSchedeArray(String regime, int n_giorni, String difficolta);

    public Scheda getScheda(int id);

}
