package GymLife.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Esercizio_giornata")
public class Esercizio_giornata {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "giornata" ,referencedColumnName = "id")
    private Giornata_scheda giornata;
 
    @ManyToOne
    @JoinColumn(name = "proprietario" ,referencedColumnName = "id")
    private User proprietario;
   
    @ManyToOne
    @JoinColumn(name = "scheda", referencedColumnName = "id")
    private Scheda scheda;

    @ManyToOne
    @JoinColumn(name = "nome",referencedColumnName = "nome")
    private Esercizio nome;
    
    @Column(name = "posizione")
    private int posizione;

    @Column(name = "n_ripetizioni")
    private int n_ripetizioni;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Giornata_scheda getGiornata() {
        return giornata;
    }

    public void setGiornata(Giornata_scheda giornata) {
        this.giornata = giornata;
    }

    public User getProprietario() {
        return proprietario;
    }

    public void setProprietario(User proprietario) {
        this.proprietario = proprietario;
    }

    public Scheda getScheda() {
        return scheda;
    }

    public void setScheda(Scheda scheda) {
        this.scheda = scheda;
    }

    public Esercizio getNome() {
        return nome;
    }

    public void setNome(Esercizio nome) {
        this.nome = nome;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public int getN_ripetizioni() {
        return n_ripetizioni;
    }

    public void setN_ripetizioni(int n_ripetizioni) {
        this.n_ripetizioni = n_ripetizioni;
    }

   

    @Override
    public String toString() {
        return "Esercizio_giornata [id=" + id + ", giornata=" + giornata + ", proprietario=" + proprietario + ", scheda=" + 
                scheda + ", nome=" + nome + ", posizione=" + posizione +",n_ripetizioni=" + n_ripetizioni + " ]";
    }
}
