## All information about polymorphism.

## Method Overloading:
    => 
    It means same method name but differnet parameter.

## Polymorphism: Many Form.
    =>
    #  Types of Polymorphism:
    1. Compile Time also known as static polymorphism. (Achieved through method overloadding, method resolution happens at compile time).
    ## Example: 
    class A{
      pubilc int add(int a, int b){
          return a+b;
      }

      public double add(double a, double b){
          return a+b;
      }
    }

    2. Run-time Polymorphism: Also know as Dynamic Polymorphism (Achieved through method overriding, method resolution happens at runtime.
    =>
    class Animal{
      void sound(){
        System.out.println("Animal makes a sound");
      }
    }
    class Dog extends Animal{
      void sound(){
        System.out.println("Dog bark");
      }
    }
    public class Test{
      public static void main(String[] args){
        Animal d= new Dog();        //polymorphic reference...
        d.sound();
      }
    }
