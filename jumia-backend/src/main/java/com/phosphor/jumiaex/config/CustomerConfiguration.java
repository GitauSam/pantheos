package com.phosphor.jumiaex.config;

import com.phosphor.jumiaex.adapters.ds.impl.CustomerRepositoryServiceImpl;
import com.phosphor.jumiaex.adapters.ds.impl.CustomerRepositoryConverter;
import com.phosphor.jumiaex.adapters.ds.repositories.CustomerRepository;
import com.phosphor.jumiaex.adapters.http.impl.CustomerRestConverter;
import com.phosphor.jumiaex.interactors.impl.GetAllCustomersUseCaseImpl;
import com.phosphor.jumiaex.interactors.impl.GetFilteredCustomersUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    final CustomerRepository customerRepository;

    public CustomerConfiguration(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Bean
    public CustomerRepositoryConverter createCustomerRepositoryConverter() {
        return new CustomerRepositoryConverter();
    }

    @Bean
    public CustomerRepositoryServiceImpl createCustomerPersistenceImpl() {
        return new CustomerRepositoryServiceImpl(
                customerRepository,
                createCustomerRepositoryConverter()
        );
    }

    @Bean
    public GetAllCustomersUseCaseImpl createGetAllCustomersUseCaseImpl() {
        return new GetAllCustomersUseCaseImpl(createCustomerPersistenceImpl());
    }

    @Bean
    public CustomerRestConverter createCustomerRestConverter() {
        return new CustomerRestConverter();
    }

    @Bean
    public GetFilteredCustomersUseCaseImpl createGetFilteredCustomersUseCaseImpl() {
        return new GetFilteredCustomersUseCaseImpl(createCustomerPersistenceImpl());
    }
}
