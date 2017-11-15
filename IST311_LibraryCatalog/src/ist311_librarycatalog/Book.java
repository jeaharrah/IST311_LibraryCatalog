/**
 * IST 311 - Professor Soby Chacko -- Fall 2017
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

/**
 * This class will contain fields and methods for book objects that will go in
 * the catalog.
 *
 * @author Eric Liang <eql5121@psu.edu>
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class Book {

    // Declare private fields needed when creating a book object
    private String _ISBN;
    private String _title;
    private String _author;
    private String _genre;
    private String _genre2;
    private String _genre3;
    private boolean _borrowed;

    // Constructors for easily creating new book objects
    // Constructor for book object with one genre
    Book(String ISBN, String title, String author, String genre) {
        _ISBN = ISBN;
        _title = title;
        _author = author;
        _genre = genre;

    }

    // Use method overloading in this constructor for creating a book object 
    // with two genres
    Book(String ISBN, String title, String author, String genre, String genre2) {
        _ISBN = ISBN;
        _title = title;
        _author = author;
        _genre = genre;
        _genre2 = genre2;
    }

    // Use method overloading in this constructor for creating a book object 
    // with three genres
    Book(String ISBN, String title, String author, String genre, String genre2, String genre3) {
        _ISBN = ISBN;
        _title = title;
        _author = author;
        _genre = genre;
        _genre2 = genre2;
        _genre3 = genre3;
    }

    /*
     ===========GETTERS AND SETTERS==================
     */

    /**
     *
     * @return
     */


    public String getISBN() {
        return _ISBN;
    }

    /**
     *
     * @param ISBN
     */
    public void setISBN(String ISBN) {
        _ISBN = ISBN;
    }

    /**
     *
     * @return the private title field
     */
    public String getTitle() {
        return _title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        _title = title;
    }

    /**
     *
     * @return the private author field
     */
    public String getAuthor() {
        return this._author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        _author = author;
    }

    /**
     *
     * @return the private genre string
     */
    public String getGenre() {
        return _genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        _genre = genre;
    }

    /**
     *
     * @return the string of the second book genre descriptor
     */
    public String getGenre2() {
        return _genre2;
    }

    /**
     *
     * @param genre2
     */
    public void setGenre2(String genre2) {
        _genre2 = genre2;
    }

    /**
     *
     * @return the string of the third book genre descriptor
     */
    public String getGenre3() {
        return _genre3;
    }

    /**
     *
     * @param genre3
     */
    public void setGenre3(String genre3) {
        _genre3 = genre3;
    }
    
    //=================METHODS==============
    // Method that gets the availability of a book depending on the boolean value
    // Alternative solution to the current method provided (boolean isBorrowed())
    // that performs the same function

    /**
     *
     * @return the string message that displays whether the book is available
     */
    public String getAvailability() {
        String availability = "";

        if (this._borrowed == true) {
            availability = "Sorry! This book is currently unavailable.";
        } else if (this._borrowed == false) {
            availability = "This book is available!";
        }

        return availability;
    }

    // 

    /**
     * Will mark a book as borrowed
     */
    public void borrowed() {
        _borrowed = true;
    }

    // w

    /**
     * Will mark a book as returned
     */
    public void returned() {
        _borrowed = false;
    }
    
    /**
     * Method to check if a book has been borrowed
     * @return the boolean of whether the book is currently borrowed
     * (true if it is, false if not)
     */
    private boolean isBorrowed() {
        boolean isBorrowed = false;

        if (_borrowed == true) {
            System.out.println("Book is borrowed.");
            isBorrowed = false;
        } else if (_borrowed == false) {
            System.out.println("Book is not borrowed.");
            isBorrowed = false;
        }

        return isBorrowed;
    }

}
