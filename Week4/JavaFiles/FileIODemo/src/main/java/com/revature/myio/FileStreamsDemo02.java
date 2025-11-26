package com.revature.myio;

import java.io.*;

public class FileStreamsDemo02 {
    public static void main(String[] args) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader("example.txt"));
             BufferedWriter outputStream = new BufferedWriter(new FileWriter("output2.txt"))) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                outputStream.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
