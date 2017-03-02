/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FABAME
 */
public class Main {

    public static Console c = new Console("EJERCICIO ARCHIVOS");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ejercicio02();
    }

    /*
     * Leer un archvo llamado miCurso.txt, 
     * en el archivo se encuentra la información de notas de todo el curso, 
     * el archivo tiene el siguiente formato:
     * NOMBREALUMNO#RUT#NOTA1#NOTA2#NOTA3.
     *
     * Se pide un programa que mediante un menú de opciones, 
     * realice lo siguiente.
* - Cargue el archivo al programa (utilizando clases y listados).
* - Ingresar el rut de un alumno y que entregue su promedio de notas.
* - Modificar la nota de un alumno (se ingresa su rut, 
* la nota que desea modificar y la nueva nota).
* - Generar reporte de aprobados. Se genera un archivo llamado 
* aprobados.txt con los nombres y promedio de todos los alumnos aprobados del curso.
* - Guardar la información nuevamente al archivo.
* - Salir.
*    
     */
    public static void ejercicio02() {
        Curso curso = new Curso("Octavo A");
        c.println(curso.cargarArchivo());
        menu();
        c.println("Ingrese una opción:");
        int opcion = c.readInt();
        while (opcion != 0) {

            // Opción 1: Cargar Datos desde el Archivo   
            if (opcion == 1) {
                c.clear();
                c.println(curso.cargarArchivo());
            }

            // Opción 2: Búsqueda del Alumno 
            if (opcion == 2) {
                c.clear();
                c.println("Ingrese el rut del alumno: ");
                String rut = c.readString();
                c.println(curso.buscarDatosAlumno(rut));
            }

            // Opción 3: Modificar Notas 
            if (opcion == 3) {
                c.clear();
                c.println("Ingrese el rut del alumno: ");
                String rut = c.readString();

                c.println("Ingrese el numero de prueba: ");
                double numeroPrueba = c.readDouble();

                c.println("Ingrese nueva nota: ");
                double nuevaNota = c.readDouble();

                c.println(curso.modificarNotaAlumno(rut, numeroPrueba, nuevaNota));

            }

            // Opción 4: Reporte de Aprobados
            if (opcion == 4) {
                c.clear();
                c.println(curso.generarReportesAprobados());
            }

            // Opción 5: Guardar Datos al Archivo
            if (opcion == 5) {
                c.clear();
                c.println(curso.guardarDatos());
            }
            c.println("");
            menu();
            c.println("Ingrese una opción:");
            opcion = c.readInt();
        }
        c.close();
    }

    public static void menu() {
        c.println("---------------------------------");
        c.println("[1] Cargar Datos desde el Archivo");
        c.println("[2] Búsqueda del Alumno");
        c.println("[3] Modificar Notas");
        c.println("[4] Reporte de Aprobados");
        c.println("[5] Guardar Datos al Archivo");
        c.println("[0] Salir");
        c.println("---------------------------------");
        c.println("");
    }
}
