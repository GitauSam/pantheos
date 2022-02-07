package com.phosphor.jumiaex.interactors.exceptions;

import lombok.Getter;

@Getter
public class CouldNotFetchCustomersException extends Exception {
    public CouldNotFetchCustomersException(String message) {
        super(message);
    }
}
