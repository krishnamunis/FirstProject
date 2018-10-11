package com.demo.sample;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/hello")
@RequestMapping("/hello")
public class HelloController {
    private CustomerDataService customerDataService = CustomerDataService.getInstance();


    @Path("/list1")
    @GET
	@GetMapping(value="/list1")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Customer> getCustomers() {
        return customerDataService.getCustomerList();
    }
    
    @POST
    @Path("/create")
    @PostMapping("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer createCustomer(Customer customer) {
        return customerDataService.addCustomer(customer);
    }
    
	@GET
	@Path("/test")
	@GetMapping(value="/test")
		public String test() {
			return "test";
	}
	
	@GET
	@Path(value="/world/{id}")
	@GetMapping(value="/world/{id}")
	  public String sayHello(@PathVariable("id") String id) {
		return "Hello World "+id;
	}
	
	
	@DELETE
	@Path(value="/delete")
	@DeleteMapping("/delete")
	public boolean delete() {
	    return CustomerDataService.delete();
	}
}
