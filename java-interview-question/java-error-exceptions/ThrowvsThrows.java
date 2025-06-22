public class ThrowvsThrows{
    public static void riskyMethod() throws ArithmeticException
    {
        int a=10/0;
    }
    public static void main(String[] args) {
        try {
            riskyMethod();
        } catch (ArithmeticException e) {
            throw new RuntimeException("wrapped exception", e);
        }
    }
}
