package com.martiply.validator;

import com.martiply.model.interfaces.ISale;

import java.util.List;
import java.util.stream.Collectors;

public class SalesResult implements ISale, ValidationError {

    public final String price;
    public final Long saleStart, saleEnd;
    private final List<String> errors;
    private boolean isIgnored;

    public SalesResult(List<ValidationResult> errors, boolean isIgnored, String price, Long saleStart, Long saleEnd) {
        this.price = price;
        this.saleStart = saleStart;
        this.saleEnd = saleEnd;
        this.errors = errors.stream().map(p -> p.val.toString()).collect(Collectors.toList());
        this.isIgnored = isIgnored;
    }

    @Override
    public boolean isIgnored() {
        return isIgnored;
    }

    @Override
    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String getSalePrice() {
        return price;
    }

    @Override
    public long getSaleStart() {
        return saleStart;
    }

    @Override
    public long getSaleEnd() {
        return saleEnd;
    }

    @Override
    public String getId() {
        return null;
    }
}
