package com.martiply.validator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    @Test
    public void gtinTest() {
        String s13 = "07350053850019";
        assertEquals(Validator.ValidatorEnum.ok, Validator.gtin(s13).val);
        String s12 = "043168000604";
        assertEquals(Validator.ValidatorEnum.ok, Validator.gtin(s12).val);
        String empty = "";
        assertEquals(Validator.ValidatorEnum.ok, Validator.gtin(empty).val);
        String f1 = "012345678";
        assertEquals(Validator.ValidatorEnum.gtin, Validator.gtin(f1).val);
        String f2 = "fr3343903903";
        assertEquals(Validator.ValidatorEnum.gtin, Validator.gtin(f2).val);
    }

    @Test
    public void idCustomTest() {
        String s1 = "fskfl;sd2342";
        assertEquals(Validator.ValidatorEnum.ok, Validator.idCustom(s1).val);
        String s2 = "fskflkl;ml;l;3ll;kl435lml;";
        assertEquals(Validator.ValidatorEnum.idCustom, Validator.idCustom(s2).val);
    }

    @Test
    public void brandTest() {
        String s1 = "jgfdfgkdf";
        assertEquals(Validator.ValidatorEnum.ok, Validator.brand(s1).val);
        String f1 = "aslfsdfklskfl;skfl;sfl;sjkfnslflsfkldsjfkldsjfksdjfsdjdkfsdsfdsfdsfd";
        assertEquals(Validator.ValidatorEnum.brand, Validator.brand(f1).val);
    }

    @Test
    public void nameTest() {
        String s1 = "jgfdfgkdf";
        assertEquals(Validator.ValidatorEnum.ok, Validator.name(s1).val);
        String f1 = "aslf;aaasdfklskfl;skfl;sfl;sjkfnslflsfkldsjfkldsjfksdjfsdjdkfsdsfdsfdsfdsfsdfsdfsfsdfdsf";
        assertEquals(Validator.ValidatorEnum.name, Validator.name(f1).val);
        String empty = null;
        assertEquals(Validator.ValidatorEnum.name, Validator.name(empty).val);
    }

    @Test
    public void priceTest() {
        String s1 = "3400.56";
        assertEquals(Validator.ValidatorEnum.ok, Validator.price(s1).val);
        String s2 = "52000";
        assertEquals(Validator.ValidatorEnum.ok, Validator.price(s2).val);
        String s3 = "999999999";
        assertEquals(Validator.ValidatorEnum.ok, Validator.price(s3).val);
        String f1 = "3400.2222222";
        assertEquals(Validator.ValidatorEnum.price, Validator.price(f1).val);
        String f2 = "03400";
        assertEquals(Validator.ValidatorEnum.price, Validator.price(f2).val);
        String f3 = "1000000000";
        assertEquals(Validator.ValidatorEnum.price, Validator.price(f3).val);
    }

    @Test
    public void categoryTest() {
        String empty = "";
        assertEquals(Validator.ValidatorEnum.category, Validator.category(empty).val);
        String s1 = "sfjfsjdflk sdjfksdj kl;djfksjfksd sdfjsjfsdf jsdfjdsnhfj nsj fjsdf njds jkdf bjksdfnbjsdf jksndfjksdnfjk njsd nbjdsf bjdsfb .kdsbf jksdfbnjdsfbnjdsf";
        assertEquals(Validator.ValidatorEnum.category, Validator.category(empty).val);
    }

    @Test
    public void conditionTest() {
        String empty = "";
        assertEquals(Validator.ValidatorEnum.cond, Validator.condition(empty).val);
    }

    @Test
    public void saleStartTs() {
        String s1 = "32342342348";
        assertEquals(Validator.ValidatorEnum.ok, Validator.saleStartTs(s1).val);
        String f1 = "32342342348a";
        assertEquals(Validator.ValidatorEnum.ts, Validator.saleStartTs(f1).val);
    }

    @Test
    public void saleStartDate() {
        String s1 = "2018-09-09";
        assertEquals(Validator.ValidatorEnum.ok, Validator.saleEndDate(s1, Validator.DATE_FORMAT).val);

        String s2 = "2018-09-09aa";
        assertEquals(Validator.ValidatorEnum.ok, Validator.saleEndDate(s2, Validator.DATE_FORMAT).val);

        String f1 = "2018-September-09";
        assertEquals(Validator.ValidatorEnum.date, Validator.saleEndDate(f1, Validator.DATE_FORMAT).val);

        String f2 = "2018/9/9";
        assertEquals(Validator.ValidatorEnum.date, Validator.saleEndDate(f2, Validator.DATE_FORMAT).val);

        String f3 = "lk4t";
        assertEquals(Validator.ValidatorEnum.date, Validator.saleEndDate(f3, Validator.DATE_FORMAT).val);

    }

    @Test
    public void age(){
        String s1 = "adult";
        assertEquals(Validator.ValidatorEnum.ok, Validator.age(s1).val);
        String f1 = "asfg";
        assertEquals(Validator.ValidatorEnum.age, Validator.age(f1).val);
    }

    @Test
    public void gender(){
        String s1 = "male";
        assertEquals(Validator.ValidatorEnum.ok, Validator.gender(s1).val);
        String f1 = "asfg";
        assertEquals(Validator.ValidatorEnum.gender, Validator.gender(f1).val);
    }

    @Test
    public void sizeSystem(){
        String s1 = "SML";
        assertEquals(Validator.ValidatorEnum.ok, Validator.sizeSystem(s1).val);
        String s2 = "EU";
        assertEquals(Validator.ValidatorEnum.ok, Validator.sizeSystem(s2).val);
        String f1 = "asfg";
        assertEquals(Validator.ValidatorEnum.sizeSystem, Validator.sizeSystem(f1).val);
    }

    @Test
    public void size(){
        String s1 = "32,33";
        assertEquals(Validator.ValidatorEnum.ok, Validator.size(s1).val);
        String f1 = "32,akdakdaksdkasdkas;ldklasdkl;askdlsakdaskdlaskdasd";
        assertEquals(Validator.ValidatorEnum.size, Validator.size(f1).val);
    }

    @Test
    public void color(){
        String s1 = "red,blue";
        assertEquals(Validator.ValidatorEnum.ok, Validator.color(s1).val);
        String f1 = "red,akdakdaksdkasdkas;ldklasdkl;askdlsakdaskdlaskdasd";
        assertEquals(Validator.ValidatorEnum.color, Validator.color(f1).val);
    }

    @Test
    public void feature(){
        String s1 = "summer,casual";
        assertEquals(Validator.ValidatorEnum.ok, Validator.feature(s1).val);
        String f1 = "summer,akdakdaksdkasdkas;ldklasdkl;askdlsakdaskdlaskdasdaadadasdasddasdasdasd";
        assertEquals(Validator.ValidatorEnum.feature, Validator.feature(f1).val);
    }

    @Test
    public void material(){
        String s1 = "nylon,cotton";
        assertEquals(Validator.ValidatorEnum.ok, Validator.material(s1).val);
        String f1 = "nylon,akdakdaksdkasdkas;ldklasdkl;askdlsakdaskdlaskdasdaadadasdasddasdasdasd";
        assertEquals(Validator.ValidatorEnum.material, Validator.material(f1).val);
    }



}
