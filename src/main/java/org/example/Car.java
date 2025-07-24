package org.example;

public class Car {
    // Attributes of the Car class
    private String brand;
    private String model;
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private double price;
    private String color;
    private int stock;

    public int getStock() {
        return this.stock;
    }

    public void showInfoBasic() {
        System.out.println(brand + " - " + model);
    }

    public String getModel() {
        return model;
    }

    public void decreaseStock (){
        this.stock -= 1;
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
        System.out.println("Marca: " + brand);
        System.out.println("Modelo: " + model);
        System.out.println("Año: " + year);
        System.out.println("Precio: $" + price);
        System.out.println("Color: " + color);
        System.out.println("Stock disponible: " + stock);
        System.out.println("-------------------");
    }
}
