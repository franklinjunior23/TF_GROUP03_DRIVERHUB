package org.example;

import java.util.regex.Pattern;

public class Validator {
    // Regular expressions
    final String dni_regex = "\\d{8}"; // 8 digits for DNI
    final String phoneNumber_regex = "^9\\d{8}$"; // Numbers starting with 9 and 9 digits long
    final String fullName_regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"; // Name with letters and accents

    final Pattern dni_patron = Pattern.compile(dni_regex);
    final Pattern phoneNumber_patron = Pattern.compile(phoneNumber_regex);
    final Pattern fullName_patron = Pattern.compile(fullName_regex);

    /**
     * Validates a full name.
     * The name must contain only letters (including accents) and spaces.
     *
     * @param fullName the full name to validate
     * @return true if the name is valid, false otherwise
     */
    public boolean validateFullName(String fullName) {
        return fullName_patron.matcher(fullName).matches();
    }

    /**
     * Validates a DNI (National Identity Document).
     * The DNI must have exactly 8 digits.
     *
     * @param dni the DNI to validate
     * @return true if the DNI is valid, false otherwise
     */
    public boolean validateDni(String dni) {
        return dni_patron.matcher(dni).matches();
    }

    /**
     * Validates a phone number.
     * The number must start with 9 and have exactly 9 digits.
     *
     * @param phoneNumber the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber_patron.matcher(phoneNumber).matches();
    }
}
