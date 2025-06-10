
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: its a flexible and powerful locking mechanism compared to the traditional synchronized
 * it allows explicit locking and unlocking, offering advanced features like fairness policies, interruptible locks
 * and the ability to try locking with a timeout.
 * 
 */

/**
 * Key Features:
 * 1. Reentrancy: A thread can acquire the lock it already holds without causing a deadlock.
 * 2. Fairness: You can create a fair lock by passing true to the constructor, ensuring threads acquire
 * the lock in the order they requested it.
 * 3. Interruptible Locking: Thread can be interrupted while waiting for the lock.
 * 4. Try Locking: You can attempt to acquire the lock without blocking indefinitely.
 * 5. Condition Variables: It provides Condition objects for finer-grained thread communication.
 */

 // ReentrantLock: It gives more control than synchronized, with try-locking, fairness etc.

 public class ReentrantLockExample{
   private final ReentrantLock lock=new ReentrantLock();
   private int counter=0;
   public void increment(){
      lock.lock();
      try{
         counter++;
      }finally{
         lock.unlock();
      }
   }
    public static void main(String[] args) {

    }
 }