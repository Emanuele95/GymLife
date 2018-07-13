package GymLife.model.request;

import GymLife.persistent.entity.Esercizio;
import java.util.ArrayList;
import org.hibernate.validator.constraints.NotBlank;

public class PrevenzioneStreachingRequest {

    @NotBlank
    private String muscolo;
    private int corpo_libero;
    private String difficolta;
    private String nome;
    ArrayList<Esercizio> exercises;

    public ArrayList<Esercizio> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Esercizio> exercises) {
        this.exercises = exercises;
    }

    public String getMuscolo() {
        return muscolo;
    }

    public void setMuscolo(String muscolo) {
        this.muscolo = muscolo;
    }

    public int getCorpo_libero() {
        return corpo_libero;
    }

    public void setCorpo_libero(int corpo_libero) {
        this.corpo_libero = corpo_libero;
    }

    public String getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(String difficolta) {
        this.difficolta = difficolta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PrevenzioneStreachingRequest [muscolo=" + muscolo + ", difficolta=" + difficolta + ", corpo_libero=" + corpo_libero + " , nome=" + nome + "]";
    }

}
