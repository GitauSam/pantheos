package com.phosphor.jumiaex.interactors.impl;

import com.phosphor.jumiaex.adapters.ds.impl.CustomerRepositoryConverter;
import com.phosphor.jumiaex.adapters.ds.impl.CustomerRepositoryServiceImpl;
import com.phosphor.jumiaex.adapters.ds.interfaces.CustomerRepositoryService;
import com.phosphor.jumiaex.interactors.exceptions.CouldNotFetchCustomersException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GetAllCustomersUseCaseImplTest {

    @Mock private CustomerRepositoryService customerRepositoryService;
    private GetAllCustomersUseCaseImpl getAllCustomersUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getAllCustomersUseCase = new GetAllCustomersUseCaseImpl(customerRepositoryService);
    }
    @Test
    void execute() throws CouldNotFetchCustomersException {
        // when
        getAllCustomersUseCase.execute();

        // then
        verify(customerRepositoryService).getAllCustomers();
    }
}