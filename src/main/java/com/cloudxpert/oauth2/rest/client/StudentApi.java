package com.cloudxpert.oauth2.rest.client;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.cloudxpert.oauth2.rest.model.StudentResource;

@Component
public class StudentApi {

	@Autowired
	WebClient webclient;
	
	@Value("${spring.studentservice.endpoint}")
	String serviceEndpoint;
	
	/**
	 * Create a Student
	 * @param the new student details
	 * @return the new student
	 */
	public Optional<StudentResource> createNewStudent(StudentResource student) {
		Duration timeoutIn10Seconds = Duration.ofSeconds(10);
		return webclient
				.method(HttpMethod.POST)
				.uri(serviceEndpoint)
				.bodyValue(student)
				.header(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
				.retrieve()
				.bodyToMono(StudentResource.class)
				.blockOptional(timeoutIn10Seconds);
	}
}
