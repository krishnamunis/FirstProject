package com.demo.sample;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		Response Response = target("/hello/world").request().get(Response.class);
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
                .accept(MediaType.TEXT_PLAIN_TYPE)
                //this time we are calling post to make a HTTP POST call
                .post(Entity.json(newCustomer), String.class);
        System.out.println(response);
	} 
        @Test
        public void putMethodTest() {
        	ObjectMapper mapper = new ObjectMapper();
            String joe = CustomerDataService.createCustomerInJSON("8","Joe", "435 West Dr, Peejay", "555-456-9877");
           // Customer joe=CustomerDataService.createNewCustomer("Joe", "435 West Dr, Peejay", "555-456-9877");
        	//String response = target("/hello/create").request().post(Entity.entity(joe, MediaType.APPLICATION_JSON),String.class);
        	try {
				Customer student = mapper.readValue(joe, Customer.class);
				System.out.println(student);
				joe = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
		         
		         System.out.println(joe);
			} 
        	catch (JsonParseException e) { e.printStackTrace();}
            catch (JsonMappingException e) { e.printStackTrace(); }
        	catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
	}*/
        @Test
        public void getMethodTest() {
           Invocation.Builder request =target("/hello/list1").request();
           // String response = target("/hello/list1").request().accept(MediaType.APPLICATION_JSON).get(String.class);
    		Response Response=request.get(Response.class);
    		System.out.println(Response);
        	
        }
}

