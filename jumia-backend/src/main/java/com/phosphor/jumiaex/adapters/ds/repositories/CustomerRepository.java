package com.phosphor.jumiaex.adapters.ds.repositories;

import com.phosphor.jumiaex.adapters.ds.domain.JpaCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<JpaCustomer, Integer> {
    List<JpaCustomer> findAllByPhoneNumberStartingWith(String phoneNumber);
}
