package ist311_librarycatalog;

//import java.util.List;
import java.util.ArrayList;
import java.util.List;

//import java.util.Scanner;
/**
 *
 * @author Eric Liang <eql5121@psu.edu>
 */
public class Search {

//    Book book = new Book();
    //Scanner in = new Scanner(System.in);
    /**
     *
     */
    private static final Catalog CATALOG = new Catalog();

    /**
     *
     */
    public static Search SEARCH = new Search();

    /**
     *
     */
    public static List<Book> bookList = CATALOG.getBookList();
    private String input;
    private Book foundBook = null;

    private final List<Book> titleSearchResults = new ArrayList<>();
    private final List<Book> authorSearchResults = new ArrayList<>();
    private final List<Book> genreSearchResults = new ArrayList<>();
    private final List<Book> isbnSearchResults = new ArrayList<>();

    /**
     *
     * @param bookList
     * @return
     */
    public void displaySearchResults(List<Book> bookList) {
        for (Book book : bookList) {
            foundBook = book;
            System.out.println(book);
        }
    }

    /**
     *
     * @param searchedBooks
     * @return chooses a result based on search results
     */
    public Book chooseResult(List<Book> searchedBooks) {
        int choice = Helper.numberValidation();
        boolean valid = true;
        if (choice > searchedBooks.size() || choice <= 0) {
            valid = true;
            do {
                System.out.println("Invalid choice.");
                choice = Helper.numberValidation();
            } while (!valid);
        } else {
            valid = false;
        }

        Book book = searchedBooks.get(choice - 1);

        System.out.println("You chose this book:");
        book.printBook();

        return book;
    }

    /**
     *
     * @param catalog
     * @return a book found through Book title
     */
    public List<Book> searchByBookTitle(Catalog catalog) {
        System.out.print("Search by book title: ");
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getTitle().toLowerCase().contains(input.toLowerCase())) {
                titleSearchResults.add(bookList.get(i));
            }
        }

        if (titleSearchResults.size() != 0) {
            int i = 1;
            System.out.println(titleSearchResults.size() + " book(s) found containing the keyword \"" + input + "\" in the title.");
            for (Book book : titleSearchResults) {
                System.out.print(i + ") ");
                System.out.println(book.getTitle());
                i++;
            }
        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the title.");
        }

        return titleSearchResults;

    }

    /**
     *
     * @param catalog
     * @return a Book found through author
     */
    public List<Book> searchByAuthor(Catalog catalog) {
        System.out.println("--SEARCH BY AUTHOR--");
        System.out.print("Search by author: ");
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getAuthor().toLowerCase().contains(input.toLowerCase())) {
                authorSearchResults.add(bookList.get(i));
            }
        }
        int i = 1;
        if (!authorSearchResults.isEmpty()) {
            System.out.println(authorSearchResults.size() + " book(s) found containing the keyword \"" + input + "\" in the author.");
            for (Book book : authorSearchResults) {
                System.out.print(i + ") ");
                System.out.println(book.getAuthor());
                i++;
            }

        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the author.");
        }
        return authorSearchResults;

    }

    /**
     *
     * @param catalog
     * @return a book found through ISBN
     */
    public List<Book> searchByISBN(Catalog catalog) {
        System.out.println("--SEARCH BY ISBN-13--");
        System.out.println("NOTE: Enter ISBN-13 code up to 13 digits with NO dashes.");
        System.out.println("Search by ISBN. ");
        input = Helper.inputISBN();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getISBN().toLowerCase().contains(input.toLowerCase())) {
                isbnSearchResults.add(bookList.get(i));
            }
        }
        if (!isbnSearchResults.isEmpty()) {
            int i = 1;
            System.out.println(isbnSearchResults.size() + " book(s) found with an ISBN-13 code matching " + input + ".");
            for (Book book : isbnSearchResults) {
                System.out.print(i + ") ");
                System.out.println(book.getTitle());
                System.out.println(book.getAuthor());
                System.out.println(book.getISBN());
                i++;
            }

        } else {
            System.out.println("No books found with an ISBN-13 code matching " + input + ".");
        }
        return isbnSearchResults;
    }

    /**
     *
     * @param catalog
     * @return a Book found through genre
     */
    public List<Book> searchByGenre(Catalog catalog) {
        System.out.println("--SEARCH BY GENRE--");
        System.out.print("Search by genre: ");
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getGenre().toLowerCase().contains(input.toLowerCase())
                    || (catalog.getBookList().get(i).getGenre2() != null && catalog.getBookList().get(i).getGenre2().toLowerCase().contains(input.toLowerCase()))
                    || (catalog.getBookList().get(i).getGenre3() != null && catalog.getBookList().get(i).getGenre3().toLowerCase().contains(input.toLowerCase()))) {
                genreSearchResults.add(bookList.get(i));
            }
        }

        if (!genreSearchResults.isEmpty()) {
            System.out.println(genreSearchResults.size() + " book(s) found containing the keyword \"" + input + "\" in the genre.");
            int i = 1;
            for (Book book : genreSearchResults) {
                System.out.print(i + ") ");
                System.out.println(book.getTitle());
                System.out.println(book.getAuthor());
                System.out.println(book.getGenre());
                if (book.getGenre2() != null) {
                    System.out.println(book.getGenre2());
                }
                if (book.getGenre3() != null) {
                    System.out.println(book.getGenre3());
                }
                i++;
            }

        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the genre.");
        }

        return genreSearchResults;
    }
}
