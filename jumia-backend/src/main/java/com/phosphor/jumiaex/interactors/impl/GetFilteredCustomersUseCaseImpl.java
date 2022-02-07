package com.phosphor.jumiaex.interactors.impl;

import com.phosphor.jumiaex.adapters.ds.interfaces.CustomerRepositoryService;
import com.phosphor.jumiaex.entities.Customer;
import com.phosphor.jumiaex.interactors.exceptions.InvalidFilterParametersException;
import com.phosphor.jumiaex.interactors.interfaces.GetFilteredCustomersUseCase;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class GetFilteredCustomersUseCaseImpl implements GetFilteredCustomersUseCase {

    private final CustomerRepositoryService customerRepositoryService;

    @Override
    public Collection<Customer> execute(String country, String state) throws InvalidFilterParametersException {

        if ((country == null || country.trim().isEmpty()) && (state == null || state.trim().isEmpty())) {
            throw new InvalidFilterParametersException("All filter parameters are null or empty");
        }

        return customerRepositoryService.getFilteredCustomers(country, state);
    }
}
