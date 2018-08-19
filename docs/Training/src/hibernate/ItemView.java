package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ItemView {

	public static void main(String[] args) {
		Configuration configuration= new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.getTransaction();
		try{
		Item item = new Item();
		Item i = null;

		/*item.setDescription("hello!!!");*/
		//transaction.begin();
		i=session.get(Item.class, 1l);
		//session.persist(item);
		System.out.println(i.getId()+i.getDescription());
		i.setDescription("BYE");
		//transaction.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		sessionFactory.close();
	}

}
