package com.phosphor.jumiaex.entities;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@AllArgsConstructor
@ToString
public class CustomerEntity implements Customer {
    private final String name;
    private final String phoneNumber;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getCountry() {
        Country country = Arrays
                            .stream(Country.values())
                            .filter(c -> c.getCode().equals(this.phoneNumber.substring(1, 4)))
                            .findAny()
                            .orElse(null);

        return country != null ? country.getName() : "N/A";
    }

    @Override
    public boolean isPhoneNumberValid() {
        return filterPhoneNumber().test(this.phoneNumber);
    }

    @Override
    public Predicate<String> filterPhoneNumber() {
        return msisdn -> {
             Country country = Arrays
                                .stream(Country.values())
                                .filter(c -> c.getCode().equals(msisdn.substring(1, 4)))
                                .findAny()
                                .orElse(null);

             if (country == null) return false;

             return Pattern
                     .compile(country.getRegex())
                     .matcher(this.phoneNumber)
                     .matches();
        };
    }

}
