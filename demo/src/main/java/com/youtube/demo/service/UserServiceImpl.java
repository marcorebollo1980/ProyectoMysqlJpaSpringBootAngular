package com.youtube.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.demo.model.User;
import com.youtube.demo.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public User save(User user) {
		return this.userRepository.save(user);
	}
	
	
	

}
