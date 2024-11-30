import com.dev.learning.models.Student;
import com.dev.learning.utils.HibernateUtils;
import org.hibernate.Session;

public class UpdateApp {
    public static void main(String[] args) {

        Session session = HibernateUtils.getSessionFactory().openSession();

        if(session == null) {
            throw new RuntimeException("Could not open Session");
        }

        // Retrieve the object from the database
        Student student = session.get(Student.class,102);

//        // made changes to the object
//        String newName = student.getName().toUpperCase();
//        student.setName(newName);

//        // update the object
//        session.beginTransaction();
//        session.update(student);
//        session.getTransaction().commit();


        // This will also work despite of calling update() method
        // update the object
        session.beginTransaction();
        student.setName("Mohit");
        session.getTransaction().commit();


    }
}
