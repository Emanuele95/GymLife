package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class VotazioneRequest {

    String user;
    int scheda;
    int proprietario;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getScheda() {
        return scheda;
    }

    public void setScheda(int scheda) {
        this.scheda = scheda;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    
    public String toString() {
        return "VotazioneRequest []";
    }

}
