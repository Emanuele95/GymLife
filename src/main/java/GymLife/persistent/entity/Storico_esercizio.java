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
@Table(name = "Storico_Esercizio")
public class Storico_esercizio {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @Column(name = "n_allenamento")
    private int n_allenamento;

    @ManyToOne
    @JoinColumn(name = "esercizio")
    private Esercizio esercizio;

    @Column(name = "posizione")
    private int posizione;

    @ManyToOne
    @JoinColumn(name = "giornata", referencedColumnName = "id")
    private Giornata_scheda giornata;

    @ManyToOne
    @JoinColumn(name = "scheda", referencedColumnName = "id")
    private Scheda scheda;

    @ManyToOne
    @JoinColumn(name = "proprietario", referencedColumnName = "id")
    private User proprietario;

    @Column(name = "ripetizioni_riuscite")
    private int ripetizioni_riuscite;

    @Column(name = "peso_usato")
    private float peso_usato;

    @Column(name = "peso_consigliato")
    private float peso_consigliato;
    
     @Column(name = "ripetizioni_originali")
    private int ripetizioni_originali;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getN_allenamento() {
        return n_allenamento;
    }

    public void setN_allenamento(int n_allenamento) {
        this.n_allenamento = n_allenamento;
    }

    public Esercizio getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(Esercizio esercizio) {
        this.esercizio = esercizio;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public Giornata_scheda getGiornata() {
        return giornata;
    }

    public void setGiornata(Giornata_scheda giornata) {
        this.giornata = giornata;
    }

    public Scheda getScheda() {
        return scheda;
    }

    public void setScheda(Scheda scheda) {
        this.scheda = scheda;
    }

    public User getProprietario() {
        return proprietario;
    }

    public void setProprietario(User proprietario) {
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
    

    @Override
    public String toString() {
        return "Storico_esercizio [id=" + id + "]";
    }
}
