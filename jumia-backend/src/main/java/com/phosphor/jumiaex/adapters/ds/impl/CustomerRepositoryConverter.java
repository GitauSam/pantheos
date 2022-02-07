package com.phosphor.jumiaex.adapters.ds.impl;

import com.phosphor.jumiaex.adapters.ds.domain.JpaCustomer;
import com.phosphor.jumiaex.common.EntityConverter;
import com.phosphor.jumiaex.entities.Customer;
import com.phosphor.jumiaex.entities.CustomerEntity;

public class CustomerRepositoryConverter implements EntityConverter<Customer, JpaCustomer> {
    @Override
    public Customer mapToTable(JpaCustomer persistenceObject) {
        return new CustomerEntity(
                persistenceObject.getName(),
                persistenceObject.getPhoneNumber()
        );
    }


}
