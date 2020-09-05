import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Solution {

    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double payment = scanner.nextDouble();
            assert 0 <= payment && payment <= 1_000_000_000;

            NumberFormat currencyFormatUS = NumberFormat.getCurrencyInstance(Locale.US);
            NumberFormat currencyFormatIndia = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
            NumberFormat currencyFormatChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
            NumberFormat currencyFormatFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);

            String us = currencyFormatUS.format(payment);
            String india = currencyFormatIndia.format(payment);
            String china = currencyFormatChina.format(payment);
            String france = currencyFormatFrance.format(payment);

            System.out.println("US: " + us);
            System.out.println("India: " + india);
            System.out.println("China: " + china);
            System.out.println("France: " + france);
        }
    }

}
