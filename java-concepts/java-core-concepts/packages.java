/**

Packages in Java serve as a container for organizing classes, interfaces, and sub-packages with similar functionalities. These packages fall into two categories: built-in packages and user-defined packages. 

Advantage of Java Package:
1. Structured Organization: Packages categorize classes and interfaces, facilitating easy maintenance.
2. Access Protection: Packages in Java provide access control mechanisms, ensuring encapsulation and security.
3. Name Collision Prevention: Packages in Java help prevent naming conflicts, ensuring clarity and avoiding ambiguity in code.
# How Do Packages Work?
1. Packages in java organize classes, interfaces, and sub-packages, mirroring directory structures.
2. For instance, package "college.staff.cse" translates to directories "college", "staff", and "cse".
3. Access to directories is facilitated via the CLASSPATH variable, ensuring easy class location.
4. Package naming convention follows reverse domain notation, e.g., "org.geeksforgeeks.practice".
5. To add classes, specify the package name at the file's beginning and save it in the corresponding directory.
6. Sub-packages, like "java.util", require explicit import and lack default access privileges.
7. Sub-package members are treated separately, necessitating explicit import for access.
*/


// Save as Rectangle.java inside the "geometry" directory
package geometry;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}


// Importing the Scanner class from the java.util package
import java.util.Scanner;

// Importing all classes from the java.util package
import java.util.*;

// Importing all classes and interfaces from a specific package
import mypackage.*;

// Importing only a specific class from a package
import mypackage.MyClass;

// Using fully qualified names to avoid naming conflicts
import java.util.ArrayList;
import mypackage.ArrayList;







Types of Packages in Java
Packages in Java can be categorised into 2 categories.

Built-in / predefined packages
User-defined packages.





#  Using Static Import
#  Static import is a feature in Java (introduced in versions 5 and above) that enables the usage of static members (fields and methods) from a class without explicitly specifying the class name. Here's an example demonstrating static import:


