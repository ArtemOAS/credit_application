package com.service;

import com.business_logic.impl.CustomerDataBaseImpl;
import com.entity.Data;
import com.entity.tags.Customer;
import com.utils.FillerEntity;
import com.utils.JaxbUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class CustomerService {
    private static final Logger LOGGER = Logger.getLogger(CustomerService.class);

    @Autowired
    JaxbUtils jaxbUtils;

    @Autowired
    FillerEntity fillerEntity;

    @Autowired
    CustomerDataBaseImpl customerDataBase;

    @Autowired
    Customer customer;


    @RequestMapping("/save_data/")
    @ResponseBody
    public String addCustomerData(
            @RequestParam(value="name", required=false, defaultValue="null")String firstName,
            @RequestParam(value="name", required=false, defaultValue="null")String lastName,
            @RequestParam(value="name", required=false, defaultValue="null")String patronymic) {
        String customerData = null;
        try {
            customerDataBase.addCustomer(new Customer(firstName, lastName, patronymic));
            customerData = jaxbUtils.objectToXml(
                    fillerEntity.fillCustomerData(
                            fillerEntity.fillCustomerData(firstName, lastName, patronymic)), Data.class);
            return customerData;
        } catch (Exception e) {
            LOGGER.info(customerData, e);
            return customerData;
        }
    }
}
