package hibernate;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OwnerView {

	public static void main(String[] args) {
		Configuration configuration= new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.getTransaction();
		try{/*
		Vehicle v1= new Vehicle();
		Owner o1 = new Owner();
		Owner o2 = new Owner();
		o2.setName("afs");
		v1.setName("abc");
		v1.getOwnerList().add(o1);
		o1.setName("prd");
		Vehicle v2= new Vehicle();
		v2.setName("efg");
		v2.getOwnerList().add(o1);
		o1.getVehicleList().add(v2);
		o1.getVehicleList().add(v1);
		o2.getVehicleList().add(v2);
		Vehicle v3= new Vehicle();
		v3.setName("ijk");
		v3.getOwnerList().add(o2);
		o2.getVehicleList().add(v3);
		transaction.begin();
		session.persist(v1);
		session.persist(v2);
		session.persist(v3);
		session.persist(o1);
		session.persist(o2);
*/
		//Owner o = session.get(Owner.class, 14l);
		Vehicle v=session.get(Vehicle.class, 56l);
		Hibernate.initialize(v.getOwnerList());
		//transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		sessionFactory.close();

	}

}
