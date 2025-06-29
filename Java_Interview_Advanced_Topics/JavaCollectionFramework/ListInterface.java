package Java_Interview_Advanced_Topics.JavaCollectionFramework;

/**
 * ## Class constructors:
 * ArrayList(): This constructor is used to create an empty list with an initial capacity sufficient to hold 10 elements.
 * ArrayList(Collection<?extends E>c): used to create a list containing the elements of the specified collection.
 * ArrayList(int initalCapacity): used to create an empty list with an initial capacity.
 *
 * Methods:
 * 1. boolean add(E e)  //add element
 * 2. boolean addAll(Collection < ? extends E> c)
 * 3. void clear()  //remove all
 * 4. Object clone() //shallow copy
 * 5. boolean contains(Object o)    // check o exists or not.
 * 6. E get(int index)      //fetch element at index.
 * 7. int indexOf(Object o) //first occurrence of the specified element.
 * 8. boolean isEmpty()     //check empty or not.
 * 9. Iterator<E> iterator()    //this method returns an iterator over the elements in this list in proper sequence.
 * 10. int lastIndex(Object o)  //opposite of indexOf(Object o)
 * 11. E remove(int index) or E remove(element)  //remove.
 * 12. E set(int index, E element)  //update
 * 13. int size()   //number of element in list.
 *
 */
import java.util.ArrayList;
public class ListInterface {
    public static void main(String args[]) {
        // create an array list
        ArrayList al = new ArrayList();
        System.out.println("Initial size of al: " + al.size());

        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1, "A2");
        System.out.println("Size of al after additions: " + al.size());

        // display the array list
        System.out.println("Contents of al: " + al);

        // Remove elements from the array list
        al.remove("F");
        al.remove(2);
        System.out.println("Size of al after deletions: " + al.size());
        System.out.println("Contents of al: " + al);
    }
}
