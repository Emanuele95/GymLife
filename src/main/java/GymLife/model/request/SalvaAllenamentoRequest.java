package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class SalvaAllenamentoRequest {

    String nome;
    String data;
    String inizio;
    String fine;
    int scheda;
    int giornata;
    int proprietario;
    String note;
    int intensita;
    int modifica_stats;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getInizio() {
        return inizio;
    }

    public void setInizio(String inizio) {
        this.inizio = inizio;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public int getScheda() {
        return scheda;
    }

    public void setScheda(int scheda) {
        this.scheda = scheda;
    }

    public int getGiornata() {
        return giornata;
    }

    public void setGiornata(int giornata) {
        this.giornata = giornata;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIntensita() {
        return intensita;
    }

    public void setIntensita(int intensita) {
        this.intensita = intensita;
    }

    public int getModifica_stats() {
        return modifica_stats;
    }

    public void setModifica_stats(int modifica_stats) {
        this.modifica_stats = modifica_stats;
    }
    
    public String toString() {
        return "SalvaAllenamentoRequest [nome=" + nome + "]";
    }

}
