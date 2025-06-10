/**
 * 1. Callable: Its a functional interface that represents a taks that can be executed by a thread and returns a result.
 *      => Key Features of Callable: Its similar to Runnable, but unlike Runnable, it can return a result and throw checked excptions. The call() method is used instead of run().
 *         
 * 2. Future: Its an interface that represents the result of an asynchronous compution. It provides methods to check if the computation is complete, retrieve the result, or cancel the task.
 *      => Key Features of Future: 
 *         1. get() method is used to retrieve the result of the computation, it blocks untill the result is available.
 *         2. isDone() method is used to checks if the task is completed.
 *         3. cancel() method attempts to cancel the execution of the task.
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture{
    public static void main(String[] args) throws Exception{
        ExecutorService executor=Executors.newSingleThreadExecutor();
        Callable<Integer> task=()->{
            Thread.sleep(1000);
            return 42;
        };
        Future<Integer> future=executor.submit(task);

        System.out.println("Doing something");
        Integer result=future.get();
        System.out.println("Result: "+ result);
        executor.shutdown();
    }   
}