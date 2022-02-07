package com.phosphor.jumiaex.interactors.impl;

import com.phosphor.jumiaex.adapters.ds.interfaces.CustomerRepositoryService;
import com.phosphor.jumiaex.entities.Customer;
import com.phosphor.jumiaex.interactors.exceptions.CouldNotFetchCustomersException;
import com.phosphor.jumiaex.interactors.interfaces.GetAllCustomersUseCase;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class GetAllCustomersUseCaseImpl implements GetAllCustomersUseCase {

    private final CustomerRepositoryService customerRepositoryService;

    @Override
    public Collection<Customer> execute() throws CouldNotFetchCustomersException {
        return customerRepositoryService.getAllCustomers();
    }
}
