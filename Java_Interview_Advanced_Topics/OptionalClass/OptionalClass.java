package Java_Interview_Advanced_Topics.OptionalClass;

import java.util.Optional;

/**
 * Optional class: introduced in java 8, to simplify null pointer exception handling.
 *
 * Optional class is used when there is high chances of getting null pointer exception even
 * after handling using exception handling techniques.
 *
 * Optional instance is a container object used to contain not-null object/value, Optional Object
 * is used to represent null with absent value.
 *
 * Optional class provides a type check solution instead of directly checking the null value, this class
 * acts as a wrapper over the value.
 * apart from null pointer check, it also provides utility methods to get default value in case of null value, throwing exception in case
 * underlying value is null.
 *
 *
 * ## syntax:
 * public final class Optional<T> extends Object
 */
public class OptionalClass {
    public static void main(String[] args){
        Integer value1=null;
        Integer value2=Integer.valueOf(100);
        //Optional
        Optional<Integer> empty=Optional.empty();
        Optional<Integer> a= Optional.ofNullable(value1);
        Optional<Integer> b=Optional.of(value2);

        System.out.println("Value of a: "+(a.isPresent()?a.get():"0"));
        System.out.println("Value of b: "+(b.isPresent()?b.get():"0"));
        System.out.println("Value of a: "+(empty.isEmpty()?empty.get():"0"));
    }
}
