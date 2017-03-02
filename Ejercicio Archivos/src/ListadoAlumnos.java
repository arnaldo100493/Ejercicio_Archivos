
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FABAME
 */
public class ListadoAlumnos {

    private List<Alumno> listadoAlumnos;

    public ListadoAlumnos() {
        this.listadoAlumnos = new LinkedList<>();
    }

    public String agregarAlumno(Alumno alumno) {
        this.listadoAlumnos.add(alumno);
        return "Alumno Ingresado.";
    }

    public Alumno buscarDatosAlumno(String rut) {
        Iterator<Alumno> iterator = this.listadoAlumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumno = (Alumno) iterator.next();
            if (alumno.getRut().equalsIgnoreCase(rut)) {
                return alumno;
            }
        }
        return null;
    }

    public String getAprobados() {
        String s = "";
        Iterator<Alumno> iterator = this.listadoAlumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumno = (Alumno) iterator.next();
            if (alumno.getPromedio() >= 40.0) {
                s += "\nALUMNO: " + alumno.getNombre() + " PROMEDIO: " + alumno.getPromedio();
            }
        }
        return s;
    }

    public String getListadoArchivosAlumnos() {
        String s = "";
        Iterator<Alumno> iterator = this.listadoAlumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumno = (Alumno) iterator.next();
            if (!s.equals("")) {
                s += "\n";
            }
            s += alumno.getFormatoArchivo();
        }
        return s;
    }

}
