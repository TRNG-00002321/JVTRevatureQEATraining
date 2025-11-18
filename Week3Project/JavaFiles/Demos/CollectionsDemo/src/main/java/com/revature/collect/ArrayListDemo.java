package com.revature.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integers: ");
        String[] numberStrings = scanner.nextLine().split(" ");
        for (String s : numberStrings) {
            myArrayList.add(Integer.parseInt(s));
        }

        Iterator<Integer> myIterator = myArrayList.iterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        System.out.print("\nEnter an integer to remove: ");
        int target = scanner.nextInt();
        scanner.nextLine();

        if (myArrayList.contains(target)) {
            myArrayList.remove((Integer) target);
            System.out.println("Removed integer from the list.");
        }
        else {
            System.out.println("This integer is not in the list.");
        }

        System.out.println("\nsize = " + myArrayList.size());
    }
}
