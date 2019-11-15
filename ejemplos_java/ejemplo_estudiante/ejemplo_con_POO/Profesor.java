public class Profesor {
    private String nombre;
    private String id;
    private String login;
    private String password;

    public Profesor(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
