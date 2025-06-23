import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public final class EmployeeExample{
  private final int id;
  private final String name;
  private final List<String> address;

  public ImmutableClassExample(int id, String name, List<String> address){
    this.id=id;
    this.name=name;
    this.address=address;
  }
  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public List<String> getAddress(){
    return address;
}
public class ImmutableClassExample{
  public static void main(String[] args){
    List<String> address=Arrays.asList("New Yourk", "Dubai");
    EmployeeExample ee=new EmployeeExample(1, "John doe", addressList);
    System.out.println("Id: "+ ee.getId());
    System.out.println("Name: "+ ee.getName());
    System.out.println("Address: "+ ee.getAddress());

    ee.getAddress().add("Los");  //exception.
  }
}
