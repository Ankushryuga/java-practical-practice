/**
 * Sytanx:
 * synchronized(objectidentifier){
 * // Access shared variables and other shared resources.
 * }
 * the objectidentifer is a reference to an object whose lock associaets with the monitor 
 * that the synchronized statement represents.
 */

class ThreadOne{
    public void printCount(){
        try{
            for(int i=5;i>0;i--){
                Thread.sleep(50);
                System.out.println("Counter --> "+i);
            }
        }catch(Exception e){
            System.out.println("Thread Interrupted");
        }
    }
}
class ThreadTwo extends Thread{
    private Thread t;
    private String threadName;
    ThreadOne one;
    ThreadTwo(String name, ThreadOne one){
        threadName=name;
        this.one=one;
    } 
    public void run(){
        synchronized(one){
            one.printCount();
        }
        System.out.println("Thread: "+ threadName+" existing. ");
    }

    public void start(){
        System.out.println("Starting "+threadName);
        if(t==null){
            t=new Thread(this, threadName);
            t.start();
        }
    }
}

public class BlockSynchronization{
    public static void main(String[] args){
        ThreadOne one=new ThreadOne();
        ThreadTwo t1=new ThreadTwo("Thread - 1", one);
        ThreadTwo t2=new ThreadTwo("Thread - 2", one);
        t1.start();
        t2.start();

        //wait for threads to end
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            System.out.println("Interruped");
        }
    }
}