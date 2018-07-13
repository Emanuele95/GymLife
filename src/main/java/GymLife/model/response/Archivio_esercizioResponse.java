package GymLife.model.response;


import GymLife.persistent.entity.Storico_esercizio;
import java.util.ArrayList;

public class Archivio_esercizioResponse extends StatusResponse {

    
    ArrayList<Storico_esercizio> esercizio;

    public ArrayList<Storico_esercizio> getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(ArrayList<Storico_esercizio> esercizio) {
        this.esercizio = esercizio;
    }
  
    @Override
    public String toString() {
        return "Archivio_esercizioResponse [allenamento=" + esercizio
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getEsercizio()="
                + getEsercizio() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
