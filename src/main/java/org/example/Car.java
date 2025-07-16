package org.example;

public class Car {
    // Attributes of the Car class
    private String brand;
    private String model;
    private int year;
    private double price;
    private String color;
    private int stock;

    public int getStock() {
        return this.stock;
    }

    public void showInfoBasic() {
        System.out.println(brand + " - " + model);
    }

    // Constructor to initialize a Car
    public Car(String brand, String model, int year, double price, String color, int stock) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.stock = stock;
    }


    // Method to display the car's information
    public void showInfo() {
        System.out.println("-------------------");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
        System.out.println("Stock available: " + stock);
        System.out.println("-------------------");
    }
}
