# Constructor: 
    => its a special block of code that is called when an object is created, its main job is to initialize the object, to set up its internal state, or to
       assign default values to its attributes. This process happens automatically when we use the "new" keyword to create an object.

# Characteristics of constructos:
    => 
    1. Same name as the class.
    2. No Return type.
    3. Automatically called on object creation.
    4. Used to set inital value for object attributes.

# Why do we need constructors in java?
    => It ensures that an object is properly initialized before use.
    # Without constructors issue.
    1. Objects might have undefined or default values.
    2. Extra initialization methods would be required.
    3. Risk of improper object state.

# When java constructor is called?
    =>
    Each time an object is created using a new() keyword.
    # Rules for writing constructors are:
    1. constructor of a class must have the same name as the class name in which it resides.
    2. A constructor in java can not be abstract, final, static or synchronized.
    3. Access modifiers can be used in constructor declaration to control its access i.e, which other class can call the constructor.


#  Types of constructors in java:
    1. Default.
    2. Parameterized constructor: a constructor that has parameters is known as parameterized constructor.
    3. Copy constructor: passed with another object which copies the data available from the passed object to the newly created object.

Note: java doesn't provide a built-in copy constructor like c++, we can create our own by writing a constructor that takes an object 
of the same class as a parameter and copies its fields.

    Example:
    class ConstructorExample{
      String name;
      int id;
      //parameterized constructor
      ConstructorExample(String name, int id){
        this.name=name;
        this.id=id;
      }
      //copy constructor.
      ConstructorExample(ConstructorExample obj){
        this.name=obj.name;
        this.id=obj.id;
      }
    }

    class Main{
      public static void main(String[] args){
        ConstructorExample obj1=new ConstructorExample("sweta", 49);
        System.out.println("GeeksName: "+obj1.name+" and id"+ obj1.id);
        System.out.println();
        ConstructorExample obj2=new ConstructorExample(obj1);
        System.out.println("Copy constructor used");
        System.out.println("GeeksName: "+obj2.name+" and id"+ obj2.id);
      }
    }


# Constructor overloading:
    => initializing object in different ways
