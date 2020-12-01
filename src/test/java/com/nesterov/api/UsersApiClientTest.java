package com.nesterov.api;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;

class UsersApiClientTest {

	/**
	 * "mvn -Dtests=integration test"          command running integration-tests group, 
	 * "mvn -Dtests=integration, smoke test"   command running integration and smoke tests group
	 **/

	@BeforeEach
	void setUp() {
		UsersApiClient.setBaseUrl();
	}

	@Test
	@Tag("integration")
	void itChecksUserList() {
		int expected = 200;
		UsersApiClient.usersList().then().statusCode(expected);
	}

	@Test
	@Tag("smoke")
	@Tag("negative")
	void givenNonExistingValueOfExistingKey_whenGetUsersList_thenFail() {
		int non_existing = 2;
		UsersApiClient.usersList().then().body("page", is(non_existing));
	}

	@Test
	@Tag("integration")
	void givenUsersApiClient_whenGetUsers_thenContentTypeIsJson() {
		UsersApiClient.usersList().then().assertThat().contentType(ContentType.JSON);
	}

	@Test
	@Tag("smoke")
	void givenExpectedHeader_whenGetUsers_thenRelevantHeaderReturned() {
		String header = "Server";
		String expected = "cloudflare";
		UsersApiClient.usersList().then().assertThat().header(header, expected);
	}

	@Test
	@Tag("smoke")
	void itChecksUserCreated() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");
		int expected = 201;
		UsersApiClient.createUser(ContentType.JSON, requestParams).then().statusCode(expected);
	}

	@Test
	@Tag("smoke")
	@Tag("negative")
	void givenEmptyBody_WhenCreateUser_thenResponseWithExpectedTextTReturned() {
		JSONObject requestParams = new JSONObject();
		UsersApiClient.createUser(ContentType.JSON, requestParams).then().assertThat().body(containsString("id"));
	}

	@Test
	@Tag("smoke")
	void givenExpectedOfExistingHeader_whenCreateUser_thenExpectedResultReturned() {
		String header = "Content-Length";
		String expected = "87";
		int expectedCode = 201;
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Alex");
		requestParams.put("job", "automation qa");
		UsersApiClient.createUser(ContentType.JSON, requestParams).then().assertThat().statusCode(expectedCode).and()
				.contentType(ContentType.JSON).and().header(header, expected);
	}

	@Test
	@Tag("regretion")
	void givenExpectedStatusCode_whenDeleteUser_thenRelevantStatusCodeReturned() {
		int expected = 204;
		UsersApiClient.deleteUser().then().assertThat().statusCode(expected);
	}

	@Test
	@Tag("regretion")
	void givenUsersApiClient_whenDeleteUser_thenEmptyBodyReturned() {
		String body = UsersApiClient.deleteUser().then().extract().body().asString();
		assertTrue(body.isEmpty(), "Empty response body");
	}

	@Test
	@Tag("performance")
	void givenExpectedStringOfExistingBody_whenPutUser_thenRelevantElementReturned() {
		final JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "zion resident");
		String expected = "updatedAt";
		UsersApiClient.putUser(ContentType.JSON, requestParams).then().body(containsString(expected));
	}

	@Test
	@Tag("performance")
	void givenExpectedStatusCode_whenPutUser_thenRelevantstatusCodeReturned() {
		final JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "zion resident");
		int expected = 200;
		UsersApiClient.putUser(ContentType.JSON, requestParams).then().statusCode(expected);
	}

	@Test
	@Tag("performance")
	void givenContantTypeText_whenPutUser_thenExpectedStatusCodeReturned() {
		final JSONObject requestParams = new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "zion resident");
		int expected = 200;
		UsersApiClient.putUser(ContentType.TEXT, requestParams).then().statusCode(expected);
	}

	@Test
	@Tag("performance")
	@Tag("positive")
	void givenExpectedStatusCode_whenSinglUserNotFound_thenRelevantStatusCodeReturned() {
		int expected = 404;
		UsersApiClient.singlUserNotFound().then().statusCode(expected);
	}

	@Test
	@Tag("performance")
	void givenExpectedBody_whenSinglUserNotFound_thenRelevantBodyReturned() {
		String expected = "{}";
		UsersApiClient.singlUserNotFound().then().body(containsString(expected));
	}

	@Test
	@Tag("smoke")
	@Tag("positive")
	void givenExpectedValueOfExistingToken_whenLoginSuccessful_thenRelevantValueReturned() {
		final JSONObject requestParams = new JSONObject();
		requestParams.put("email", "eve.holt@reqres.in");
		requestParams.put("password", "cityslicka");
		String key = "token";
		String expected = "QpwL5tke4Pnpja7X4";
		UsersApiClient.loginSuccessful(ContentType.JSON, requestParams).then().body(key, is(expected));
	}

	@Test
	@Tag("smoke")
	@Tag("nagative")
	void givenExpectedValueOfNon_ExistingToken_whenLoginSuccessful_thenFail() {
		final JSONObject requestParams = new JSONObject();
		;
		String key = "token";
		String expected = "TEST";
		UsersApiClient.loginSuccessful(ContentType.JSON, requestParams).then().body(key, is(expected));
	}
}
