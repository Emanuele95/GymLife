package GymLife.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ArchivioRequest {

    String user;
    String data;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

   

    public String toString() {
        return "ArchivioRequest [data=" + data + "]";
    }

}
