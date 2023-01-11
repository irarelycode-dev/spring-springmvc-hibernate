package hibernatedemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;

import hibernatedemo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			Date dob=DateUtils.parseDate("05/12/1997");
			Student student=new Student("Paul","wall","paulwall@gmail.com",dob);
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			factory.close();
		}
	}

}
