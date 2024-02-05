package com.krishna.rest.webservices.resfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

	//timestamp ,error details, message
	
	private LocalDateTime timeStamp;
	private String message;
	private String details;
}
