import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulated exchange rates (base: USD)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("INR", 83.10);
        exchangeRates.put("GBP", 0.79);
        exchangeRates.put("JPY", 151.40);

        System.out.println("🌍 Welcome to the Currency Converter");

        // Display available currencies
        System.out.println("Available Currencies: USD, EUR, INR, GBP, JPY");

        System.out.print("Enter base currency (e.g. USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g. EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Check if currencies exist in our map
        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("❌ Unsupported currency code.");
            return;
        }

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Convert to USD first if base is not USD
        double amountInUSD = amount / exchangeRates.get(baseCurrency);

        // Convert from USD to target currency
        double convertedAmount = amountInUSD * exchangeRates.get(targetCurrency);

        System.out.printf("✅ %.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        scanner.close();
    }
}
