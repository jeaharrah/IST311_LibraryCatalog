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

    private Book book1 = new Book("978-0-44845-714-7", "The Little Engine That Could", "Watty Piper", "Children's Literature");
    private Book book2 = new Book("978-1-41699-644-6", "Sent", "Margaret Peterson Haddix", "Historical Fiction");
    private Book book3 = new Book("ISBN", "Book 3", "Author", "Genre");
    private Book book4 = new Book("ISBN", "Book 4", "Author", "Genre");

    List<Book> books = new ArrayList<Book>() {
        {
            add(book1);
            add(book2);
            add(book3);
            add(book4);

        }
    };
    
    public void displayBooks() {
        System.out.println("------BOOK CATALOG------");
        System.out.println("Number of books: [" + books.size() + "]");
        System.out.println("");
        
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("ISBN-13: " + book.getISBN());
            System.out.println("------------");

        }

    }

    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        catalog.displayBooks();

    }

}
