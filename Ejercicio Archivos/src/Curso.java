/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FABAME
 */
public class Curso {

    private String nombre;
    private ListadoAlumnos listadoAlumnos;

    public Curso() {
        this.nombre = "";
        this.listadoAlumnos = new ListadoAlumnos();
    }

    public Curso(String nombre) {
        this.nombre = nombre;
        this.listadoAlumnos = new ListadoAlumnos();
    }

    public Curso(Curso curso) {
        this.nombre = curso.getNombre();
        this.listadoAlumnos = new ListadoAlumnos();
    }

    public String cargarArchivo() {
        Archivo archivo = new Archivo("curso.txt");
        if (archivo.reset()) {

            String linea = archivo.readLine();
            while (linea != null) {

                // Separar los campos desde el archivo 
                String[] arreglo = linea.split("#");
                String nombre = arreglo[0];
                String rut = arreglo[1];
                String notaString1 = arreglo[2];
                String notaString2 = arreglo[3];
                String notaString3 = arreglo[4];

                // Convertir las notas a decimales
                double nota1 = Double.parseDouble(notaString1);
                double nota2 = Double.parseDouble(notaString2);
                double nota3 = Double.parseDouble(notaString3);

                // Crear el objeto alumno
                Alumno alumno = new Alumno(nombre, rut, nota1, nota2, nota3);
                this.listadoAlumnos.agregarAlumno(alumno);

                //Main.c.println(notaString3);
                linea = archivo.readLine();
            }
            archivo.close();
            return "Datos Cargados en Memoria.";
        }
        return "Error en la carga de datos.";
    }

    public String buscarDatosAlumno(String rut) {
        Alumno alumno = this.listadoAlumnos.buscarDatosAlumno(rut);
        if (alumno != null) {
            String nombre = alumno.getNombre();
            double promedio = alumno.getPromedio();
            return "Promedio de " + nombre + ": " + promedio;
        }
        return "Alumno no encontrado.";
    }

    public String modificarNotaAlumno(String rut, double numeroPrueba, double nuevaNota) {
        Alumno alumno = this.listadoAlumnos.buscarDatosAlumno(rut);
        if (alumno != null) {
            if (numeroPrueba == 1) {
                alumno.setNota1(nuevaNota);
            }
            if (numeroPrueba == 2) {
                alumno.setNota2(nuevaNota);
            }
            if (numeroPrueba == 3) {
                alumno.setNota3(nuevaNota);
            }
            return "Notas Modificadas.";
        }
        return "Alumno no encontrado.";
    }

    public String generarReportesAprobados() {
        Archivo archivo = new Archivo("aprobados.txt");
        if (archivo.rewrite()) {
            String aprobados = this.listadoAlumnos.getAprobados();
            archivo.writeLine(aprobados);
            archivo.close();
        }
        return "Archivo Creado.";
    }

    public String guardarDatos() {
        Archivo archivo = new Archivo("curso.txt");
        if (archivo.rewrite()) {
            String alumnos = this.listadoAlumnos.getListadoArchivosAlumnos();
            archivo.writeLine(alumnos);
            archivo.close();
        }
        return "Archivo Creado.";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
