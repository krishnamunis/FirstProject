package com.demo.sample;

import java.util.ArrayList;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;

public class CustomerDataService {
    private static List<Customer> customerList;

    private static CustomerDataService ourInstance = new CustomerDataService();

    public static CustomerDataService getInstance() {
        return ourInstance;
    }

    private CustomerDataService() {
        customerList = new ArrayList<>();
        //creating some dummy customers
        DataFactory dataFactory = new DataFactory();
        for (int i = 1; i <= 6; i++) {
            Customer customer = new Customer(Integer.toString(i));
            customer.setName(dataFactory.getName());
            customer.setAddress(dataFactory.getAddress() + ", "
                                          + dataFactory.getCity());
            customer.setPhoneNumber(dataFactory.getNumberText(3) + "-" +
                                              dataFactory.getNumberText(3) + "-" +
                                              dataFactory.getNumberText(4));
            customerList.add(customer);
        }
    }
    
    public Customer addCustomer(Customer customer) {
    	String newId = Integer.toString(customerList.size() + 1);
        customer.setId(newId);
       // customer.setName("Arun");
       // customer.setAddress("1021 Hweitt Street");
       // customer.setPhoneNumber("343-343-3433");
        customerList.add(customer);
        return customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    
    public static boolean delete() {
        return customerList.removeAll(customerList);
    }

    public static String createCustomerInJSON(String id,String name, String address, String phoneNumber) {
        return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"address\":\"%s\",\"phoneNumber\":\"%s\"}",
                             id,  name, address, phoneNumber);

    }

    public static Customer createNewCustomer(String name, String address, String phoneNumber) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setAddress(address);
        newCustomer.setPhoneNumber(phoneNumber);
        return newCustomer;
    }
}
