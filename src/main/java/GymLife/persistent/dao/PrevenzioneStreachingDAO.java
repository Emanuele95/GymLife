package GymLife.persistent.dao;


import GymLife.persistent.entity.Esercizio;
import java.util.ArrayList;

public interface PrevenzioneStreachingDAO {
        public ArrayList<Esercizio> getFisioterapiaArray( String muscolo, int corpo_libero, String difficolta, String nome);

}
