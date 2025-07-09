package org.example;

// en esta clase se va a gestionar al cliente
public class Cliente {

    private String address, fullName;
    private int dni, phoneNumber, age;
    boolean workStatu;

    public Cliente(int dni, String fullName) {
        this.dni = dni;
        this.fullName = fullName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
       return phoneNumber;
    }
    // view info

    @Override

    public String toString() {
        return "the client's phonesx number is : "+ phoneNumber;
    }

}
