package org.example;

public class Customer {
    private String address;
    private String fullName;
    private String dni;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Constructor para inicializar al cliente con la información
    public Customer(String fullName, String dni, String phoneNumber, String address) {
        this.fullName = fullName;
        this.dni = dni;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Mostrar la información del cliente
    public void showCustomerInfo() {
        System.out.println("\n=== Información del Cliente ===");
        System.out.println("Nombre completo: " + fullName);
        System.out.println("DNI: " + dni);
        System.out.println("Número de teléfono: " + phoneNumber);
        System.out.println("Dirección: " + address);
    }

}
