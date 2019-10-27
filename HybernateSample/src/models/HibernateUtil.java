package models;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private final static SessionFactory factory;
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}
	public static Session getSession() {
		return factory.getCurrentSession();
	}
}
