/**
Java is a class-mandatory programming language that imposes an object model on the developer.
Class serve as a prototype for representing objects that group pieces of data and methods. An object is an entity
that has a state and behaviour.


## Properties of Java Classes
1. A Java class serves as a blueprint for creating objects and doesn't take up memory.
2. It comprises variables of various types and methods. You can include data members, methods, constructors, nested classes, and interfaces within a class.
3. It acts as a template for organizing and defining the behaviour of objects in your program.

## Syntax of Java Classes
One can declare a public, private, or default class as:

public class PublicClassName {
    // declaration section for 
    // methods and attributes
} 

private class PrivateClassName {
    // declaration section for 
    // methods and attributes
} 

class DefaultClassName {
    // declaration section for 
    // methods and attributes
} 
*/

class Car{
    // declaration of private attributes
    private String modelName;
    private String owner;
    private int regNumber;
    
    // declaration of public constructor
    public Car(String modelName, String owner, int regNumber){
        this.modelName = modelName;
        this.owner = owner;
        this.regNumber = regNumber;
    }
    
    // declaration of public methods
    public void startEngine(){
        System.out.println("Engine is starting ....");
    }
    
    public void accelerate(){
        System.out.println("Car is accelerting ...");
    }
    
    public void stop(){
        System.out.println("Car is stopping ...");
    }
    // prints car attributes
	public void showCarInformation(){
        System.out.println("The car is owned by: " + this.owner);
        System.out.println("Car Model: " + this.modelName);
       	System.out.println("Registration Number: " + String.valueOf(this.regNumber));
    }
}
/***
Components of Java Class:
The class name pertains to a namespace in which we can associate coherent methods and data

Class Keyword: it signifies that we intended to begin creating a prototype of an object.


Constructors
Java constructors initialize an instantiated object based on preconditions set by the caller. Constructors can be parameterized or specified without parameters.

A class may contain multiple constructors that configure an instantiated object accordingly. A constructor is a specialized method that must be defined with:

The same name as the class.
Does not return an explicit type.
Cannot be synchonized, abstract, static, and final.
*/
