package GymLife.model.response;


import GymLife.persistent.entity.Massimale;
import java.util.ArrayList;

public class AllenatiResponse extends StatusResponse {

    
    ArrayList<Massimale> massimali;

    public ArrayList<Massimale> getMassimali() {
        return massimali;
    }

    public void setMassimali(ArrayList<Massimale> massimali) {
        this.massimali = massimali;
    }
    
    @Override
    public String toString() {
        return "AllenatiResponse [massimali=" + massimali
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getSchede()="
                + getMassimali() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
