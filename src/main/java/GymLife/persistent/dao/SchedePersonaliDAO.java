package GymLife.persistent.dao;

import GymLife.persistent.entity.SalvaScheda;
import GymLife.persistent.entity.Votazione;
import java.util.ArrayList;

public interface SchedePersonaliDAO {

    public ArrayList<SalvaScheda> getSchedePersonali(int id_utilizzatore);

    public ArrayList<Votazione> getVotazioniPersonali(int id_votante, int scheda, int proprietario);
    
    public void addVotazione(Votazione votazione);

}
