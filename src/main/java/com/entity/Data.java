package com.entity;

import com.entity.tags.Customer;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class Data {

    private List<Customer> customer;

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return new Gson().toJson(Data.class);
    }
}
