
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecution{
    public static void main(String[] args) {
        ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
        Runnable task=()->System.out.println("Running at: "+ System.currentTimeMillis());
        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);// delay 1s, repeat every 2s.
    }
}