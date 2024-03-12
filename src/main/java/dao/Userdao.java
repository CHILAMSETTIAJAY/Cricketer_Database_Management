package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import dto.User;

public class Userdao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ajay");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public User insert(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public String getPassword(String name) {
		try {
			Query query = entityManager.createQuery("SELECT u.userPassword FROM User u WHERE u.userName = ?1");
			query.setParameter(1, name);
			String pass = (String) query.getSingleResult();
			return pass;
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return "MultiUseres";
		}

	}

	public List<User> fetchAll() {
		Query query = entityManager.createQuery("select s from User s");
		List<User> users = query.getResultList();
		return users;
	}
	
	public boolean deletebyid(int id) {
		User user = entityManager.find(User.class, id);
		if(user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	public boolean updatedata(User user) {
		if(user != null) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return true;
		}
		return false;
	}
	
	public User fecthbyid(int id) {
		return entityManager.find(User.class, id);
	}
}
