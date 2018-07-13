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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "Giornata_scheda")
public class Giornata_scheda {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "proprietario", referencedColumnName = "id")
    private User proprietario;

    @ManyToOne
    @JoinColumn(name = "scheda", referencedColumnName = "id")
    private Scheda scheda;

    @Column(name = "miglioramento")
    private int miglioramento;

    @Column(name = "n_miglioramento")
    private int n_miglioramento;

    public int getMiglioramento() {
        return miglioramento;
    }

    public void setMiglioramento(int miglioramento) {
        this.miglioramento = miglioramento;
    }

    public int getN_miglioramento() {
        return n_miglioramento;
    }

    public void setN_miglioramento(int n_miglioramento) {
        this.n_miglioramento = n_miglioramento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Giornata_scheda [id=" + id + ", nome=" + nome + ", scheda=" + scheda + ", proprietario" + proprietario + " ]";
    }
}
