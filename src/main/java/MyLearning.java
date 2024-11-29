import com.dev.learning.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyLearning {
    public static void main(String [] args) {

        // Configuration
        // With the configuration we can build the SessionFactory
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // all will be set from Envirnment class
        configuration.addAnnotatedClass(Student.class); // add the class/entity to the configuration

        // SessionFactory
        // data source is configuration that defines how to connect to database
        // It manages connections
        // data source here is the session factory
        // So to create session factory we need configuration
        //
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Session object comes from session factory
        // Initialize the session object
        // To initialize session object we need session factory
        // openSession() method will return a session object
        Session session = sessionFactory.openSession();

        Student student = new Student();
        student.setId(102);
        student.setName("Rajesh");
        student.setClassName("PG");
        student.setAge(25);


        // We need to tell hibernate to generate the insert query to save the student
        // So in order to do that we do a transaction
        // In order to define a transaction we call beginTransaction() method on session object
        session.beginTransaction();
        session.save(student);

        // After creating transaction saving data we need to commit the transaction
        session.getTransaction().commit();

        System.out.println("Student saved...");

        session.close();

    }

}
