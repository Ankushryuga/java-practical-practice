# Interface vs Abstract:
    =>
| Feature                    | Interface                            | Abstract Class                     |
| -------------------------- | ------------------------------------ | ---------------------------------- |
| Inheritance                | Multiple (implements)                | Single (extends only one class)    |
| Constructor                | ❌ No constructors                    | ✅ Can have constructors            |
| Fields                     | Only `public static final`           | Can have instance variables        |
| Access Modifiers (methods) | Only public/abstract/default         | Can use `private/protected/public` |
| Implementation             | Only `default/static` (since Java 8) | Partial/full allowed               |

# instance variable:
    =>
    A variable declared within a class but outside of any method, constructor, or block. Each object(instance) of that class get its
    own unique copy of these variables.

# From Java 9 interfaces can have private as well as private static methods in interfaces.
