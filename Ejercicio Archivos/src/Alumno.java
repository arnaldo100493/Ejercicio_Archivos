/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FABAME
 */
public class Alumno {

    private String nombre;
    private String rut;
    private double nota1;
    private double nota2;
    private double nota3;

    public Alumno() {
        this.nombre = "";
        this.rut = "";
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
    }

    public Alumno(String nombre, String rut, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.rut = rut;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public Alumno(Alumno alumno) {
        this.nombre = alumno.getNombre();
        this.rut = alumno.getRut();
        this.nota1 = alumno.getNota1();
        this.nota2 = alumno.getNota2();
        this.nota3 = alumno.getNota3();
    }

    public String getInformacion() {
        return "Nombre: " + this.nombre + "Rut: " + this.rut + " Notas: " + this.nota1 + this.nota2 + this.nota3 + "Promedio: " + this.getPromedio();
    }

    public double getPromedio() {
        double suma = this.nota1 + this.nota2 + this.nota3;
        double promedio = suma / 3;
        return promedio;
    }

    public String getFormatoArchivo() {
        String nombre = this.nombre;
        String rut = this.rut;
        double nota1 = this.nota1;
        double nota2 = this.nota2;
        double nota3 = this.nota3;
        String gato = "#";
        return nombre + gato + rut + gato + nota1 + gato + nota2 + gato + nota3 + gato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

}
