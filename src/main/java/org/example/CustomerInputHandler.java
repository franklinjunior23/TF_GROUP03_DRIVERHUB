package org.example;

import java.util.Scanner;

public class CustomerInputHandler {
    private final Scanner sc = new Scanner(System.in);
    private final Validator validator = new Validator();

    public Customer createCustomer() {
        String fullName = promptForFullName();
        String dni = promptForDni();
        String phoneNumber = promptForPhoneNumber();
        String address = promptForAddress();

        return new Customer(fullName, dni, phoneNumber, address);
    }

    private String promptForFullName() {
        String fullName;
        do {
            System.out.print("Ingresa tu nombre completo: ");
            fullName = sc.nextLine();
            if (!validator.validateFullName(fullName)) {
                System.out.println("Nombre inválido. Solo se permiten letras y espacios.");
            }
        } while (!validator.validateFullName(fullName));
        return fullName;
    }

    private String promptForDni() {
        String dni;
        do {
            System.out.print("Ingresa tu DNI (8 dígitos): ");
            dni = sc.nextLine();
            if (!validator.validateDni(dni)) {
                System.out.println("DNI inválido. Debe tener 8 dígitos.");
            }
        } while (!validator.validateDni(dni));
        return dni;
    }

    private String promptForPhoneNumber() {
        String phoneNumber;
        do {
            System.out.print("Ingresa tu número de teléfono (debe comenzar con 9 y tener 9 dígitos): ");
            phoneNumber = sc.nextLine();
            if (!validator.validatePhoneNumber(phoneNumber)) {
                System.out.println("Número de teléfono inválido. Debe comenzar con 9 y tener 9 dígitos.");
            }
        } while (!validator.validatePhoneNumber(phoneNumber));
        return phoneNumber;
    }

    private String promptForAddress() {
        System.out.print("Ingresa tu dirección: ");
        return sc.nextLine();
    }

}
