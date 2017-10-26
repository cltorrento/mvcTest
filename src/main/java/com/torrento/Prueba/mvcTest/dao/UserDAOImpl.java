package main.java.com.torrento.Prueba.mvcTest.dao;

import java.util.List;
import main.java.com.torrento.Prueba.mvcTest.entity.User;

public interface UserDAOImpl {

	List<User> getAllUsers();
	
	User getUserById(int userId);
	
    void addUser(User user);
    
    void updateUser(User user);
    
    void deleteUser(int userId);
    
    boolean userExists(String name, String surname);
}
