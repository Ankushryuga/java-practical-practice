# Java 8 features:
    =>
    1. Lambda Expression: Concise functional code using ->
    2. Functional Interfaces: single-methods interfaces.
    3. Stream API: Efficient Data manipulation.
    4. Date/Time API: Robust Date and Time Handling.
    5. Collection API: enhanced methods for collections(removeIf, replaceAll).
    6. Concurrency API improvements: New classes for parallel processing (e.g, CompletableFeature).
    7. Optional Class: Handle null value safety.
    8. forEach() method:
    9. Default Methods: evolve interfaces without breaking compatibility.
    10. Static Methods: Allows adding methods with default implementations to interfaces.
    11. Method References: Refer to methods easily.



# Java 17 Features:
    =>
    1. Sealed classes:  Allows class designers to control which other classes or interfaces may extend or implement them, useful for defining restricted class hierarchies.
      public sealed class Shape permits Circle, Square {}
      final class Circle extends Shape{}
      final class Square extends Shape{}

    2. Pattern Matching: enhances the switch statement with pattern matching capabilities.
        Example:
        static String formatter(Object o){
          return switch(o){
            case Integer i  -> String.format("int %d", i);
            case Long l     -> String.format("long %d", l);
            case String s   -> String.format("String %s", s);
            default         -> o.toString();
          }
        }
     
    3. Strong Encapsulation
    4. Applets, RMI removed

# Java 21 Features:
    =>
    1. Virtual Threads: Lightweight, JVM-managed threads ideal for high-concurrency tasks like server-side apps.
      "Virutal threads will not improve your application latency but will improve your throughput a lot"
      Example:
        Thread.Builder builder = Thread.ofVirtual().name("GFG thread");
        Runnable task=()->{
          System.out.println("Running threads");
        };
        Thread t= builder.start(task);
        System.out.println("Thread t name: "+t.getName());
        Thread.sleep(1000);
        t.join();

    2. Record Pattern & Pattern Matching for Switch
    3. Sequenced Collections: Introduces SequencedCollection, SequencedSet, and SequencedMap interface/
    4. Generational:  Z Garbage collector now uses young/old heap regions, delivers low-latency with reduced heap size and higher throughput.
    etc.

    
