# Java oops questions
# Java oops questions

# What are the main principles of Object Oriented Programming? 14. What is the difference between Object Oriented Programming language and Object Based Programming language?

    => oops core feature:
    1. Encapsulation
    2. Abstraction
    3. Polymorphism
    4. Inheritance

    1. oops language: are fully-featured and support all 4 oops principles.
    2. Object-based language: only support objects and encapsulation, not fully oop features like inheritance and polymorphism.

# In Java what is the default value of an object reference defined as an instance variable in an Object?

    =>
    when you declare an instance variable but do not explictly initialize it, java provides a default value depending on the variable type.

    For object references (like String, Integer, Person, etc.), the default is null.

    Example:
        public class Example {
        String name; // instance variable, not initialized

        public void printName() {
            System.out.println(name); // Prints: null
        }

        public static void main(String[] args) {
            Example ex = new Example();
            ex.printName();
        }
    }

# ✅ Summary of Default Values for Instance Variables:

    =>
        Data Type Default Value
        int 0
        boolean false
        char '\u0000'
        float 0.0f
        double 0.0d
        Object types null
        Note: This applies only to instance variables, not local variables, which must be explicitly initialized before use.

# What is the value returned by constructor in java?

        => it returns the reference to the object that is being created.

# Can we inherit a Constructor?

    =>
    No constructors cannot be inherited in java,
    b/c constructors are special methods tied to a specific class name and the subclass has a differnet name.
    however you can call it by super().

# Why constructors cannot be final, static, or abstract in Java

    =>
    1. final means a methods cannot be overriden, constructors are never inherited or overridden, so making them final is pointless and disallowed.
    2. static means the method belongs to the class, not instances, constructors are used to created instances, so it makes no sense for them to be static.
    3. Abstract: means the method must be overridden in subclass

# In OOPS, what is meant by composition? 26. How aggregation and composition are different concepts? 27. Why there are no pointers in Java?

    =>
    1. Composition: one class "has-a" relationship with another class, it means one object is composed of one or more objects from other classes.

    Aggregation vs Composition.
    1. Relationship: Aggregation (wear "has-a")  Composition (String "has-a").
    2. Coupling: Aggregation (Loose coupling), Composition (Tight coupling).
    etc.

# 28.If there are no pointers in Java, then why do we get NullPointerException?

    => when you try to access a method of field using a null reference, b/c there no actual object in memory to operate on.

# Is it possible to use this() and super() both in same constructor? What is the meaning of object cloning in Java?

    =>
    No, it is not possible to use both this() and super() in the same constructor.
    b/c: both this() and super() must be the first statement in the constructor, since only one statement can be first, java doesn't allow both in the same constructor.

    public class Child extends Parent {
        Child() {
        this();    // ❌ Error if super() is also used
        super();   // ❌ Compile-time error
        }
    }

    # Object cloning means creating an exact copy of an existing object with the same state (field values).
    # Key points:
    1. java provides cloning using the clone() method from the object class.
    2. Class must implement Cloneable interface.
    3. Override the clone() method.
    Example:
        =>
        class Person implements Cloneable{
            String name;
            public Person(String name){
                this.name=name;
            }
            public Object clone() throws CloneNotSupportedException{
                return super.clone();   //shallow copy..
            }
        }

# In Java, why do we use static variable? 33. Why it is not a good practice to create static variables in Java?

    =>
    static variable is a class-level variable, shared by all instances of a class.
    Use static, only when value is truly shared and constant.
    avoid using static for storing mutable shared state, instance-specific data.

# What is the purpose of static method in Java?

    => it belongs to the class rather than any specific object, it can be called without creating an instance of the class.
    Example:

# Why do we mark main method as static in Java? 36. In what scenario do we use a static block? 37. Is it possible to execute a program without defining a main() method? 38. What happens when static modifier is not mentioned in the signature of main method? 39. What is the difference between static method and instance method in

    => main() method is marked static b/c it serves as the entry point of a java application and must be called by the JVM without creating an object of the class.
    => if main() method is not static, the JVM would need to create an Object first- but it wouldn't know how without calling main().

    # Static block:
    A static block is used for. static initialization -  it runs once when the class is loaded, before any constructor or main().

    # use cases:
        1. Load configuration files.
        2. Register drivers

    # it was possible before java 7 to execute a program without main() method, but since java 7, the JVM requires a main() method.

# Why it is not possible to do method overloading by changing return

    => since method overloading is compile-time polymorphism, and it resolved at compile time using method signature,
    Return type is not part of the method signature.

# Is it allowed to overload main() method in Java?

    => yes,
    public class Test {
    public static void main(String[] args) {
        System.out.println("Original main");
        main(5); // calling overloaded main
    }

    public static void main(int num) {
        System.out.println("Overloaded main with int: " + num);
    }
    }

# Does Java allow virtual functions? 51. What is meant by covariant return type in Java?

    =>
    yes, in java, all non-static, non-final, and non-private methods are virtual by default.

    Virtual Functions: its a method whose behavior can be overriden in a subclass and is resolved at runtime (polymorphism).

    A covariant return type allows an overriding method in a subclass to return a more specific type (a subtype) than the method it overrides in the superclass.

# What is Runtime Polymorphism? 53. Is it possible to achieve Runtime Polymorphism by data members in java?

    =>
    Runtime polymorphism or Dynamic Method dispatch: its an ability of java to decide at runtime which method to call based on the actual object type, not the reference type.

    Its not possible to achieve runtime polymorphism using only data members, it only applies to methods.,

# Explain the difference between static and dynamic binding?

    =>
    Binding: it refers to the process of linking a method call to its definition.
    1. Static Binding (Early Binding): done at compile time, applies to Static, Final, Private, and Overloaded methods. Not polymorphism.
    Example:
    class Demo{
        static void greet(){
            System.out.println("Hello from static methods");
        }
        void show(int a){
            System.out.println("Integer version");
        }
        void show(String s){
            System.out.println("String version");
        }
    }

    2. Dynamic Binding (Late Binding): done at runtime, applies to overridden instances methods.
    its runtime polymorphism.
    Example:
    class Parent{
        void display(){
            System.out.println("Parent");
        }
    }
    class Child extends Parents{
        @Override
        void display(){
            System.out.println("child");
        }
    }

    public class Test {
        public static void main(String[] args){
            Parent p=new Child();
            p.display();//runtime poly
        }
    }

# Is it allowed to mark a method abstract method without marking the class abstract?

    => No, an abstract method has no body- its a placeholder that must be implemented by subclasses.
    If a class contains even one abstract method, it must be declared as abstract b/c.
    1. A non-abstract class must provide complete implementation for all methods.

# Is it allowed to mark a method abstract as well as final? 60. Can we instantiate an abstract class in Java? 61. What is an interface in Java? 62. Is it allowed to mark an interface method as static? 63. Why an Interface cannot be marked as final in Java?

    =>
    no, an abstract method must be overridden in a subclass.
    abstract cannot be instantiated directly, but we can achieve through annonoymous class.
    Example:
    abstract class Shape{
        abstract void draw();
    }
    Shape s=new Shape(){
        void draw(){
            System.out.println("Hello")
        }
    }

# Marker Interface?

    => A marker interface in java is an interface that has no methods or fields, its completely empty.
    => it is used to mark or tag a class, giving metadata or behavioral information to the java compiler or JVM without defining any methods.
    means:
    "This class has a special property - handle it differently."

    Interfaces:
    1. Serializable:    Tells the JVM the object can be serialized.
    2. Cloneable:   Marks that the class supports object cloning.
    3. Remote(RMI): Indicates that objects can be used remotely.
    4. SingleThreadModel: Markser for servlet.

# What can we use instead of Marker interface? 66. How Annotations are better than Marker Interfaces? 67. What is the difference between abstract class and interface in Java?

    =>
    we can use Annotations instead of marker interfaces.
    # Marker interface are empty interfaces used to tag a class, but they lack flexibility.

    # Marker interface:
    class MyClass implements Serializable{}

    # with Annotation:
    @SerializableMarker
    class MyClass{}
    @interface SerializableMarker{}

    # How are Annotations better than marker interface?
    1. can store metadata: Annotation (Yes), Marker (No).
    2. Multiple Per class: Annotation (Yes), Marker (Only one interface name allowed).
    3. Checked at:  Annotation (Compile time, runtime source), Marker (runtime via instanceOf).

    # Interface: for defining a contract b/w unrelated classes, all methods are implicitly public, abstract(unless static/default/private).

    # Abstract class: for common behaviour across closely related classes.(can be public, private, protected or default)

# Does Java allow us to use private and protected modifiers for variables in interfaces?

    => no, all variables declared inside interface are implicitly:
        public static final
        That means:
        public → accessible wherever the interface is accessible.
        static → belongs to the interface (not instance).
        final → constant (must be initialized when declared).

# How can we cast to an object reference to an interface reference?

    =>either direcly or through inheritance

    Example:
    InterfaceName ref=(InterfaceName) object;
    //if the object does not implement the interface, you'll get ClassCastException at runtime.

        interface Animal {
            void speak();
        }

        class Dog implements Animal {
            public void speak() {
                System.out.println("Woof!");
            }

            public void bark() {
                System.out.println("Barking...");
            }
        }

        public class Test {
            public static void main(String[] args) {
                Dog dog = new Dog();

                // Cast Dog object to Animal interface reference
                Animal a = (Animal) dog;
                a.speak(); // ✅ Calls Dog's speak()

                // a.bark(); // ❌ Not allowed: bark() is not in Animal interface
            }
        }

        //Runtime safety.
        if(obj instanceof Runnable){
            Runnable r=(Runnable) obj;
            r.run();
        }

# Can a class be Marked final, and how can we create final method ?

    => yes, but a final class cannot be subclassed(i.e., no other class can extend it).
    # Example:
    final class Utility{
        public static void sayHi(){
            System.out.println("Hi);
        }
    }
    class SubUtility extends Utility{   //error.
    }

    => use the final keyword before the method declarations.
    => A final method cannot be overridden in a subclass.

# How can we prohibit inheritance in java?

    =>
    1. Mark class as final: prevents any class from extending it.
    2. Use a private constructor: prevents subclassing by making the constructor inaccessible.

# What is a Nested class?

    => nested class that is declared inside another class, it helps logically group classes thatare only used in one place, increasing encapsulation, readability and code organization.

    # Type os nested class.
    1. static nested class: declared with static keyword, doesn't have access to instance members of the outer class.

    # Example:
    class Outer{
        static class StaticNested{
            void display(){
                System.out.println("Static nested class");
            }
        }
    }
    #Usage: Outer.StaticNested obj=new Outer.StaticNested();
    obj.display();

    2. Non-static Nested class: has access to all members (even private) of the outer class.
        => member inner class:
            class Outer{
                class Inner{
                    void display(){
                        System.out.println("Member inner class");
                    }
                }
            }

    # usage:
    Outer outer=new Outer();
    Outer.Inner inner=outer.new Inner();
        => Local inner:
        class Outer{
            void method(){
                class LocalInner{
                    void msg(){
                        System.out.println("Local inner");
                    }
                }
                LocalInner obj=new LocalInner();
                obj.msg();
            }
        }
    3. Anonymous Inner class:
        => A class with no name defined and instantiated in place:
        Runnable r=new Runnable(){
            public void run(){
                System.out.println("ANno");
            }
        };
        new Thread(r).start();

# What is the difference between a Nested class and an Inner class in Java?

    =>
    "nested class" refers to any class defined within another class.
    1. static nested classes.
    2. Inner classes(non-static nested classes).
    => all inner classes are nested classes, but not all nested classes are inner classes.

# What is a Nested interface?

    => A nested interface is an interface declared inside a class or another interface.
    # Example:
    class OuterClass{
        interface NestedInterface{
            void display();
        }
    }
    class MyClass implements OuterClass.NestedInterface{
        public void display(){
            System.out.println("Nested interface");
        }
    }
    # Nested interface inside an interface:
    interface OuterInterface{
        interface Nested{
            void show();
        }
    }
    class MyNestedImpl implements OuterInterface.Nested {
    public void show() {
        System.out.println("Nested inside interface");
    }
    }
    # Example:
    public interface Map{
        interface Entry<K, V>{
            K getKey();
            V getValue();
        }
    }
    class MyEntry implements Map.Entry<String, Integer>{
        public String getKey(){
            return "key";
        }
        public Integer getValue(){
            return 100;
        }
    }

# How can we access the non-final local variable, inside a Local Inner class?

    => must be final. then only
    void method() {
    int x = 10;  // 👈 Effectively final (never reassigned)

        class LocalInner {
            void print() {
                System.out.println(x);  // ✅ Allowed
            }
        }

        LocalInner inner = new LocalInner();
        inner.print();
    }

# Do we have to explicitly mark a Nested Interface public static?

    => no, all nested interfaces are implicitly static in java.
    => when you declare an interface inside a class or interface, the compiler automatically treats it as public static.

# Why do we use Static Nested interface in Java?

    =>
    1. Group Related Types Together
    2. Encapsulation and access control.

# How will you create an immutable class in Java?

    => make class final, all fields private and final, and provide only getter no setters.
