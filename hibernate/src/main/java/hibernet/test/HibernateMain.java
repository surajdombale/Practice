package hibernet.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

public class HibernateMain {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		System.out.println("Configuration");
		conf.configure("hibernate.cfg.xml");
		System.out.println("Configuration loaded succesfully");
		SessionFactory factory = conf.buildSessionFactory();
		System.out.println("SessionFactory loaded succesfully");
		Session session = factory.openSession();
		System.out.println("session created succesfully");
	Transaction t = session.beginTransaction();
		
	Employee emp1 = new Employee(1,"sachin", "mumbai");
	session.save(emp1);
	t.commit();
//Query query=session.createQuery("From Employee e");
//List<Employee> list=query.getResultList();
//Iterator<Employee> it = (Iterator<Employee>)list.iterator();
//while(it.hasNext()) {
//	Employee e=  it.next();
//	System.out.println(e);
//}
	}

}
