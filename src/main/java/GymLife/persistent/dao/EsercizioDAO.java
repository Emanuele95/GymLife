package GymLife.persistent.dao;


import GymLife.persistent.entity.Esercizio;
import java.util.ArrayList;

public interface EsercizioDAO {
        public ArrayList<Esercizio> getEserciziArray( String muscolo, int corpo_libero, String difficolta, String nome);
        public Esercizio getEsercizio(String nome);


}
