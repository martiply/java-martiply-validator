package com.martiply.validator;

import com.martiply.model.interfaces.AbsImg;
import com.martiply.model.interfaces.IApparelExtension;
import com.martiply.model.interfaces.IItem;
import com.martiply.model.interfaces.ISale;

import java.util.List;
import java.util.stream.Collectors;

public class PermaResult implements IItem, ValidationError {

    public final String idCustom, gtin, name, brand;
    private final List<String> errors;

    public PermaResult(List<ValidationResult> errors, String idCustom, String gtin, String name, String brand) {
        this.idCustom = idCustom;
        this.gtin = gtin;
        this.name = name;
        this.brand = brand;
        this.errors = errors.stream().map(p -> p.val.toString()).collect(Collectors.toList());
    }

    @Override
    public boolean isIgnored() {
        return false;
    }

    @Override
    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String getGtin() {
        return gtin;
    }

    @Override
    public String getIdCustom() {
        return idCustom;
    }

    @Override
    public String getBrand() { return brand; }

    @Override
    public String getName() { return name; }



    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getPrice() {
        return null;
    }

    @Override
    public String getCategory() {
        return null;
    }

    @Override
    public int getHits() {
        return 0;
    }

    @Override
    public Condition getCondition() {
        return null;
    }

    @Override
    public IApparelExtension getApparelExtension() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public ISale getSale() {
        return null;
    }

    @Override
    public AbsImg getImg() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public int getOwnerId() {
        return 0;
    }
}
