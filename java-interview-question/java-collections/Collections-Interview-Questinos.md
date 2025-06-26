# Collection vs Collections
    => COllection: 
    is an interface present in java.util package. It is used to represent a group of individual objects as a single unit.
    Collection is considered as the root interface of the collection framework, it provides several classes and interfaces to represent a group of individual object as a signle unit.

    The List, Set and Queue are the main sub-interface of the collection interface, the map interface is also part of the java collection, but it doesn't inherit the collection of the interface. The add(), remove(), clear(), size() and contains() are the important methods of the collection interface.

    Declaration:
    public interface Collection<E> extends Iterable <E>
    Type parameters: E - the type of elements returned by this iterator.

    # Its an interface that contains a static method since java8. The interface can also contain abstract and default methods.


    => Collections:
    Is a utility class present in java.util package. It defines several utility methods like sorting and searching which is used to operate on collection. It has all static methods.

    It contains only static methods.

