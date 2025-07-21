package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Costumer {
    private final Scanner sc = new Scanner(System.in);
    private String address, fullName;
    private String  dni, phoneNumber;
    final String dni_regex="\\d{8}", phoneNumber_regex="^9\\d{8}$", fullName_regex="^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    final Pattern dni_patron = Pattern.compile(dni_regex);
    final Pattern phoneNumber_patron = Pattern.compile(phoneNumber_regex);
    final Pattern fullNamer_patron= Pattern.compile(fullName_regex);

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
         Boolean validation1 = false, validation2=false, validation3=false;

                 do{
                     System.out.print("Ingrese su nombre completo: ");
                     fullName=sc.nextLine();
                     Matcher match = fullNamer_patron.matcher(fullName);
                     if(match.matches()){
                         System.out.println("Nombre validado");
                         validation3=true;
                     }else{
                         System.out.println("El nombre no puede contener numeros, intentelo de nuevo");
                     }
                 }while (!validation3);

                 System.out.print("ingrese su Direccion: ");
                 address=sc.nextLine();

                do {
                    System.out.print("Ingrese su numero de DNI: ");
                    dni=sc.nextLine();
                    Matcher match =dni_patron.matcher(dni);
                    if(match.matches()){
                        System.out.println("DNI validado");
                        validation2=true;
                    }else{
                        System.out.println("DNI invalido, intentelo de nuevo");
                    }
                }while (!validation2);

                 do {
                     System.out.print("Ingrese su numero de contacto: ");
                     phoneNumber=sc.nextLine();
                     Matcher match =phoneNumber_patron.matcher(phoneNumber);
                    if(match.matches()){
                        System.out.println("Numero de contacto validado");
                        validation1=true;
                    }else{
                        System.out.println("Numero de contaco invalido, intentelo de nuevo");
                    }
                 }while (!validation1);
    }


    //Method to view costumer information(option3)
    public void option3(){
        System.out.println("====INFORMACION DEL CLIENTE====");
        System.out.println("Nombre: " +fullName+ "\nDireccion: " +address+"\nCelular: " +phoneNumber+ "\nDNI: " +dni);
    }

}
