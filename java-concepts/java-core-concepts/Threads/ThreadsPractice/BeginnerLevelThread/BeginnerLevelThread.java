/**
 * [Beginner] Basics of Threads.
 * 1. What is thread?
 * 2. Creating threads: Runnable and Thread.
 * 3. Thread lifecycle and state.
 */

    
/**
* Thread: Its a smallest unit of execution in a program, by default, java programs run in a single thread: the main thread. Threads allow you to perform multiple tasks concurrently.
*/

//Creating threads by Runnable interface.
//
public class BeginnerLevelThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Runnable thread is running");
    }
    public static void main(String[] args) {
        Thread thread=new Thread(new BeginnerLevelThread());
        thread.start();
        System.out.println("Main thread is running..");
    }
}

// //Creating threads by extending Thread class.
// public class MyThread extends Thread{
//     @Override
//     public void run(){
//         System.err.println("Thread is running");
//     }
//     public static void main(String[] args) {
//         MyThread thread=new MyThread();
//         thread.start();
//     }
// }