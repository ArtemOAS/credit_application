package com.utils;

import com.entity.Data;
import com.entity.tags.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FillerEntity {

    @Autowired
    private Customer customer;

    @Autowired
    Data data;

    public Data fillCustomerData(List<Customer> customerList){
        data.setCustomer(customerList);
        return data;
    }

    public List<Customer> fillCustomerData(String firstName, String lastName, String patronymic){
        List<Customer> customerList = new ArrayList<>();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPatronymic(patronymic);
        customerList.add(customer);
        return customerList;
    }
}
