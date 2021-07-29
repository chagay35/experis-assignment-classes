package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Writer {
    /**
     * here we are writing on file all the information
     * @param listOfDetails with the information
     */
    public void writeToFile(List<ArrayList<String>> listOfDetails){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            for (ArrayList<String> l : listOfDetails) {
                l.forEach((city) -> {
                    try {
                        myWriter.write(city + ",");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                myWriter.write("|");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
