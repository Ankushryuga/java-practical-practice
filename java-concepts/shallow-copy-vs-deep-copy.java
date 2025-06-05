/**
Example of shallow copy vs deep copy
We will be using Cloneable interface which is of Marker interface type 
*/

/**
Cloneable Interface:
The cloneable interface in java is a marker interface. This means it doesn't contain any methods but serves 
as a signal to JRE that the class allows for field-for-field copying of instances.

When a class implements Cloneable,  it indicates that it supports the creation of copy through the clone() method.


## Implementing cloning:
1. Implement the cloneable interface in your class.
2. Override the clone() method from object class.
3. call super.clone() inside the clone() method.
*/


/**
  ## SHALLOW COPY:  a shallow copy of an object copies all the member fields, but it does not copy objects that the fields refere to.
  Instead the references to these objects are copied, meaning both the original and the copied object refere to the same objects.


  ## In java, the clone() method creates a shallow copy by default.
**/
class Addresss{
  String city;
  Address(String city){
    this.city=city;
  }
}
public class ShallowCopy implements Cloneable{
  String name;
  int age;
  Address address;
  Person(String name, int age, Address address){
    this.name=name;
    this.age=age;
    this.address=address;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException{
    return super.clone();
  }
  @Override
  public String toString(){
    return "Person {name='"+name+"'+, age="+age+", address="+address.city+"}";
  }

  public static void main(String[] args){
    try{
      Address address=new Address("New york");
      ShallowCopy original=new ShallowCopy("Alice", 30, address);
      ShallowCopy cloned=(ShallowCopy) origina.clone();  //shallow copy..

      System.out.println("Original"+original);
      System.out.println("cloned"+cloned);

      cloned.address.city="Los caligo";
      System.out.println("After modifying cloned object");
      System.out.println("Original"+original);
      System.out.println("CLoned"+cloned_;
    }catch(CloneNotSupportedException e){
      e.printStackTrace();
    }
  }

  /**
  Original: Person{name='Alice', age=30, address=New York}
Cloned: Person{name='Alice', age=30, address=New York}
After modifying cloned object:
Original: Person{name='Alice', age=30, address=Los Angeles}
Cloned: Person{name='Alice', age=30, address=Los Angeles}
  */
}



/*
Deep copy, it duplicates everything directly or indirectly referenced by the fields in the original object.
THis means the cloned object does not share references with the original object: it create a complete independent copy.
*/

class Address implements Cloneable{
  String city;
  Address(String city){
    this.city=city;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException{
    return super.clone();
  }
}

public class DeepCopy implements Cloneable {
  String name;
  int age;
  Address address;
  DeepCopy(String name, int age, Address address){
    this.name=name;
    this.age=age;
    this.address=address;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException{
    DeepCopy cloned=(DeepCopy) super.clone();
    cloned.address=(Address) address.clone();  //deep copy of address.
    return cloned;
  }

  @Override
  public String toString(){
    return "Person{name='"+name+"', age="+age+", address="+address.city+"}";
  }

  public static void main(String[] args){
    try{
      Address address=new Address("New York");
      DeepCopy original=new DeepCopy("Alice", 30, address);
      DeepCopy cloned=(DeepCopy) original.clone();

      System.out.println("Original: "+original);
      System.out.println("Cloned: "+cloned);
      cloned.address.city="Los Angeles";
      System.out.println("After modifying cloned object");
      System.out.println("Original"+original);
      System.out.println("Cloned"+cloned);
    }catch(CloneNotSupportedException e){
      e.printStackTrace();
  }
}






