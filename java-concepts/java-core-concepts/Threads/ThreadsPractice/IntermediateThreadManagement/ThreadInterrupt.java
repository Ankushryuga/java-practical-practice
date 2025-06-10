/**
 * Interrupt(): this is used to signal a thread that it should stop what it is doing and do something else, However,
 * calling interrupt() does not forcibly stop the thread; it merely sets the thread's interrup status to true.
 * 
 * The thread itself must check for this status and handle it appropriately. 
 */

public class ThreadInterrupt{
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Working...");
            }
            System.out.println("Thread interruped");
        });
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
        } catch (InterruptedException e) {
        }
    }
}