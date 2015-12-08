package com.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class MyResourceTest 
{
	private HttpServer server;
	private WebTarget target;
    
	@Before
    public void setUp(){
		server = Main.startServer();
		final Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
    }
	
	@After
	public void tearDown(){
		server.shutdown();
	}
	
	@Test
	public void testGotIt(){
		final String responseMsg = target.path("myresource").request().get(String.class);
		Assert.assertEquals("Got it!", responseMsg);
	}
}
