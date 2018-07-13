package GymLife.model.response;


import GymLife.persistent.entity.Misurazione;
import java.util.ArrayList;

public class Archivio_misurazioneResponse extends StatusResponse {

    
    ArrayList<Misurazione> misurazione;

    public ArrayList<Misurazione> getMisurazione() {
        return misurazione;
    }

    public void setMisurazione(ArrayList<Misurazione> misurazione) {
        this.misurazione = misurazione;
    }

    @Override
    public String toString() {
        return "Archivio_misurazioneResponse [misurazione=" + misurazione
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getMisurazione()="
                + getMisurazione() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
