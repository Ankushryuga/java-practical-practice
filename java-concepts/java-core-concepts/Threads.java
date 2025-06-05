import java.util.*;

// public class Main extends Thread{
//   public static void merge(int[] arr, int l, int m, int r){
//     int n1=m-l+1;
//     int n2=r-m;
//     int[] L=new int[n1];
//     int[] R=new int[n2];
    
//     for(int i=0;i<n1;i++){
//       L[i]=arr[i+l];  
//     }
//     for(int j=0;j<n2;j++){
//       R[j]=arr[m+1+j];
//     }
//     int i=0, j=0;
//     int k=l;
//     while(i<n1 && j<n2){
//       if(L[i]<=R[j]){
//         arr[k]=L[i];
//         i++;
//       }else{
//         arr[k]=R[j];
//         j++;
//       }
//       k++;
//     }
//     while(i<n1){
//       arr[k]=L[i];
//       i++;
//       k++;
//     }
//     while(j<n2){
//       arr[k]=R[j];
//       j++;
//       k++;
//     }
//   }
//   public static void sort(int[] arr, int l, int r){
//     if(l<r){
//       int m=l+(r-l)/2;
//       sort(arr, l, m);
//       sort(arr, m+1, r);
//       merge(arr, l, m, r);
//     }
//   }
//     int[] arr={12, 24,132, 113, 10,2};
//     public static void main(String[] args) {
//       // System.out.println("Hello, World!");
//   // sort(arr, 0, arr.length-1);
//   /**
//   * If the class extends the Thread class, the thread can be run by 
//   * creating an instance of the class and call its start() method.
//   */
//   Main thread=new Main();
//   thread.start();
//     System.out.println("Code outside of the thread:");
//     }
//   public void run (){
      

//     System.out.println("code inside the thread");
//     sort(arr, 0, arr.length-1);
//     for(int n:arr){
//     System.out.print(n+" ");
//   }
//   }
// }



/**
 * If the class implements the Runnable interface, the Thread can be run by passing an instance of the class to a Thread Object's constructor and then calling the thread start method.
 * 
 */
public class Main implements Runnable{
  public static void main(String[] args){
    Main obj=new Main();
    Thread thread=new Thread(obj);
    thread.start();
    System.out.println("This code is outside the thread..");
  }
  public void run (){
    System.out.println("This is inside thread");
  }
}


/**
 * extending vs implementing threads.
 * 
 * The major difference is that when a class extends the thread class, you cannot extend any other class, 
 * but by implementing the Runnable interface, it is possible to extend from another class as well, 
 * example: MyClass extends Otherclass implements Runnable.
 */
