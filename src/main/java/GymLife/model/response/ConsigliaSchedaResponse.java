package GymLife.model.response;


import GymLife.persistent.entity.Esercizio_giornata;
import java.util.ArrayList;

public class ConsigliaSchedaResponse extends StatusResponse {

    
    ArrayList<Esercizio_giornata> schede;

    public ArrayList<Esercizio_giornata> getSchede() {
        return schede;
    }

    public void setSchede(ArrayList<Esercizio_giornata> schede) {
        this.schede = schede;
    }

   
  
    @Override
    public String toString() {
        return "ConsigliaSchedaResponse [schede=" + schede
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getSchede()="
                + getSchede() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
