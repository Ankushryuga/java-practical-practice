
import java.util.concurrent.CountDownLatch;


// it allows one or more threads to wait unitl a set of operations in other threads completes.
public class CountDownLatchExample{
    public static void main(String[] ags) throws InterruptedException{
        CountDownLatch latch=new CountDownLatch(3);
        Runnable worker=()->{
            System.out.println("Working");
            latch.countDown();
        };
        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();


        latch.await();  //wait for all 3 to finish.
        System.out.println("All workers finished");
    }
}