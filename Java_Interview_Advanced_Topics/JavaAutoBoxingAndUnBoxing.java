package Java_Interview_Advanced_Topics;

import java.util.ArrayList;
import java.util.List;

/**
 * Autoboxing: it's a technique used by java compiler to convert a primitive value to its wrapper counterpart.
 *
 * ## Compiler uses autoboxing in following scenarios:
 *  1. If a primitive value is passed as an argument to a function which is expecting a wrapper class object.
 *
 *  2. If a primitive value is assigned to a variable of the type of wrapper class.
 *
 *
 *
 * Unboxing: It's a technique used by java compiler to covert primitive class to its respective object.
 * ## Compiler used unboxing in following scenarios:
 * 1. If a wrapper class object is passed as an argument to a function which is expecting a primitive value.
 * 2. If a wrapper class object is assigned to a variable of primitive type.
 *
 */
public class JavaAutoBoxingAndUnBoxing {
    //Autoboxing:
    Integer obj=10;
    //Explicit Casting:
    Integer obj2=Integer.valueOf(10);

    //Unboxing:
    int i=obj;
    //Explicit value deduction:
//    i=obj.intValue();

    /**
     * Autoboxing Example:
     */
    public static void main(String[] args){

        //Autoboxing:
        List<Integer> list=new ArrayList<>();
        //Autoboxing by passing as an argument. int value is getting converted to Integer.
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list);


        //Unboxing:
        Integer integer=Integer.valueOf(-10);
        //unboxing by passing as an argument, Integer object is converted to int.
        int i=Math.abs(integer);
        System.out.println(i);
        int j=integer;  //unboxing by assigning integer object to int variable.
    }

}
