public class ExceptionPropagation{
    public static void method1(){
        int data=50/0;
    }
    public static void method2(){
        method1(); //method1 exception propagates here
    }
    public static void main(String[] args) {
        try {
            method2();  //method2 exception propagates here
        } catch (Exception e) {
        }
    }
}
