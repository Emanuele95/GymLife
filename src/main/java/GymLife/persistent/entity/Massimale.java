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
@Table(name = "Massimale")
public class Massimale {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "esercizio")
    private Esercizio esercizio;

    @Column(name = "valore")
    private int valore;

    @Column(name = "n_massimale")
    private int n_massimale;

    @Column(name = "data")
    private String data;

    public int getN_massimale() {
        return n_massimale;
    }

    public void setN_massimale(int n_massimale) {
        this.n_massimale = n_massimale;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

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

    public Esercizio getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(Esercizio esercizio) {
        this.esercizio = esercizio;
    }

    @Override
    public String toString() {
        return "Massimale [user=" + user + ", esercizio=" + esercizio + ", data=" + data + ", valore=" + valore + ",  n_massimale=" + n_massimale + " ]";
    }
}
