package com.cesur;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @Column(name = "id_alumno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alumno;
    
    private String nombre;
    private String apellidos;
    private String curso;
    private int edad;
    private int num_asignaturas;

    public Alumno() {
        
    }

    public Alumno(String nombre, String apellidos, String curso, int edad, int num_asignaturas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.edad = edad;
        this.num_asignaturas = num_asignaturas;
    }   

    public int getId_alumno() {
        return id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNum_asignaturas() {
        return num_asignaturas;
    }

    public void setNum_asignaturas(int num_asignaturas) {
        this.num_asignaturas = num_asignaturas;
    }

    @Override
    public String toString() {
        return "Alumno [id_alumno=" + id_alumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso
                + ", edad=" + edad + ", num_asignaturas=" + num_asignaturas + "]";
    }

}
