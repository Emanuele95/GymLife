package GymLife.model.response;


import GymLife.persistent.entity.SalvaScheda;
import GymLife.persistent.entity.User;
import java.util.ArrayList;

public class SchedePersonaliResponse extends StatusResponse {

    
    ArrayList<SalvaScheda> schede;

    public ArrayList<SalvaScheda> getSchede() {
        return schede;
    }

    public void setSchede(ArrayList<SalvaScheda> schede) {
        this.schede = schede;
    }

   
  
    @Override
    public String toString() {
        return "SchedePersonaliResponse [schede=" + schede
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getSchede()="
                + getSchede() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
