package OOPS.Interfaces;

import java.io.Serializable;

/**
 * Types of Interfaces:
 * 1. Normal or Regular Interface : Contains, Abstract methods (implicitly public and abstract), can include default and static methods., can include private methods.
 *
 */

interface Vehicle{
    void drive();
    default void stop(){
        System.out.println("vehicle stopped");
    }
}

/**
 * 2. Functional Interface: Contains, exactly one abstract method, can have default or static methods.
 */
@FunctionalInterface
interface Converter{
    int convert(String input);
}

/**
 * 3. Marker Interface: No methods or fields, used to mark a class for specific purpose.
 * ## Example: Serializable, Cloneable, Remote
 */

class User implements Serializable{

}

/**
 * 4. Nested Interface: An interface declared inside another class or interface.
 * Used to group logically related interfaces or provide tight encapsulation.
 *
 */

class Outer{
    interface InnerInterface{
        void display();
    }
}

class Demo implements Outer.InnerInterface{
    public void display(){
        System.out.println("Nested Interface");
    }
}
public class Interfaces {
    public static void main(String[] args){
//        Converter conv=(a)->Integer.parseInt(a);
        Converter conv=Integer::parseInt;
    }
}
