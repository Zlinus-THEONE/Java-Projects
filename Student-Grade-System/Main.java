import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeSystem {
    public static void main(String[] args) {
        ArrayList<String> Students = new ArrayList<>();
        ArrayList<Float> mathGrades = new ArrayList<>();
        ArrayList<Float> englishGrades = new ArrayList<>();
        ArrayList<Float> scienceGrades = new ArrayList<>();
        ArrayList<Float> averageGrades= new ArrayList<>();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("____________________");
            System.out.println("[1] Add a student");
            System.out.println("[2] Remove a student");
            System.out.println("[3] Print all students");
            System.out.println("____________________");
            System.out.println("Enter your action by choosing a number from 1-3");
            System.out.println("____________________");
            System.out.println();

            String firstName;
            String lastName;
            String middleInitial;

            float averageG;
            float mathG;
            float englishG;
            float scienceG;

            try {
                System.out.print("Enter a command: ");
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        input.nextLine();

                        System.out.println("_______________________________");

                        System.out.print("Student's first name: ");
                        firstName = input.nextLine().trim();

                        System.out.print("Student's last name: ");
                        lastName = input.nextLine().trim();

                        System.out.println("Student's middle initial (ex: G., M., O.)");
                        System.out.print("IF student has no MI type /: ");
                        middleInitial = input.nextLine().trim().toUpperCase();
                        System.out.println();

                        if (middleInitial.equals("/")) {
                            middleInitial = "";
                        }

                        System.out.print("---- Grade in Mathematics =  ");
                        mathG = input.nextFloat();

                        System.out.print("---- Grade in English = ");
                        englishG = input.nextFloat();

                        System.out.print("---- Grade in Science = ");
                        scienceG = input.nextFloat();

                        averageG = ((mathG+englishG+scienceG) / 3);
                        System.out.printf("AVERAGE SCORE = %.2f\n", averageG);
                        System.out.println("PASS = " +  (averageG > 75));

                        Students.add(lastName+", "+firstName+" "+middleInitial);
                        mathGrades.add(mathG);
                        englishGrades.add(englishG);
                        scienceGrades.add(scienceG);
                        averageGrades.add(averageG);

                        break;
                    case 2:
                        System.out.println("_______________________________");
                        System.out.print("Remove a student by index: ");
                        int removeStudent = input.nextInt() - 1;

                        if (removeStudent > Students.size() || removeStudent < 0) {
                            System.out.println("******************************");
                            System.out.println("⚠ Invalid index");
                            continue;
                        } else {
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Successfully removed "+ Students.get(removeStudent) + " from the table");
                            Students.remove(removeStudent);
                            mathGrades.remove(removeStudent);
                            englishGrades.remove(removeStudent);
                            scienceGrades.remove(removeStudent);
                            averageGrades.remove(removeStudent);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        }


                        break;
                    case 3:
                        if (Students.isEmpty()) {
                            System.out.println("******************************");
                            System.out.println("⚠ There are no students in the system");
                            continue;
                        }
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        for (int i = 0; i < Students.size(); i++) {
                            System.out.println("_______________________________");
                            System.out.println((i + 1) + ".Student: "+Students.get(i));
                            System.out.println(" + Mathematics = " + mathGrades.get(i));
                            System.out.println(" + English = " + englishGrades.get(i));
                            System.out.println(" + Science = " + scienceGrades.get(i));
                            System.out.println();

                            System.out.printf("AVERAGE SCORE = %.2f\n", averageGrades.get(i));
                            System.out.println("PASS = " +  (averageGrades.get(i) > 75));

                            System.out.println("_______________________________");
                        }
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("******************************");
                System.out.println("⚠ Please enter a number");
                System.out.println();

                input.nextLine();
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("******************************");
                System.out.println("⚠ Index out of bounds");
                System.out.println();

                input.nextLine();
            }
            catch (Exception e) {
                System.out.println("******************************");
                System.out.println("⚠ Something went wrong");
                System.out.println();

                input.nextLine();
            }
        }
    }
}
