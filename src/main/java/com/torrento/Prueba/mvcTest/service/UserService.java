package main.java.com.torrento.Prueba.mvcTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import main.java.com.torrento.Prueba.mvcTest.dao.UserDAOImpl;
import main.java.com.torrento.Prueba.mvcTest.entity.User;


@Service
public class UserService implements UserServiceInterface {

	//@Autowired
	private UserDAOImpl UserDAO;
	
	@Override
	public List<User> getAllUsers() {
		return UserDAO.getAllUsers();
	}

	@Override
	public User getUserById(int userId) {
		User usr = UserDAO.getUserById(userId);
		return usr;
	}

	@Override
	public boolean addUser(User user) {
		if (UserDAO.userExists(user.getName(), user.getSurname())) {
            return false;
        } else {
            UserDAO.addUser(user);
            return true;
        }
	}

	@Override
	public void updateUser(User user) {
		UserDAO.updateUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		UserDAO.deleteUser(userId);
	}

}
