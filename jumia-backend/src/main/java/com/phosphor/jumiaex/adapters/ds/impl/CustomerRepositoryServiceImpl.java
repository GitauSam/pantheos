package com.phosphor.jumiaex.adapters.ds.impl;

import com.phosphor.jumiaex.adapters.ds.interfaces.CustomerRepositoryService;
import com.phosphor.jumiaex.adapters.ds.repositories.CustomerRepository;
import com.phosphor.jumiaex.entities.Country;
import com.phosphor.jumiaex.entities.Customer;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CustomerRepositoryServiceImpl implements CustomerRepositoryService {

    private final CustomerRepository customerRepository;
    private final CustomerRepositoryConverter customerRepositoryConverter;

    @Override
    public Collection<Customer> getAllCustomers() {
        customerRepository.count();
        return customerRepository
                .findAll()
                .stream()
                .map(customerRepositoryConverter::mapToTable)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Customer> getFilteredCustomers(String country, String state) {
        if (country != null && (state == null || state.isEmpty())) {
            Country c = Arrays
                            .stream(Country.values())
                            .filter(cp -> cp.getName().equals(country))
                            .findAny()
                            .orElse(null);

            return customerRepository
                    .findAllByPhoneNumberStartingWith(c != null ? String.format("(%s)", c.getCode()) : "")
                    .stream()
                    .map(customerRepositoryConverter::mapToTable)
                    .collect(Collectors.toList());
        } else if ((country == null || country.isEmpty()) && state != null) {
            return customerRepository
                    .findAll()
                    .stream()
                    .map(customerRepositoryConverter::mapToTable)
                    .filter(c -> c.isPhoneNumberValid() == (state.equalsIgnoreCase("Valid")))
                    .collect(Collectors.toList());
        }

        assert country != null;

        Country c = Arrays
                .stream(Country.values())
                .filter(cp -> cp.getName().equals(country))
                .findAny()
                .orElse(null);

        return customerRepository
                .findAllByPhoneNumberStartingWith(c != null ? String.format("(%s)", c.getCode()) : "")
                .stream()
                .map(customerRepositoryConverter::mapToTable)
                .filter(cp -> cp.isPhoneNumberValid() == (state.equalsIgnoreCase("Valid")))
                .collect(Collectors.toList());
    }

}
