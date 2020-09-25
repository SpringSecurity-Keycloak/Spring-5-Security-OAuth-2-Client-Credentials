package com.cloudxpert.oauth2.rest.client;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloudxpert.oauth2.rest.model.StudentResource;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = { "classpath:application-test.properties" })
@ActiveProfiles({ "test" })
@OverrideAutoConfiguration(enabled = true)
public class StudentApiTest {

	@Autowired
	StudentApi studentApi;
	
	@Test
	public void testCreateStudent() {
		StudentResource newStudent = new StudentResource();
		newStudent.setFirstName("Donald");
		newStudent.setLastName("Biden");
		Optional<StudentResource> createdStudent= studentApi.createNewStudent(newStudent);
		assertTrue(createdStudent.isPresent());
	}
}
