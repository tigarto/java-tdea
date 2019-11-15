public class Clase {
    private String nombreCurso;
    private int numEstudiantes;
    private double porcentajes[];
    private int numNotas;
    private String nombreNotas[];
    private Estudiante estudiantes[];
    private int estMat;

    public Clase(String nombreCurso, int numEstudiantes, int numNotas) {
        this.nombreCurso = nombreCurso;
        this.numEstudiantes = numEstudiantes;
        this.numNotas = numNotas;
        porcentajes = new double[numNotas];
        estudiantes = new Estudiante[numEstudiantes];
        estMat = 0;
    }

    public double[] getPorcentajes() {
        return porcentajes;
    }

    public void setPorcentajes(double[] porcentajes) {
        this.porcentajes = porcentajes;
    }

    /**
     * Asume que la cosa es para un colegio
     */
    public int agregarEstudiante(Estudiante est) {
        if (estMat < numEstudiantes) {
            estudiantes[estMat] = est;
            estMat++;
            return 0; // Estudiante matriculado
        }
        else {
            // Grupo lleno
            return -1;
        }
    }

    public int ponerNota(String idEst, int index, double nota) {
        int found = -1; // Iniciamente se asume que no hay estudiante con el id pasado
        for(int i = 0; i < numEstudiantes; i++) {
            if(idEst.equals(estudiantes[i].getId())) {
                found = 0;
                estudiantes[i].ponerNota(index,nota);
                break;
            }
        }
        return found;
    }

    public  void imprimirNotas() {
        double notas[] = new double[numNotas];
        System.out.format("%-30s  %9s %8s\n","Nombre","Nota 1","Nota 2");
        for (int i = 0; i < numEstudiantes; i++) {
            // https://docs.oracle.com/javase/tutorial/essential/io/formatting.html
            System.out.format("%-27s  ",estudiantes[i].getNombre());
            notas = estudiantes[i].getNotas();
            for (int j = 0; j < numNotas; j++) {
                System.out.format("%9.1f",notas[j]);
            }
            System.out.println();
        }
    }

    public Estudiante obtenerEstudiante(String idEst) {
        Estudiante eRes = new Estudiante();
        for(int i = 0; i < numEstudiantes; i++) {
            if(idEst.equals(estudiantes[i].getId())) {
                eRes = estudiantes[i];
                break;
            }
        }
        return eRes;
    }
}
