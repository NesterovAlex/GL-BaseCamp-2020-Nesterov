package com.nesterov.selenium.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:google_search.properties", encoding="UTF-8")
@Import(value = { SpringConfig.class })
public class GoogleSearchConfig {

}
