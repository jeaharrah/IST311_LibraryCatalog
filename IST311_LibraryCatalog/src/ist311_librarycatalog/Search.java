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
    public static Catalog catalog = new Catalog();
    public static Search search = new Search();
    public static List<Book> bookList = catalog.getBookList();
    private String input;
    private Book foundBook = null;

    public static void main(String[] args) {
        boolean finished = false;
        int choice = 0;

        search.searchByBookTitle(catalog);
        search.searchByGenre(catalog);
        search.searchByISBN(catalog);
        search.searchByAuthor(catalog);
//       while(!finished){
//           if(choice == 1){
//               search.searchByBookTitle(catalog);
//           }
//       }
    }

    public Book displaySearchResults(List<Book> bookList) {
        for (Book book : bookList) {
            foundBook = book;
            System.out.println(book);
        }
        return foundBook;
    }

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

        System.out.println("You chose this book.");
        book.printBook();

        return book;
    }

    public Book searchByBookTitle(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        System.out.print("Search by book title: ");
        input = Helper.inputNonBlankString();
        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getTitle().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if (searchedBooks.size() != 0) {
            int i = 1;
            System.out.println(searchedBooks.size() + " book(s) found containing the keyword \"" + input + "\" in the title.");
            for (Book book : searchedBooks) {
                foundBook = book;
                System.out.print(i + ") ");
                System.out.println(book.getTitle());
                i++;
            }
            chooseResult(searchedBooks);
        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the title.");
        }

        return foundBook;
    }

    public Book searchByAuthor(Catalog catalog) {
        System.out.println("--SEARCH BY AUTHOR--");
        List<Book> searchedBooks = new ArrayList<>();
        System.out.print("Search by author: ");
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getAuthor().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        int i = 1;
        if (!searchedBooks.isEmpty()) {
            System.out.println(searchedBooks.size() + " book(s) found containing the keyword \"" + input + "\" in the author.");
            for (Book book : searchedBooks) {
                foundBook = book;
                System.out.print(i + ") ");
                System.out.println(book.getAuthor());
                i++;
            }
        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the author.");
        }
        return foundBook;

    }

    public Book searchByISBN(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        System.out.println("--SEARCH BY ISBN-13--");
        System.out.println("NOTE: Enter ISBN-13 code up to 13 digits with no dashes.");
        System.out.print("Search by ISBN: ");
        input = Helper.inputNonBlankString();

//        while (Helper.inputISBN(input) == false) {    
//            searchByISBN(catalog);
//        }
        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getISBN().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if (!searchedBooks.isEmpty()) {
            int i = 1;
            System.out.println(searchedBooks.size() + " book(s) found with an ISBN-13 code matching " + input + ".");
            for (Book book : searchedBooks) {
                System.out.print(i + ") ");
                System.out.println(book.getISBN());
                i++;
            }
        } else {
            System.out.println("No books found with an ISBN-13 code matching " + input + ".");
        }
        return foundBook;
    }

    public Book searchByGenre(Catalog catalog) {
        System.out.println("--SEARCH BY GENRE--");
        List<Book> searchedBooks = new ArrayList<>();
        System.out.print("Search by genre: ");
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getGenre().toLowerCase().contains(input.toLowerCase())
                    || (catalog.getBookList().get(i).getGenre2() != null && catalog.getBookList().get(i).getGenre2().toLowerCase().contains(input.toLowerCase()))
                    || (catalog.getBookList().get(i).getGenre3() != null && catalog.getBookList().get(i).getGenre3().toLowerCase().contains(input.toLowerCase()))) {
                searchedBooks.add(bookList.get(i));
            }
        }

        if (!searchedBooks.isEmpty()) {
            System.out.println(searchedBooks.size() + " book(s) found containing the keyword \"" + input + "\" in the genre.");
            int i = 1;
            for (Book book : searchedBooks) {
                System.out.print(i + ") ");
                System.out.println(book.getGenre());
                i++;
            }
        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the genre.");
        }

        return foundBook;
    }
}
