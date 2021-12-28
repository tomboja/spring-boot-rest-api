package com.tomboja.bootrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 12/27/21
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 93659234387L;
    private final String resourceName; // Name of the resource that is not available
    private final String fieldName;
    private final Object fieldValue; // This can be any type

    public ResourceNotFoundException(String resourceName,
                                     String fieldName,
                                     Object fieldValue,
                                     String operation) {
        super(String
                .format("%s not found with %s : '%s' when performing %s",
                        resourceName, fieldName, fieldValue, operation));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
