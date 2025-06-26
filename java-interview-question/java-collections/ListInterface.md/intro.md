# Java List Interface:
    => List interface in java extends the collection interface and a part of java.util.package. It is used to store the ordered collections of elements.

    ## The implementation classes of the List interface are ArrayList, LinkedList, Stack & Vector.

    => It can add Null values that depend on the implementation.

## List Methods:
    =>
    1. Adding Elements:
        a. add(Object o);   //this method is used to add an element at the end 
        b. add(int index, Object o);    //this method is used to add an element at a specific index in the list.

    2. Update elements:
        a. set(): //set method change the element 
            => set(1, "RUST")
    
    3. Search:
        a. indexOf(Object o):       //it returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.
            => Example:       
             List<Integer> al = new ArrayList<>();
             al.add(1);
             al.add(4);
             int i=al.indexOf(2);
            

        b. lastIndexOf(Object o):   //it returns the index of last occurrence of the specified element in the list, or -1 if the element is not found.
            => Example:
            int i=al.lastIndexOf(2);

