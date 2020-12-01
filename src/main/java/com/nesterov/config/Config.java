package com.nesterov.config;

import static java.lang.System.getenv;
 
public  class Config {

	public static final String ENVIRONMENT = "TESTS_BASE_URL"; 
	public static final String DEFAULT_URL = "https://reqres.in/";
	public static final String BASE_URL = getEnv(ENVIRONMENT);
	
	private  Config() {
	}

	private static String getEnv(String env) {
		String baseUrl = getenv(env);
		if(baseUrl == null) {
			baseUrl = DEFAULT_URL;
		}
		return baseUrl;
	}
}
