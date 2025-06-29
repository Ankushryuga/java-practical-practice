package Java_Interview_Advanced_Topics.RecordClass;

/**
 * record class: It designed to serve as a concise and efficient way to declare immutable data-carrying classes. It significantly
 * reduces the boilerplate code traditionally required for POJOs.
 *
 * ## key characteristics and features of java records:
 * 1. Immutability: All fields declared in a record are implicitly private final, ensuring that the state of a record object cannot be modified
 * after its creation.
 *
 *
 *
 * ## Java Record for Sealed Interfaces:
 * As records are final by default and can extend interfaces, we can define sealed interface and let records implement them for better code management.
 */
//record class::
sealed interface Person permits Employee, Manager{
    int id();
    String name();
}
record Employee(int id, String name) implements Person{}
record Manager(int id, String name) implements Person{}

public class RecordClass {
    public static void main(String[] args) {
        Person employee = new Employee(23, "Roberto");
        System.out.println(employee.id());
        System.out.println(employee.name());
    }
}
