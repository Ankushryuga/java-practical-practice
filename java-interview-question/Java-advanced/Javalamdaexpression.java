
/**
 * Lambda expression: lambda expressions work on princile of functional interface,
 * A functional interface is an interface with only one method. A lambda expression provides an implementation of the functional interface method.
 * 
 * 
 * ### Syntax:
 * parameter -> expression body
 */

public class Javalamdaexpression{
    public static void main(String[] args){
        Javalamdaexpression test=new Javalamdaexpression();

        //with type declaration:
        MathOperation addition=(int a, int b)-> a+b;

        //with out type declaration:
        MathOperation sub=(a,b)-> a-b;

        //with return statement along with curly braces:
        MathOperation mult=(int a, int b)->{return a*b;};

        //division:
        MathOperation div=(int a, int b)-> a/b;

        System.out.println("10+5 = "+test.operate(10,5, addition));
        System.out.println("10-5 = "+test.operate(10,5, sub));
        System.out.println("10*5 = "+test.operate(10,5, mult));
        System.out.println("10/5 = "+test.operate(10,5, div));


        //without parenthesis:
        GreetingService greetingService1=message->System.out.println("Hello "+message);
        GreetingService greetingService2=message->System.out.println("Hello "+message);
        
        greetingService1.sayMessage("Hello Greetings 1");
        greetingService2.sayMessage("Hello Greetings 2");
    }
        interface MathOperation{
            int operation(int a, int b);
        }
        interface GreetingService{
            void sayMessage(String message);
        }
        
        private int operate(int a, int b, MathOperation operation){
            return MathOperation.operation(a, b);
        }
}