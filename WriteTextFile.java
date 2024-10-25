package com.tripillar.filehandling.text;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
    public static void main(String[] args) {
        String fileName = "output.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, this is a sample text.");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

