package Task004;

import java.util.*;

public class currencyconverter {
    private static final Map<String, Double> rates = Map.of(
            "USD_EUR", 0.85, "USD_GBP", 0.75, "EUR_USD", 1.18,
            "EUR_GBP", 0.88, "GBP_USD", 1.33, "GBP_EUR", 1.14
    );

    private static final String[] currencies = { "USD", "EUR", "GBP" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== CURRENCY CONVERTER =====");
            displayOptions();
            int choice = getValidInput(sc, "Select base currency: ", 1, currencies.length + 1);
            if (choice == currencies.length + 1) break;

            int target = getValidInput(sc, "Convert to: ", 1, currencies.length);
            System.out.print("Enter amount: ");
            double amount = getValidAmount(sc);

            String key = currencies[choice - 1] + "_" + currencies[target - 1];
            double rate = rates.getOrDefault(key, 1.0);
            double result = amount * rate;

            System.out.printf("\n%.2f %s = %.2f %s%n", amount, currencies[choice - 1], result, currencies[target - 1]);
        }
        System.out.println("Exiting... Thank you for using the converter.");
        sc.close();
    }

    private static void displayOptions() {
        for (int i = 0; i < currencies.length; i++)
            System.out.println((i + 1) + ". " + currencies[i]);
        System.out.println((currencies.length + 1) + ". Exit");
    }

    private static int getValidInput(Scanner sc, String message, int min, int max) {
        int input;
        do {
            System.out.print(message);
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Try again: ");
                sc.next();
            }
            input = sc.nextInt();
        } while (input < min || input > max);
        return input;
    }

    private static double getValidAmount(Scanner sc) {
        double amount;
        do {
            while (!sc.hasNextDouble()) {
                System.out.print("Invalid amount. Enter again: ");
                sc.next();
            }
            amount = sc.nextDouble();
        } while (amount <= 0);
        return amount;
    }
}
