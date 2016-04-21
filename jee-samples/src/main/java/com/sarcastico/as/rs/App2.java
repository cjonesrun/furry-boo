package com.sarcastico.as.rs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/app2")
public class App2 extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(App2Endpoints.class));
	}
	

}
