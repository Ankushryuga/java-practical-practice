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
