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
    public static List<Book> bookList =  catalog.getBookList();
    private String input;
    private boolean found;
    
    public static void main(String[] args) {
        boolean finished = false;
       int choice = 0;
       
       
       search.searchByBookTitle(catalog);
 
//       while(!finished){
//           if(choice == 1){
//               search.searchByBookTitle(catalog);
//           }
//       }
        
    }
    
    public void displaySearchResults(List<Book> bookList){
        for(Book book: bookList){
            System.out.println(book);
        }
    }
    public void searchByBookTitle(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getTitle().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if(searchedBooks.size() != 0){
            for(Book book: searchedBooks){
                System.out.println(book.getTitle());
            }
        }
        else{
            System.out.println("No books found.");
        }
 
    }

    public void searchByAuthor(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getAuthor().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if(searchedBooks.size() != 0){
            for(Book book: searchedBooks){
                System.out.println(book.getAuthor());
            }
        }
        else{
            System.out.println("No books found.");
        }
 
    }

    public void searchByISBN(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getISBN().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if(searchedBooks.size() != 0){
            for(Book book: searchedBooks){
                System.out.println(book.getISBN());
            }
        }
        else{
            System.out.println("No books found.");
        }
 
    }

    public void searchByGenre(Catalog catalog) {
        List<Book> searchedBooks = new ArrayList<>();
        input = Helper.inputNonBlankString();

        for (int i = 0; i < bookList.size(); i++) {
            if (catalog.getBookList().get(i).getGenre().toLowerCase().contains(input.toLowerCase())) {
                searchedBooks.add(bookList.get(i));
            }
        }
        if(searchedBooks.size() != 0){
            for(Book book: searchedBooks){
                System.out.println(book.getGenre());
            }
        }
        else{
            System.out.println("No books found.");
        }
 
    }
}
