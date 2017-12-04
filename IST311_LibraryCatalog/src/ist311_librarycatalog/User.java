/**
 * IST 311 - Professor Soby Chacko -- Fall 2017 
 * Team Members: Jennifer A'Harrah, Eric Liang, Sachin Patel
 * Scrum Master: Sachin Patel --- Product Owner: Jennifer A'Harrah 
 * Problem #2: Library Catalog
 */
package ist311_librarycatalog;

/**
 * User class contains fields and methods for retrieving and displaying the
 * user's name in order to make the program more personal when he or she runs it
 * @author Jennifer A'Harrah <jka5240@psu.edu>
 */
public class User {
    private String _userName = null;
    
    public String getName() {
        return this._userName;
    }

    public void setName() {
        System.out.println("-= Enter your name =-");
        String userName = Helper.inputNonBlankString();
        this._userName = userName;
    }
    
    public static void main(String[] args) {
        User user = new User();
        user.setName();
        
    }
    
}