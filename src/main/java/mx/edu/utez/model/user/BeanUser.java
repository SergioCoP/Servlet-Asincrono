package mx.edu.utez.model.user;

public class BeanUser {

    private int idUser;
    private String nameuser;
    private String lastnameUser;
    private String email;
    private String password;
    private int Status;

    public BeanUser() {
    }

    public BeanUser(int idUser, String nameuser, String lastnameUser, String email, String password, int status) {
        this.idUser = idUser;
        this.nameuser = nameuser;
        this.lastnameUser = lastnameUser;
        this.email = email;
        this.password = password;
        Status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
