package com.krishna.rest.webservices.resfulwebservices.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.rest.webservices.resfulwebservices.entity.HelloWorldBean;
import com.krishna.rest.webservices.resfulwebservices.entity.Users;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {
	
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource)
	{
		this.messageSource=messageSource;
	}
	
	@GetMapping("/")
	public ResponseEntity<String> helloWorld()
	{
		return new ResponseEntity<>("Hello World",HttpStatus.OK);
	}
    
	@GetMapping("/helloBean")
	public HelloWorldBean helloWorldBean()
	{
        return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hell")
	public String helloWorldInternationalization()
	{
		Locale locale=LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
//        return new HelloWorldBean("Hello World");
        
        //good.morning.message= Good Morning in message.properties 
	}

	@GetMapping("/helloBean/pathvariable/{name}")
	public HelloWorldBean helloWorldBean1(@PathVariable String name)
	{
        return new HelloWorldBean("Hello World"+"  "+name);
	}
	
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<Users> deleteUser(@PathVariable int userId)
//	{
//		
//	}

}
