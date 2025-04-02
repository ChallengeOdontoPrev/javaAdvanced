package com.odontoprev.challenge.controllers.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class ValidationError extends CustomError {

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String erro, String path) {
        super(timestamp, status, erro, path);
    }

    public void addError(String fieldName, String message) {
        errors.removeIf(x -> x.getFieldName().equals(fieldName));
        errors.add(new FieldMessage(fieldName, message));
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
}
