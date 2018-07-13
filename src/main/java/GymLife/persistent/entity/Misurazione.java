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
@Table(name = "Misurazione")
public class Misurazione {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    
    @ManyToOne
    @JoinColumn(name = "parte")
    private Parti_misurazione parte;

    @Column(name = "data")
    private String data;

    @Column(name = "n_misurazione")
    private int n_misurazione;

    @Column(name = "valore")
    private int valore;

    @Column(name = "misura")
    private String misura;

    public int getN_misurazione() {
        return n_misurazione;
    }

    public void setN_misurazione(int n_misurazione) {
        this.n_misurazione = n_misurazione;
    }

    public Parti_misurazione getParte() {
        return parte;
    }

    public void setParte(Parti_misurazione parte) {
        this.parte = parte;
    }

    
    public int getValore() {
        return valore;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public String getMisura() {
        return misura;
    }

    public void setMisura(String misura) {
        this.misura = misura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Misurazione [data=" + data + ", user=" + user + ", parte="+ parte +"]";
    }
}
