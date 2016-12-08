package com.dao;

import com.entity.tags.Customer;

import java.util.List;

public interface CustomerDataBase {
    Customer addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer getCustomer(Customer customer);
    void updateCustomer(Customer customer);
    List<Customer> getAll();
}
