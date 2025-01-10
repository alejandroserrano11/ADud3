package com.cesur;

import java.util.List;

import org.hibernate.Session;

public class ManagerAlumno {
    // CRUD

    public void crear(String nombre, String apellidos, String curso, int edad, int num_asignaturas) {
        Alumno nuevoAlumno = new Alumno(nombre, apellidos, curso, edad, num_asignaturas);
        nuevoAlumno.setNombre(nombre);
        nuevoAlumno.setApellidos(apellidos);
        nuevoAlumno.setCurso(curso);
        nuevoAlumno.setEdad(edad);
        nuevoAlumno.setNum_asignaturas(num_asignaturas);

        Session session = ManagerPrincipal.sessionFactory.openSession();
        session.beginTransaction();
        session.persist(nuevoAlumno);
        session.getTransaction().commit();

        session.close();
    }

    public Alumno leer(int id_alumno) {
        Session session = null;
        try {
            session = ManagerPrincipal.sessionFactory.openSession();
            return session.get(Alumno.class, id_alumno);
        } finally {
            if (session != null)
                session.close();
        }

    }

    public void actualizar(int id_alumno, String nombre, String apellidos, String curso, Integer edad, Integer num_asignaturas) {
        Session session = ManagerPrincipal.sessionFactory.openSession();
        session.beginTransaction();

        Alumno alumno = session.get(Alumno.class, id_alumno);
        if (nombre != null) alumno.setNombre(nombre);
        if (apellidos != null)alumno.setApellidos(apellidos);
        if (curso != null)alumno.setCurso(curso);
        if (edad != null) alumno.setEdad(edad);
        if (num_asignaturas != null)alumno.setNum_asignaturas(num_asignaturas);

        session.merge(alumno);
        session.getTransaction().commit();
        session.close();
    }

    public void borrar(int id_alumno) {
        Session session = ManagerPrincipal.sessionFactory.openSession();
        session.beginTransaction();

        Alumno alumno = session.get(Alumno.class, id_alumno);
        session.remove(alumno);

        session.getTransaction().commit();
        session.close();
    }

    // leerTodos

    public List<Alumno> leerTodos() {
        Session session = null;
        try {
            session = ManagerPrincipal.sessionFactory.openSession();
            return session.createQuery("from Alumno", Alumno.class).list();
        } finally {
            if (session != null)
                session.close();
        }
    }
    
}
