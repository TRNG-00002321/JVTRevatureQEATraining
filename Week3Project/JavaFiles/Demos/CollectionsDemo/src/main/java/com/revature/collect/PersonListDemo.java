package com.revature.collect;

import java.util.ArrayList;
import java.util.List;

public class PersonListDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person(1, "Jeffy", 27));
        people.add(new Person(2, "Jenny", 30));
        people.add(new Person(3, "Jopper", 22));
        people.add(new Person(4, "Jacque", 28));
        people.add(new Person(5, "Jumbus", 21));

        System.out.println(people);

        for (Person p : people) {
            p.setAge(p.getAge() + 5);
        }

        System.out.println(people);
    }
}
