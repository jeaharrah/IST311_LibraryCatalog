/**
 * IST 311 - Professor Soby Chacko -- Fall 2017
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class will contain methods that deal with input validation for the user.
 *
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class Helper {

    // Method that reads user input from the keyboard and continues prompting
    // the user until a valid number is entered
    /**
     *
     * @return the valid inputted integer
     */
    public static int numberValidation() {
        Scanner in = new Scanner(System.in);
        int number = 0;
        boolean validNum = false;
        String input = "";

        do {
            System.out.print("Enter a number: ");
            input = in.nextLine();

            try {
                number = Integer.parseInt(input);
                validNum = true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid input");
            }

        } while (validNum != true);

        return number;
    }

    // Method that reads user input from the keyboard and validates it to ensure
    // that the input is not empty or whitespace. This will be used when we
    // add functionality for the user to search for a book given certain keywords
    /**
     *
     * @return the valid inputted string
     */
    public static boolean inputISBN(String string) {
        
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        
        if (string.length() != 13) {
            System.out.println("Not 13 digit ISBN.");
            return false;
        } else if (!string.matches(regex)) {
            System.out.println("Letters in ISBN.");
            return false;
        } else{
            return true;
        }
    }

    public static String inputNonBlankString() {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean blankString = false;

        do {
//            System.out.print("Enter input: ");
            input = keyboard.nextLine();

            if (input.equals("") || input.trim().isEmpty()) {
                System.out.println("ERROR: Input cannot be empty or whitespace");
                blankString = true;

            } else {
                blankString = false;
            }

        } while (blankString == true);

        return input;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // Test the numberValidation() and inputNonBlankString() methods
        // Use a println when calling these to ensure that the return value
        // is outputted to the screen
        // (May remove return values in future if we feel they are unnecessary)
        System.out.println(numberValidation());
        System.out.println(inputNonBlankString());

    }
}
