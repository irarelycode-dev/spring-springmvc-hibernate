package hibernatedemo.demo;

import org.hibernate.*;
import org.hibernate.cfg.*;

import java.text.ParseException;
import java.util.List;

import hibernatedemo.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) throws ParseException {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		Student student = new Student("chennai", "super", "kings@gmail.com",DateUtils.parseDate("12/12/1998"));
		session.beginTransaction();
		session.save(student);
		System.out.println("Student Id:" + student.getId());
		// retrieve student

		Student myStudent = session.get(Student.class, student.getId());
		System.out.print(myStudent.toString());

		@SuppressWarnings("unchecked")
		List<Student> students = session.createQuery("from Student s where email='vickynsp15@gmail.com'")
				.getResultList();

		System.out.println("number of records:" + students.size());

		session.getTransaction().commit();

	}
}
