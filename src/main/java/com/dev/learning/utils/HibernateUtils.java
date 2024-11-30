package com.dev.learning.utils;

import com.dev.learning.models.Student;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    // Session Factory object is a singleton object and immutable
    // Make sure only one session factory object is created throughout the application
    // As might calling the getSessionFactory() method will create new sessionFactory object everytime
    //So in order to avoid this only generate the session factory object if it does not exist

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        try {
            if(sessionFactory == null) {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Student.class);

                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return sessionFactory;
    }
}
