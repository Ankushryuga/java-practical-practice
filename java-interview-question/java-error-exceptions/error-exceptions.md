# Java Error and Exceptions questions

# Java Error and Exceptions questions

# Type of Exception:

    =>
    1. Checked:     A checked exception is an exception that is checked by the compiler at compilation-time, these are also called as compile time exceptions. These exceptions cannot be ignored.

    2. Unchecked:   An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions,

    3. Errors: these are not exceptions but it way worse then exceptions, but these are typically ignored in your code.

# Exception Hierarchy:

    =>
    All exception classes are subtypes of the java.lang.Exception class.
    The Exception class, is a subclas of the Throwable class.

    java.lang->Object->Throwable -> Exception:-> Runtime Exceptions, Other Exceptions.
    -> Exception:-> Errors

https://www.tutorialspoint.com/java/images/exceptions1.jpg

# In Java, what are the differences between a Checked and Unchecked?

    =>
    1. Checked Exceptions: Exceptions that are checked at compile time, the compiler forces you to handle them try-catch or throws.

    2. Unchecked Exception: Exceptions that are not checked at compile time, they occur during runtime and typically due to programming bugs.

## Example:

    =>
    Checked Exceptions: IOException, SQLException, FileNotFoundExceptions, ParseException.

    Unchecked Exceptions: NullPointerExceptions, ArrayIndexOutOfBoundsException, ArithmeticException, IllegalArgumentException.

# How to handle Runtime(unchecked) exceptions?

    => unchecked exception are not required to be caught or declared, but you can still handle them gracefully using:
    1. try-catch
    2. validate inputs to avoid runtime exceptions
    3. catch general exception or RuntimeException.
    4. use finally block for cleanup.

    # Example:
    public class Example{
        public static void main(String[] args){
            try{
                int[] arr=new int[3];
                System.out.println(arr[4]);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid array access" +e.getMessage());
            }
        }
    }

# Can we create a finally block without creating a catch block?

    => yes

# Can we create a finally block without creating a try-catch block?

    => no

# Can we re-throw an Exception in Java?

    => Yes, by using throw keyword.
    # Example:
    public void process() throws Exception{
        try{
            throw new Exception("Original Exceptions");
        }catch(Exception e){
            throw e;
        }
    }

# What is the difference between throw and throws in Java?

    =>
    # throw: used to actually throw an exception.
    purpose: used iniside a method to throw an exception instance.
    # Example:
    throw new IllegalArgumentException("Invalid age");

    # throws: used to declare that a method may throw exceptions.
    purpose: Used in a method signature to declare that the method may throw one or more exceptions.
    # Example:
    public void readFile() throws IOException, SQLException{

    }

# What is the concept of Exception Propagation?

    =>
    Exception propagation: when an exception occurs in a method and is not caught there, it is passed (propagated) up the call stack to the caller method.
    If the caller also doesn't handle it, the exception continues to propagate up untill:
    1. It is caught by some method in the call stack.
    2. It reaches the JVM, which then terminates the program and prints the exception stack trace.

# 🔍 How Exception Propagation Works

    =>
    Exception occurs in a method.
    If no try-catch in that method to handle it, the method terminates.
    The exception is thrown back to the caller method.
    The caller method tries to handle it (or passes it further up).
    This continues until exception is handled or program terminates.

# When we override a method in a Child class, can we throw an additional Exception that is not thrown by the Parent class method?

    => No,
    # Rule for exception handling in method overriding:
    Same Exception: Child class can throw
    subclass of parents exception: allowed.

    subclasss or new checked exception: no.
