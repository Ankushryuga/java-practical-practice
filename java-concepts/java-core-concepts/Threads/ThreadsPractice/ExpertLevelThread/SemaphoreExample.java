
import java.util.concurrent.Semaphore;

public class SemaphoreExample{
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);   //max 3 threads.
        Runnable task=()->{
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" acquired permit");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                
            } finally{
                System.out.println(Thread.currentThread().getName()+" releasing permits");
                semaphore.release();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();   
        }
    }
}