package com.martiply.validator;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void perma(){
        String s1Gtin = "0435345655444";
        String s1idCustom = null;
        String s1Name = "adasdas";
        String s1Brand = "ddd";
        PermaResult res1 = Validator.perma(s1Gtin, s1idCustom, s1Name, s1Brand);
        assertEquals(res1.getErrors().size(), 0);
        String f1Gtin = "4543";
        PermaResult res2 = Validator.perma(f1Gtin, s1idCustom, s1Name, s1Brand);
        assertEquals(res2.getErrors().get(0), Validator.ValidatorEnum.gtin.toString());
        String f1Name = "dggdfglfd;gkfdgkldfgfdgfdlg;fdl;gdl;gfdddddrrrrrrrrrrrrrrrrrrffffffffffffffffffffffffffffffff";
        PermaResult res3 = Validator.perma(f1Gtin, s1idCustom, f1Name, s1Brand);
        assertEquals(2, res3.getErrors().size());
    }

    @Test
    public void basics(){
        String s1Price = "100";
        String s1Category = "a;ada";
        String s1Url = "http://dflgf.com";
        String s1Description = "adad";
        BasicsResult res1 = Validator.basics(s1Price, s1Category, s1Url, s1Description);
        assertEquals(res1.getErrors().size(), 0);

        String f1Url = null;
        String f1Description = "";
        BasicsResult res2 = Validator.basics(s1Price, s1Category, f1Url, f1Description);
        res2.getErrors().stream().forEach(System.out::println);
        assertEquals(res2.getErrors().size(), 0);
    }

    @Test
    public void saleTs() {
        String s1Price = "10.33";
        String s1Start = "10044654654";
        String s1End   = "10044654654";
        SalesResult res1 = Validator.salesTs(s1Price, s1Start, s1End);
        assertEquals(0, res1.getErrors().size());
        assertFalse(res1.isIgnored());


        String f1Price = "10.33aaa";
        SalesResult res2 = Validator.salesTs(f1Price, s1Start, s1End);
        assertEquals(1, res2.getErrors().size());
        assertFalse(res2.isIgnored());

        String f2Price = null;
        String f2Start = null;
        String f2End = null;
        SalesResult res3 = Validator.salesTs(f2Price, f2Start, f2End);
        assertEquals(0, res3.getErrors().size());
        assertTrue(res3.isIgnored());

    }

    @Test
    public void apparel(){
        String s1Age = "adult";
        String s1Gender = "male";
        String s1SizeSystem = "SML";
        String s1Color = "red";
        String s1Size = "32";
        String s1material = "silk";
        String s1Feature  = "";
        String s1GroupId  = "";
        ApparelResult res1 = Validator.apparel(s1Gender, s1Age, s1SizeSystem, s1Size, s1Color, s1material, s1Feature, s1GroupId);
        assertEquals(0, res1.getErrors().size());
        assertFalse(res1.isIgnored());

        String f1Age = "";
        String f1Gender = "";
        String f1SizeSystem = null;
        String f1Color = "";
        String f1Size = null;
        String f1material = null;
        String f1Feature  = null;
        String f1GroupId  = "";
        ApparelResult res2= Validator.apparel(f1Gender, f1Age, f1SizeSystem, f1Size, f1Color, f1material, f1Feature, f1GroupId);
        assertEquals(0, res2.getErrors().size());
        assertTrue( res2.isIgnored());

        String f2Size = "akdas.apsdlkasld al;sdkl;sadlasdk ka;ldklas; dkl;asdasdkasldklas";
        String f2Feature = "alsdkls;adladadl;ajdajdajdasjdksajdklsajdkasddaskdksadas sdksakdkas kdj kasdjk'sakdasd'as";
        ApparelResult res3 = Validator.apparel(s1Gender, s1Age, s1SizeSystem, f2Size, s1Color, s1material, f2Feature, s1GroupId);
        assertEquals(2, res3.getErrors().size());
        assertFalse(res1.isIgnored());
    }



}
