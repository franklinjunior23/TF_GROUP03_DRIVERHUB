package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Car> cars;
    private Scanner scanner;

    public Menu(List<Car> cars) {
        this.cars = cars;
        this.scanner = new Scanner(System.in);
    }

    private void printMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Mostrar datos");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Salir");
    }

    private void showCarsStockAvailable() {
        System.out.println("----- CARS AVAILABLE -----");
        int count = 1;
        boolean found = false;

        for (Car car : cars) {
            if (car.getStock() > 0) {
                System.out.print(count + ". ");
                car.showInfoBasic();  // Asume que showInfoBasic() ya hace println
                count++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("No hay autos disponibles en stock.");
        }

        System.out.println("----------------------------");
    }


    public void startApplication() {
        int option = 0;
        do {
            if (option == 0) {
                printMenu();
            }

            System.out.print("Selecciona una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
                continue;
            }

            switch (option) {
                case 1:
                    this.showCarsStockAvailable();
                    break;
                case 2:
                    printMenu();
                    break;
            }
        }
        while (option != 3);
    }

}
