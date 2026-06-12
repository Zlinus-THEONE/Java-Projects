import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        System.out.println("Mortgage Calculator");
        System.out.println("-----------------------");

        System.out.print("Principal = ");
        double principal = input.nextDouble();

        System.out.print("Annual Interest Rate = ");
        double interestRate = input.nextDouble();
        interestRate = interestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period/Years = ");
        double periodYears = input.nextDouble();
        periodYears *= MONTHS_IN_YEAR;

        double mortgage = principal*((interestRate * Math.pow(1+interestRate, periodYears)) / (Math.pow(1+interestRate, periodYears) - 1));

        System.out.println("-----------------------");
        System.out.println("Mortgage = $" + mortgage);
        System.out.println("-----------------------");
    }
}