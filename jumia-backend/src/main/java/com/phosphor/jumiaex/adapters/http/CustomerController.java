package com.phosphor.jumiaex.adapters.http;

import com.phosphor.jumiaex.adapters.http.dto.CustomerDto;
import com.phosphor.jumiaex.adapters.http.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerController {
    ResponseEntity<ApiResponse<List<CustomerDto>>> getAllCustomers();
    ResponseEntity<ApiResponse<List<CustomerDto>>> filterCustomers(String country, String state
    );
}
