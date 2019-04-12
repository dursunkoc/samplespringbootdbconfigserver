/**
 * 
 */
package com.aric.samples.dev;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Dursun KOC
 *
 */
@Configuration
@Profile("pg-dev")
public class PostgresDevelopmentConfiguration {
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
	    return new TomcatServletWebServerFactory() {
	    	
	    	@Override
	    	protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
	    		tomcat.enableNaming();
	    		return super.getTomcatWebServer(tomcat);
	    	}

	        
	        @Override
	        protected void postProcessContext(Context context) {
	        	super.postProcessContext(context);
	        	ContextResource contextResource = new ContextResource();
	            contextResource.setName("jdbc/config");
	            contextResource.setType(DataSource.class.getName());
	            contextResource.setProperty("driverClassName", "org.postgresql.Driver");
	            contextResource.setProperty("url", "jdbc:postgresql://localhost:5432/postgres");
	            contextResource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
	            contextResource.setProperty("username", "postgres");
	            contextResource.setProperty("password", "");
	            context.getNamingResources().addResource(contextResource);
	        }
	    };
	}
}