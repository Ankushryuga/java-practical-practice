
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample{
    public static void main(String[] args){
        ExecutorService executor=Executors.newFixedThreadPool(2);
        Runnable task=()->{
            System.out.println("Task executed by: "+ Thread.currentThread().getName());
        };

        executor.execute(task); //fire and forget.
        Future<String> future=executor.submit(()->{
            return "Task Result";
        });

        try{
            System.out.print("Result: "+future.get());
        }catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        executor.shutdown();
    }
}


/**
 * Summary:
 * 1. ExecutorService: simplifies concurrent task execution.
 * 2. It abstract thread management and improves scalability.
 * 3. Supports both Runnable and Callable tasks.
 * 4. Returns Future for result tracking and cancellation.
 * 
 */