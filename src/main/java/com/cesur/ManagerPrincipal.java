package com.cesur;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManagerPrincipal {
    // Atributo, sessionFactory crea la sesión de Hibernate para la conexión con la base de datos
    protected static SessionFactory sessionFactory;

    public ManagerPrincipal() {
        sessionFactory = null;
    }
    
    // método setUp para configurar la sesión, si algo falla, se destruye el registro y se muestra un mensaje de error

    public void setUp() {
       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println(e.getMessage());
        }
    }

    // método exit para cerrar la sesión de Hibernate
    
    public void exit() {
        if ((sessionFactory!=null) && (!sessionFactory.isClosed())) {
            sessionFactory.close();
        }
    }
}
