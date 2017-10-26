package main.java.com.torrento.Prueba.mvcTest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import main.java.com.torrento.Prueba.mvcTest.entity.User;

@Transactional
@Repository
public class UserDAO implements UserDAOImpl {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String query = "FROM users usr ORDER BY usr.Id";
		return (List<User>) entityManager.createQuery(query).getResultList();
	}
	
	@Override
	public User getUserById(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);		
	}

	@Override
	public void updateUser(User user) {
		User usr = getUserById(user.getId());
		usr.setName(user.getName());
		usr.setSurname(user.getSurname());
		entityManager.flush();		
	}

	@Override
	public void deleteUser(int userId) {
		entityManager.remove(getUserById(userId));		
	}

	@Override
	public boolean userExists(String name, String surname) {
		String query = "FROM users WHERE name = ? and surname = ?";
		int count = entityManager.
				createQuery(query).
				setParameter(1, name).
				setParameter(2, surname).
				getResultList().
				size();
		return count > 0 ? true : false;
	}

}
