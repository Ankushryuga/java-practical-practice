

/**
 * The synchronized keyword in java is used to control access to critical sections of code or shared
 * resources in a multithreaded environment. It ensures that only one thread can execute a block of code or a method at a time,
 * preventing race conditions and maintaining thread safety.
 */
/**
 * Synchronized Methods:
 * When a method is declared as synchronized, the thread must acquire the intrinsic lock(monitor) of the
 * object before executing the method, once the thread finishes, the lock is released.
 * 
 */

 public class Synchronization{
    int count=0;
    public synchronized  void increment(){
        count++;
    }
    public static void main(String[] args) {
        Synchronization counter=new Synchronization();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                counter.increment();
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        System.out.println("Count:"+counter.count);
    }
 }