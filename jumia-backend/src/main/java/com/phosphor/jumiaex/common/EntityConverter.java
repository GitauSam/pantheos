package com.phosphor.jumiaex.common;

import java.io.Serializable;

public interface EntityConverter<T extends Serializable, P extends Serializable> {
    default T mapToTable(final P persistenceObject) {
        throw new UnsupportedOperationException();
    }
}

