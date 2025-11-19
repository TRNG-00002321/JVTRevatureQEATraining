package com.revature.assignments;

import java.util.Optional;

public class Assignment4 {
    public static void main(String[] args) {
        Person p1 = new Person("Jay", "123-456-7890", "8100 Spooner Street", "Springfield", 79013);
        Person p2 = new Person("Paulina", "523-776-8910");

        Optional<Address> checkAddress = Optional.ofNullable(p1.getAddress());

        if (checkAddress.isEmpty()) {
            System.out.println(p1.getName() + " has no address. It is null.");
        }
        else {
            System.out.println(p1.getName() + " has an address: " + p1.getAddress() + ".");
        }

        checkAddress = Optional.ofNullable(p2.getAddress());
        if (checkAddress.isPresent()) {
            System.out.println(p2.getName() + " has an address: " + p2.getAddress() + ".");
        }
        else {
            System.out.println(p2.getName() + "'s address is null.");
        }
    }
}
