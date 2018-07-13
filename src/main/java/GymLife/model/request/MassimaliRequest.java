package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class MassimaliRequest {

    String username;
    String esercizio;
    String data;
    int valore;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

   

    public String toString() {
        return "MassimaliRequest [username=" + username + ", esercizio="
                + esercizio + ", data=" + data + ", valore=" + valore +"]";
    }

}
