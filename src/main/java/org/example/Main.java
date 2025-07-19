package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // entrada y salida datos del comprador
        Scanner sc = new Scanner(System.in);
        Comprador comprador = new Comprador();
        int option4=1;
        do{
            comprador.menuComprador();
            comprador.opcionesMenu();
            System.out.println("Desea regresar al menu principal del cliente\n1. Si.\n2. No.");
            option4 =Integer.parseInt(sc.nextLine());

        }while(option4==1);

        //fin de datos del comprador



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