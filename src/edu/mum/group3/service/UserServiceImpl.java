package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.UserDao;
import edu.mum.group3.model.User;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	public User getUser(int userid) {
		return userDao.getUser(userid);
	}
	
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
}
