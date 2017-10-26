package main.java.com.torrento.Prueba.mvcTest.service;

import java.util.List;

import main.java.com.torrento.Prueba.mvcTest.entity.User;

public interface UserServiceInterface {

	List<User> getAllUsers();
	
    User getUserById(int userId);
    
    boolean addUser(User user);
    
    void updateUser(User user);
    
    void deleteUser(int userId);
}
