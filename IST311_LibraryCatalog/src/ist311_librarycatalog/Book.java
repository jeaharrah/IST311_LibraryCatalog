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
    private boolean _borrowed;

    // Constructor for easily creating new book objects
    Book(String ISBN, String title, String author, String genre) {
        _ISBN = ISBN;
        _title = title;
        _author = author;
        _genre = genre;

    }

    /*
     ===========GETTERS AND SETTERS==================
     */
    Book() {

    }

    public String getISBN() {
        return _ISBN;
    }

    public void setISBN(String ISBN) {
        _ISBN = ISBN;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getAuthor() {
        return this._author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getGenre() {
        return _genre;
    }

    public void setGenre(String genre) {
        _genre = genre;
    }

    //=================METHODS==============
    
    // Method that gets the availability of a book depending on the boolean value
    // Alternative solution to the current method provided (boolean isBorrowed())
    // that performs the same function
    public String getAvailability() {
        String availability = "";

        if (this._borrowed == true) {
            availability = "This book is currently unavailable";
        } else if (this._borrowed == false) {
            availability = "This book is available";
        }

        return availability;
    }
    
    // will mark a book as borrowed
    public void borrowed() {
        _borrowed = true;
    }

    // will mark a book as returned
    public void returned() {
        _borrowed = false;
    }

    // will check if a book has been borrowed
    // true if yes, false if it is not
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
