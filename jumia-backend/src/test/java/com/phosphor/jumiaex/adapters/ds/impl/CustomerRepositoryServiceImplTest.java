package com.phosphor.jumiaex.adapters.ds.impl;

import com.phosphor.jumiaex.adapters.ds.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerRepositoryServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerRepositoryConverter customerRepositoryConverter;
    private CustomerRepositoryServiceImpl customerRepositoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerRepositoryService = new CustomerRepositoryServiceImpl(
                customerRepository, customerRepositoryConverter
        );
    }

    @Test
    void getAllCustomers() {
        // when
        customerRepositoryService.getAllCustomers();

        // then
        verify(customerRepository).findAll();
    }

    @Test
    void getFilteredCustomers() {
        // given
        String countryCode = "(212)";
        String state = "Valid";
        // when
        customerRepositoryService.getFilteredCustomers(countryCode, state);

        // then
        ArgumentCaptor<String> countryCodeCaptor = ArgumentCaptor.forClass(String.class);
        verify(customerRepository).findAllByPhoneNumberStartingWith(countryCodeCaptor.capture());

    }
}