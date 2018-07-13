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
@Table(name = "Schede_personali")
public class SalvaScheda {

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
    @JoinColumn(name = "id_utilizzatore", referencedColumnName = "id")
    private User id_utilizzatore;

    @Column(name = "visibile")
    private int visibile;

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

    public User getId_utilizzatore() {
        return id_utilizzatore;
    }

    public void setId_utilizzatore(User id_utilizzatore) {
        this.id_utilizzatore = id_utilizzatore;
    }

    public int getVisibile() {
        return visibile;
    }

    public void setVisibile(int visibile) {
        this.visibile = visibile;
    }

    @Override
    public String toString() {
        return "SchedaPersonale [scheda=" + scheda + ", visibile=" + visibile + " ]";
    }
}
