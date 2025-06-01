/**
Java Objects
Objects model an entity in the real world. Modeling entities require you to identify the state and set of actions that can be performed in that object. This way of thinking is key to object-oriented programming.

An Object is the root class of all instantiated objects in Java.
Instantiated objects are names that refer to an instance of the class.
Declaring Objects in Java
Sphere sphere = new Sphere(10);

The first two tokens in the code snippet above declare an object in Java. When we read into the code, it means creating a new instance of Sphere and initializing its radius to 10.

Initializing a Java object
As mentioned, a constructor initializes an object in Java. Multiple class constructors mean that instantiating an object can have different signatures. We use the new NameOfClass([arguments_values])) to initialise a new object. There are mainly three ways to initialize an object in Java:

By Reference Variable
A constructor may accept reference type parameters.

Recall: All object types in Java are passed by reference.
**/
Example: Initialization through reference

class Cube extends AbstractShape{
    private double side;
    public Cube(Cube cubeReference){
        this(this.side);
    }
}

// The above code effectively copies the content of arguments passed in the constructor of type Cube.

/**
By method
An object may be initialized with a setter function that alters the class's internal state and may be accessed with a getter function. This initialization allows only one instance of the class to be modified dynamically: one can alter that of the object at runtime.
*/
//Example: Initialization through a method

class Cube extends AbstractShape{
	private double side;
    
    public Cube(){
    	System.out.println("Cube is instantiated.");    
    }
    public void setSide(double side){
        this.side = side;
    }
    
    public double getSide(){
        return this.side;
    }
    // ...
}

class Main{
    public static void main(String [] args){
        Cube cube = new Cube();
        cube.setSide(5.7);
    	System.out.println("Internal state of the cube: " + cube.getSide()); 
        cube.setSide(11.2);
    	System.out.println("Internal state of the cube: " + cube.getSide());    
    }
}
/**
By constructor
Finally, an object may be initialized by specifying arguments passed in a constructor. A constructor is a unique method that initializes the state of class instance.

Different Ways to Create Objects in Java
There are different ways to instantiate an object in Java; this section aims to discuss and implement each style.

Using new Keyword
This is the most direct form of object creation in Java. This style tells Java to initialize a class instance and assign a reference to it in a named object, in this case, cube.

Cube cube = new Cube(4.5);

Using Class.forName(String className) Method
This style can be attained if the class has a public constructor. The Class.forName() method does not yet instantiate an object; to do so, the newInstance() has to be typecast in the given class.

*/
class Cube {
    public Cube(){
        System.out.println("Cube is instantiated.");
    }
    // ...
}

public class Main{
    public static void main(String[] args) throws ClassNotFoundException, 
                                                  InstantiationException,
                                                  IllegalAccessException{
        Class obj = Class.forName("Cube");
        Cube cube = (Cube)obj.newInstance();
    }
}
/**
Using clone() Method
It requires the object to implement a Cloneable interface. Since objects are passed by reference in Java, changes that happen somewhere in the program affect the internal state of that object. In cases where we do not want unintended side effects to happen, we can copy the entire contents of an object and treat it independently.
*/
class Cube implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public Cube(double x){
        System.out.println("instantiated with " + x);
    }
    // ...
}

public class Main{
    public static void main(String[] args) throws CloneNotSupportedException{
        Cube cube1 = new Cube(4.5); 
        Cube cube2 = (Cube)cube1.clone();
    }
}
/**
Deserialization
It converts a stream of bytes into an object. We must implement the Serializeable interface in the class to implement this style.
*/
class Cube implements Serializeable{    
    public Cube(double x){
        System.out.println("instantiated with " + x);
    }
    // ...
}

public class Main{
    public static void main(String[] args) throws Exception{
        Cube cube1 = new Cube(4.5); 
        Cube cube2 = (Cube)cube1.clone();
    }
}

/**
Anonymous Objects in Java
Anonymous objects are nameless entities that may be used for calling a specific method defined in a class without needing the entire class – nameless objects mean the class instance does not have a reference.

System.out.println(new Cube(5.5).surfaceArea());

Creating Multiple Objects by One Type
One can create multiple objects within a container type in Java, such as List, Array, ArrayList, Queue, and Stack.

Real World Example: Account
*/
import java.util.ArrayList;
import java.util.List;

class Account{
    private String accountName;
    private String accountHolder;
    private String accountNumber;
    
    Account(String accountName, String accountHolder, String accountNumber){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }
}

class Main{
   public static void main(String[] args) {
      List<Account> accountList = new ArrayList<Account>();

      accountList.add(new Account("BDO", "Jenifer Alvez", "001-237-9900"));
      accountList.add(new Account("BPI", "John Ronel", "001-247-9982"));
      accountList.add(new Account("JPMC", "Ross Geller", "001-239-9920"));
      accountList.add(new Account("BDO", "Jenifer Adriana", "001-217-9980"));
       
      for(Tester tester : testerList){
         System.out.println(tester.getData());
      }
   }
}
/**
  
Difference between Classes and Objects in Java
Class	Object
A class is a blueprint for declaring and creating objects.	An object is a class instance that allows programmers to use variables and methods from inside the class.
Memory is not allocated to classes. Classes have no physical existence.	When objects are created, they are allocated to the heap memory.
You can declare a class only once.	A class can be used to create many objects.
Class is a logical entity.	An object is a physical entity.
We cannot manipulate class as it is not available in memory.	Objects can be manipulated.
Class is created using the class keyword like class Dog{}	Objects are created through new keyword like Dog d = new Dog();. We can also create an object using the newInstance() method, clone() method, factory method, and deserialization.
Example: Mobile is a class.	If Mobile is the class, then iphone, redmi, blackberry, and samsung are its objects with different properties and behaviours.
Classes can have attributes and methods defined.	Objects can have specific values assigned to their attributes.
Classes serve as blueprints for creating objects.	Objects represent specific instances created from a class.


*/
