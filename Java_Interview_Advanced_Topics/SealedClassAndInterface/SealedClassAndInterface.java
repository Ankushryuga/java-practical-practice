package Java_Interview_Advanced_Topics.SealedClassAndInterface;

/**
 * Sealed Class: A sealed class can define the subtypes that are permitted to extend
 * it while other classes cannot extend it.
 *
 * # Following are salient points to consider for a sealed class:
 * 1. A Sealed class is declared using a sealed keyword.
 * 2. Sealed classes allow to declaration of which class can be a subtype using the permits keywords.
 * 3. A class extending sealed clas must be declared as either sealed, non-sealed, or final.
 *
 */

/**
 * Sealed Interface: An interface can be marked as sealed interface using sealed keyword and then using permits keywords
 * we can the interfaces which can extend this interface.
 *
 * # syntax:
 * public sealed interface Person permits Employee, Manager{
 *
 * }
 */
//a sealed interface person which is to be inherited by Employee and Manager interface.
sealed interface Person permits Employee, Manager{
    String getName();
}
//Employee and manager interfaces have to extend person and can be sealed or non-sealed
non-sealed interface Employee extends  Person{
    int getEmployeeId();
}
non-sealed interface Manager extends Person{
    int getManagerId();
}

class CorpManager implements Manager{
    String name;
    int id;
    public CorpManager(int id, String name){
        this.id=id;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public int getManagerId(){
        return id;
    }
}

class CorpEmployee implements Employee{
    String name;
    int id;
    public CorpEmployee(int id, String name){
        this.id=id;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public int getEmployeeId(){
        return id;
    }
}
public class SealedClassAndInterface {
    public static int getId(Person person){
        if(person instanceof Employee){
            return ((Employee) person).getEmployeeId();
        }
        else if(person instanceof Manager){
            return ((Manager) person).getManagerId();
        }
        return -1;
    }
    public static void main(String[] args){
        Person manager=new CorpManager(23,"Roberto");
        System.out.println("Id: "+getId(manager));
    }
}
