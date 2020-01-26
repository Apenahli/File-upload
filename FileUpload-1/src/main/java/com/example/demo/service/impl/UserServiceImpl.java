package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository rep;

	@Override
	public List<User> findAll() {

		return (List<User>) rep.findAll();
	}
	
	@Override
	public void save(User user) {
		rep.save(user);
		
	}
}
