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
@Table(name = "Storico_Allenamento")
public class Storico_allenamento {

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
    @JoinColumn(name = "giornata", referencedColumnName = "id")
    private Giornata_scheda giornata;

    @ManyToOne
    @JoinColumn(name = "scheda", referencedColumnName = "id")
    private Scheda scheda;

    @ManyToOne
    @JoinColumn(name = "proprietario", referencedColumnName = "id")
    private User proprietario;

    @Column(name = "data")
    private String data;

    @Column(name = "ora_inizio")
    private String ora_inizio;

    @Column(name = "ora_fine")
    private String ora_fine;

    @Column(name = "note")
    private String note;

    @Column(name = "intensità")
    private int intensità;

    @Column(name = "modifica_stats")
    private int modifica_stats;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra_inizio() {
        return ora_inizio;
    }

    public void setOra_inizio(String ora_inizio) {
        this.ora_inizio = ora_inizio;
    }

    public String getOra_fine() {
        return ora_fine;
    }

    public void setOra_fine(String ora_fine) {
        this.ora_fine = ora_fine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIntensità() {
        return intensità;
    }

    public void setIntensità(int intensità) {
        this.intensità = intensità;
    }

    public int getModifica_stats() {
        return modifica_stats;
    }

    public void setModifica_stats(int modifica_stats) {
        this.modifica_stats = modifica_stats;
    }
   
    @Override
    public String toString() {
        return "Storico_allenamento [id=" + id + "]";
    }
}
