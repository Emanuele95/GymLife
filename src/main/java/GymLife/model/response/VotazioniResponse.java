package GymLife.model.response;

import GymLife.persistent.entity.Scheda;
import java.util.ArrayList;

public class VotazioniResponse extends StatusResponse {

    ArrayList<Scheda> votazioni;

    public ArrayList<Scheda> getVotazioni() {
        return votazioni;
    }

    public void setVotazioni(ArrayList<Scheda> votazioni) {
        this.votazioni = votazioni;
    }

    

    @Override
    public String toString() {
        return "VotazioniResponse [votazioni=" + votazioni
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getVotazioni()="
                + getVotazioni() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
