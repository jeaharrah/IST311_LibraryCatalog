/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311_librarycatalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Eric Liang
 */
public class Sorter {

    public static void main(String[] args) {
        //String[] names = {"joe", "slim", "ed", "george"};
        Catalog catalog = new Catalog();
        //catalog.displayBooks();
        List<Book> bookList = new ArrayList<>(catalog.getBooks());

        for (Book book : catalog.getBooks()) {
            System.out.println(book.getTitle());
        }

        System.out.println("After sort.");
 
       for (Book book : catalog.getBooks()) {
            System.out.println(book.getTitle());
        }
        /*
        sortStringBubble(names);
        for (int k = 0; k < 4; k++) {
            System.out.println(names[k]);
        }*/
    }

}
