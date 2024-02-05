package com.krishna.rest.webservices.resfulwebservices.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Users {
	
	

	@Id
	@GeneratedValue
	private Integer id;
	
	public Users(Integer id, @Size(min = 2, message = "name should be atlest 2 chars") String name,
			@Past(message = "Should always be in past") LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	
	@Size(min=2 ,message="name should be atlest 2 chars")
	private String name;
	
	@Past(message="Should always be in past")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
}
