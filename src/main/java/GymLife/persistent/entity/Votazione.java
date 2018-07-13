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
@Table(name = "Votazione")
public class Votazione {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "scheda", referencedColumnName = "id")
    private Scheda scheda;

    @ManyToOne
    @JoinColumn(name = "proprietario", referencedColumnName = "id")
    private User proprietario;

    @ManyToOne
    @JoinColumn(name = "id_votante", referencedColumnName = "id")
    private User id_votante;

    @Column(name = "voto")
    private int voto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getId_votante() {
        return id_votante;
    }

    public void setId_votante(User id_votante) {
        this.id_votante = id_votante;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "SchedaPersonale [scheda=" + scheda + ", voto=" + voto + " ]";
    }
}
