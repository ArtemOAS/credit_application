package com.entity;

import com.entity.tags.Customer;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Component
@XmlRootElement(name = "data")
public class Data {

    private List<Customer> customer;

    @XmlElement(name = "customer")
    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
