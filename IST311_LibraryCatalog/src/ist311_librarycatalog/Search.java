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
    private boolean found;

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

    public void displaySearchResults(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public Book chooseResult(List<Book> searchedBooks) {
        int choice = Helper.numberValidation();
        return searchedBooks.get(choice - 1);
    }

    public void searchByBookTitle(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        System.out.println("Search by book title: ");
        input = Helper.inputNonBlankString();
        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getTitle().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if (searchedBooks.size() != 0) {
            int i = 1;
            System.out.println("Books found containing the keyword \"" + input + "\" in the title.");
            for (Book book : searchedBooks) {
                System.out.print(i + ") ");
                System.out.println(book.getTitle());
                i++;
            }
//            chooseResult(searchedBooks);
        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the title.");
        }

    }

    public void searchByAuthor(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        System.out.println("Search by author: ");
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getAuthor().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        int i = 1;
        if (!searchedBooks.isEmpty()) {
            System.out.println("Books found containing the keyword \"" + input + "\" in the author.");
            for (Book book : searchedBooks) {
                System.out.print(i + ") ");
                System.out.println(book.getAuthor());
                i++;
            }
        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the author.");
        }

    }

    public void searchByISBN(Catalog catalog) {
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
            System.out.println("Books found with an ISBN-13 code matching " + input + ".");
            for (Book book : searchedBooks) {
                System.out.print(i + ") ");
                System.out.println(book.getISBN());
                i++;
            }
        } else {
            System.out.println("No books found with an ISBN-13 code matching " + input + ".");
        }

    }

    public void searchByGenre(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        System.out.println("Search by genre: ");
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getGenre().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if (!searchedBooks.isEmpty()) {
            System.out.println("Books found containing the keyword \"" + input + "\" in the genre.");
            int i = 1;
            for (Book book : searchedBooks) {
                System.out.print(i + ") ");
                System.out.println(book.getGenre());
                i++;
            }
        } else {
            System.out.println("No books found containing the keyword \"" + input + "\" in the genre.");
        }

    }
}
