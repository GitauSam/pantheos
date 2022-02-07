package com.phosphor.jumiaex.entities;

import java.io.Serializable;
import java.util.function.Predicate;

public interface Customer extends Serializable {
    String getName();
    String getPhoneNumber();
    String getCountry();
    boolean isPhoneNumberValid();

    Predicate<String> filterPhoneNumber();

}
