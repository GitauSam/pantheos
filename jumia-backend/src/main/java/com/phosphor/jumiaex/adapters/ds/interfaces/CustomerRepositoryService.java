package com.phosphor.jumiaex.adapters.ds.interfaces;

import com.phosphor.jumiaex.entities.Customer;

import java.util.Collection;

public interface CustomerRepositoryService {
    Collection<Customer> getAllCustomers();
    Collection<Customer> getFilteredCustomers(String country, String state);
}
