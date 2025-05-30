/**
The Cloneable Interface: its a marker interface, this means it doesn't contains any methods but serves as a signnal to Java runtime that the class
allows for field-for-field copying of instances. When a class implements **Clonable**, it indicates that it supports the creation of a copy through 
the clone() method.
*/

/**
Implementing Clonning:
1. Implement the Cloneable interface in your class.
2. Override the clone() method from the Object class.
3. Call super.clone() inside the clone() method.
*/

class Person implements Cloneable{
  String name;
  int age;
  Person(String name, int age){
    this.name=name;
    this.age=age;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  @Override
  public String toString(){
    return "Person{name='" +name+"', age="+age+"}";
  }
  public static void main(String[] args){
    try{
      Person original=new Person("Alice", 30);
      Person cloned=(Person)original.clone();
      System.out.println("Original: "+ original);
      System.out.println("Cloned: "+ cloned);
    }catch(CloneNotSupportedException e){
      e.printStackTrace();
    }
  }
}



////// Shallow Copy:
/**
A shallow copy of an object copies all the member fields, but it does not copy objects that the fields refer to.
Instead, the references to these objects are copied, meaning both the original and copied object refer to the same objects.

In Java, the clone() method creates a shallow copy by default.
*/


// ### Example of Shallow Copy:
class Address{
  String city;
  Address(String city){
    this.city=city;
  }
}

class Person implements Cloneable{
  String name;
  int age;
  Address address;
  
  Person (String name, int age, Address address){
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
    return "Person{name='"+name+"', age="+age+", address="+address.city+"}";
  }

  public static void main(String[] args){
    try{
      Address address=new Address("New York");
      Person original=new Person("Alice", 30, address);
      Person cloned=(Person) original.clone();
      System.out.println("Original: "+original);
      System.out.println("Cloned: "+cloned);
      //modify the address 
      cloned.address.city="Los angeles";
      System.out.println("After Modifying cloned object:");
      System.out.println("Original: "+original);
      System.out.println("Cloned: "+cloned);
    }catch(CloneNotSupportedException e){
      e.printStackTrace();
    }
  }
}


///// Deep Copy:
/**
A deep copy, on the other hand, duplicates everything directly or indirectly referenced by the fields in the original object.
This means the cloned object does not share references with the original object; it creates a completely independent copy.
*/


// ## Exampl:
// To implement a deep copy, you need to clone each field that is an object;

class Address implements Cloneable{
  String city;
  Address (String city){
    this.city=city;
  }
  @Override
  protected Object clone() throws CloneNotSupportedException{
    return super.clone();
  }
}

class Person implements Cloneable{
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
    Person cloned=(Person) super.clone();
    cloned.address=(Address) address.clone();        //deep copy of address
    return cloned;
  }

  @Override
  public String toString(){
    return "Person{name='"+ name+"', age="+age+", address="+address.city+"}";
  }

  public static void main(String[] args){
    try{
      Address address=new Address("New York");
      Person original=new Person("Alice", 40, address);
      Person cloned=(Person) original.clone();
      System.out.println("Original: "+ original);
      System.out.println("Cloned: "+ cloned);
      cloned.address.city="Los Angeles";

      System.out.println("After modifying cloned object:");
      System.out.println("Original:"+original);
      System.out.println("Cloned:"+cloned);
    }catch(CloneNotSupportedException e){
      e.printStackTrace();
    }
  }
}




























