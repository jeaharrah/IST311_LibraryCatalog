/**
 * IST 311 - Professor Soby Chacko -- Fall 2017
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

import static ist311_librarycatalog.Search.bookList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class will contain methods that deal with input validation for the user.
 *
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class Helper {

    private Book returnedBook = null;

    /**
     * Method that reads user input from the keyboard and continues prompting
     * the user until a valid number is entered
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

    /**
     *
     * @return String for validated ISBN with dashes
     */
    public static String inputISBN() {
        System.out.print("Enter in ISBN-13 code (13 digits, no dashes): ");
        String regISBN = Helper.inputNonBlankString();

        while (Helper.validateISBN(regISBN) == false) {
            System.out.print("Enter in ISBN-13 code (13 digits, no dashes): ");
            regISBN = Helper.inputNonBlankString();
        }

        regISBN = Helper.hyphenateISBN(regISBN);
        return regISBN;
    }

    /**
     *
     * @param string
     * @return
     * @returns true for valid ISBN, false for invalid ISBN
     */
    public static boolean validateISBN(String string) {

        String regex = "\\d+"; // checks for regular expressions of decimals only

        if (string.length() != 13) {
            System.out.println("Not a 13 digit ISBN.");
            return false;
        } else if (!string.matches(regex)) {
            System.out.println("Letters in ISBN.");
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @param string
     * @return
     */
    public static String hyphenateISBN(String string) {
        StringBuilder str = new StringBuilder(string);
        str.insert(3, "-");
        str.insert(5, "-");
        str.insert(11, "-");
        str.insert(15, "-");
        string = str.toString();
        return string;
    }

    /**
     *
     * @return the valid inputted string
     */
    public static String inputNonBlankString() {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean blankString = false;

        do {
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
