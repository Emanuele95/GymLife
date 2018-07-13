package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class AllenatiRequest {

    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   

    public String toString() {
        return "AllenatiRequest [nome=" + nome + "]";
    }

}
