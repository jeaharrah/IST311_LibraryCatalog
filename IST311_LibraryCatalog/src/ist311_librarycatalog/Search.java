package ist311_librarycatalog;

//import java.util.List;
//import java.util.Scanner;
/**
 *
 * @author Eric Liang <eql5121@psu.edu>
 */
public class Search {

//    Book book = new Book();
    //Scanner in = new Scanner(System.in);
//    Catalog catalog = new Catalog();
//    List<Book> bookList =  catalog.getBookList();
    private String input;
    private boolean found;

    public boolean searchByBookTitle(Book book) {
        input = Helper.inputNonBlankString();
        if (book.getTitle().toLowerCase().contains(input.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean searchByAuthor(Book book) {
        input = Helper.inputNonBlankString();
        if (book.getAuthor().toLowerCase().contains(input.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean searchByISBN(Book book) {
        input = Helper.inputNonBlankString();
        if (book.getISBN().toLowerCase().contains(input.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean searchByGenre(Book book) {
        input = Helper.inputNonBlankString();
        if (book.getGenre().toLowerCase().contains(input.toLowerCase())) {
            return true;
        } else {
            return false;
        }

    }

}
