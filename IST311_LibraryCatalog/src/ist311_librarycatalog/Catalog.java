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

    public static void main(String[] args) {
        Book _book1 = new Book("978-0-44845-714-7", "The Little Engine That Could", "Piper, Watty", "Children's Literature", 5);

        System.out.println(_book1.getNumOfBooks());
        _book1.borrowBook();
        System.out.println(_book1.getNumOfBooks());
    }

    /**
     *
     * @returns a List<Book>
     */
    public List<Book> getBookList() {
        return books;
    }

    // Instantiate some private book objects
    private Book _book1 = new Book("978-0-44845-714-7", "The Little Engine That Could", "Piper, Watty", "Children's Literature", 5);
    private Book _book2 = new Book("978-1-41699-644-6", "Sent", "Haddix, Margaret Peterson", "Historical Fiction", 6);
    private Book _book3 = new Book("978-0-34533-970-6", "The Fellowship of the Ring", "Tolkien, J.R.R.", "Fantasy", "Adventure", 3);
    private Book _book4 = new Book("978-0-48628-211-4", "Frankenstein", "Shelley, Mary", "Fiction", "Gothic Fiction", "Science Fiction", 5);
    private Book _book5 = new Book("978-0-06207-348-8", "And Then There Were None", "Christie, Agatha", "Mystery", 4);
    private Book _book6 = new Book("978-1-11840-803-2", "Java All-in-One for Dummies", "Lowe, Doug", "Informational", "Computer Science", 1); // test debug
    private Book _book7 = new Book("978-0-44100-576-5", "Mossflower: Prequel to Redwall", "Jacques, Brian", "Fiction", "Adventure", 2); // test debug

    // Create an arraylist that stores Book objects
    // Add each book to the arraylist
    List<Book> books = new ArrayList<Book>() {
        {
            add(_book1);
            add(_book2);
            add(_book3);
            add(_book4);
            add(_book5);
            add(_book6);
            add(_book7);
        }
    };

    /**
     * Method for displaying each book object with its various attributes.
     * Contains if-else logic for dealing with any book object that has more
     * than one genre.
     *
     * @author Jennifer A'Harrah <jka5240@psu.edu>
     */
    public void displayBooks() {
        System.out.println("");
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
            System.out.println("Number of copies left: " + book.getNumOfBooks());
            System.out.println("------------");

        }
        System.out.println("");
    }

    /**
     * prevents duplicates or exact copies of books from showing up twice if an
     * exact copy is added through addBook method
     *
     * @param newBook
     * @return
     */
    public boolean isCopy(Book newBook) {

        for (int i = 0; i < books.size(); i++) {
            if (newBook.getTitle().equals(books.get(i).getTitle())
                    && newBook.getAuthor().equals(books.get(i).getAuthor())
                    && newBook.getISBN().equals(books.get(i).getISBN())
                    && newBook.getGenre().equals(books.get(i).getGenre())) {

                books.get(i).setNumOfBooks(books.get(i).getNumOfBooks() + 1);
                // increments number fo copies by 1
                return true;
            }
        }
        return false;
    }

    /**
     * adds a book to catalog unless it already exists in which case it prompts
     * isCopy method to add a copy to the existing entry
     */
    public void addBook() {
        Book newBook = new Book();

        System.out.print("Enter in a book name: ");
        newBook.setTitle(Helper.inputNonBlankString());

        System.out.print("Enter in an author's first name: ");
        String firstName = Helper.inputNonBlankString();
        System.out.print("Enter in an author's last name: ");
        String lastName = Helper.inputNonBlankString();

        String fullName = lastName + ", " + firstName;
        newBook.setAuthor(fullName);

        String regISBN = Helper.inputISBN();
        newBook.setISBN(regISBN);

        System.out.print("Enter in a genre: ");
        newBook.setGenre(Helper.inputNonBlankString());
        if (isCopy(newBook) == true) {
            System.out.println("Book already exists, adding a copy...");
        } else {
            newBook.setNumOfBooks(1); // adds one copy of the new book
            getBookList().add(newBook);
            System.out.println("Book has been added to the catalog!");
        }
    }

}
