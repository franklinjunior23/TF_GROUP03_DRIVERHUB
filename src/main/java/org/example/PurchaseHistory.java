package org.example;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistory {
    private List<Receipt> history; // List to store purchase receipts

    public PurchaseHistory() {
        this.history = new ArrayList<>();
    }

    // Method to add a purchase receipt to the history
    public void addPurchase(Receipt receipt) {
        history.add(receipt);
    }

   // Method to show the purchase history
    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No hay historial de compras.");
            return;
        }

        System.out.println("\n=== HISTORIAL DE COMPRAS ===");
        for (int i = 0; i < history.size(); i++) {
            System.out.println("\nCompra #" + (i + 1));
            history.get(i).showReceipt();
        }
    }
}
