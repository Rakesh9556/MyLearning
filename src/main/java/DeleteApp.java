import com.dev.learning.models.Student;
import com.dev.learning.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteApp {
    public static void main(String[] args) {


        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.getTransaction();

        try {
            // Load the object to be delete
            Student student = session.get(Student.class, 101);

            // Begin the tarnsaction
            transaction.begin();
            session.delete(student);
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }
        finally {
            session.close();
        }

    }
}
