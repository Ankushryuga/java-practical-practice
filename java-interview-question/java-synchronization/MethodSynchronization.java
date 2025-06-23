class ThreadOne extends Thread{
    public void printCount(){
        try{
            for(int i=5;i>0;i--){
                Thread.sleep(50);
                System.out.println("Counter -- "+ i);
            }
        }
        catch(Exception e){
            System.out.println("Thread "+Thread.currentThread().getName()+ " interruped");
        }
    }
    public synchronized void run(){
        printCount();
        System.out.println("Thread "+Thread.currentThread().getName()+ " existing");
    }
}
public class MethodSynchronization{
    public static void main(String[] args){
        ThreadOne one=new ThreadOne();
        Thread t1=new Thread(one);
        Thread t2=new Thread(one);
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