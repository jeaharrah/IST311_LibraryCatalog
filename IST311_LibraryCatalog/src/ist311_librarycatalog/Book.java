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

    /**
     *
     * @return the number of books avaliable
     */
    public int getNumOfBooks() {
        return _numOfBooks;
    }

    /**
     *
     * @param _numOfBooks
     */
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
    // PBI-6: 
    // Sorting for book name
    // not implemented: book isbn, author, genre, etc.
    @Override
    public int compareTo(Book compareBook) {
        int compareNumbers = ((Book) compareBook).getNumOfBooks();

        //ascending order
        return this._numOfBooks - compareNumbers;

        //descending order
        //return comapreNumbers - this._numOfBooks;
    }

    /**
     * compares and sorts by book title.
     */
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
    // sorts by ISBN
    public static Comparator<Book> BookISBNComparator = new Comparator<Book>() {

        public int compare(Book book1, Book book2) {
            String bookISBN1 = book1.getISBN().toUpperCase();
            String bookISBN2 = book2.getISBN().toUpperCase();

            //ascending order
            return bookISBN1.compareTo(bookISBN2);

            //descending order
            // return bookISBN2.compareTo(bookISBN1);
        }
    };
    // sorts alphabaetically by last name of Author
    public static Comparator<Book> BookAuthorComparator = new Comparator<Book>() {

        public int compare(Book book1, Book book2) {
            String bookAuthor1 = book1.getAuthor().toUpperCase();
            String bookAuthor2 = book2.getAuthor().toUpperCase();

            //ascending order
            return bookAuthor1.compareTo(bookAuthor2);

            //descending order
            //return bookAuthor2.compareTo(bookAuthor1);
        }
    };
    public static Comparator<Book> BookGenreComparator = new Comparator<Book>() {

        public int compare(Book book1, Book book2) {
            String bookGenre1 = book1.getGenre().toUpperCase();
            String bookGenre2 = book2.getGenre().toUpperCase();

            //ascending order
            return bookGenre1.compareTo(bookGenre2);

            //descending order
            //return bookGenre2.compareTo(bookGenre1);
        }
    };

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        List<Book> books = new ArrayList<>(catalog.getBooks());

        // test case of book sorting by name
        /*
        for (Book book : books) {
            System.out.println(book.getTitle());
        }*/
        catalog.displayBooks();
        //catalog.getBooks().sort(BookNameComparator);
        //catalog.getBooks().sort(BookISBNComparator);
        //catalog.getBooks().sort(BookAuthorComparator);
        catalog.getBooks().sort(BookGenreComparator);

        System.out.println("==================After sort==================");
        catalog.displayBooks();

        /*
        for (Book book : books) {
            System.out.println(book.getTitle());
        }*/
    }
}
