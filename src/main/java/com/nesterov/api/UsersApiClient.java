package com.nesterov.api;

import static com.nesterov.config.Config.BASE_URL;
import static com.nesterov.endpoints.EndPoints.USERS;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import com.nesterov.endpoints.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsersApiClient {
	
	private UsersApiClient() {
	}

	public static void setBaseUrl() {
		baseURI = BASE_URL;
	}
	
	public static Response usersList() {
		return get(USERS);
	}
	
	public static Response createUser(ContentType contentType, JSONObject requestParams) {
		return given().contentType(contentType).body(requestParams.toString()).post(USERS);	
	}
	
	public static Response deleteUser() {
		return given().delete(EndPoints.USERS_2);	
	}
	
	public static Response putUser(ContentType contentType, JSONObject requestParams) {
		return given().contentType(contentType).body(requestParams.toString()).put(EndPoints.USERS_2);	
	}
	
	public static Response singlUserNotFound() {
		return given().get(EndPoints.USERS_23);	
	}
	
	public static Response loginSuccessful(ContentType contentType, JSONObject requestParams) {
		return given().contentType(contentType).body(requestParams.toString()).post(EndPoints.LOGIN);	
	}
}
