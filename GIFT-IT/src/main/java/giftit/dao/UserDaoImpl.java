package giftit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import giftit.model.User;

@Repository("ud")
public class UserDaoImpl implements UserDao {

	private List<User> listUsers;
	@Autowired
SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")   
	public void addUser(User u) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(u);
		tx.commit();
		sess.close();
		System.out.println("Insertion succesfull");
	}

	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	public List<User> listUsers() {
		// TODO Auto-generated method stub
Session sess=sessionFactory.openSession();
		
		listUsers=sess.createQuery("from User").list();
		return listUsers;
		
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		listUsers= sess.createQuery("from User u where u.id=:id").setParameter("id", id).list();
	tx.commit();
	sess.close();
			return listUsers.size()>0?listUsers.get(0):null;
	}

	public void removeUser(int id) {
		// TODO Auto-generated method stub
		Session sess=sessionFactory.openSession();
		Transaction trx=sess.beginTransaction();
		
		User u=(User)sess.load(User.class,id );
			sess.delete(u);
		trx.commit();
		sess.close();
	}

}
