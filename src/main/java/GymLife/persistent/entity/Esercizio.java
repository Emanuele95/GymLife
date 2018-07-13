package GymLife.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Esercizio")
public class Esercizio {

    @Id
    @Column(name = "nome")
    private String nome;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "consigli")
    private String consigli;
    @Column(name = "corpo_libero")
    private int corpo_libero;
    @Column(name = "difficolta")
    private String difficolta;
    @Column(name = "muscolo")
    private String muscolo;
     @Column(name = "salute")
    private int salute;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSalute() {
        return salute;
    }

    public void setSalute(int salute) {
        this.salute = salute;
    }

    
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getConsigli() {
        return consigli;
    }

    public void setConsigli(String consigli) {
        this.consigli = consigli;
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

    public String getMuscolo() {
        return muscolo;
    }

    public void setMuscolo(String muscolo) {
        this.muscolo = muscolo;
    }

    @Override
    public String toString() {
        return "Esercizio [nome=" + nome + ", consigli=" + consigli + ", corpo_libero=" + corpo_libero
                + ", difficolta=" + difficolta
                + ", muscolo=" + muscolo + ", salute=" + salute +"]";
    }
}
