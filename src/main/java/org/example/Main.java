package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Car> cars = loadCarsFromFile("cars-data.json");

        Menu menu = new Menu(cars);
        menu.startApplication();
    }
    // Method to load cars from the JSON file (in resources)
    private static List<Car> loadCarsFromFile(String fileName) {
        try (InputStreamReader reader = new InputStreamReader(Menu.class.getClassLoader().getResourceAsStream(fileName))) {
            // Create a Gson object to parse the JSON
            Gson gson = new Gson();
            // Define the type of list to be deserialized
            return gson.fromJson(reader, new TypeToken<List<Car>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}