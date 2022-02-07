package com.phosphor.jumiaex.interactors.interfaces;

import com.phosphor.jumiaex.entities.Customer;
import com.phosphor.jumiaex.interactors.exceptions.CouldNotFetchCustomersException;

import java.util.Collection;

public interface GetAllCustomersUseCase {
    Collection<Customer> execute() throws CouldNotFetchCustomersException;
}
