package com.solo.ujianjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solo.ujianjpa.entity.User;
import com.solo.ujianjpa.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> saveUsers(List<User> user) {
		return userRepository.saveAll(user);
	}
	
	public List<User> findUserByCompanyId(int user_company_id) {
		return userRepository.findUserByCompanyId(user_company_id);
	}
	
	public List<User> findUserByNames(String user_name) {
		return userRepository.findUserByNames(user_name);
	}
}
