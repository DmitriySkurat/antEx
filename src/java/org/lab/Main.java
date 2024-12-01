package org.lab;

import org.lab.model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String JSON_FILE_PATH = "out/user.json";

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Chingis");
        user.setPassword("123123");
        user.setEmail("Kakashka228@gmail.com");
        user.setPhone("+777777777");

        System.out.println(user);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            gson.toJson(user, writer);
            System.out.println("User added to file " + JSON_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }

        /**
         * Garbage collector usage
         */
        user = null;
        System.gc();
    }
}