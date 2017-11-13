/**
 * IST 311 - Professor Soby Chacko -- Fall 2017 
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah 
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

import java.util.Scanner;

/**
 * This class will contain methods that deal with input validation for the user.
 *
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class Helper {

    public boolean numberValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Helper helper = new Helper();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter in a number: ");
        String x = in.nextLine();
        helper.numberValidation(x);
        
        while (helper.numberValidation(x) == false) {
            System.out.println("Invalid input.");
            System.out.print("Enter in a number: ");
            x = in.nextLine();
        }
    }
}
