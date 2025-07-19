package org.example;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class Comprador {
    private final Scanner sc = new Scanner(System.in);
    private String address, fullName;
    private int opcion, dni, phoneNumber;


    // menu principal del comprador
    public void menuComprador() {
        System.out.println("BIENVENIDO - GESTION COMPRA VEHICULAR");
        System.out.println("===DATOS PERSONALES===\n1. Ingresar datos\n2. Modificar datos\n3. Ver informacion");

    }

    //elegir opciones del menu
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


    // metodo para la opcion 1 y 2 del menu
    public void option1and2 (){
         Boolean validation = false;
         while(!validation){
             try {
                 System.out.println("Ingrese su nombre completo");
                 //validacion si es que contiene algun numero
                 String tempFullame= sc.nextLine();
                 if (tempFullame.matches(".*\\d+.*")){
                     throw new IllegalAccessException(" El nombre no deve contener numeros");
                 }
                 fullName= tempFullame;

                 System.out.println("ingrese su Direccion");
                 address=sc.nextLine();

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


    //metodo para visualizar toda la info(option3)
    public void option3(){
        System.out.println("Nombre: " +fullName+ "\nDireccion: " +address+ "\nDNI: " +dni);
    }

}
