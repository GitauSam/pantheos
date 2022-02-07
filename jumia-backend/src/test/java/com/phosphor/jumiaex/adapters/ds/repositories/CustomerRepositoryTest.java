package com.phosphor.jumiaex.adapters.ds.repositories;

import com.phosphor.jumiaex.adapters.ds.domain.JpaCustomer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void itShouldFindAllByPhoneNumberStartingWith() {
        // given
        String phoneNumber = "(212)";

        // when
        List<JpaCustomer> customers = customerRepository
                                        .findAllByPhoneNumberStartingWith(phoneNumber);

        // then
        assertThat(customers.size()).isEqualTo(7);
    }
}