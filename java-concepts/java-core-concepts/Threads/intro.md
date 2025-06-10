## Threads:
        => Threads allows a program to operate more efficiently by doing multiple things at the same time.
        Threads can be used to perform complicated tasks in the background without interrupting the main program.


## Creating a Thread:
        =>
        There are 2 ways to create a thread.
        1. It can be created by extending the Thread class and overriding its run() method:

        Example:
        public class Main extends Thread{
            public void run(){
                System.out.println("This code is running in a thread");
            }
        }

        2. Another way to create a thread is to implement Runnable interface.

        Example:
        public class Main implements Runnable{
            public void run(){
                System.out.println("This code is running in a thread");
            }
        }


## Running Threads by using Thread class.
        => If the class extends the Thread clsas, the thread can be run by creating an instance of the class and its start() method:

        public class Main extends Thread{
            public static void main(String[] args){
                Main thread = new Main();
                thread.start();
                System.out.println("This code is outside of the thread"); 
            }
            public void run(){
                System.out.println("This code is running in a thread");
            }
        }

## Running Threads by using Runnable Interface.
        => If the class implements the Runnable interface, the thread can be run by passing an instance of the class to a Thread object's constructor and then calling the thread's start() method:

        public class Main implements Runnable{
            public static void main(String[] args){
                Main obj=new Main();
                Thread thread=new Thread(obj);
                System.out.println("This code is outside of the thread");
            }
            public void run(){
                System.out.println("This code is running in a thread");
            }
        }

## Differences b/w "extending" and "implementing" Threads
        => The major difference is that when a class extends the Thread class, you cannot extend any other class, but by implementing the Runnable interface, it is possible to extend from another class as well, 
        like: MyClass extends OtherClass implements Runnable.

## Concurrency Problems:
        => 
        When the threads and main program are reading and writing the same variables, the values are unpredictable. The problems that result from this are called concurrency problems.
        
        example code:
        public class Main extends Thread{
            public static int amount=0;
            public static void main(String[] args){
                Main thread=new Main();
                thread.start();
                System.out.println(amount);
                amount++;
                System.out.println(amount);
            }
            public void run(){
                amount++;
            }
        }

## To Avoid concurrency problems: it is best to share as few attributes b/w threads as possible. If attributes need to be shared, one possible solution is to use the **isAlive()** method to the thread to check whether the thread has finished running before using any attributes that the thread can change.
        =>
        use isAlive() to prevent concurrency problems:
        public class Main extends Thread{
            public static int amount=0;

            public static void main(String[] args){
                Main thread=new Main();
                thread.start();
                //wait for the thread to finish.
                while(thread.isAlive()){
                    System.out.println("Waiting...");
                }
                //update amount and print its value.
                System.out.println("Main: "+ amount);
                amount++;
                System.out.println("Main: "+ amount);
            }
            public void run(){
                amount++;
            }
        }