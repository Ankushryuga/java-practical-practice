// its a classic concurrency problem:
/**
  Producer: generates data and adds it to a shared buffer (e.g, queue, list), must wait if the buffer is full.

  Consumer: Takes data from the buffer to process it, must wait if the buffer is empty.
  🧠 The Problem
How do you safely coordinate producers and consumers so that:

The producer doesn’t add data when the buffer is full.
The consumer doesn’t try to remove data when the buffer is empty.
Both operate without corrupting shared data (i.e., thread safety).
💡 Why Is This Important?
It teaches key concepts in:

Thread synchronization
Mutual exclusion
Inter-thread communication (wait, notify, notifyAll

🧰 Tools Used to Solve It in Java:
synchronized blocks/methods
wait() and notify() / notifyAll()
ReentrantLock and Condition (more advanced)
BlockingQueue (simplest, high-level approach)
*/

class SharedBufferNotify{
  private final List<Integer> buffer=new ArrayList<>();
  private final int capacity=5;

  public synchronized void produce(int value) throws InterruptedException{
    while(buffer.size()==capacity){
      wait();  //wait untill there's space.
    }
    buffer.add(value);
    System.out.println("Produced:" + value);
    notify();  //wake one consumer.
  }
  public synchronized void consume() throws InterruptedException{
    while(buffer.isEmpty()){
      wait();  //wait untill there's something to consume.
    }
    int value=buffer.remove(0);
    System.out.println("Consumed:"+value);
    notify();//wake one producer.
  }
}


class SharedBufferNotifyAll {
    private final List<Integer> buffer = new ArrayList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // wake all waiting threads (maybe more than one consumer)
    }

    public synchronized void consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        int value = buffer.remove(0);
        System.out.println("Consumed: " + value);
        notifyAll(); // wake all waiting threads (maybe more than one producer)
    }
}


public class ProducerConsumer{
  public static void main(String[] args){
    SharedBufferNotify buffer=new SharedBufferNotify();
    Runnable producer=()->{
      try{
        for(int i=0;i<10;i++){
          buffer.produce(i);
          Thread.sleep(100);
        }
      }catch(InterruptedException e){
        Thread.currentThread().interrupt();
      }
    };
    Runnable consumer=() ->{
      try{
        for(int i=0;i<10;i++){
          buffer.consume();
          Thread.sleep(150);
        }
      }catch(InterruptedException e){
        Thread.currentThread().interrupt();
      }
    };
    new Threead(producer).start();
    new Threead(consumer).start();
    new Threead(consumer).start();  // Second consumer to test notifyAll
  }
}
