
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


//Parallel Taks, Efficient for divide-and-conquer style recursive tasks.

class SumTask extends RecursiveTask<Integer>{
    int[] arr;
    int start, end;

    SumTask(int[] arr, int start, int end){
        this.arr=arr;
        this.start=start;
        this.end=end;
    }
    
    @Override
    protected Integer compute(){
        if(end-start <= 3){
            int sum=0;
            for(int i=start;i<end;i++){
                sum+=arr[i];
            }
            return sum;
        }else{
            int mid=(start+end)/2;
            SumTask left=new SumTask(arr, start, mid);
            SumTask right=new SumTask(arr, mid, end);
            left.fork();
            return right.compute()+left.join();
        }
    }
}

public class ForkJoinPoolExample{
    public static void main(String[] args) {
        int[] numbers={1,2,3,4,5,6};
        ForkJoinPool pool=new ForkJoinPool();
        int sum=pool.invoke(new SumTask(numbers, 0, numbers.length));
        System.out.println("Sum is: " + sum);        
    }
}