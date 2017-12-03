/**
 * IST 311 - Professor Soby Chacko -- Fall 2017
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This class will contain fields and methods for book objects that will go in
 * the catalog.
 *
 * @author Eric Liang <eql5121@psu.edu>
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class Book implements Comparable<Book> {

    // Declare private fields needed when creating a book object
    private String _ISBN;
    private String _title;
    private String _author;
    private String _genre;
    private String _genre2;
    private String _genre3;
    private boolean _borrowed;
    private int _numOfBooks;

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
     * @return the private ISBN string
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

    public int getNumOfBooks() {
        return _numOfBooks;
    }

    public void setNumOfBooks(int _numOfBooks) {
        this._numOfBooks = _numOfBooks;
    }

    //=================METHODS==============
    /**
     * Will mark a book as borrowed
     */
    public void borrowed() {
        this._borrowed = true;
    }

    /**
     * Will mark a book as returned
     */
    public void returned() {
        this._borrowed = false;
    }

    /**
     * Method to check if a book has been borrowed
     *
     * @return the string message that displays whether the book is available
     */
    public String isBorrowed() {
        String availability = "";

        if (this._borrowed == true) {
            availability = "Sorry! This book is currently unavailable.";
        } else if (this._borrowed == false) {
            availability = "This book is available!";
        }

        return availability;
    }
    // ======= Sorting methods =========
    @Override
    public int compareTo(Book compareBook) {
        int compareNumbers = ((Book) compareBook).getNumOfBooks();

        //ascending order
        return this._numOfBooks - compareNumbers;

        //descending order
        //return comapreNumbers - this._numOfBooks;
    }

    public static Comparator<Book> BookNameComparator = new Comparator<Book>() {
        public int compare(Book book1, Book book2) {
            String bookName1 = book1.getTitle().toUpperCase();
            String bookName2 = book2.getTitle().toUpperCase();

            //ascending order
            return bookName1.compareTo(bookName2);

            //descending order
            // bookName2.compareTo(bookName1);
        }
    };
    // PBI-6: 
    // Sorting for book name
    // not implemented: book isbn, author, genre, etc.
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        List<Book> books = new ArrayList<>(catalog.getBooks());
        
        
        for (Book book : books) {
            System.out.println(book.getTitle());
        }

        books.sort(BookNameComparator);
        System.out.println("====After====");
        for (Book book : books) {
            System.out.println(book.getTitle());
        }

    }
}
