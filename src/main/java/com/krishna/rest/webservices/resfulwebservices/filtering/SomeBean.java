package com.krishna.rest.webservices.resfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//@JsonIgnoreProperties("field1")
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String field1;
	
	@JsonIgnore
	private String field2;
	private String field3;

}
