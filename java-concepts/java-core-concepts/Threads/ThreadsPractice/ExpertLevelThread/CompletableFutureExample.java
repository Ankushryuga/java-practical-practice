
import java.util.concurrent.CompletableFuture;


//async programming

public class CompletableFutureExample{
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->{
            return "Hello";
        }).thenApply(result->result+" world").thenAccept(System.out::println);
    }
}