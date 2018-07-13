package GymLife.model.request;

import java.util.ArrayList;
import org.hibernate.validator.constraints.NotBlank;

public class Profilo_intensitaRequest {

    @NotBlank
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
    @Override
    public String toString() {
        return "Profilo_intensitaRequest []";
    }

}
