package com.phosphor.jumiaex.interactors.interfaces;

import com.phosphor.jumiaex.entities.Customer;
import com.phosphor.jumiaex.interactors.exceptions.CouldNotFetchCustomersException;
import com.phosphor.jumiaex.interactors.exceptions.InvalidFilterParametersException;

import java.util.Collection;

public interface GetFilteredCustomersUseCase {
    Collection<Customer> execute(String country, String state) throws CouldNotFetchCustomersException, InvalidFilterParametersException;
}
