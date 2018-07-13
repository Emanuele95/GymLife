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
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "Scheda")
public class Scheda {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "proprietario", referencedColumnName = "id")
    private User proprietario;

    @Column(name = "regime")
    private String regime;

    @Column(name = "n_giorni")
    private int n_giorni;

    @Column(name = "valutazione")
    private int valutazione;

    @Column(name = "n_valutazione")
    private int n_valutazione;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "difficolta")
    private String difficolta;

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

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public int getN_giorni() {
        return n_giorni;
    }

    public void setN_giorni(int n_giorni) {
        this.n_giorni = n_giorni;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public int getN_valutazione() {
        return n_valutazione;
    }

    public void setN_valutazione(int n_valutazione) {
        this.n_valutazione = n_valutazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(String difficolta) {
        this.difficolta = difficolta;
    }


    @Override
    public String toString() {
        return "Scheda [id=" + id + ", nome=" + nome + ", proprietario=" + proprietario
                + ", regime=" + regime
                + ", n_giorni=" + n_giorni + ", valutazione=" + valutazione + ", n_valutazione=" + n_valutazione
                + ", descrizione=" + descrizione + ", difficolta=" + difficolta + "]";
    }
}
