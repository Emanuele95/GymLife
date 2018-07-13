package GymLife.model.request;

import java.util.ArrayList;
import org.hibernate.validator.constraints.NotBlank;

public class Profilo_massimaliRequest {

    @NotBlank
    private String username;
    private String esercizio;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(String esercizio) {
        this.esercizio = esercizio;
    }
   

    @Override
    public String toString() {
        return "Profilo_massimaliRequest [esercizio=" + esercizio + "]";
    }

}
