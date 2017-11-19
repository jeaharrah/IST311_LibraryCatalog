/**
 * IST 311 - Professor Soby Chacko -- Fall 2017 
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah 
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class Menu {
        public static void main(String[] args) {
        // Created new instance of the class to test method, as per instructions
        Menu mainMenu = new Menu("Wheel of Fortune");

        MenuChoice spinWheel = mainMenu.addChoice("Spin the wheel");
        MenuChoice buyVowel = mainMenu.addChoice("Buy a vowel");
        MenuChoice solvePuzzle = mainMenu.addChoice("Solve the puzzle");
        MenuChoice help = mainMenu.addChoice("Help");
        MenuChoice quit = mainMenu.addChoice("Quit");

        while (true) {
            mainMenu.chooseFromMenu();
        }

    }

    // enumerate to hold the values of the menu in a dynamic way
    enum MenuChoices {
        SPIN,
        BUY,
        SOLVE,
        HELP,
        QUIT
    }

    private List<MenuChoice> _choices;
    private String _title;
    private Scanner _keyboard;

    // Private constructor so that the programmer cannot instantiate a menu that
    // doesn't pass in a string argument (the menu title)
    private Menu() {

    }

    // instance of Menu that initialiazes the arraylist, title, and scanner to be used 
    // in the class.
    Menu(String title) {
        this._choices = new ArrayList<>();
        this._title = title;
        this._keyboard = new Scanner(System.in);
    }

    // Displays only the menu title
    public void getMenuTitle() {
        System.out.println("-= " + _title + " =-");
    }

    // method that returns the chocice made by the user
    MenuChoice addChoice(String text) {
        MenuChoice choice = new MenuChoice(text);
        _choices.add(choice);
        return choice;
    }

    // method that displays the menu and shows what choices are available
    void displayMenu() {
        System.out.println("-= " + _title + " =-");
        int num = 1;
        for (MenuChoice choice : _choices) {
            System.out.println(num + ") " + choice.getText());
            num++;
        }
    }

    // Displays only the menu choices
    void displayMenuChoices() {
        int num = 1;
        for (MenuChoice choice : _choices) {
            System.out.println(num + ") " + choice.getText());
            num++;
        }
    }

    // method that allows the user to make a choice from the list of menu options
    MenuChoice chooseFromMenu() {
        boolean validNum = false;
        boolean validRange = false;
        boolean continueRunning = true;
        int numberChoice = 0;
        MenuChoice menuChoice = null;

        Scanner keyboard = new Scanner(System.in);

        displayMenuChoices();

        do {
            System.out.println("");
            System.out.print("Enter choice: ");
            String input = keyboard.nextLine();
            // Dealing with invalid input
            try {
                numberChoice = Integer.parseInt(input);
                validNum = true;
            } catch (Exception e) {
                System.out.println("ERROR: Please enter a number");
            }
            if (validNum == true && numberChoice >= 1) {
                validRange = true;
            } // Dealing with entry that is out of range
            else if ((validNum == true) && (numberChoice < 1)) {
                System.out.print("ERROR: Please enter a number between ");
                System.out.println("1 and ");
            }
            // Continue looping while the input is either non-numeric or
            // out of range of the menu choice items
        } while (validNum != true || validRange != true);

        menuChoice = _choices.get(numberChoice - 1);
        MenuChoices choice = MenuChoices.values()[numberChoice - 1];
        System.out.println();
        
        switch(choice) {
            
            
        }

        return menuChoice;
    }
}
