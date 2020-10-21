package com.firstProject.Practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstProject.Practice.entity.UsersEntity;
import com.firstProject.Practice.service.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersRestController {
	
	@Autowired
	UsersService userService;
	
	@GetMapping
	public List<UsersEntity> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping(value="/{userId}")
	public Optional<UsersEntity> getUser(@PathVariable("userId") Long userId) {
		return userService.getUser(userId);
	}
	
	@GetMapping(value="/username")
	public List<UsersEntity> getByUserName(@RequestParam(value="userName") String name){
		return userService.getUserByName(name);
	}
	
	@GetMapping(value="/username/city")
	public List<UsersEntity> getByUserNameAndCityName(@RequestParam(value="userName") String name,
			@RequestParam(value="city") String city){
		return userService.getUserByNameAndCityName(name, city);
		
	}
	
	@PostMapping(value="/user")
	public void addUser(@RequestBody UsersEntity user) {
		userService.addUser(user);
	}
	
	@DeleteMapping(value="/deleteUser")
	public void deleteUser(Long id) {
		userService.deleteuser(id);
	}
	
	@PutMapping(value="/user/{userId}")
	public void updateuser(@RequestBody UsersEntity user, @PathVariable("userId") Long userId) {
		userService.updateuser(user,userId);
	}

}
