package hibernatedemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Date;

import hibernatedemo.entity.*;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Date dob=DateUtils.parseDate("15/05/1997");
			System.out.println("Saving 3 students");
			Student student1 = new Student("vicky", "shruti", "vickynsp15@gmail.com",dob);
			Student student2 = new Student("tan tana", "tan", "doe15@gmail.com",dob);
			Student student3 = new Student("RCB", "losers", "rcblosers@fans.com",dob);
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("done and dusted!");
		} catch (Exception e) {
			System.out.println("error:" + e);
		} finally {
			factory.close();
		}
	}
}
