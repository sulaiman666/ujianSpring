package com.solo.ujianjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solo.ujianjpa.entity.User;
import com.solo.ujianjpa.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping("/addusers")
	public List<User> addUsers(@RequestBody List<User> user) {
		return userService.saveUsers(user);
	}
	
	@GetMapping("/findusercompanyid/{id}")
	public List<User> findUserByCompanyId(@PathVariable int id) {
		return userService.findUserByCompanyId(id);
	}
	
	@GetMapping("/finduserbyname/{name}")
	public List<User> findUserByName(@PathVariable String name) {
		return userService.findUserByNames(name);
	}
}
