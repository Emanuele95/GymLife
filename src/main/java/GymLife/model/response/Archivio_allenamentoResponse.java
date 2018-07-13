package GymLife.model.response;


import GymLife.persistent.entity.Storico_allenamento;
import java.util.ArrayList;

public class Archivio_allenamentoResponse extends StatusResponse {

    
    ArrayList<Storico_allenamento> allenamento;

    public ArrayList<Storico_allenamento> getAllenamento() {
        return allenamento;
    }

    public void setAllenamento(ArrayList<Storico_allenamento> allenamento) {
        this.allenamento = allenamento;
    }

    
  
    @Override
    public String toString() {
        return "Archivio_allenamentoResponse [allenamento=" + allenamento
                + ", esito=" + esito
                + ", descrizione=" + descrizione + ", getAllenamento()="
                + getAllenamento() + ", isEsito()=" + isEsito() + ", getDescrizione()="
                + getDescrizione() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + "]";
    }

}
