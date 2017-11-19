/**
 * IST 311 - Professor Soby Chacko -- Fall 2017 
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah 
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

/**
 *
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class MenuChoice {

    // Main method for testing class functionality
    public static void main(String[] args) {
        MenuChoice menuChoice = new MenuChoice("This is a new menu choice!");
        // Verify that the menu choice text is printed out
        System.out.println(menuChoice.getText());
    }

    // Private constructor so that the programmer cannot create a menu choice
    // that has no descriptive string argument passed into it
    private MenuChoice() {

    }

    private String _text;

    // Retrieves the descriptive text of the menu choice item
    public String getText() {
        return _text;
    }

    // Constructor that accepts a string argument (the name of the choice)
    public MenuChoice(String text) {
        this._text = text;
    }

}
