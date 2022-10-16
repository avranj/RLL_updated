package com.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByName(String name);

	

}
