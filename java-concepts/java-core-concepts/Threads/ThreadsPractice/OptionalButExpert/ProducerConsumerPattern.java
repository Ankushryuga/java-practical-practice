
import java.util.LinkedList;
import java.util.Queue;

// one of the most important pattern in multithreading.

public class ProducerConsumerPattern{
    private final Queue<Integer> queue=new LinkedList<>();
    private final int CAPACITY=5;
    
    public void produce() throws InterruptedException{
        int value=0;
        while (true) { 
            synchronized (this) {
                while(queue.size()==CAPACITY){
                    wait(); //wait for space.
                }
                queue.add(value++);
                System.out.println("Produced: " + value);
                notify();   //notify consumer.
                Thread.sleep(500);
            }   
        }
    }

    public void consumer() throws InterruptedException{
        while (true) { 
            synchronized (this) {
                while(queue.isEmpty()){
                    wait();
                }
                int value=queue.poll();
                System.out.println("Consumed: "+ value);
                notify();
                Thread.sleep(1000);
            }
        }
    }
    public static void main(String[] args) {
        ProducerConsumerPattern pod=new ProducerConsumerPattern();
        new Thread(()->{
            try {
                pod.produce();
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(()->{
            try {
                pod.consumer();
            } catch (InterruptedException e) {
            }
        }).start();
    }
}