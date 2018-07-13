package GymLife.model.request;

import java.util.ArrayList;
import org.hibernate.validator.constraints.NotBlank;

public class Profilo_pesoRequest {

    @NotBlank
    private String username;
    private String parte;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

    @Override
    public String toString() {
        return "Profilo_pesoRequest [parte=" + parte + "]";
    }

}
