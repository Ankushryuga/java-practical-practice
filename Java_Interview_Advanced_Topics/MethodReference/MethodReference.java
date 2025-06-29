package Java_Interview_Advanced_Topics.MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Method Reference: it points to methods by their name even without specifying the arguments. Arguments are passed by the lambda expression.
 *
 * A method reference is described using "::" symbol;
 *
 * ## Type of java method references:
 * 1. Static methods.=> Syntax: <<class-name>>::methodName
 * 2. Instance methods.=> Syntax: <<object-name>>::methodName
 * 3. Constructor using new operator(TreeSet::new)
 */
public class MethodReference {
    public static void main(String[] args){
        /**
         * Static method reference:
         */
        List<String>name=new ArrayList<>();
        name.add("A");
        name.add("B");
        name.add("C");

        //by lambda::
        name.forEach(i->System.out.println(i));
        //by method reference:
        name.forEach(System.out::println);

        /**
         * Instance Method:
         */
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6);

        //sorted using lambda expression:
        numbers=numbers.stream().sorted((a,b)->a.compareTo(b)).toList();

        //using method reference:
        numbers=numbers.stream().sorted(Integer::compareTo).toList();

        System.out.println(numbers);


        /**
         * Reference to a constructor:
         */
        List<String> studentName=Arrays.asList("Ankush","Spandana", "Ramesh");
        Student[] students=studentName.stream().map(Student::new).toArray(Student[]::new);

        List<Student> list=Arrays.asList(students);
        System.out.println(list);
    }
}
class Student{
    String name;
    Student(String name){
        this.name=name;
    }
    public String toString(){
        return this.name;
    }
}