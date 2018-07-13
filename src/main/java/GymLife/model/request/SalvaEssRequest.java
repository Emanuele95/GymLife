package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class SalvaEssRequest {

    String nome;
    String esercizio;
    int posizione;
    int giornata;
    int scheda;
    int proprietario;
    int ripetizioni_riuscite;
    float peso_usato;
    float peso_consigliato;
    int ripetizioni_originali;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(String esercizio) {
        this.esercizio = esercizio;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public int getGiornata() {
        return giornata;
    }

    public void setGiornata(int giornata) {
        this.giornata = giornata;
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

    public int getRipetizioni_riuscite() {
        return ripetizioni_riuscite;
    }

    public void setRipetizioni_riuscite(int ripetizioni_riuscite) {
        this.ripetizioni_riuscite = ripetizioni_riuscite;
    }

    public float getPeso_usato() {
        return peso_usato;
    }

    public void setPeso_usato(float peso_usato) {
        this.peso_usato = peso_usato;
    }

    public float getPeso_consigliato() {
        return peso_consigliato;
    }

    public void setPeso_consigliato(float peso_consigliato) {
        this.peso_consigliato = peso_consigliato;
    }

    public int getRipetizioni_originali() {
        return ripetizioni_originali;
    }

    public void setRipetizioni_originali(int ripetizioni_originali) {
        this.ripetizioni_originali = ripetizioni_originali;
    }
    
    public String toString() {
        return "SalvaEssRequest [nome=" + nome + "]";
    }

}
