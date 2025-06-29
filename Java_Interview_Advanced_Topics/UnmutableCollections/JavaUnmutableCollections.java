package Java_Interview_Advanced_Topics.UnmutableCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * # un-mutable is available for List, Set and Map interface.
 * Syntax:
 * List unmodifiableList=Collections.unmodifiableList(arrayList);
 *
 * where arrayList is a mutable list instance, so we are required to create a list and then using unmodifiableList().
 * we get an immutable instance from which we cannot add/remove element.
 *
 */
public class JavaUnmutableCollections {

    public static void main(String[] args) {
        /**
         * Creating unmodifiable list before java 9.
         */
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list= Collections.unmodifiableList(list);
        System.out.println(list);

        /**
         * After Java 9:
         */
        List<String> list2=List.of("A", "B", "C");
        System.out.println(list2);
    }
}
