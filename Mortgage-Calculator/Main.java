import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        boolean loop = true;
        double principal;
        double interestRate;
        double periodYears;
        String restart;

        System.out.println("Mortgage Calculator");
        System.out.println("-----------------------");

        while (loop) {
            System.out.println();
            System.out.println("*******************************");
            while (true) {
                System.out.print("Principal = ");
                principal = input.nextDouble();

                if (principal < 1000 || principal > 1000000 ) {
                    System.out.println("Enter a value greater or equals to $1000 and value less than $1M");
                } else {break;}
            }

            while (true) {
                System.out.print("Annual Interest Rate % = ");
                interestRate = input.nextDouble();


                if (interestRate > 30 || interestRate <= 0 ) {
                    System.out.println("Enter a value less than 0 and 30");
                } else {
                    interestRate = interestRate / PERCENT / MONTHS_IN_YEAR;
                    break;
                }
            }

            while (true) {
                System.out.print("Period/Years = ");
                periodYears = input.nextDouble();

                if (periodYears > 30 || periodYears <= 0 ) {
                    System.out.println("Enter a value between 1 and 30");
                } else {
                    periodYears *= MONTHS_IN_YEAR;
                    break;
                }
            }

            double mortgage = principal*((interestRate * Math.pow(1+interestRate, periodYears)) / (Math.pow(1+interestRate, periodYears) - 1));

            System.out.println("-----------------------");
            System.out.println("Mortgage = $" + mortgage);
            System.out.println("-----------------------");
            System.out.println();

            System.out.print("To continue, enter Y = ");
            input.nextLine();
            restart = input.nextLine().toLowerCase().trim();

            if (!restart.equals("y")) {
                loop = false;
            }
        }

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("Thank you for using our mortgage calculator!");
    }
}
