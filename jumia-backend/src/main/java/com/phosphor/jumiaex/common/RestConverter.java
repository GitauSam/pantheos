package com.phosphor.jumiaex.common;

import java.io.Serializable;

public interface RestConverter<R extends Serializable, E extends Serializable> {
    default R mapToRest(final E entity) {
        throw new UnsupportedOperationException();
    }
}
