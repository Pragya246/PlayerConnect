package com.build.playerconnectbeta.exceptions;

import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

public class ResourceNotFoundException extends RuntimeException {

    String field;
    int fieldType;

    public ResourceNotFoundException (String field, Integer fieldType) {
        super(String.format("%s not found with id: %d", field, fieldType));
        this.field = field;
        this.fieldType = fieldType;
    }
}
