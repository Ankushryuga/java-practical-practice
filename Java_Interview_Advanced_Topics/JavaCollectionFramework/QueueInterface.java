package Java_Interview_Advanced_Topics.JavaCollectionFramework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Queue Interface: elements are stores and process the data in order means elements are inserted at the end remove from the front.
 * Queue Interface: Implementation classes:
 *     =>
 *     1. LinkedList: not thread safe
 *     2. PriorityQueue: not thread safe
 *     3. ArrayDeque: not thread safe
 *     4. ConcurrentLinkedQueue(for thread-safe operations)
 *     5. PriorityBlockQueue (for thread-safe)
 *
 *     # Methods:
 *
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
 * 14. sort(Comparator comp):       //sort the element of the queue on the basis of the given comparator.
 * 15. boolean offer(object);        // used to insert
 * 16. Object poll();   // this method is used to retrieve and remove the head of the queue or return nul if empty.
 * 17. Object element() // used to retrieves, but does not remove.
 * 18. Object peek()       //used to retrieve, but does not remove.
 */

class LinkedListQueue{
    public LinkedListQueue(){
        Queue<Integer> q=new LinkedList<>();
        q.add(23);
        q.add(35);

        Iterator iterator=q.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next()+" ");
        }
    }
}

class PriorityQueueExample{
    public PriorityQueueExample(){
        Queue<Integer> q=new PriorityQueue<>();
        q.add(303);
        q.add(332);
    }
}

/**
 * PriorityBlockingQueue: is an unbounded blocking queue that uses the same ordering rules as class PriorityQueue and supplies blocking retrieval operations.
 * It is unbounded, adding elements may sometimes fail due to resource exhaustion resulting in OutOfMemoryError.
 */
class PriorityBlockQueue{
    public PriorityBlockQueue() {
        Queue<Integer> pq = new PriorityBlockingQueue<>();
        pq.add(49);
        pq.add(4933);
    }
}
public class QueueInterface {
}
