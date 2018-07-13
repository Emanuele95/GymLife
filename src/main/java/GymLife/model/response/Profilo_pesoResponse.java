package GymLife.model.response;


import GymLife.persistent.entity.Misurazione;
import java.util.ArrayList;

public class Profilo_pesoResponse extends StatusResponse {

    
    ArrayList<Misurazione> misuarzione;

    public ArrayList<Misurazione> getMisuarzione() {
        return misuarzione;
    }

    public void setMisuarzione(ArrayList<Misurazione> misuarzione) {
        this.misuarzione = misuarzione;
    }

    @Override
    public String toString() {
        return "Profilo_pesoResponse [misuarzione=" + misuarzione
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getMisuarzione()="
                + getMisuarzione() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
