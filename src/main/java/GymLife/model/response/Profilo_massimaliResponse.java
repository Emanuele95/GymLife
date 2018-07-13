package GymLife.model.response;


import GymLife.persistent.entity.Massimale;
import java.util.ArrayList;

public class Profilo_massimaliResponse extends StatusResponse {

    
    ArrayList<Massimale> massimale;

    public ArrayList<Massimale> getMassimale() {
        return massimale;
    }

    public void setMassimale(ArrayList<Massimale> massimale) {
        this.massimale = massimale;
    }

    
    
    @Override
    public String toString() {
        return "Profilo_massimaliResponse [massimale=" + massimale
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getMassimale()="
                + getMassimale() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
