package com.martiply.validator;

import com.martiply.model.interfaces.AbsImg;
import com.martiply.model.interfaces.IApparelExtension;
import com.martiply.model.interfaces.IItem;
import com.martiply.model.interfaces.ISale;

import java.util.List;
import java.util.stream.Collectors;

public class BasicsResult implements IItem, ValidationError {

    public final String price, condition, category, url, desc;
    private final List<String> errors;

    public BasicsResult(List<ValidationResult> errors, String price, String condition, String category, String url, String desc) {
        this.price = price;
        this.condition = condition;
        this.category = category;
        this.url = url;
        this.desc = desc;
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
    public String getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public int getOwnerId() {
        return 0;
    }

    @Override
    public String getIdCustom() {
        return null;
    }

    @Override
    public String getGtin() {
        return null;
    }


    @Override
    public String getName() {
        return null;
    }


    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public IdType getIdType() {
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
    public ISale getSale() {
        return null;
    }

    @Override
    public AbsImg getImg() {
        return null;
    }
}
