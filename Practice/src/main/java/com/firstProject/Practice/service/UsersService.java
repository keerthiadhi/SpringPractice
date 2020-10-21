package com.firstProject.Practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstProject.Practice.entity.UsersEntity;
import com.firstProject.Practice.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository userRepo;

	public List<UsersEntity> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<UsersEntity> getUser(Long id) {
		return userRepo.findById(id);
	}

	public void addUser(UsersEntity user) {
		userRepo.save(user);
	}
	
	public void deleteuser(Long id) {
		userRepo.deleteById(id);
	}
	
	public void updateuser(UsersEntity user,Long id) {
		userRepo.save(user);
	}

	public List<UsersEntity> getUserByName(String name) {
		return userRepo.findByUserName(name);
	}
	
	public List<UsersEntity> getUserByNameAndCityName(String name, String city) {
		return userRepo.findByUserNameAndCity(name, city);
	}

}
