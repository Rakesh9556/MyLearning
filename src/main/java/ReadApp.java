import com.dev.learning.models.Student;
import com.dev.learning.utils.HibernateUtils;
import org.hibernate.Session;

public class ReadApp {
        public static void main(String[] args) {

            Session session = HibernateUtils.getSessionFactory().openSession();

            // To retrieve data we use diiferent methods:

            // 1. get()
            // in parameter we pass the table name and the id
            // Student student = session.get(Student.class, 101);

            // 2. load()
            Student student = session.load(Student.class, 107);
            System.out.println(student);
        }
}
