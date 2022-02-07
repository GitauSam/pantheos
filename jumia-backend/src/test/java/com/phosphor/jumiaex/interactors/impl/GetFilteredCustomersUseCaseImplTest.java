package com.phosphor.jumiaex.interactors.impl;

import com.phosphor.jumiaex.adapters.ds.interfaces.CustomerRepositoryService;
import com.phosphor.jumiaex.interactors.exceptions.CouldNotFetchCustomersException;
import com.phosphor.jumiaex.interactors.exceptions.InvalidFilterParametersException;
import com.phosphor.jumiaex.interactors.interfaces.GetFilteredCustomersUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GetFilteredCustomersUseCaseImplTest {

    @Mock
    private CustomerRepositoryService customerRepositoryService;
    private GetFilteredCustomersUseCase getFilteredCustomersUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getFilteredCustomersUseCase = new GetFilteredCustomersUseCaseImpl(customerRepositoryService);
    }

    @Test
    void execute() throws CouldNotFetchCustomersException, InvalidFilterParametersException {
        //given
        String countryTest = "Morocco";
        String stateTest = "Valid";

        //when
        getFilteredCustomersUseCase.execute(countryTest, stateTest);

        //then
        ArgumentCaptor<String> countyCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> stateCaptor = ArgumentCaptor.forClass(String.class);

        verify(customerRepositoryService)
                .getFilteredCustomers(countyCaptor.capture(), stateCaptor.capture());
    }
}