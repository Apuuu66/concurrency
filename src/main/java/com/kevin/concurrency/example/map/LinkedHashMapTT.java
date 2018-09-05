package com.kevin.concurrency.example.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Kevin on 2018/8/26.
 */
public class LinkedHashMapTT {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();


        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(4, 4);
        linkedHashMap.get(4);
        linkedHashMap.put(5, 5);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("-------------------------------------------------");
        LinkedHashMap<Integer, Integer> linkedHashMapLRU = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 3;
            }
        };

        linkedHashMapLRU.put(1, 1);
        linkedHashMapLRU.put(2, 2);
        linkedHashMapLRU.put(3, 3);
        linkedHashMapLRU.put(4, 4);
        linkedHashMapLRU.put(5, 5);
        linkedHashMapLRU.get(4);
        linkedHashMapLRU.get(3);
        for (Map.Entry entry : linkedHashMapLRU.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
