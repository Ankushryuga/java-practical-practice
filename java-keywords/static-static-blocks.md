# Static keyword:
    => it mainly used for memory management, allowing variables and methods to belong to the class itself rather than individual instances. The static keyword
       is used to share the same variable or method of a given class. The users can apply static keywords with variables, methods, blocks and nested classes, 
       The static keyword belongs to the class rather than an instance of the class.
       The static keyword is used for a constant variable or method that is the same for every instance of a class.


# What is a static keyword in java?
    => its a non-access modifier used for:
      1. variables (class-level, shared across instances).: when a variable is declared as static, then a single copy of the variable is created and shared among all the objects of the class level.
        static variables are, essentially, global variables. All instances of the class share the same static variable.
        
      2. Methods (called without object creation).
      3. Blocks(executed once when the class loads).
      4. Nested classes(static inner classes).

# Note:
    =>
    1. we can create static variables at the class level only.
    2. static block and static variables are executed in the order they are present in a program
    
# Note: static variables are initialzied by calling static methods before the static block is executed.

# Note: To create a static member(block, variable, method, nested class), precede its declaration with the keyword static. 

# Characteristics of the "static" keyword?
    =>
    1. static variables and methods use memory only once when the program runs, and this memory is shared by all the objects of the class.
    2. we do not need to create objects of the class to use static methods.
    3. we can call static members using the class name directly.
    4. static members belong to the class, not to any specified object.
    5. static members can not access non-static members.
    6. Static methods cannot be overridden in subclasses because they belong to the class, not to an object.
    
# When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object. 


## Example:  
    =>
    // Java program to demonstrate execution
    // of static blocks and variables
    class Geeks
    {
        // static variable
        static int a = m1();
        
        // static block
        static {
            System.out.println("Inside static block");
        }
        
        // static method
        static int m1() {
            System.out.println("from m1");
            return 20;
        }
        
        // static method(main !!)
        public static void main(String[] args)
        {
           System.out.println("Value of a : "+a);
           System.out.println("from main");
        }
    }


## Static Methods:
    =>
    When a method is declared with the static keyword, it is known as the static method. Any static member can be accessed before any objects of its class are created, and without
    reference to any object. Methods declared as static have several restrictions.

    1. They can only directly call other staitc methods.
    2. They can only directly access statid data.
    3. They cannot refer to **this** or **super** in any way.

# NOTE:
    => static methods cannot access instance variables, instance methods, or use super in a static context.
      // Java program to demonstrate restriction on static methods
    class Geeks
    {
        // static variable
        static int a = 10;
        
        // instance variable
        int b = 20;
        
        // static method
        static void m1()
        {
            a = 20;
            System.out.println("from m1");
            
             // Cannot make a static reference to the non-static field b
             b = 10; // compilation error
                    
             // Cannot make a static reference to the 
                     // non-static method m2() from the type Test
             m2();  // compilation error
             
             //  Cannot use super in a static context
             System.out.println(super.a); // compiler error 
        }
        // instance method
        void m2()
        {    
            System.out.println("from m2");
        }
        public static void main(String[] args)
        {
            // main method 
        }
    }

# When to use Static variable and methods?
    =>
    1. use the static variable for the property that is common to all objects.
# Example:
    =>
    // A java program to demonstrate use of
    // static keyword with methods and variables
    
    // Student class
    class Student {
        String name;
        int rollNo;
    
        // static variable
        static String cllgName;
    
        // static counter to set unique roll no
        static int counter = 0;
    
        public Student(String name)
        {
            this.name = name;
    
            this.rollNo = setRollNo();
        }
    
        // getting unique rollNo
        // through static variable(counter)
        static int setRollNo()
        {
            counter++;
            return counter;
        }
    
        // static method
        static void setCllg(String name) { cllgName = name; }
    
        // instance method
        void getStudentInfo()
        {
            System.out.println("name : " + this.name);
            System.out.println("rollNo : " + this.rollNo);
    
            // accessing static variable
            System.out.println("cllgName : " + cllgName);
        }
    }
    
    // Driver class
    public class StaticDemo {
        public static void main(String[] args)
        {
            // calling static method
            // without instantiating Student class
            Student.setCllg("XYZ");
    
            Student s1 = new Student("Geek1");
            Student s2 = new Student("Geek2");
    
            s1.getStudentInfo();
            s2.getStudentInfo();
        }
    }

# Static classes:
    =>
    A class can be made static only if it is a nested class, we cannot declare a top-level class with a static modifier but can declare nested classes as static.

    // A java program to demonstrate use
    // of static keyword with Classes
    import java.io.*;
    
    public class Geeks {
    
        private static String str = "GeeksforGeeks";
    
        // Static class
        static class MyNestedClass {
          
            // non-static method
            public void disp(){ 
              System.out.println(str); 
            }
        }
      
        public static void main(String args[])
        {
            Geeks.MyNestedClass obj
                = new Geeks.MyNestedClass();
            obj.disp();
        }
    }

# Static variables are shared across all instances of a class, while instance variables are unique to each object.
    =>
    public class Geeks {
    public static int count = 0;
    public int id;

    public Geeks() {
        count++;
        id = count;
    }

    public static void printCount() {
        System.out.println("Number of instances: " + count);
    }

    public void printId() {
        System.out.println("Instance ID: " + id);
    }

    public static void main(String[] args) {
        Geeks g1 = new Geeks();
        Geeks g2 = new Geeks();
        Geeks g3 = new Geeks();

        g1.printId();
        g2.printId();
        g3.printId();

        Geeks.printCount();
    }
    }


# Static vs Non-Static
    =>
    Static members have one copy shared across the class.
    
    Non-static members have a separate copy for each instance of the class.
    
    Static members are accessed via the class name.
    
    Non-static members are accessed via an object reference.
    
    Static members cannot be overridden.
    
    Non-static members can be overridden in subclasses.
    
    Static members cannot use this or super keyword.
    
    Non-static members can use this and super keyword.
    
    Static members exist for the duration of the class's lifecycle.
    
    Non-static members exist as long as the object they belong to is alive.
    
    Advantages of Static Keyword
    Static members use the memory only once and this helps save memory when we have to deal with big programs.
    Static members provide fast access because static members belong to the class not to an object and that's why they can be access faster than regular member.
    We can access static members from anywhere, whether an object of the class has been created or not.
    We can use static final variables to create constant that stays the same throughout the program.
    Disadvantages of Static Keyword
    Static members can't be overridden or dynamically bound like instance members.
    Static methods and variables make unit testing difficult due to tight coupling.
    Static variables create a global state, which can lead to unwanted side effects across different parts of the program.
    Static variables stay in memory as long as the program runs, which might cause memory to be used longer than needed.
    Using too many static members can reduce the benefits of object-oriented programming, like hiding data and using inheritance.
