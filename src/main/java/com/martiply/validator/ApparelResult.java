package com.martiply.validator;

import com.martiply.model.interfaces.IApparelExtension;

import java.util.List;
import java.util.stream.Collectors;

public class ApparelResult implements IApparelExtension, ValidationError {

    public final String gender, age, sizeSystem, size, color, material, feature, groupId;
    private final List<String> errors;
    private final boolean isIgnored;

    public ApparelResult(List<ValidationResult> errors, boolean isIgnored, String gender, String age, String sizeSystem, String size, String color, String material, String feature, String groupId) {
        this.gender = gender;
        this.age = age;
        this.sizeSystem = sizeSystem;
        this.size = size;
        this.color = color;
        this.material = material;
        this.feature = feature;
        this.groupId = groupId;
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
    public String getGroupId() {
        return groupId;
    }

    @Override
    public Gender getGender() {
        return IApparelExtension.Gender.valueOf(gender);
    }

    @Override
    public Age getAge() {
        return IApparelExtension.Age.valueOf(age);
    }

    @Override
    public SizeSystem getSizeSystem() {
        return IApparelExtension.SizeSystem.valueOf(sizeSystem);
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String getFeature() {
        return feature;
    }


    @Override
    public String getId() {
        return null;
    }
}
