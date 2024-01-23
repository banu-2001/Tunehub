package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
@Service
public class UsersServiceImplementation   implements UsersService
{

	
	@Autowired
	UsersRepository repo;
	public String addUser(Users user) {
		repo.save(user);
		return "user added succesfully";
	}
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		String db_pass = user.getPassword();
		if(password.equals(db_pass)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public String getRole(String email) {
		Users user = repo.findByEmail(email);
		return user.getRole();
	}
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}
	public void updateUser(Users user) {
		repo.save(user);
	}	
	
}
