package GymLife.persistent.dao;

import GymLife.persistent.entity.Storico_esercizio;
import GymLife.persistent.entity.Storico_allenamento;
import GymLife.persistent.entity.Massimale;
import GymLife.persistent.entity.Misurazione;

import java.util.ArrayList;

public interface ArchivioDAO {

    public ArrayList<Massimale> getMassimaleArchivio(int user, String data);

    public ArrayList<Misurazione> getMisurazioneArchivio(int user, String data);

    public ArrayList<Storico_esercizio> getEsercizioArchivio(int user, int n_allenamento);

    public ArrayList<Storico_allenamento> getAllenamentoArchivio(int user, String data);

}
