package com.krishna.rest.webservices.resfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishna.rest.webservices.resfulwebservices.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
    
	
}
