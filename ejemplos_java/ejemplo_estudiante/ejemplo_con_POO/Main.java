import java.util.Calendar;

public class Main {
    public static void main(String args[]) {
        //testEstudiante();
        testClase();

    }

    public static void testEstudiante() {
        Estudiante e1 = new Estudiante("Bart Simpson","001",2);
        double [] porc = {0.45, 0.55};
        double avg = e1.calcularPromedio(porc);
        e1.imprimirInfoEstudiante();
        System.out.println("Promedio: " + avg);
        e1.ponerNota(0,2.5);
        e1.ponerNota(1,3);
        e1.imprimirInfoEstudiante();
        System.out.println("Promedio: " + e1.calcularPromedio(porc));
    }

    public static void testClase() {

        double [] porc = {0.45, 0.55};
        Estudiante e1 = new Estudiante("Bart Simpson","001",2);
        Estudiante e2 = new Estudiante("Milhouse Mussolini", "002",2);
        Profesor p = new Profesor("Skinner","003");
        e1.setLogin("b1");
        e1.setPassword("123");
        e2.setLogin("m1");
        e2.setPassword("456");
        Clase claseMat = new Clase("Matematicas",2,2);
        claseMat.setPorcentajes(porc);
        claseMat.agregarEstudiante(e1);
        claseMat.agregarEstudiante(e2);
        claseMat.imprimirNotas();
        claseMat.ponerNota("001",0,2.5);
        claseMat.ponerNota("001",1,3);
        claseMat.ponerNota("002",0,2.8);
        claseMat.ponerNota("002", 1, 2.9);
        claseMat.imprimirNotas();
        Estudiante eR = claseMat.obtenerEstudiante("001");
        eR.imprimirInfoEstudiante();



    }
}
