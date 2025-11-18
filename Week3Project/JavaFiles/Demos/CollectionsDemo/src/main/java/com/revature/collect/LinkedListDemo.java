package com.revature.collect;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integers: ");
        String[] numberStrings = scanner.nextLine().split(" ");
        for (String s : numberStrings) {
            myLinkedList.add(Integer.parseInt(s));
        }

        Iterator<Integer> myIterator = myLinkedList.iterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        System.out.print("\nEnter an integer to remove: ");
        int target = scanner.nextInt();
        scanner.nextLine();

        if (myLinkedList.contains(target)) {
            myLinkedList.remove((Integer) target);
            System.out.println("Removed integer from the list.");
        }
        else {
            System.out.println("This integer is not in the list.");
        }

        System.out.println("\nsize = " + myLinkedList.size());
    }
}