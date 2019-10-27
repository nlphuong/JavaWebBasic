package models;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRepository {

	public Student getStudentById(int id) {
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			return session.get(Student.class, id);
		}
	}
	
	public void edit(Student obj) {
		try(Session session = HibernateUtil.getSession()){
			Transaction tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
		}
	}
	
	public List<Student> getStudents(){
		try(Session session = HibernateUtil.getSession()){
			session.beginTransaction();
			return session.createQuery("from Student").list();
		}
	}
	public void add(Student obj) {
		try(Session session = HibernateUtil.getSession()){
			Transaction tran = session.beginTransaction();
			session.save(obj);
			tran.commit();
		}
	}
	public void delete(int id) {
		try(Session session = HibernateUtil.getSession()){
			Transaction tran = session.beginTransaction();
			session.delete(new Student(id));
			tran.commit();
		}
	}
}
