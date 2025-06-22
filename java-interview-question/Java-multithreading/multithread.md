# Java multithread questions
# resources:

https://jenkov.com/tutorials/java-concurrency/index.html#better-user-experience-with-regards-to-fairness

# Java multithread questions

# What is multithreading?

    => it means that you have multiple threads of execution inside the same application, A thread is like a separate CPU executing your application.
    A multithreaded application is like an application that has multiple CPUs executing differnet parts of the code at the same time.

# Thread:

    => A thread is lightweight subprocesses, representing smallest unit of execution with separate path,

# multithreading vs multiprocessing vs multiprogramming vs multitasking vs concurrency

    =>
    # Multithreading: multiple threads within a single process run concurrently. Shared memory within same process.

    # Multiprocessing: Multiple process run in parallel, usually on multiple CPUs, true parallelism.

    # Multiprogramming: Multiple program reside in memory and the CPU switches b/w then, increases CPI utilization.

    # Multitasking: CPU swithces quickly b/w tasks to give illusion of parallelism, preemptive or cooperative.

    # concurrency: multiple tasks logically happen at the same time, but not necessarily simultaneoulsy. managed by via threads, corouties etc.

# How Multi-threading works in Java?

    => Multithreading in java allows a program to execute multiple threads concurrently enabling better CPU utilization, faster performance, and responsive applications.

    # How it works?
        => it uses the Thread class and Runnable interface from the java.lang package to implement multithreading.

    # Core components:
    1. Thread class: Represents a single thread of execution.

    2. Runnable interface: Defines the task a thread executes.

    3. start() method: starts a thread (calls run() in a new call stack).

    4. run() method: the code the thread executes.

    5. ExecuterService: advanced thread pool management.

    5. synchronized keyword: it ensures thread-safe access to shared resources.

# 🚦 Thread Lifecycle in Java

    =>
    NEW → RUNNABLE → RUNNING → TERMINATED
                ↑
            WAITING / BLOCKED

    NEW – Thread object is created
    RUNNABLE – Thread is ready to run (after .start())
    RUNNING – JVM scheduler picks thread to run
    BLOCKED/WAITING – Waiting for a resource or signal
    TERMINATED – Thread has completed or stopped

# Race conditions:

    => if multiple threads access shared data.

# Deadlocks:

    => when threads wait on each other forever.

# Thread scheduling:

    => OS/JVM-dependent.

# Basic to advanced multithreading.
    
    Thread lifecycle and states
    Thread vs Runnable
    Thread scheduling
    Thread priorities
    Synchronization
    Deadlocks
    wait(), notify(), notifyAll()
    volatile keyword
    Thread-safe collections
    ExecutorService, Callable, Future
    ForkJoin framework
    CompletableFuture (async programming)

# What are the disadvantages of multithreading?
    =>
    1. Complexity in design and debug.
    2. Synchrnoization overhead
    3. Deadlocks
    etc

# What is a Thread’s priority and how it is used in scheduling?
    =>
    Each thread in java has a priority, which is an integer value that helps the thread scheduler decide which thread to run first when multiple threads are waiting to be executed.
    => Priority is not a guarantee -> its a hint to the JVM thread scheduler.
    # Java Assigns priorities in the range.
    1. Thread.MIN_PRIORITY  => value=> 1 => Lowest Priority
    2. Thread.NORM_PRIORITY => value=> 5 => Default Priority
    3. Thread.MAX_PRIORITY  => value=> 10 => Highest

    # Example: How to set priority:
    Thread t=new Thread();
    t.setPriority(Thread.MAX_PRIORITY);    //10
    System.out.println(t.getPriority());

    # Java uses preemptive, priority-based thread scheduling (depend on JVM & OS).
    # If multiiple threads are runnable, higher priority thread may get more CPU time.
    # Don't rely on priority alone for correctness or important logic.
    # Use higher-level concurrency control (Executors, Semaphore, etc.) for better control.

# What are the differences between Pre-emptive Scheduling Scheduler and Time Slicing Scheduler?
    =>
    Both pre-emptive scheduling and time slicing are CPU scheduling strategies uses by OS and JVM thread schedulers to manage multithreaded execution, but they work differently.
    🔄 1. Pre-emptive Scheduling
    
    A higher priority thread can preempt (interrupt) a lower priority thread.
    🔧 Characteristics:
    CPU is allocated to the highest priority thread available.
    If a new thread with higher priority becomes runnable, it preempts the current one.
    It helps in handling critical tasks first.
    🧠 Example Scenario:
    Thread A (priority 5) is running.
    Thread B (priority 8) becomes ready.
    Thread A is preempted and Thread B gets the CPU.
    ⏱️ 2. Time Slicing (Round-Robin Scheduling)
    
    Every thread is given equal CPU time in turns, regardless of priority.
    🔧 Characteristics:
    CPU is assigned to each runnable thread for a fixed time slice (called a quantum).
    After the time slice expires, the CPU moves to the next thread, and so on.
    Helps achieve fair CPU sharing among threads.
    🧠 Example Scenario:
    Thread A, B, C all have same priority.
    Each gets, say, 100ms time slice.
    Threads run in rotation, even if they haven't finished execution.
    🆚 Comparison Table
    | Feature              | Pre-emptive Scheduling             | Time Slicing Scheduling         |
    | -------------------- | ---------------------------------- | ------------------------------- |
    | CPU Allocation       | Based on **priority**              | Based on **fixed time quantum** |
    | Fairness             | Can cause **starvation**           | Ensures **fair CPU time**       |
    | Preemption           | Yes, by **higher priority** thread | No, all get equal turns         |
    | Implementation Focus | **Responsiveness**, priority       | **Fairness**, equal sharing     |
    | JVM Dependence       | Partially implemented by JVM       | Mostly handled by OS scheduler  |


# Is it possible to call run() method instead of start() on a thread in Java?
    => Yes, it possible to call run() method directly on a thread, but its not the same as calling start().
    
    | Feature               | `start()`                             | `run()`                             |
    | --------------------- | ------------------------------------- | ----------------------------------- |
    | New Thread            | Yes – creates a new thread            | No – runs in the current thread     |
    | Executes `run()`      | Yes                                   | Yes                                 |
    | Executes concurrently | ✅ Yes                                 | ❌ No (synchronously in main thread) |
    | Thread Lifecycle      | Goes through NEW → RUNNABLE → RUNNING | No lifecycle involved               |

    # Example:
    class MyThread extends Thread{
        public void run(){
        System.out.println("Running" + Thread.currentThread().getName());
        }
    }
    public class ThreadRunVsStart{
        public static void main(String[] args){
            MyThread t1=new Mythread();
            t1.run();    // will not start a new thread; run in main thread.
            t1.start(); //starts a new thread and run in parallel.
        }
    }
    Running in: main        ← from run()
    Running in: Thread-0    ← from start()
    
    🚫 Calling run() directly does not start a new thread

    It simply invokes a method like any other function, synchronously, within the current thread.
    
    ❗ Important Note:
    Calling start() twice on the same thread will throw IllegalThreadStateException.
    Calling run() multiple times is allowed, but not multithreaded.



# 151.How will you make a user thread into daemon thread if it has already started?
    => Once a user thread has already started, you cannot make it a daemon thread. In java trying to set a thread after it has start will be result in a java.lang.IllegalThreadStateException.
    Thread t=new Thread(myRunnable);
    t.start();
    t.setDaemon(true);    //Throws IllegalThreadStateException.

    Why?
    Daemon status is part of the internal thread state that must be defined before the thread runs. Allowing changes after start could lead to unpredictable behavior in JVM thread management.


# In what scenarios can we interrupt a thread?
    => Interrupting a thread is a way to signal that it should stop what its doing and do something else - typically stop execution gracefuuly, you don't forcefully kill it, but politely request to stop.
    1. To Stop a long-running or blocking operations.
        => if a thread is performing a task that may take a long time (e.g, file download, batch processing) you want to stop it before completion.
        thread.interrupt();

    2. To Stop a thread that's waiting, sleeping or blocked.
        => if a thread is in a sleep(), wait(), or blocking I/O call, interrupting it will cause it to throw an InterruptedException, allowing it to break out of the blocked state.
        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){
        }

    3. To cancel a Task submitted to ExecutorService.
        => When using ExecutorService, you can interrup a running task using future.cancel(true);
        #example:
            => 
            Future<?> future = executor.submit(task);
            future.cancel(true);    //attempts to interrup the thread running the task.

    => Interrupting doesn't kill a thread. It just sets an internal flag (interrupted = true) or throws an InterruptedException if the thread is blocked.
    => Threads must be designed to respond to interruptions.
    If a thread ignores the interrupt flag or exception, it will keep running.


# In Java, is it possible to lock an object for exclusive use by a thread?
    => yes, it is absolutely possible to lock an object so that only one thread can access a block of code or critical section at a time, its done using:
    1. synchronized keyword:
        => you can synchronize a method or block of code using an object as a lock.
        # Example: synchronized block.
        Object lock = new Object();
        synchronized (lock){
        //only 1 thread can execute this block at a time using this lock. 
            System.out.println("Thread has exclusive access");
        }
        # Example: synchronized method:
        public synchronized void doWark(){
        }    

        # Instance methods lock on this.
        # static synchronized methods lock on the Class Object.

        import java.util.concurrent.locks.ReentrantLock;
        
        ReentrantLock lock = new ReentrantLock();
        
        lock.lock();
        try {
            // critical section
            System.out.println("Thread has exclusive access");
        } finally {
            lock.unlock(); // always unlock in a finally block
        }

        
# 🔄 When Do You Use synchronized, ReentrantLock These?
    | Locking Mechanism | Use Case                                                    |
    | ----------------- | ----------------------------------------------------------- |
    | `synchronized`    | Simple mutual exclusion with implicit locking               |
    | `ReentrantLock`   | More flexible locking (tryLock, interruptibility, fairness) |


# How notify() method is different from notifyAll() method?
    => Both are methods of the Object class in java and are used for inter-thread communication, typically with wait(), inside a synchronized context.
    ### notify():
    1. Wakes up on thread that is waiting on the object's monitor.
    2. The Specific thread chosen is not guranted
    3. Useful when only 1 thread needs to proceed.
    # example:
    synchronized(obj){
        obj.notify();
    }

    ### notifyAll():
    1. Wakes up all threads that are waiting on the object's monitor.
    2. All awakened thread will compete to acquire the lock and proceed.
    3. Use this when multiple thread might be waiting, and you don't know which should proceed.
    # example:
    synchronized(obj){
        obj.notifyAll();
    }

    | Feature          | `notify()`                                                 | `notifyAll()`                        |
    | ---------------- | ---------------------------------------------------------- | ------------------------------------ |
    | Wakes up         | One waiting thread                                         | All waiting threads                  |
    | Thread selection | Arbitrary                                                  | All notified (but still compete)     |
    | Use case         | Only one thread needs to run                               | Multiple threads may need to proceed |
    | Risk             | Can cause **missed signals** if the wrong thread is chosen | Safer in complex conditions          |

    #######note:
    1. Both must be called inside a synchronized block.
    2. Threads must be waiting on the same object's monitor using wait().
    3. Use notify() only if you're sure that one waiting thread is sufficient and the rest can remain waiting.
