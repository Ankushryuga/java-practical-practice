package Java_Interview_Advanced_Topics;

/**
 * Introduced in java 8.
 *
 * Lambda expression works on the principle of functional interface. A functional interface is an
 * interface with only 1 method to implement.
 *
 * # A lambda expression provides implementation of the functional interface method.
 *
 * ## Syntax:
 * parameter -> expression body.
 *
 * ## Scope of java lambda expression:
 *  => you can refer to any final variable or effectively final variable(which is assigned only once)
 */


public class Javalambda {
    public static void main(String[] args){
        Javalambda lm=new Javalambda();

        MathOperation add=(int a, int b)->a+b;
        MathOperation sub=(int a, int b)->{
            if(a>=b){
                return a-b;
            }
            return b-a;
        };
        MathOperation mul=(int a, int b)->a*b;
        MathOperation div=(int a, int b)->{
            try{
                return a/b;
            }catch(ArithmeticException e){
                System.out.println(e.getMessage());
                return 0;
            }
        };

        System.out.println("10+5"+lm.operate(10, 5, add));
        System.out.println("10-5"+lm.operate(10, 5, sub));
        System.out.println("10*5"+lm.operate(10, 5, mul));
        System.out.println("10/5"+lm.operate(10, 5, div));

//        StringToIntConversion st1=(message)->Integer.parseInt(message);
        StringToIntConversion st2=Integer::parseInt;
    }


    interface MathOperation{
        int someOperation(int a, int b);
    }
    interface StringToIntConversion{
        int stringToIntegerConversion(String value);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.someOperation(a,b);
    }
}
