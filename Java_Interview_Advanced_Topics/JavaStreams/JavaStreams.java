package Java_Interview_Advanced_Topics.JavaStreams;

/**
 * Streams: it represents a sequence of objects from a source which support aggregate operations.
 * Generating Streams:
 * Introduced in java 8, Collection interface has 2 methods to generate a steam.
 * 1. stream()  -> it returns a sequential stream considering collection as its source.
 *      #example: List<String> names=Arrays.asList("john", "jane");
 *      names.stream().forEach(name->{
 *          System.out.println(Thread.currentThread().getName() + ":"+name);
 *      }
 *      );
 *
 *
 * 2. parallelStream() -> it returns a parallel stream considering collection as its source.
 *      => it used multiple threads from ForkJoinPool to process element in parallel.
 *      It improves performance for large data sets, especially on multi-core CPUs.
 *
 *      ## Example:
 *      List<String> name=Arrays.asList("john", "jane");
 *      name.parallelStream().forEach(name -> {
 *          System.out.println(Thread.currentThread.getName()+":"+name);
 *      }
 */
public class JavaStreams {

}

