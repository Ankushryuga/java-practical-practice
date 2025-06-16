/***
Copy Constructor:
  1. Initialize a new object as a copy of an existing object.
  2. Has one parameter, a reference to an object of the same class.

Parameterized Constructor:
  1. Initialize a new object with specific values provided as arguments.
  2. Can have multiple parameter of different types.
*/

class MyClass{
  int value;

  //parameterized constructor.
  public MyClass(int value){
    this.value=value;
  }
  //Copy constructor.
  public MyClass(MyClass other){
    this.value=other.value;
  }
}

public class Main{
  public static void main(String[] args){
    MyClass obj1=new MyClass(10);    //Parameterized constructor.
    MyClass obj2=new MyClass(obj1);  //Copy constructor.
  }
}
