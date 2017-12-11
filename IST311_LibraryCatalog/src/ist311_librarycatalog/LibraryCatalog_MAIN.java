/**
 * IST 311 - Professor Soby Chacko -- Fall 2017
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

import static ist311_librarycatalog.Book.BookAuthorComparator;
import static ist311_librarycatalog.Book.BookGenreComparator;
import static ist311_librarycatalog.Book.BookISBNComparator;
import static ist311_librarycatalog.Book.BookNameComparator;
import java.util.ArrayList;
import java.util.List;

/**
 * Design a Library catalog. Create a catalog that contains various books. Allow
 * the users to search for books and show their status (availability). If
 * available, allow the user to check the book out. Add more features to your
 * application.
 *
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class LibraryCatalog_MAIN {

    /**
     * @param args the command line arguments
     */
    public static Catalog catalog = new Catalog();
    public static Search search = new Search();
    public static List<Book> bookList = catalog.getBookList();

    enum SearchSortOptions {
        TITLE,
        AUTHOR,
        GENRE,
        ISBN,
    }

    enum ReturnToMain {
        RETURN_TO_MAIN,
    }

    public static void main(String[] args) {

        Menu mainMenu = new Menu("Library");
        Menu searchMenu = new Menu("Search");
        Menu catalogMenu = new Menu("View Catalog");
        Menu returnMenu = new Menu("Material Return");
        Menu helpMenu = new Menu("Help");

        Menu borrowMenu = new Menu("Check Out A Book");
        Menu sortMenu = new Menu("Sort");

        /**
         * Menu Choice items for Main Menu
         */
        MenuChoice choiceViewCatalog = mainMenu.addChoice("View Catalog");
        MenuChoice choiceSearch = mainMenu.addChoice("Search");
        MenuChoice choiceReturnBook = mainMenu.addChoice("Return");
        MenuChoice choiceHelp = mainMenu.addChoice("Help");
        MenuChoice choiceQuit = mainMenu.addChoice("Quit");

        /**
         * Menu Choice items for Catalog menu
         */
        MenuChoice displayBooks = catalogMenu.addChoice("Display Books");
        MenuChoice sortChoice = catalogMenu.addChoice("Sort books by attribute");
        MenuChoice selectBook = catalogMenu.addChoice("Select Book for Checkout");
        /**
         * Menu Choice items for Sort menu
         */
        MenuChoice sortTitle = sortMenu.addChoice("Title");
        MenuChoice sortAuthor = sortMenu.addChoice("Author");
        MenuChoice sortGenre = sortMenu.addChoice("Primary Genre");

        /**
         * Menu Choice items for Borrow menu
         */
        MenuChoice borrowBook = borrowMenu.addChoice("Check Out Selected Book");

        /**
         * Menu Choice items for Search menu
         */
        MenuChoice searchTitle = searchMenu.addChoice("Title");
        MenuChoice searchAuthor = searchMenu.addChoice("Author");
        MenuChoice searchGenre = searchMenu.addChoice("Genre");
        /**
         * Menu Choice items for Return menu
         */
        MenuChoice returnBook = returnMenu.addChoice("Return Book");
        /**
         * 'Return to Main' Menu Choice object Add to all menus other than the
         * main menu
         */
        MenuChoice returnToMain = catalogMenu.addChoice("Return to Main Menu");
        returnToMain = searchMenu.addChoice("Return to Main Menu");
        returnToMain = borrowMenu.addChoice("Return to Main Menu");
        returnToMain = returnMenu.addChoice("Return to Main Menu");
        returnToMain = helpMenu.addChoice("Return to Main Menu");

        boolean finished = false;
        MenuChoice chosen = null;
        int input = 0;

        do {
            chosen = mainMenu.chooseFromMenu();
            if (chosen == choiceQuit) {
                System.out.println("Thanks for visiting!");
                finished = true;

                // Else-if block for user wanting to view catalog
            } else if (chosen == choiceViewCatalog) {
                catalogMenu.getMenuTitle();
                System.out.println("You can sort the catalog by:");
                for (SearchSortOptions option : SearchSortOptions.values()) {
                    System.out.println(option.ordinal() + 1 + ") " + option.toString());
                }
                System.out.println("Or:");
                for (ReturnToMain option : ReturnToMain.values()) {
                    System.out.println(SearchSortOptions.values().length + 1 + ") " + option.toString());

                }

                System.out.println("");
                input = Helper.numberValidation();
                System.out.println("");

                if (input == SearchSortOptions.TITLE.ordinal() + 1) {
                    catalog.getBookList().sort(BookNameComparator);
                    catalog.displayBooks();
                } else if (input == SearchSortOptions.AUTHOR.ordinal() + 1) {
                    catalog.getBookList().sort(BookAuthorComparator);
                    catalog.displayBooks();
                } else if (input == SearchSortOptions.GENRE.ordinal() + 1) {
                    catalog.getBookList().sort(BookGenreComparator);
                    catalog.displayBooks();
                } else if (input == SearchSortOptions.ISBN.ordinal() + 1) {
                    catalog.getBookList().sort(BookISBNComparator);
                    catalog.displayBooks();
                } else if (input == SearchSortOptions.values().length + 1) {
                    
                }
                
                // Else-if block for user wanting to search
            } else if (chosen == choiceSearch) {
                searchMenu.getMenuTitle();

                System.out.println("You can search by:");
                for (SearchSortOptions option : SearchSortOptions.values()) {
                    System.out.println(option.ordinal() + 1 + ") " + option.toString());
                }

                System.out.println("Or:");
                for (ReturnToMain option : ReturnToMain.values()) {
                    System.out.println(SearchSortOptions.values().length + 1 + ") " + option.toString());

                }

                System.out.println("");
                input = Helper.numberValidation();
                System.out.println("");

                if (input == SearchSortOptions.TITLE.ordinal() + 1) {
                    search.searchByBookTitle(catalog);
                } else if (input == SearchSortOptions.AUTHOR.ordinal() + 1) {
                    search.searchByAuthor(catalog);
                } else if (input == SearchSortOptions.GENRE.ordinal() + 1) {
                    search.searchByGenre(catalog);
                } else if (input == SearchSortOptions.ISBN.ordinal() + 1) {
                    search.searchByISBN(catalog);
                } else if (input == SearchSortOptions.values().length + 1) {
                    mainMenu.chooseFromMenu();
                }

            } else if (chosen == choiceReturnBook) {
                returnMenu.getMenuTitle();
                System.out.println("Please enter ISBN of book being returned");
                
                
                
            }
            
            else if (chosen == choiceHelp) {
                helpMenu.getMenuTitle();
                System.out.println("--INSTRUCTIONS--");
                
                System.out.println("MENU HANDLING:");
                System.out.println("Type the number of the desired menu choice.");
                System.out.println("Press the 'Enter' key.");
                System.out.println("");
                
                System.out.println("MENU CHOICE OPTION INFORMATION:");
                System.out.println("'View Catalog' allows you to view and sort the list of books.");
                System.out.println("'Search' allows you to search for a book by an attribute and check out a book.");
                System.out.println("'Return' allows you to return a book by entering its ISBN-13 code.");
                System.out.println("'Quit' allows you to quit the application.");
                System.out.println("     -------------------------");
            }

        } while (finished != true);

    }

}
