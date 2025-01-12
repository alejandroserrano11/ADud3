package com.cesur;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static ManagerAlumno managerAlumno;
    private static ManagerPrincipal managerPrincipal;
    public static void main(String[] args) {

        // configuro el entorno llamando a setUp de ManagerPrincipal
        // llamo a menuPpal para mostrar las opciones
        // cierro el entorno llamando a exit de ManagerPrincipal

        managerPrincipal = new ManagerPrincipal();
        managerPrincipal.setUp();
        managerAlumno = new ManagerAlumno();

        menuPpal();

        managerPrincipal.exit();
    }

    // método menuPpal para mostrar las opciones del menú

    private static void menuPpal() {

        String opcion = null;
        Scanner teclado = new Scanner(System.in);

        do {
            mostrarOpcionesPpal();
            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    menuCrear(teclado);                
                    break;

                case "2":
                    menuLeer(teclado);                   
                    break;

                case "3":
                    menuActualizar(teclado);                   
                    break;

                case "4":
                    menuBorrar(teclado);                   
                    break;

                case "5":
                    menuLeerTodos(teclado);                   
                    break;
                
                default:                   
                    break;
            }
        } while (!opcion.equals("6"));

    }

    // método menuCrear para insertar un alumno

    private static void menuCrear(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU INSERTAR ALUMNO   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce nombre Alumno: ");
        String nombre = teclado.nextLine();

        System.out.print("Introduce Apellidos Alumno: ");
        String apellidos = teclado.nextLine();

        System.out.print("Introduce Curso Alumno: ");
        String curso = teclado.nextLine();

        System.out.print("Introduce Edad Alumno: ");
        int edad = teclado.nextInt();

        System.out.print("Introduce Número de Asignaturas Alumno: ");
        int numAsignaturas = teclado.nextInt();
        teclado.nextLine();

        managerAlumno.crear(nombre, apellidos, curso, edad, numAsignaturas);
        System.out.println();
    }

    // método menuLeer para solicitar un ID y mostrar los datos del alumno

    private static void menuLeer(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU LEER ALUMNO   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Alumno a leer: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.println(managerAlumno.leer(id));
        System.out.println();
    }

    // método menuActualizar para actualizar los datos de un alumno

    private static void menuActualizar(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU ACTUALIZAR ALUMNO   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Alumno a actualizar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        Alumno alumno = managerAlumno.leer(id);
        System.out.println("Introduce elemento a actualizar o ENTER para no actualizarlo");

        System.out.print("Introduce nombre Alumno: ");
        String nombre = teclado.nextLine();
        if (!nombre.equals("")) {
            alumno.setNombre(nombre);
        }

        System.out.print("Introduce Apellidos Alumno: ");
        String apellidos = teclado.nextLine();
        if (!apellidos.equals("")) {
            alumno.setApellidos(apellidos);
        }
        
        System.out.print("Introduce Curso Alumno: ");
        String curso = teclado.nextLine();
        if (!curso.equals("")) {
            alumno.setCurso(curso);
        }

        System.out.print("Introduce Edad Alumno: ");
        String edad = teclado.nextLine();
        if (!edad.equals("")) {
            alumno.setEdad(Integer.parseInt(edad));
        }

        System.out.print("Introduce Número de Asignaturas Alumno: ");
        String numAsignaturas = teclado.nextLine();
        if (!numAsignaturas.equals("")) {
            alumno.setNum_asignaturas(Integer.parseInt(numAsignaturas));
        }

        managerAlumno.actualizar(alumno.getId_alumno(), alumno.getNombre(), alumno.getApellidos(), alumno.getCurso(), alumno.getEdad(), alumno.getNum_asignaturas());
        System.out.println();

    }

    // método menuBorrar para borrar un alumno

    private static void menuBorrar(Scanner teclado) {
        System.out.println();
        System.out.println("***   MENU BORRAR ALUMNO   ***");
        System.out.println("--------------------------------");

        System.out.print("Introduce ID Alumno a borrar: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        managerAlumno.borrar(id);
        System.out.println();
    }

    // método menuLeerTodos para mostrar todos los alumnos

    public static void menuLeerTodos(Scanner teclado) {
        System.out.println();
        List<Alumno> listado = managerAlumno.leerTodos();
        for (Alumno alumno : listado) {
            System.out.println(alumno);
        }
        System.out.println();
    }

    // método mostrarOpcionesPpal para mostrar las opciones del menú

    private static void mostrarOpcionesPpal() {
        System.out.println();
        System.out.println("***   INTRODUCE OPCION:   ***");
        System.out.println("-----------------------------");
        System.out.println("1) Introducir Alumno");
        System.out.println("2) Mostrar Alumno");
        System.out.println("3) Modificar Alumno");
        System.out.println("4) Borrar Alumno");
        System.out.println("5) Mostrar Todos los Alumnos");
        System.out.println("6) SALIR");
        System.out.println();
    }
}