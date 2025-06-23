/**
 * A thread can send an interrupt signal to JVM to interrupt by invoking interrupt on the Thread object for the thread to be interruped, 
 * This means interruption of a thread is caused by any other thread calling the interrupt() method.
 * 
 */

public class InterruptingThread {
   public static void main(String[] args) {
      System.out.println("Thread main started");
      final Task task = new Task();
      final Thread thread = new Thread(task);
      thread.start();
      thread.interrupt(); // calling interrupt() method
      System.out.println("Main Thread finished");
   }
}
class Task implements Runnable {
   @Override
   public void run() {
      for (int i = 0; i < 5; i++) {
         System.out.println("[" + Thread.currentThread().getName() + "] Message " + i);
         if(Thread.interrupted()) {
            System.out.println("This thread was interruped by someone calling this Thread.interrupt()");
            System.out.println("Cancelling task running in thread " + Thread.currentThread().getName());
            System.out.println("After Thread.interrupted() call, JVM reset the interrupted value to: " + Thread.interrupted());
            break;
         }
      }
   }
}

package com.tutorialspoint;

public class TestThread {
   public static void main(String[] args) {
      System.out.println("Thread main started");
      final Task task1 = new Task();
      final Thread thread1 = new Thread(task1);
      final Task task2 = new Task();
      final Thread thread2 = new Thread(task2);
      final Task task3 = new Task();
      final Thread thread3 = new Thread(task3);
      thread1.start();
      thread2.start();
      thread3.start();
      thread1.interrupt(); // calling interrupt() method
      System.out.println("Main Thread finished");
   }
}
class Task implements Runnable {
   @Override
   public void run() {
      if(Thread.interrupted()) {
         System.out.println("[" + Thread.currentThread().getName() + "] Interrupted ");
      }else {
         System.out.println("[" + Thread.currentThread().getName() + "] Uninterrupted ");
      }
   }
}


package com.tutorialspoint;

public class TestThread {
   public static void main(String[] args) {
      System.out.println("Thread main started");
      final Task task = new Task();
      final Thread thread = new Thread(task);
      thread.start();
      thread.interrupt(); // calling interrupt() method
      System.out.println("Main Thread finished");
   }
}
class Task implements Runnable {
   @Override
   public void run() {
      for (int i = 0; i < 5; i++) {
         System.out.println("[" + Thread.currentThread().getName() + "] Message " + i);
         try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			System.out.println("This thread was interruped by someone calling this Thread.interrupt()");
		}        
      }
   }
}