package com.martiply.validator;

import com.martiply.model.interfaces.IApparelExtension;
import com.martiply.model.interfaces.IItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

public class Validator {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static enum ValidatorEnum {
        ok("ok"),

        gtin("GTIN is digit only and has to be 8, 12, 13, or 14 characters"),
        idCustom("Custom id has to be at most 20 characters"),
        name("Name is required and must be at most 80 characters"),
        brand("Brand is required and must be at most 30 characters"),
        price("Price is required and has to be below 1 billion with at most 2 digits precision"),
        category("Category is required and must be at most 200 characters"),
        cond("Condition is required and must be valid"),
        desc("Description must be at most 5000 characters"),
        ts("Timestamp has to be valid Long"),
        date("Date has to be formatted correctly"),
        gender("Gender is required and must be valid"),
        age("Age is required and must be valid"),
        sizeSystem("Size System is required and must be valid"),
        size("Size is required and must be at most 40 characters"),
        color("Color is required and must be at most 40 characters"),
        material("Material is required and must be at most 40 characters"),
        feature("Feature must be at most 60 characters"),
        groupId("Group Id must be at most 30 characters")
        ;

        private final String text;

        ValidatorEnum(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }



    public static ValidationResult gtin (String s){
        s = s == null ? "" : s;
        ValidatorEnum val;
        if (!s.isEmpty() && s.matches("\\d+") && (s.length() == 8 || s.length() == 12 || s.length() == 13 || s.length() == 14)){
            val =  ValidatorEnum.ok;
        } else if (s.isEmpty()){
            val = ValidatorEnum.ok;
        } else{
            val = ValidatorEnum.gtin;
        }
        return new ValidationResult(s, val);
    }

    public static ValidationResult idCustom(String s){
        s = s == null ? "" : s;
        ValidatorEnum val;
        if (!s.isEmpty() &&  s.length() < 20){
            val =  ValidatorEnum.ok;
        } else if (s.isEmpty()){
            val = ValidatorEnum.ok;
        } else {
            val = ValidatorEnum.idCustom;
        }
        return new ValidationResult(s, val);
    }

    public static ValidationResult name(String s) {
        return maxLength(s, 80, ValidatorEnum.name);
    }

    public static ValidationResult brand(String s) {
        return maxLength(s, 30, ValidatorEnum.brand);
    }

    public static ValidationResult price(String s) {
        return price(s, ValidatorEnum.price);
    }

    private static ValidationResult price(String s, ValidatorEnum val){
        s = s == null ? "" : s;
        if (!s.isEmpty() && s.matches("^[1-9]\\d{0,8}(?:\\.\\d{1,2})?$")){
            val =  ValidatorEnum.ok;
        }
        return new ValidationResult(s, val);
    }

    public static ValidationResult category(String s){
        return maxLength(s, 200, ValidatorEnum.category);
    }

    public static ValidationResult condition(String s){
        s = s == null ? "" : s;
        ValidatorEnum val = ValidatorEnum.ok;
        try {
            IItem.Condition.valueOf(s);
        } catch (IllegalArgumentException e){
            val = ValidatorEnum.cond;
        }
        return new ValidationResult(s, val);
    }

    public static ValidationResult description(String s) {
        return maxLength(s, 5000, ValidatorEnum.category);
    }

    private static ValidationResult maxLength(String s, int maxLength, ValidatorEnum val){
        s = s == null ? "" : s;
        if (!s.isEmpty() && s.length() <= maxLength) {
            val = ValidatorEnum.ok;
        }
        return new ValidationResult(s, val);
    }

    private static ValidationResult maxLengthCanEmpty(String s, int maxLength, ValidatorEnum val) {
        s = s == null ? "" : s;
        if (!s.isEmpty() && s.length() <= maxLength) {
            val = ValidatorEnum.ok;
        } else if (s.isEmpty()) {
            val = ValidatorEnum.ok;
        }
        return new ValidationResult(s, val);
    }

    private static ValidationResult ts(String s) {
        s = s == null ? "" : s;
        ValidatorEnum val = ValidatorEnum.ok;
        try {
            Long.valueOf(s);
        }catch (NumberFormatException e){
            val = ValidatorEnum.ts;
        }
        return new ValidationResult(s, val);
    }

    private static ValidationResult date(String s, String dateFormat){
        s = s == null ? "" : s;
        String pattern = "yyyy-MM-dd";
        ValidatorEnum val = ValidatorEnum.ok;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = simpleDateFormat.parse(s);
            s = String.valueOf(date.toInstant().toEpochMilli() * 1000);
        } catch (ParseException e) {
            val = ValidatorEnum.date;
            s = "";
        }
        return new ValidationResult(s, val);
    }

    public static ValidationResult saleStartTs(String s){
        return ts(s);
    }

    public static ValidationResult saleEndTs(String s){
        return ts(s);
    }

    public static ValidationResult saleStartDate(String s, String dateFormat){
        return date(s, dateFormat);
    }

    public static ValidationResult saleEndDate(String s, String dateFormat){
        return date(s, dateFormat);
    }


    public static ValidationResult age(String s) {
        s = s == null ? "" : s;
        ValidatorEnum val = ValidatorEnum.ok;
        try {
            IApparelExtension.Age.valueOf(s);
        } catch (IllegalArgumentException e){
            val = ValidatorEnum.age;
        }
        return new ValidationResult(s, val);

    }

    public static ValidationResult gender(String s) {
        s = s == null ? "" : s;
        ValidatorEnum val = ValidatorEnum.ok;
        try {
            IApparelExtension.Gender.valueOf(s);
        } catch (IllegalArgumentException e){
            val = ValidatorEnum.gender;
        }
        return new ValidationResult(s, val);
    }

    public static ValidationResult sizeSystem(String s) {
        s = s == null ? "" : s;
        ValidatorEnum val = ValidatorEnum.ok;
        try {
            IApparelExtension.SizeSystem.valueOf(s);
        } catch (IllegalArgumentException e){
            val = ValidatorEnum.sizeSystem;
        }
        return new ValidationResult(s, val);
    }

    public static ValidationResult size(String s){
        return maxLength(s, 40, ValidatorEnum.size);
    }

    public static ValidationResult color(String s){
        return maxLength(s, 40, ValidatorEnum.color);
    }

    public static ValidationResult material(String s){
        return maxLength(s, 40, ValidatorEnum.material);
    }

    public static ValidationResult feature(String s){
        return maxLengthCanEmpty(s, 60, ValidatorEnum.feature);
    }

    public static ValidationResult groupId(String s){
        return maxLengthCanEmpty(s, 30, ValidatorEnum.groupId);
    }

}
