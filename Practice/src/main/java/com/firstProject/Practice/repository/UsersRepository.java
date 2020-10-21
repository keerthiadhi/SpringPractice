package com.firstProject.Practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstProject.Practice.entity.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long>{
	
	public List<UsersEntity> findByUserName(String name);
	
	public List<UsersEntity> findByUserNameAndCity(String name, String city);
}
