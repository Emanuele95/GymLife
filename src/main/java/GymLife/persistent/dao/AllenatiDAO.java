package GymLife.persistent.dao;

import GymLife.persistent.entity.Storico_esercizio;
import GymLife.persistent.entity.Storico_allenamento;
import GymLife.persistent.entity.Massimale;

import java.util.ArrayList;

public interface AllenatiDAO {

    public ArrayList<Massimale> getMassimaliPersonali(int user);

    public void addEss(Storico_esercizio esercizio);
    
    public void addAllenamento(Storico_allenamento allenamento);
    
}
