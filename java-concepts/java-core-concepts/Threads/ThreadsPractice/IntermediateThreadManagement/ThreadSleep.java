//Thread.sleep() method is used to pause the execution of the current thread specified amount of time.

public class ThreadSleep{
    public static void main(String[] args) {
        System.err.println("Sleeping for 2 seconds");
        try{
        Thread.sleep(2000);     //this will throw "InterrupedException" exception.
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Woke up");
    }
}