package com.service;

import com.dao.CustomerDataBase;
import com.dao.impl.CustomerDataBaseImpl;
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
public class CustomerController {
    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Autowired
    CustomerDataBase customerDataBase ;

    @RequestMapping("/save_data/")
    @ResponseBody
    public String addCustomerData(
            @RequestParam(value="name", required=false, defaultValue="null")String firstName,
            @RequestParam(value="name", required=false, defaultValue="null")String lastName,
            @RequestParam(value="name", required=false, defaultValue="null")String patronymic) {
        String customerData = null;
        try {
            customerDataBase.addCustomer(new Customer(firstName, lastName, patronymic));
            customerData = FillerEntity.fillCustomerData(FillerEntity.fillCustomerData(firstName, lastName, patronymic)).toString();
            return customerData;
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return customerData;
    }
}
