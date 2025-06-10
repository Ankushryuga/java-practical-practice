
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService: Manually creating and managing threads becomes messy in large application:
 * 
 */

 //ExecutorService with Runnable:
 public class ExecutorServiceExample{
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        Runnable task=()->{
            System.out.println("Running in: "+ Thread.currentThread().getName());
        };
        executorService.submit(task);
        executorService.submit(task);

        executorService.shutdown();
    }
 }