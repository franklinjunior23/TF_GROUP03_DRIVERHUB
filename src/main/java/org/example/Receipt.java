package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    private Customer customer;
    private Car car;
    private Date purchaseDate;

    public Receipt(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
        this.purchaseDate = new Date(); // Fecha actual
    }

    public void showReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(purchaseDate);

        System.out.println("=== BOLETA DE COMPRA ===");
        System.out.println("Fecha de compra: " + formattedDate);
        System.out.println("Cliente: " + customer.getFullName());
        System.out.println("DNI: " + customer.getDni());
        System.out.println("Teléfono: " + customer.getPhoneNumber());
        System.out.println("----------------------------");
        System.out.println("Carro comprado: " + car.getModel() + " " + car.getModel() + " (" + car.getYear() + ")");
        System.out.println("Precio: $" + car.getPrice());
        System.out.println("----------------------------");
    }
}
