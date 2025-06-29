# Collection:
    => its a interface.
# Collections:
    => its a utilty class.


# Classes Associate with java List interface:
    =>
    1. ArrayList: dynamic arrays, it may be slower but helpful for data manipulation.
            # example:
            List<Integer> list=new ArrayList<Integer>(n);
    2. Vector: growable array of object, it implement dynamic array that means it can grow or shrink as required.
            # Example:
            List<Integer> list=new Vector<Integer>(n);
    3. Stack: it extends Vector class model and implement Stack DS, it work on LIFO.
            # Example:
            List<Integer> list=new Stack<Integer>(n);
    4. LinkedList: its a linear DS where elements are not stored in contiguous locations and every element is a separate object with a data part and address part.
            # Example:
            List<Integer> list=new LinkedList<>();


# ArrayList vs LinkedList
ArrayList : Underlying structure is Dynamic Array
LinkedList : Underlying structure is Doubly-linked list
ArrayList : O(1) - Fast random access
LinkedList: O(n) - Slow random access
ArrayList: Memory is lower (contiguous memory)
LinkedList : Memory is higher (extra pointers per node)
ArrayList: Iteration speed is faster
LinkedList : Iterartion speed is slower.
ArrayList:Insertion and deletion is slower
Linkedlist: Insertion and deletion is faster.


# Queue Interface: Implementation classes:
    =>
    1. LinkedList
    2. PriorityQueue
    3. ArrayDeque
    4. ConcurrentLinkedQueue(for thread-safe operations)