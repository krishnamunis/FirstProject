package com.demo.sample;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/hello")
@RequestMapping("/hello")
public class HelloController {
	//private List<Customer> customerList = new ArrayList<>();
	/*@GET
	@Path("/list")
	@GetMapping(value="/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer findById() {
		Customer newCustomer = new Customer();
		newCustomer.setId("1");
		newCustomer.setName("Tim");
		newCustomer.setPhoneNumber("45668727718");
		newCustomer.setAddress("Tester");
		return newCustomer;
	}*/
    private CustomerDataService customerDataService = CustomerDataService.getInstance();

    @GET
    @Path("/list1")
	@GetMapping(value="/list1")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customerDataService.getCustomerList();
        }
    
    @POST
    @Path("/create")
    @PostMapping("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
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
@Path(value="/world")
@GetMapping(value="/world")
  public String sayHello() {
	return "Hello World ";
}
}
