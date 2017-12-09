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
        Menu mainMenu = new Menu("LIBRARY");

        MenuChoice viewCatalog = mainMenu.addChoice("View Catalog");
        MenuChoice search = mainMenu.addChoice("Search");
        MenuChoice returnBook = mainMenu.addChoice("Return");
        MenuChoice help = mainMenu.addChoice("Help");
        MenuChoice quit = mainMenu.addChoice("Quit");

        mainMenu.getMenuTitle();
        mainMenu.chooseFromMenu();

    }

    // enumerate to hold the values of the menu in a dynamic way
    enum MenuChoices {
        VIEW_CATALOG,
        SEARCH,
        RETURN,
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
        System.out.println("== " + _title.toUpperCase() + " ==");
    }

    // method that returns the chocice made by the user
    MenuChoice addChoice(String text) {
        MenuChoice choice = new MenuChoice(text);
        _choices.add(choice);
        return choice;
    }

    // method that displays the menu and shows what choices are available
    void displayMenu() {
        System.out.println("== " + _title.toUpperCase() + " ==");
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
        boolean validRange = true;
        MenuChoice menuChoice = null;
        int num = 0;

        this.displayMenu();
        System.out.println("");

        do {
            num = Helper.numberValidation();
            if (num <= 0 || num > _choices.size()) {
                validRange = false;
                System.out.println("ERROR: Please enter a number between 1 and "
                        + _choices.size());
            } else {
                validRange = true;
            }

        } while (validRange != true);
        
        menuChoice = _choices.get(num - 1);
        System.out.println("You chose: " + menuChoice.getText());
        System.out.println("");

        return menuChoice;
    }
}
