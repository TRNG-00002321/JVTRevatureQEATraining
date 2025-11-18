package com.revature.collect;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        // myList.add(1);
        myList.add("Jasdhir");
        myList.add("Nikhil");
        myList.add("Moses");
        // myList.add(10.3);

        System.out.println(myList.get(1));

        Iterator iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        for (String s : myList) {
            System.out.println(s);
        }

        myList.remove(1);
        System.out.println(myList);

        // Iterate over a list from end to beginning
        for (int i = myList.size() - 1; i >= 0; i--) {
            System.out.println(myList.get(i));
        }
    }
}
