/**
 * Thread Lifecycle: A thread can be in these state:
 * 
 * State                Description
 * 
 * New                  Created but not started.
 * Runnable             Ready to run or running.
 * Blocked              Waiting to acquire a monitor lock
 * Waiting              Waiting indefinitely
 * Timed_waiting        Waiting for a time (e.g., sleep())
 * Terminated           Execution complete
 */



 ///Example Multiple Threads.

 public class ThreadLifeCycle{
    public static void main(String[] args) {
        Runnable task=()->{
            System.out.println("Thread: "+ Thread.currentThread().getName()+" is running");
        };
        for(int i=0;i<10;i++){
            new Thread(task).start();
        }
    }
}