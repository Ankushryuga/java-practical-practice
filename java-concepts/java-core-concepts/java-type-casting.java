/**
Type casting in java is the process of converting one data type to another, it can be done automatically or manually.
Automatic type casting occurs when a value of one data type is assigned to another compatible data type.


# There are 2 types of casting: widening type casting and narrowing type casting.
TypeCasting: 
Type means the data type of a variable or entity and Casting means converting the data type of an entity to another data type.


*/


public class StringtoInt {

  public static void main(String args[]) {
    // Declaring String variable
    String s = "1000";

    // Convert to int using Integer.parseInt()
    int i = Integer.parseInt(s);

    // Printing value of i
    System.out.println(i);
  }
}



/**
What is Type Casting/Conversion in Java
Type casting, also known as type conversion, is the process of changing the data type of a variable in Java. It allows you to convert a variable from one type to another, either widening or narrowing the range of possible values.

Type casting is useful when you need to perform operations on variables of different types or when you want to assign a value of one type to a variable of another type. It can be seen in the above example, when we assigned the value of a String variable to an Integer.



Primitive Data types
There are eight types of primitive data types in Java as given below:

byte
short
int
long
float
double
char
boolean
Primitive data types in Java are like the different kinds of Lego blocks you can use to build something. Type casting is like when you need to change one Lego block into another to make it fit or work together with a different block.

Types of Casting in Java
Type Casting in Java is mainly of two types.

Widening Type Casting
Narrow Type Casting
Widening Type Casting in Java
Widening type casting refers to the conversion of a lower data type into a higher one. It is also known as implicit type casting or casting down. It happens on its own. It is secure since there is no possibility of data loss.

Widening Type Casting happens on the following scenarios or conditions:

Both the data types must be compatible with each other. For example, converting a string to an integer is not possible as the string may contain alphabets that cannot be converted to digits.
The target variable holding the type casted value must be larger than the value being type casted.


//Widening Type Casting:
double  ->  float  ->  long  ->  int  ->  short  -> byte
<------------------------------------------------------- Increasing order of size.
*/




// Widening Type Casting:
public class WideningTypeCastingExample {

  public static void main(String[] args) {
    int i = 10;

    // Automatic Casting from int to long
    long l = i;

    // Automatic Casting from int to double
    double d = i;

    System.out.println("int i = " + i);
    System.out.println("long l =  " + l);
    System.out.println("double d = " + d);
  }
}
