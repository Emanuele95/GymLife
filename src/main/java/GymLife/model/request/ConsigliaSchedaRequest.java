package GymLife.model.request;

import GymLife.persistent.entity.Esercizio_giornata;
import GymLife.persistent.entity.Scheda;
import java.util.ArrayList;
import org.hibernate.validator.constraints.NotBlank;

public class ConsigliaSchedaRequest {

    @NotBlank
    private String regime;
    private int n_giorni;
    private String difficolta;
    ArrayList<Esercizio_giornata> schede;

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public int getN_giorni() {
        return n_giorni;
    }

    public void setN_giorni(int n_giorni) {
        this.n_giorni = n_giorni;
    }

    public String getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(String difficolta) {
        this.difficolta = difficolta;
    }

    public ArrayList<Esercizio_giornata> getSchede() {
        return schede;
    }

    public void setSchede(ArrayList<Esercizio_giornata> schede) {
        this.schede = schede;
    }

    @Override
    public String toString() {
        return "ConsigliaScheda [schede=" + schede + ", regime=" + regime + ", n_giorni=" + n_giorni + ",difficolta=" + difficolta + "]";
    }

}
