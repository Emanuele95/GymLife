package GymLife.model.response;

import java.util.ArrayList;
import GymLife.persistent.entity.Esercizio;


public class PrevenzioneStreachingResponse extends StatusResponse {

    ArrayList<Esercizio> exercises;

    public ArrayList<Esercizio> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Esercizio> exercises) {
        this.exercises = exercises;
    }

  
    @Override
    public String toString() {
        return "PrevenzioneStreachingResponse [exercises=" + exercises
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getExercises()="
                + getExercises() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
