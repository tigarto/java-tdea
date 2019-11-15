public class Estudiante {
    private String nombre;
    private String id;
    private double [] notas;
    private int numNotas;
    private String login;
    private String password;

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Estudiante() {
        this.nombre = "";
        this.id = "";
        this.numNotas = 0;
    }

    public Estudiante(String nombre, String id, int numNotas) {
        this.nombre = nombre;
        this.id = id;
        this.numNotas = numNotas;
        this.notas = new double[this.numNotas];
        // Inicializando todas las notas a 0
        for(int i = 0; i < notas.length; i++) {
            this.notas[i] = 0.0;
        }
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

    public int ponerNota(int index, double nota) {
        if (index >= numNotas) {
            // Error por nota fuera de indice
            return -1;
        }
        else {
            notas[index] = nota;
            // Todo esta bien
            return 0;
        }
    }

    public double[] getNotas() {
        return notas;
    }

    public double calcularPromedio(double [] porcetajes) {
        double avg = 0;
        for(int i = 0; i < numNotas;i++) {
            avg += notas[i]*porcetajes[i];
        }
        return avg;
    }

    public void imprimirInfoEstudiante(){
        System.out.println("**********************************************************");
        System.out.println("-> Nombre: " + nombre);
        System.out.println("-> Notas: ");
        for (int i = 0; i < numNotas; i++) {
            System.out.format("   %d. %.1f\n",i ,notas[i]);
        }
        System.out.println("**********************************************************");
    }

}
