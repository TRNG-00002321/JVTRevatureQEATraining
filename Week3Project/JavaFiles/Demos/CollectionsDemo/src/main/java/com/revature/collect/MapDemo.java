package com.revature.collect;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Double> persons = new HashMap<>();

        persons.put("Alex", 10000.00);
        persons.put("Rebecca", 250000.00);
        persons.put("Peter", 20000.00);
        persons.put("Steve", 90000.00);
        // When putting duplicate keys, the value is updated to the latest value.
        // persons.put("Alex", 150000.00)

        System.out.println(persons.get("Peter"));

        Set<Map.Entry<String, Double>> names = persons.entrySet();
        for (Map.Entry<String, Double> e : names){
            System.out.println(e.getKey() + ", " + e.getValue());
        }
    }
}
