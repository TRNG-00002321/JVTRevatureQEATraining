package com.revature.collect;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>(); // No guarantee of ordering
        // Set<String> names = new TreeSet<>(); // Elements sorted based on natural ordering
        // Set<String> names = new LinkedHashSet<>(); // Backed by a LinkedList; maintains insertion order

        names.add("Andrew");
        names.add("Ian");
        names.add("Brandon");
        // names.add("Andrew");

        System.out.println(names);
        System.out.println(names.size());

        for (String s : names) {
            System.out.println(s);
        }

        names.clear();
        System.out.println(names.isEmpty());

        names.add("Smith");
        names.add("John");
        names.add("Pablo");
        names.add("Fred");
        names.add("Lucy");
        names.add("Geraldine");

        System.out.println(names.isEmpty());
        System.out.println(names.contains("Andrew"));
        System.out.println(names.size());

        names.remove("John");
        System.out.println(names);
        System.out.println(names.size());
    }
}
