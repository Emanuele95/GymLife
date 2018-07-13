package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Archivio_esercizioRequest {

    String user;
    int n_allenamento;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getN_allenamento() {
        return n_allenamento;
    }

    public void setN_allenamento(int n_allenamento) {
        this.n_allenamento = n_allenamento;
    }

    public String toString() {
        return "Archivio_esercizioRequest [n_allenamento=" + n_allenamento + "]";
    }

}
