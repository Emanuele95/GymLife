package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class SalvaSchedaRequest {

    int scheda;
    String id_utilizzatore;
    String proprietario;
    int visibile;

    public int getScheda() {
        return scheda;
    }

    public void setScheda(int scheda) {
        this.scheda = scheda;
    }

    public String getId_utilizzatore() {
        return id_utilizzatore;
    }

    public void setId_utilizzatore(String id_utilizzatore) {
        this.id_utilizzatore = id_utilizzatore;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public int getVisibile() {
        return visibile;
    }

    public void setVisibile(int visibile) {
        this.visibile = visibile;
    }

   
    public String toString() {
        return "SalvaSchedaRequest [scheda=" + scheda + ", id_utilizzatore="
                + id_utilizzatore + ", proprietario=" + proprietario + ", visibile=" + visibile +"]";
    }

}
