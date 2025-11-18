package com.revature.collect;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SortDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Brandon");
        names.add("Alex");
        names.add("Peter");
        names.add("Nikhil");

        System.out.println(names);

        Collections.sort(names);
        System.out.println(names);

        Collections.sort(names, Collections.reverseOrder());
        System.out.println(names);
    }
}
