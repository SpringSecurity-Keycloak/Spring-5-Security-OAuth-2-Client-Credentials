package com.todaystech.oauth2.rest.client;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import no.nav.security.mock.oauth2.MockOAuth2Server;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import com.todaystech.oauth2.rest.model.StudentResource;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({ "test" })
public class StudentApiTest {

	@Autowired
	StudentApi studentApi;
	
	private MockOAuth2Server oauthServer = new MockOAuth2Server();
	private MockWebServer mockApiService = null;

	@Before
	public void startOauthServer() throws IOException {

		mockApiService = new MockWebServer();

		MockResponse mockResponse = new MockResponse();
		mockResponse.addHeader("Content-Type", "application/json; charset=utf-8").addHeader("Cache-Control", "no-cache")
				.setBody("{\"firstName\": \"John\", \"lastName\": \"Doe\"}");
		mockApiService.enqueue(mockResponse);

		oauthServer.start(InetAddress.getByAddress("127.0.0.1", new byte[] { 127, 0, 0, 1 }), 8081);
	}

	@After
	public void stopOauthServer() throws IOException {
		/**
		 * The MockOauth2Server uses an instance of MockWebServer and will shut down
		 * both servers
		 */
		oauthServer.shutdown();
	}

	@Test
	public void testCreateStudent() {
		StudentResource newStudent = StudentResource.builder().firstName("John").lastName("Doe").build();

		studentApi.serviceEndpoint = mockApiService.url("/v1/student").toString();
		Optional<StudentResource> createdStudent = studentApi.createNewStudent(newStudent);
		Assert.assertEquals(createdStudent.get().getFirstName(), newStudent.getFirstName());

	}
}
