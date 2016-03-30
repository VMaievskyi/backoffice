package com.backoffice;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class SessionManagement {

	@Scope(value = WebApplicationContext.SCOPE_SESSION)
	@Bean(name = "sessionContext")
	public SessionContext sessionContext() {
		return new SessionContext();
	}

	public class SessionContext extends ConcurrentHashMap<String, Object> {
	}
}
