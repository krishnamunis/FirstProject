package com.demo.sample;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

@Produces("application/json")
//@XmlRootElement
public class Customer { 
    private String id; 
    private String name; 
    private String address; 
    private String phoneNumber; 

    public Customer() {
    	    }
    public Customer(String id) {
    	this.id=id;
    } 
    
    public Customer(String id,String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber=phoneNumber;
    }
 
    public void setId(String id) { 
        this.id = id; 
    } 
 
    public void setName(String name) { 
        this.name = name; 
    } 
 
    public void setAddress(String address) { 
        this.address = address; 
    } 
 
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
    } 
 
    public String getId() { 
        return id; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public String getPhoneNumber() { 
        return phoneNumber; 
    } 
 
    public String getAddress() { 
        return address; 
    }
    public String toString() {
    	return "Customer[id:"+id+",name:"+name+",Address:"+address+",PH:"+phoneNumber+"]";
    }
	
}
