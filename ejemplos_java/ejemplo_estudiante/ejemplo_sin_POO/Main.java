import java.util.Scanner;

public class Main {

    static int numEstudiantes;
    static int numNotas;
    static double notas[][];
    static String estudiantes[][];
    static String infoProfesor[];
    static double porcentajes[];
    static String loginInfo[][];

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        test1();





    }

    /*
    * Carga el estado inicial del sistema
    * */
    public static void inicializarSistema() {
        // Se asumen solo dos alumnos
        numEstudiantes = 2;
        estudiantes = new String[numEstudiantes][2];


        inicializarEstudiante(0, "Bart Simpson", "001");
        inicializarEstudiante(1, "Milhouse Mussolini", "002");
        // Creando array de notas e inicializandolo a 0
        numNotas = 2;
        notas = new double[numEstudiantes][numNotas];
        inicializarNotas(notas,numEstudiantes,numNotas);

        // Inicializando porcentajes
        porcentajes = new double[numNotas];
        porcentajes[0] = 0.45;
        porcentajes[1] = 0.55;

        // Inicializando informacion del profesor

        infoProfesor = new String[2];
        infoProfesor[0] = "skinner"; // login
        infoProfesor[1] = "123456";  // password

        loginInfo = new String[numEstudiantes + 1][2];
        // Bart
        loginInfo[0][0] = "b1";
        loginInfo[0][1] = "123";
        // Milhouse
        loginInfo[1][0] = "m1";
        loginInfo[1][1] = "456";
        // Skinner
        //loginInfo[2][0] = "skinner";
        //loginInfo[2][1] = "123456";


    }

    public static void inicializarEstudiante(int i, String nombre, String id) {
        estudiantes[i][0] = nombre;
        estudiantes[i][1] = id;
        //estudiantes[i][2] = login;
        //estudiantes[i][3] = pass;
    }

    public static void inicializarNotas(double N[][], int nEst, int nNotas) {
        for (int i = 0; i < nEst; i++) {
            for (int j = 0; j < nNotas; j++) {
                N[i][j] = (double) 0;
            }
        }
    }

    public static void imprimirNotas() {
        System.out.format("%-30s  %9s %8s\n","Nombre","Nota 1","Nota 2");
        for (int i = 0; i < numEstudiantes; i++) {
            // https://docs.oracle.com/javase/tutorial/essential/io/formatting.html
            System.out.format("%-27s  ",estudiantes[i][0]);
            for (int j = 0; j < numNotas; j++) {
                System.out.format("%9.1f",notas[i][j]);
            }
            System.out.println();
        }
    }

    public static int obtenerIndiceEstudiante(String id) {
        int index = 0;
        boolean indexEncontrado = false;
        for (int i = 0; i < numEstudiantes; i++) {
            if (estudiantes[i][1].equals(id)== true) {
                index = i;
                indexEncontrado = true;
                break;
            }
        }
        if (indexEncontrado == true) {
            return index;
        }
        else {
            return -1;
        }
    }

    public static void asignarNota(String id, int numNota, double valor) {
        int indexEstudiante = obtenerIndiceEstudiante(id);
        if (indexEstudiante == -1) {
            System.out.println("ERROR!!!, estudiante no encontrado");
        }
        else {
            notas[indexEstudiante][numNota] = valor;
            System.out.println("Nota " + valor + " asignada.");
        }
    }


    public static double [] consultarNotasEstudiante(String id) {
        int indexEstudiante = obtenerIndiceEstudiante(id);
        double [] notasEst = new double[numNotas];
        if (indexEstudiante == -1) {
            System.out.println("ERROR!!!, estudiante no encontrado");
            for (int i = 0; i < numNotas; i++) {
                notasEst[i] = -1;
            }
        }
        else {

            for (int i = 0; i < numNotas; i++) {
                notasEst[i] = notas[indexEstudiante][i];
            }
        }
        return notasEst;
    }

    public static double calculaPromedioEstudiante(String id) {
        int indexEstudiante = obtenerIndiceEstudiante(id);
        if (indexEstudiante == -1) {
            System.out.println("ERROR!!!, estudiante no encontrado");
            return -1;
        }
        else {
            double [] notasEst = consultarNotasEstudiante(id);
            double avg = 0;
            for(int i = 0; i < notasEst.length; i++) {
                avg += notasEst[i]*porcentajes[i];
            }
            return avg;
        }
    }


    public static void test1() {
        System.out.println("-------- Funcion para test --------\n");
        System.out.println("** Inicializando el sistema **");
        inicializarSistema();
        System.out.println("** Imprimiendo informacion de las notas **\n");
        imprimirNotas();
        System.out.println();
        System.out.println("** Validando asignacion de notas **");
        // Colocando las 2 notas de bart
        asignarNota("001",0,2.5);
        asignarNota("001",1,3.0);
        // Colocando las 2 notas de Milhouse
        asignarNota("003",0,2.8);
        asignarNota("002",0,2.8);
        asignarNota("002",1,2.9);
        System.out.println();
        imprimirNotas();
        // Calculo del promedio del estudiante
        System.out.println("** Validando la funcion de promedio **");
        System.out.println("Promedio Bart: " + calculaPromedioEstudiante("001"));
        System.out.println();
        // Login test
        System.out.println("** Validando la funcion de login **");
        System.out.println("Usuario inexistente: " + validarUsuario("s","p"));
        System.out.println("Clave incorrecta: " + validarUsuario("b1","p"));
        System.out.println("Usuario y clave validos: " + validarUsuario("b1","123"));
        System.out.println("** Validando obtener id de usuario **");
        System.out.println("id: " + obtenerIdUsuario("b1","p"));
        System.out.println("** Validando obtener información estudiante **");
        imprimirInfoEstudiante(obtenerIdUsuario("b1","p"));
    }

    public static int validarUsuario(String u, String p) {
        int codigo = 0;  // Se asume inicialmente usuario valido
        int index = 0;
        for(int i = 0; i < numEstudiantes + 1; i++) {
            if(u.equals(loginInfo[i][0])) {
                index = i;
                break;
            }
            else {
                codigo = -1; // Usuario no encontrado
                index = codigo;
            }
        }
        if (codigo != -1) {
            if(!p.equals(loginInfo[index][1])) {
                codigo = -2; // Password invalido
            }
        }
        return codigo;
    }

    public static String obtenerIdUsuario(String u, String p) {
        int index = 0;
        if(validarUsuario(u,p) == 0) {
            // Usuario valido
            for(int i = 0; i < numEstudiantes;i++) {
                if (u.equals(loginInfo[i][0])) {
                    index = i;
                    break;
                }
            }
        }
        return estudiantes[index][1];

    }

    public static void imprimirInfoEstudiante(String id){
        double avg = calculaPromedioEstudiante(id);
        double notasEst[] = consultarNotasEstudiante(id);
        int indice = obtenerIndiceEstudiante(id);
        System.out.println("**********************************************************");
        System.out.println("-> Nombre: " + estudiantes[indice][0]);
        System.out.println("-> Notas: ");
        for (int i = 0; i < numNotas; i++) {
            System.out.format("   %d. %.1f\n",i ,notasEst[i]);
        }
        System.out.format("-> Promedio: %.1f\n",avg);
        System.out.println("**********************************************************");
    }


}
