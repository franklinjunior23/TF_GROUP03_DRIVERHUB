package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Comprador {
    private final Scanner sc = new Scanner(System.in);
    private String address, fullName;
    private int  dni, phoneNumber;


    // Main costumer menu
    public void menuComprador() {
        System.out.println("BIENVENIDO - GESTION COMPRA VEHICULAR");
        System.out.println("===DATOS PERSONALES DEL CLIENTE===\n1. Ingresar datos\n2. Modificar datos\n3. Ver informacion");

    }

    //Choose menu options
    public void opcionesMenu(){

        int option = 0;
        option = Integer.parseInt(sc.nextLine());
        switch (option){
            case 1 : option1and2();
                break;

            case 2: option1and2();
                break;

            case 3: option3();
                break;
        }

    }


    // Method of option 1 and 2
    public void option1and2 (){
         Boolean validation = false;
         while(!validation){
             try {
                 System.out.println("Ingrese su nombre completo");
                 //data validation
                 String tempFullame= sc.nextLine();
                 if (tempFullame.matches(".*\\d+.*")){
                     throw new IllegalAccessException(" El nombre no deve contener numeros");
                 }
                 fullName= tempFullame;

                 System.out.println("ingrese su Direccion");
                 address=sc.nextLine();

                 System.out.println("Ingrese su numero de contacto");
                 phoneNumber=Integer.parseInt(sc.nextLine());

                 System.out.println("Ingrese su DNI");
                 dni=Integer.parseInt(sc.nextLine());


                 validation=true;

             }catch (InputMismatchException e){
                 System.out.println("Error de entrada, intentelo de nuevo");
             } catch (IllegalAccessException e) {
                 System.out.println("Error de validacion:"+ e.getMessage());
             }

         }
    }


    //Method to view costumer information(option3)
    public void option3(){
        System.out.println("Nombre: " +fullName+ "\nDireccion: " +address+"\nCelular: " +phoneNumber+ "\nDNI: " +dni);
    }

}
