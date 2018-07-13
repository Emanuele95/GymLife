package GymLife.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "n_allenamenti")
    private int n_allenamenti;
    @Column(name = "n_misurazioni")
    private int n_misurazioni;
    @Column(name = "n_massimali")
    private int n_massimali;

    public int getN_allenamenti() {
        return n_allenamenti;
    }

    public void setN_allenamenti(int n_allenamenti) {
        this.n_allenamenti = n_allenamenti;
    }

    public int getN_misurazioni() {
        return n_misurazioni;
    }

    public void setN_misurazioni(int n_misurazioni) {
        this.n_misurazioni = n_misurazioni;
    }

    public int getN_massimali() {
        return n_massimali;
    }

    public void setN_massimali(int n_massimali) {
        this.n_massimali = n_massimali;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public String toString() {
        return "User [id=" + id + ", nome=" + nome + " ]";
    }

}
