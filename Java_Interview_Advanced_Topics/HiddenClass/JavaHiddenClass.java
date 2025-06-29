package Java_Interview_Advanced_Topics.HiddenClass;

/**
 * hidden classes: java 15 has introduced hidden classes which cannot be used directly by other class bytecode.
 * These hidden classes are intended to be used by frameworks that generate classes at runtime and use them using reflection.
 *
 * ## Syntax: in order to create a hidden class, we must create a Lookup instance as shown below:
 * MethodHandles.Lookup lookup=MethodHandles.lookup();, once lookup instance is available, we can use defineHiddenClass() method to create
 * hidden class using bytearray of hidden class.
 *
 * Class<?> hiddenClass=lookup.defineHiddenClass(getByteArray(), true, ClassOption.NESTMATE).lookupClass();
 *
 * Bytearray of hidden class can be retrieved using classpath of the hidden class:
 * public static byte[] getByteArray() throws IOException{
 *
 * }
 */

import jdk.jshell.execution.Util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaHiddenClass {
    public static void main(String args[]) throws IllegalAccessException, IOException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        // create the lookup object
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        // define the hidden class using the byte array of Util class
        // Using NESTMATE option so that hidden class has access to
        // private members of classes in same nest
        Class<?> hiddenClass = lookup.defineHiddenClass(getByteArray(),
                true, ClassOption.NESTMATE).lookupClass();

        // get the hidden class object
        Object hiddenClassObj = hiddenClass.getConstructor().newInstance();

        // get the hidden class method
        Method method = hiddenClassObj.getClass().getDeclaredMethod("square", Integer.class);

        // call the method and get result
        Object result = method.invoke(hiddenClassObj, 3);

        // print the result
        System.out.println(result);

        // as hidden class is not visible to jvm, it will print hidden
        System.out.println(hiddenClass.isHidden());

        // canonical name is null thus this class cannot be instantiated using reflection
        System.out.println(hiddenClass.getCanonicalName());

    }
    public static byte[] getByteArray() throws IOException {
        InputStream stream = Util.class.getClassLoader().getResourceAsStream("com/tutorialspoint/Util.class");
        byte[] bytes = stream.readAllBytes();
        return bytes;
    }
}