package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.User;

public interface UserDao {

	public void addUser(User user);

	public List<User> listUsers();
	
	public User getUser(int userId);
	
	public void deleteUser(User user);
}
