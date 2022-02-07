package com.phosphor.jumiaex.adapters.http.impl;

import com.phosphor.jumiaex.adapters.http.CustomerController;
import com.phosphor.jumiaex.adapters.http.dto.CustomerDto;
import com.phosphor.jumiaex.adapters.http.responses.ApiResponse;
import com.phosphor.jumiaex.interactors.exceptions.CouldNotFetchCustomersException;
import com.phosphor.jumiaex.interactors.exceptions.InvalidFilterParametersException;
import com.phosphor.jumiaex.interactors.interfaces.GetAllCustomersUseCase;
import com.phosphor.jumiaex.interactors.interfaces.GetFilteredCustomersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {

    private final CustomerRestConverter customerRestConverter;

    private final GetAllCustomersUseCase getAllCustomersUseCase;
    private final GetFilteredCustomersUseCase getFilteredCustomersUseCase;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiResponse<List<CustomerDto>>> getAllCustomers() {
        ApiResponse<List<CustomerDto>> apiResponse;

        try {
            List<CustomerDto> customers = getAllCustomersUseCase
                                            .execute()
                                            .stream()
                                            .map(customerRestConverter::mapToRest)
                                            .collect(Collectors.toList());

            apiResponse = new ApiResponse<>(
                                    "Success",
                                    "200",
                                    "Successfully fetched customers",
                                    customers
                        );
        } catch (CouldNotFetchCustomersException e) {
            e.printStackTrace();
            apiResponse = new ApiResponse<>(
                    "Error",
                    "99",
                    String.format("Unable to fetch customer. Error: %s.", e.getMessage())
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<ApiResponse<List<CustomerDto>>> filterCustomers(
            @RequestParam(name = "country") String country,
            @RequestParam(name = "phone_state") String state) {

        ApiResponse<List<CustomerDto>> apiResponse;

        try {
            apiResponse = new ApiResponse<>(
                                    "Success",
                                    "200",
                                    "Successfully fetched customers",
                                    getFilteredCustomersUseCase
                                            .execute(country, state)
                                            .stream()
                                            .map(customerRestConverter::mapToRest)
                                            .collect(Collectors.toList())
                            );
        } catch (CouldNotFetchCustomersException | InvalidFilterParametersException e) {
            apiResponse = new ApiResponse<>(
                    "Error",
                    "99",
                    String.format("Unable to fetch filtered customer(s). Error: %s.", e.getMessage())
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
