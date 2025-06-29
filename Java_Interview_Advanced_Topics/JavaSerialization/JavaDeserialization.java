package Java_Interview_Advanced_Topics.JavaSerialization;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class JavaDeserialization {

    public static void main(String [] args) {
        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.homeAddress);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.homeAddress);
    }
}
//class Employee implements java.io.Serializable {
//
//    private static final long serialVersionUID = 1L;
//    public String name;
//    public String address;
//    public transient int SSN;
//    public int number;
//
//    public void mailCheck() {
//        System.out.println("Mailing a check to " + name + " " + address);
//    }
//}