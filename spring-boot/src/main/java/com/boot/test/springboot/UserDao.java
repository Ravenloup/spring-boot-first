/**
 * 
 */
package com.boot.test.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author sunil.yadav
 *
 */
@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return user = userRepository.insert(user);
	}

	public List<User> getusers() {
		return userRepository.findAll();
	}

	public User getUser(String id) {
		return userRepository.findOne(id);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(String id) {
		userRepository.delete(id);
	}
}
