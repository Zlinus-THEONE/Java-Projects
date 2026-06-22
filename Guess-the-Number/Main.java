import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        byte points = 0;
        byte lives;

        System.out.println("Guess the RANDOM number from 1-?");
        System.out.println("-----------------------------------");

        while (true) {
            lives = 5;
            System.out.print("ENTER a number to generate from 1-? = ");
            int theBound = input.nextInt();

            int theNumber = rand.nextInt(1,theBound);
            System.out.println("Guess the RANDOM number from 1-"+theBound );
            System.out.println();
            System.out.println();

           while (lives > 0) {
               System.out.print("ENTER a number = ");
               int answer = input.nextInt();
               System.out.println();

               if (answer==theNumber) {
                   System.out.println("YOU GUESSED THE RANDOM NUMBER CORRECTLY!");
                   System.out.println("-----------------------------------");
                   points++;
                   System.out.println("You Win = +" + points + " Points");
                   System.out.println("-----------------------------------");
                   System.out.println();

                   break;
               }
               else {
                   System.out.println("YOU GUESSED WRONG, TRY AGAIN!");
                   System.out.println("-----------------------------------");
                   lives--;
                   System.out.println("Lives = " + lives);

                   if (theNumber > answer) {
                       System.out.println("The Random Number is GREATER than " + answer);
                   }
                   else {
                       System.out.println("The Random Number is LESSER than " + answer);
                   }

                   if (lives <= 2) {
                       if (theNumber % 2 == 0) {
                           System.out.println("The Random Number is an EVEN number");
                       }
                       else {
                           System.out.println("The Random Number is ODD number");
                       }
                   }

                   System.out.println("-----------------------------------");
                   System.out.println();
               }
           }

           if (lives <= 0) {
               System.out.println("YOU LOST! The number was " + theNumber);
               points = 0;
               System.out.println("Your Points = " + points);
               System.out.println();
           }

        }
    }
}
