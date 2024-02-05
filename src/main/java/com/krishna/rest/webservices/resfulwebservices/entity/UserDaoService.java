package com.krishna.rest.webservices.resfulwebservices.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	//Jpa/Hibernate->database
	
	private static List<Users> users=new ArrayList<>();
	
	static {
		users.add(new Users(1,"Adam",LocalDate.now().minusYears(30)));
		users.add(new Users(2,"Kris",LocalDate.now().minusYears(25)));

		users.add(new Users(3,"Sang",LocalDate.now().minusYears(20)));

		
	}
	public List<Users> findAll(){
		return users;
	}
	
	//public User save(User user);
	
	public Users findOne(int id) {
		
		return users.stream().filter((user)->user.getId()==id).findFirst().orElse(null);
	}
	
	public ResponseEntity<Users> save(Users user)
	{
		user.setId(4);
		users.add(user);
		return new ResponseEntity<Users>(user,HttpStatus.CREATED);
	}
	
	public void delete(int userId)
	{
	     Users userget = users.stream().filter(user-> user.getId()==userId).findFirst().orElse(null);
	    
	     if(userget!=null)
	     {
	    	 users.remove(userget);
	     }
	     
	}
}
