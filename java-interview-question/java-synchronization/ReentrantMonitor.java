/**
 * ReentrantLock: its a class that implements Lock Interface, it provides the synchronization feature with great flexibility 
 * which is why it is the most used Lock class in java.
 * 
 * It is necessary for the reliable and "fair working of thread", 
 * In ReentrantLock: threads are small sub-processes of a big operation.
 */

/**
 * Working of ReentrantLock:
 * => when multiple threads try to access a shared resource then, ReentrantLock restricts access to a single thread at a time through 
 * lock() and unlock() methods.
 * 
 * # Syntax:
 * 
 ReentrantLock nameOflock = new  ReentrantLock(); 
// by default false
Or,
ReentrantLock nameOflock = new  ReentrantLock(true); 
// we can make it true
 */

import java.util.concurrent.locks.ReentrantLock;

class Thrid{
    private static ReentrantLock reenlock=new ReentrantLock();
    static void operation(int data){
        boolean lockAcquired=reenlock.tryLock();
        if(lockAcquired){
            try{
                reenlock.lock();
                for(int i=0;i<=4;i++){
                    System.out.println(data++);
                }
            }catch(Exception e){

            }finally{
                reenlock.unlock();
            }
        }else{
            System.out.println("In else block");
        }
    }
}
class ThreadOne extends Thread{
    public void run(){
        Thrid.operation(1);
    }
}
class ThreadTwo extends Thread{
    public void run(){
        Thrid.operation(5);
    }
}

class ThreadThree extends Thread{
    public void run(){
        Thrid.operation(10);
    }
}


public class ReentrantLock{
    public static void main(String[] args){
        ThreadOne t1=new ThreadOne();
        ThreadTwo t2=new ThreadTwo();
        ThreadThree t3=new ThreadThree();

        t1.start();
        t2.start();
        t3.start();
    }
}



package com.tutorialspoint;

import java.util.concurrent.locks.ReentrantLock;

class Thrd {
   // creating object of ReentrantLock class
   private static ReentrantLock lockr = new  ReentrantLock(true);
   static void operation(int data) {
     // give access to lock
     boolean lockAcquired = lockr.tryLock(); 
     if (lockAcquired) {
       try {
         lockr.lock(); 
         // giving lock to thread
         for(int i = 1; i <= 4; i++) {
            System.out.println(data++);
         }
         // checking lock count
         System.out.println("Count of Lock: " + lockr.getHoldCount());
       } finally {
         lockr.unlock(); 
         // unlocking the lock 
       }
     } else {
       System.out.println("I am in else block");
     }
   }
}
class Thrd1 extends Thread {
   // thread number 1 
   public void run() {
     Thrd.operation(1);
     // method calling  
   }
}
class Thrd2 extends Thread {
   // thread number 2 
   public void run() {
     Thrd.operation(5);  
     // method calling
   }
}
class Thrd3 extends Thread {
   // thread number 3
   public void run() {
     Thrd.operation(10);  
     // method calling
   }
}
public class TestThread {
   public static void main(String args[]) {
     // creating object for thread class
     Thrd1 oprt1 = new Thrd1();
     Thrd2 oprt2 = new Thrd2();  
     Thrd3 oprt3 = new Thrd3();
     // Starting the thread operation
     oprt1.start();
     oprt2.start();  
     oprt3.start();
   }
}