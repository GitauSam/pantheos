package com.phosphor.jumiaex.adapters.http.impl;

import com.phosphor.jumiaex.adapters.http.dto.CustomerDto;
import com.phosphor.jumiaex.common.RestConverter;
import com.phosphor.jumiaex.entities.Customer;

public class CustomerRestConverter implements RestConverter<CustomerDto, Customer> {
    @Override
    public CustomerDto mapToRest(Customer entity) {
        return new CustomerDto(
                        entity.getName(),
                        entity.getPhoneNumber(),
                        entity.getCountry(),
                        entity.isPhoneNumberValid() ? "Valid" : "Invalid"
                );
    }
}
