/**
 * IST 311 - Professor Soby Chacko -- Fall 2017 
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah 
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

/**
 * Design a Library catalog. Create a catalog that contains various books.
 * Allow the users to search for books and show their status (availability). 
 * If available, allow the user to check the book out. 
 * Add more features to your application.
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class LibraryCatalog_MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Book book1 = new Book("9780-4484-57147", "The Little Engine That Could", "Watty Piper", "Children's Literature");
        System.out.println(book1.getTitle());
        System.out.println(book1.getAuthor());
        System.out.println(book1.getISBN());
        System.out.println(book1.getGenre());
        
        Catalog catalog = new Catalog();
        catalog.displayBooks();
        
    }
    
}
