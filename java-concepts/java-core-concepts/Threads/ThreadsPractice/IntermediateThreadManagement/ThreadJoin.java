/**
 * join() method is used to pause the execution of the current thread untill the thread on which join() is called has completed its execution.
 * 
 */

public class ThreadJoin{
    public static void main(String[] args) throws InterruptedException{
        Thread thread=new Thread(()->{
            System.err.println("Thread is running.. ");
        });

        thread.start();
        thread.join();      //wait for thread to finish. thread.join(1000) => wait for 1 second.
        System.err.println("Main thread resumes");
    }
}