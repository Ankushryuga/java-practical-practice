
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTaskWithExceptionHandling{
    public static void main(String[] args) {
        ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
        //Schedule a task to run after 2 seconds delay.
        scheduler.schedule(()->{
            System.out.println("Task runs after 2 seconds delay");
        }, 2, TimeUnit.SECONDS);

        //Schedule a repeating task every 3 seconds, starting after 1 seoncds.
        scheduler.scheduleAtFixedRate(()->{
            try {
                System.out.println("Repeating task running at " + System.currentTimeMillis());
                if(Math.random()>0.7){
                    throw new RuntimeException("Random failure");
                }
            } catch (Exception e) {
                System.out.println("Exception caught in scheduled task: "+ e.getMessage());
            }
        }, 1, 3, TimeUnit.SECONDS);

        //shutdown scheduler after 15 seconds.
        scheduler.schedule(()->{
            System.out.println("shutting down scheduler");
            scheduler.shutdown();
        }, 15, TimeUnit.SECONDS);
    }
}

/**
 * Explanation:
 * 1. schedule(Runnable, delay, TimeUnit)   ->  runs once after a delay.
 * 2. scheduleAtFixedRate(Runnable, initialDelay, period, TimeUnit) -   runs repeatedly every period seconds.
 * 3. Exception handling iniside the task is important b/c if an exception escapes the task, the scheduled repeating task will be canceled.
 * 4. We scheule a final task to shut down the scheduler gracefully after 15 seconds.
 */