package com.revature.java8;

import java.util.Optional;

public class Demo01 {
    public static void main(String[] args) {
        String[] words = new String[10];
        words[5] = "Perry";

        /*
        * String word = words[5].toLowerCase();
        * System.out.println(word);
        */

        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
        }
        else {
            System.out.println("Word is null");
        }
    }
}
