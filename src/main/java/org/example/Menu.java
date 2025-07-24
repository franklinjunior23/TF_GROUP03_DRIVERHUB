package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Car> cars;
    private List<Car> availableCars;
    private Scanner scanner;
    private PurchaseHistory history = new PurchaseHistory();

    public Menu(List<Car> cars) {
        this.cars = cars;
        this.scanner = new Scanner(System.in);
        this.availableCars = new ArrayList<>();

        // filtered list of available cars
        for (Car car : cars) {
            if (car.getStock() > 0) {
                availableCars.add(car);
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Mostrar carros disponibles");
        System.out.println("2. Mostrar compras");
        System.out.println("3. Salir");
    }

    private void printCarMenu() {
        System.out.println("\n=== Menú Carros ===");
        System.out.println("1. Ver detalles de carro");
        System.out.println("2. Comprar carro");
        System.out.println("3. Volver al menú principal");
    }

    private void printPurchasesMenu() {
        System.out.println("\n=== Menú Compras ===");
        System.out.println("1. Ver historial de compras");
        System.out.println("2. Volver al menú principal");
    }

    private void showCarsStockAvailable() {
        System.out.println("----- CARS AVAILABLE -----");
        int count = 1;
        boolean found = false;

        for (Car car : this.availableCars) {
            if (car.getStock() > 0) {
                System.out.print(count + ". ");
                car.showInfoBasic();
                count++;
                found = true;
            }
        }

        if (!found) {
            System.out.println("No hay autos disponibles en stock.");
        }

        System.out.println("----------------------------");
    }

    private void handleCarMenu() {
        int carOption = 0;
        while (carOption != 3) {
            printCarMenu();
            System.out.print("Selecciona una opción: ");
            try {
                carOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
                continue;
            }

            switch (carOption) {
                case 1:
                    showCarDetails();
                    break;
                case 2:
                    buyCar();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    break;
            }
        }
    }

    private void showCarDetails() {
        System.out.print("Ingrese el número del carro para ver los detalles: ");
        int carNumber = Integer.parseInt(scanner.nextLine());

        // Restamos 1 para que la selección del usuario (que comienza en 1) coincida con los índices de la lista
        if (carNumber > 0 && carNumber <= this.availableCars.size()) {
            Car car = this.availableCars.get(carNumber - 1);  // Restamos 1 al número ingresado
            car.showInfo();  // Muestra la información completa del carro
        } else {
            System.out.println("Carro no válido.");
        }
    }

    private void buyCar() {

        System.out.println("----- Comprar Carro -----");

        System.out.print("Ingrese el número del carro que desea comprar: ");
        int carNumber = Integer.parseInt(scanner.nextLine());

        if (carNumber > 0 && carNumber <= this.availableCars.size()) {
            Car car = this.availableCars.get(carNumber - 1);

            CustomerInputHandler customerInputHandler = new CustomerInputHandler();
            Customer customer = customerInputHandler.createCustomer();

            Receipt receipt = new Receipt(customer, car);
            receipt.showReceipt();

            history.addPurchase(receipt);

            car.decreaseStock();
            System.out.println("¡Compra exitosa! El carro " + car.getModel() + " ha sido adquirido.");

        } else {
            System.out.println("Carro no válido.");
        }
    }

    private void handlePurchasesMenu() {
        int purchaseOption = 0;
        while (purchaseOption != 2) {
            printPurchasesMenu();
            System.out.print("Selecciona una opción: ");
            try {
                purchaseOption = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
                continue;
            }

            switch (purchaseOption) {
                case 1:
                    showPurchaseHistory();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    break;
            }
        }
    }

    private void showPurchaseHistory() {
        System.out.println("----- Historial de Compras -----");
        history.showHistory();
        System.out.println("-------------------------------");
    }

    public void startApplication() {
        int option = 0;
        while (option != 3) {
            printMainMenu();
            System.out.print("Selecciona una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta nuevamente.");
                continue;
            }

            switch (option) {
                case 1:
                    showCarsStockAvailable();
                    handleCarMenu();
                    break;
                case 2:
                    handlePurchasesMenu();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
                    break;
            }
        }
    }
}
