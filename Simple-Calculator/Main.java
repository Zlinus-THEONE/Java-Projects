import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double answer = 0;
        float[] result;

        System.out.println("CALCULATOR +-x÷^");
        System.out.println("---------------");
        System.out.println("1(Value 1#) +(Operator) 1(Value2#) [PRESS ENTER] =  2 (Result)");

        while (true) {
            System.out.println();

            System.out.print("INPUT: ");
            String problem = input.nextLine().trim();

            if (problem.contains("+")) {
                result = CalculateValues(problem, "+");
                answer = result[0]+result[1];
            }
            else if (problem.contains("-")) {
                result = CalculateValues(problem, "-");
                answer = result[0]-result[1];
            }
            else if (problem.contains("x")) {
                result = CalculateValues(problem, "x");
                answer = result[0]*result[1];
            }
            else if (problem.contains("*")) {
                result = CalculateValues(problem, "*");
                answer = result[0]*result[1];
            }
            else if (problem.contains("÷")) {
                result = CalculateValues(problem, "÷");
                answer = result[0]/result[1];
            }
            else if (problem.contains("/")) {
                result = CalculateValues(problem, "/");
                answer = result[0]/result[1];
            }
            else if (problem.contains("^")) {
                result = CalculateValues(problem, "^");
                answer = Math.pow(result[0], result[1]);
            }

            if (answer % 1 != 0) {
                System.out.printf("ANSWER: %.3f\n", answer);
            } else {
                System.out.printf("ANSWER: %.0f\n", answer);
            }

            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println();

        }
    }

    static float[] CalculateValues(String problem, String operator) {
        float val1  = Integer.parseInt(problem.substring(0, problem.indexOf(operator)).trim());
        float val2 = Integer.parseInt(problem.substring(problem.indexOf(operator) + 1).trim());

        return new float[]{val1, val2};
    }
}
