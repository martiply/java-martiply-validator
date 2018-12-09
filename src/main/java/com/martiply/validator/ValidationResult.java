package com.martiply.validator;

public class ValidationResult {

    final public String result;
    final public Validator.ValidatorEnum val;

    public ValidationResult(String result, Validator.ValidatorEnum val) {
        this.result = result;
        this.val = val;
    }
}
