package com.demo.sample;


import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldApplicationTests extends JerseyTest  {

	@Override
	protected Application configure() {
		return new ResourceConfig(HelloController.class);
	}
	/*@Test
	public void contextLoads() {
		String Response = target("/hello/test").request().get(String.class);
		System.out.println(Response +"Arun");
		Assert.assertTrue("test".equals(Response));
		
	}
	@Test
	public void contextLoads1() {
		Response Response = target("/hello/world/56").request().get(Response.class);
		System.out.println(Response +"Arun");
		
	}
	@Test
	public void simpleJson() {
		Customer newCustomer = new Customer();
        newCustomer.setName("Jake Mae");
        newCustomer.setAddress("342, Snake Dr, GreenLake");
        newCustomer.setPhoneNumber("444-333-4564");   
       String response = target("/hello/create")
                .request(MediaType.APPLICATION_JSON)
                //this time we are calling post to make a HTTP POST call
                .post(Entity.json(newCustomer), String.class);
        System.out.println(response);
	} */
	
	
	
    @Test
    public void postMethodTest() {
        String joe = CustomerDataService.createCustomerInJSON("7","Joe", "435 West Dr, Peejay", "555-456-9877");
    	String response = target("/hello/create").request()
    									.post(Entity.entity(joe,MediaType.APPLICATION_JSON),String.class);
    	System.out.println(response);
    	Assert.assertEquals(joe, response);
    }
    
    @Test
    public void getMethodTest() {
       Invocation.Builder request =target("/hello/list1").request(MediaType.APPLICATION_JSON);
		String Response=request.get(String.class);
		System.out.println(Response);
    }
    
    @Test
    public void deleteMethodTest() {
    	Invocation.Builder request =target("/hello/delete").request();
    	 boolean Response=request.delete(boolean.class);
    	 System.out.println(Response);
    	 Assert.assertEquals(true, Response);
    	// Assert.assertTrue("test".equals(Response));
    }
}
