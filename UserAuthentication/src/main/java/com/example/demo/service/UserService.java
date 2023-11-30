package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public boolean userExistsInDatabase(User user) {
        return repo.existsByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

	public boolean userExistsInDatabase(org.apache.catalina.User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
