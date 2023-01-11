package hibernatedemo.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import hibernatedemo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		int id = 3000;
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, id);
			student.setEmail("newmail@gmail.com");
			Student studentUpdated = session.get(Student.class, id);
			System.out.println("After email update:" + studentUpdated.getEmail());
			System.out.print("Done");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.delete(studentUpdated);
			session.createQuery("delete from Student where id=1").executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		} finally {
			session.close();
		}

	}

}
