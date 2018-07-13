package GymLife.model.response;


import GymLife.persistent.entity.Votazione;
import GymLife.persistent.entity.User;
import java.util.ArrayList;

public class VotazioneResponse extends StatusResponse {

    
    ArrayList<Votazione> votazione;

    public ArrayList<Votazione> getVotazione() {
        return votazione;
    }

    public void setVotazione(ArrayList<Votazione> votazione) {
        this.votazione = votazione;
    }

    @Override
    public String toString() {
        return "VotazioneResponse [votazione=" + votazione
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getVotazione()="
                + getVotazione() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
