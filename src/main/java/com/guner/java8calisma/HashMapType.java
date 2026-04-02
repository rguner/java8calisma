package com.guner.java8calisma;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//public class HashMapType <K extends Serializable, V>  aynı sonuc{
public class HashMapType <K, V> {
    private Map<K, V> map = new HashMap<>();

    public void put(K k, V v) {
        map.put(k, v);
    }

    public Map<K,V> getMap() {
        return map;
    }

    public void putAll(Map<K, V> newMap) {
        map.putAll(newMap);
    }

    public Map<K, V> getIntegerKeyTypedMapFromList() {
        List<Integer> listOfInteger = List.of(1,2,3,4,5,6,7,8,9,10);
        return listOfInteger.stream()
                .collect(Collectors.toMap(item -> (K) item, item -> (V) item.toString()));
    }

    public void putAllOfIntegerKeyTypedMapFromList() {
        List<Integer> listOfInteger = List.of(1,2,3,4,5,6,7,8,9,10);
        Map<K, V> tempMap = listOfInteger.stream()
                .collect(Collectors.toMap(item -> (K) item, item -> (V) item.toString()));
        map.putAll(tempMap);
    }

    public void addIntegerKeyTypedItem() {
        Integer key= 11;
        map.put((K) key,(V) "eleven");
    }



}
