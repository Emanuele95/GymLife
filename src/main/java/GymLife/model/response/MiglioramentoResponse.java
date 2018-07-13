package GymLife.model.response;

import GymLife.persistent.entity.Giornata_scheda;
import java.util.ArrayList;

public class MiglioramentoResponse extends StatusResponse {

    ArrayList<Giornata_scheda> miglioramento;

    public ArrayList<Giornata_scheda> getMiglioramento() {
        return miglioramento;
    }

    public void setMiglioramento(ArrayList<Giornata_scheda> miglioramento) {
        this.miglioramento = miglioramento;
    }

    @Override
    public String toString() {
        return "MiglioramentoResponse [miglioramento=" + miglioramento
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getMiglioramento()="
                + getMiglioramento() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
