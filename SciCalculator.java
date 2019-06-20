import java.util.Scanner;

public class SciCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0; //initialized all my variables
        double total = 0;
        int calcs = 0;
        int selection = 1;
        double second = 0;
        double average;
        double result1=0;
        while (selection != 0) { //the while loop for as long as the user didn't choose 0
            System.out.println("Current Result: " + result);
            System.out.println("Calculator Menu\n---------------\n0. Exit Program\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exponentiation\n6. Logarithm\n7. Display Average");
            System.out.println("Enter Menu Selection: ");
            selection = scanner.nextInt();
            while (selection > 7 || selection < 0) { //all out of range choices are given the error message
                System.out.println("Error: Invalid selection!");
                System.out.println("Enter Menu Selection: ");
                selection = scanner.nextInt();
            }
            if (selection == 0) {//if the user chooses 0 then break out of the while loop
                break;
            }
            while (selection == 7 && calcs == 0) {//if the user chooses to average but there are no calculations yet, then error message
                System.out.println("Error: No calculations yet to average! ");
                System.out.println("Enter Menu Selection: ");
                selection = scanner.nextInt();
            }
            if (selection == 7 && calcs != 0) {
                average = total / calcs;
                average = Math.round(average * 100.0) / 100.0;//round in order to give an average to two decimal places
                System.out.println("Sum of calculations: " + total + "\nNumber of calculations: " + calcs + "\nAverage of calculations: " + average);
                System.out.println("Enter Menu Selection: ");
                selection = scanner.nextInt();
            }
            while (selection > 7 || selection < 0) {//another check point for out of range selections
                    System.out.println("Error: Invalid selection!");
                    System.out.println("Enter Menu Selection: ");
                    selection = scanner.nextInt();
            }
            if (selection != 0&&selection!=7) { //if the choice is from 1-6 then we ask the user for two operands
                    System.out.println("Enter first operand: ");
                    try {
                        result = Double.parseDouble(scanner.next()); //detect if the next input is a string or a double
                    } catch (NumberFormatException RESULT) {//if it's the word RESULT, then it will catch it and assign the previous result as the new operand
                        result = result1;
                    }
                    System.out.println("Enter second operand: ");
                    try {
                        second = Double.parseDouble(scanner.next());//if it's a number, then it will just be that number
                    } catch (NumberFormatException RESULT) {//if RESULT, then it will assign the last result as the new second operand
                        second = result1;
                    }
            }if (selection == 0) {
                break;
            }
                switch (selection) {// all the math
                    case 1:
                        result += second;
                        break;
                    case 2:
                        result -= second;
                        break;
                    case 3:
                        result *= second;
                        break;
                    case 4:
                        result /= second;
                        break;
                    case 5:
                        result = Math.pow(result, second);
                        break;
                    case 6:
                        result = Math.log(second) / Math.log(result);
                        break;
            }
                total += result;//total count, number of calculations count
                calcs += 1;
                result1=result;// make a copy of the result
            }
            System.out.println("Thanks for using this calculator. Goodbye!");
        }
}
