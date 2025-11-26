package com.revature.myio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamsDemo01 {
    static FileInputStream fileInputStream;
    static FileOutputStream fileOutputStream;
    public static void main(String[] args) {
        try {
            fileInputStream = new FileInputStream("example.txt");
            fileOutputStream = new FileOutputStream("output1.txt");
            int c;
            // c = fileInputStream.read();
            while ((c = fileInputStream.read()) != -1) {
                // System.out.println(c); // Prints the ASCII chars
                // System.out.write(c);
                fileOutputStream.write(c);
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
