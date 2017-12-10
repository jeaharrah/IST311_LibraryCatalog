/**
 * IST 311 - Professor Soby Chacko -- Fall 2017 
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah 
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will contain methods for adding books to the catalog, displaying
 * the catalog, etc.
 *
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class Catalog {

    public List<Book> getBookList() {
        return books;
    }
    
    // Instantiate some private book objects
    private Book _book1 = new Book("978-0-44845-714-7", "The Little Engine That Could", "Piper, Watty", "Children's Literature");
    private Book _book2 = new Book("978-1-41699-644-6", "Sent", "Haddix, Margaret Peterson", "Historical Fiction");
    private Book _book3 = new Book("978-0-34533-970-6", "The Fellowship of the Ring", "Tolkien, J.R.R.", "Fantasy", "Adventure");
    private Book _book4 = new Book("978-0-48628-211-4", "Frankenstein", "Shelley, Mary", "Fiction", "Gothic Fiction", "Science Fiction");
    private Book _book5 = new Book("978-0-06207-348-8", "And Then There Were None", "Christie, Agatha", "Mystery");
    
    // Create an arraylist that stores Book objects
    // Add each book to the arraylist
    List<Book> books = new ArrayList<Book>() {
        {
            add(_book1);
            add(_book2);
            add(_book3);
            add(_book4);
            add(_book5);

        }
    };
    
    /**
     * Method for displaying each book object with its various attributes.
     * Contains if-else logic for dealing with any book object that has more
     * than one genre.
     * @author Jennifer A'Harrah <jka5240@psu.edu>
     */
    public void displayBooks() {
        System.out.println("------BOOK CATALOG------");
        System.out.println("Number of books: [" + books.size() + "]");
        System.out.println("");
        
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            if (book.getGenre2() != null) {
                System.out.println("Genre 2: " + book.getGenre2());
            }
            if (book.getGenre3() != null) {
                System.out.println("Genre 3: " + book.getGenre3());
            }
            System.out.println("ISBN-13: " + book.getISBN());
            System.out.println("------------");

        }

    }

    /**
     * Main method for testing Catalog.java methods
     * @author Jennifer A'Harrah <jka5240@psu.edu>
     * @param args
     */
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        
        catalog.displayBooks();
        
    }

}
