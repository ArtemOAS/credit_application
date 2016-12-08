package com.utils;

import com.entity.Data;
import com.entity.tags.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class FillerEntity {

    private static Customer customer = new Customer();

    @Autowired
    private static Data data;

    public static Data fillCustomerData(List<Customer> customerList){
        data.setCustomer(customerList);
        return data;
    }

    public static List<Customer> fillCustomerData(String firstName, String lastName, String patronymic){
        List<Customer> customerList = new ArrayList<>();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPatronymic(patronymic);
        customerList.add(customer);
        return customerList;
    }
}
