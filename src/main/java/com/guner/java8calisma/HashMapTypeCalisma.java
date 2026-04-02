package com.guner.java8calisma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapTypeCalisma {
    public static void main(String[] args) {
        execute1();
        System.out.println("------------------");
        execute2();
        System.out.println("------------------");
        execute3();
        System.out.println("------------------");
        execute4();
        System.out.println("------------------");
        execute5();

    }

    private static void execute1() {
        HashMapType<String, String> hashMapType1 = new HashMapType<>();
        hashMapType1.put("one", "one1");
        //java: incompatible types: int cannot be converted to java.lang.String -compile time
        //hashMapType1.put(1, "one1");

        HashMapType<Integer, String> hashMapType2 = new HashMapType<>();
        hashMapType2.put(1, "one1");

       // compile time
       //java: incompatible types: java.util.Map<java.lang.Integer,java.lang.String> cannot be converted to java.util.Map<? extends java.lang.String,? extends java.lang.String>
       //hashMapType1.getMap().putAll(hashMapType2.getMap());

        hashMapType1.getMap().forEach((k, v) -> System.out.println(k + " : " + v));

    }

    private static void execute2() {
        // Serializable kullanarak hem String hem Integer key kabul edilir
        HashMapType<Serializable, String> hashMapType1 = new HashMapType<>();
        hashMapType1.put("one", "one1");

        HashMapType<Integer, String> hashMapType2 = new HashMapType<>();
        hashMapType2.put(1, "one1");

        // Artık putAll çalışır: Integer de Serializable'dır
        hashMapType1.getMap().putAll(hashMapType2.getMap());

        hashMapType1.getMap().forEach((k, v) -> System.out.println(k + " : " + v));

    }

    private static void execute3() {
        HashMapType<String, String> hashMapType1 = new HashMapType<>();
        hashMapType1.put("one", "one1");

        hashMapType1.addIntegerKeyTypedItem();

        // String cast olduğu ve hashMapType1.getMap() içinde Integer key'ler olduğu için ClassCastException oluşur
        //hashMapType1.getMap().forEach((k, v) -> System.out.println(k + " : " + v));

        hashMapType1.getMap().values().forEach(System.out::println);

    }

    private static void execute4() {
        HashMapType<String, String> hashMapType1 = new HashMapType<>();
        hashMapType1.put("one", "one1");

        hashMapType1.getMap().putAll(hashMapType1.getIntegerKeyTypedMapFromList());

        // String cast olduğu ve hashMapType1.getMap() içinde Integer key'ler olduğu için ClassCastException oluşur
        //hashMapType1.getMap().forEach((k, v) -> System.out.println(k + " : " + v));

        hashMapType1.getMap().values().forEach(System.out::println);

    }

    private static void execute5() {
        HashMapType<String, String> hashMapType1 = new HashMapType<>();
        hashMapType1.put("two", "two2");

        hashMapType1.putAllOfIntegerKeyTypedMapFromList();

        // String cast olduğu ve hashMapType1.getMap() içinde Integer key'ler olduğu için ClassCastException oluşur
        //hashMapType1.getMap().forEach((k, v) -> System.out.println(k + " : " + v));

        hashMapType1.getMap().values().forEach(System.out::println);


    }




}
