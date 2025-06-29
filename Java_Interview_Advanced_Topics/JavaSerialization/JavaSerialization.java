package Java_Interview_Advanced_Topics.JavaSerialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization: it's a mechanism where an object can be represented as a sequence of bytes that includes all the information of object.
 *
 * ## Methods for serializing and deserializing an object.
 * Classes ObjectInputStream and ObjectOutputStream are high-level streams that contains the methods for serializing and deserializing an object.
 *
 * ## Note: A class can be serialized successfully, if 2 conditions are met.
 * 1. class must implement the java.io.Serializable interface.
 * 2. All the fields in the class must be serializable, if a field is not serializable, it must be marked as transient.
 *
 */

class Employee implements Serializable{
    private static final long serialVersionUID=1L;
    public String name;
    public String homeAddress;
    public transient int SSN;
    public void mailCheck(){
        System.out.println("Mailing a check to: "+name+" "+homeAddress);
    }
}
public class JavaSerialization {
    public static void main(String[] args){
        Employee e=new Employee();
        e.name="Ankush";
        e.homeAddress="NH-35";
        e.SSN=1202022;

        try{
            FileOutputStream fileOut=new FileOutputStream("serialize.ser");
            ObjectOutputStream out=new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}

