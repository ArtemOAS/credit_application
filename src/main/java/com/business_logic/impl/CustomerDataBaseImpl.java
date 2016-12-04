package com.business_logic.impl;

import com.business_logic.CustomerDataBase;
import com.entity.tags.Customer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CustomerDataBaseImpl implements CustomerDataBase {
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();

    @Override
    public Customer addCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        Customer customerData = entityManager.merge(customer);
        entityManager.getTransaction().commit();
        return customerData;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.remove(getCustomer(customer));
        entityManager.getTransaction().commit();
    }

    @Override
    public Customer getCustomer(Customer customer) {
        return entityManager.find(Customer.class, customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> namedQuery = entityManager.createNamedQuery("Customer.getdAll", Customer.class);
        return namedQuery.getResultList();
    }
}
