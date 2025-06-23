/**
 * synchronization is a way to establish connection b/w multiple thread trying to access shared resources.
 * It is necessary for reliable thread interaction.
 * 
 * ## Static Synchronization:
 *  => It refers to synchronizing static methods using the synchronized keyword, 
 * this is used to control concurrent access to class-level resources, not instance-level ones.
 * 
 * ## NOTE:
 *  1. When you declare a static method as synchronized, the lock is on the Class object, not on any particular instance.
 *  2. This is useful when multiple threads need coordinated access to static/shared data.
 * 
 * # Syntax:
 * public class MyClass{
 *  public static synchronized void myStaticMethod(){}
 * }
 * //above syntax is equivalent to 
 * public class MyClass{
 *  public static void myStaticMethod(){
 *  synchronized(MyClass.class){
 * // critical code.
 * }
 * }
 * }  
 */
class ThreadOne{
    public static synchronized void printCount(){
        try{
            for(int i=5;i>0;i--){
                Thread.sleep(50);
                System.out.println("Counter --- "+i);
            }
        }catch(Exception e){
            System.out.println("Thread interrupted");
        }
    }
}
class ThreadDemo extends Thread{
    private Thread t;
    private String threadName;
    ThreadDemo(String name){
        threadName=name;
    }
    public void run(){
        ThreadOne.printCount();
        System.out.println("Thread "+ threadName +" existing.");
    }

    public void start(){
        System.out.println("Starting "+ threadName);
        if(t==null){
            t=new Thread(this, threadName);
            t.start();
        }
    }
}
public class StaticSynchronization{
    public static void main(String[] args){
        ThreadDemo t1=new ThreadDemo("Thread -1 ");
        ThreadDemo t2=new ThreadDemo("Thread -2 ");

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}