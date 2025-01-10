package com.cesur;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManagerPrincipal {
    protected static SessionFactory sessionFactory;

    public ManagerPrincipal() {
        sessionFactory = null;
    }
    
    public void setUp() {
       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println(e.getMessage());
        }
    }

    public void exit() {
        if ((sessionFactory!=null) && (!sessionFactory.isClosed())) {
            sessionFactory.close();
        }
    }
}
