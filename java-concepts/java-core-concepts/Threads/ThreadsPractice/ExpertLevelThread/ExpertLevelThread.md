## Expert level thread:
1. ReentrantLock: its a flexible and powerful locking mechanism compared to the traditional synchronized, it allows explicit locking and unlocking

2. ReadWriteLock: Its allows multiple threads to read a resource simultaneously while ensuring exclusive access for write operations.

3. CountDownLatch: It allows one or more threads to wait until a set of operations being performed in other threads completes.

4. CyclicBarrier: It allows a set of threads to wait for each other to reach a common barrier point, its useful when multiple threads must coordinate their execution at certain stages.

5. Semaphore: It is used to control access to a shared resource by multiple threads, limiting the number of threads that can access the resource simultaneously. Semaphores are particulary useful in scenarios where you want to enforce a fixed number of permits for accessing a resource, such as database connections etc.
    
    5.1. Key Features of semaphore:
        a. Permits: A semaphore maintains a set number of permits. Threads acquire permits to proceed and release them when done.
        b. Blocking: if no permits are available, a thread attempting to acquire one will block until a permit is released.
        c. Fairness: Semaphores can be configured to ensure fairness, meaning permits are granted in the order threads requested them.
    
    5.2. Types of Semaphores:
        a. Counting Semaphore: Allows a fixed number of threads to access a resource.
        b. Binary Semaphore: A special case of counting semaphore with only one permits, similar to a lock.


6. CompletableFuture: It allow you to write non-blocking, concurrent code in more readable and functional style.
    => Key Features:
        a. Asynchronous Exception: Run tasks asynchronously without blocking the main thread.
        b. Chaining: Combine multiple asynchronous tasks using methods like thenApply, thenAccept, and thenCompose.
        c. Combining Futures: Combine multiple CompletableFuture instances using methods like thenCombine or allOf.
        d. Exception Handling: Handle exceptions gracefully with methods like exceptionally or handle.
        e. Non-blocking: avoid blocking the thread while waiting for results using whenComplete or join.


7. ForkJoinPool: Its a advance version of ExecutorService, it efficiently execute tasks that can be broken into smaller subtasks, following divide-and-conquer paradigm. 
        => Key Features:
            a. Work-Stealing Algorith: Threads in the pool can steal tasks from other threads queues to keep themselves busy, improving resource utilization.
            b. RecursiveTask and RecursiveAction: It works with 2 types of tasks: RecursiveTask<V>: Returns a result, and RecursiveAction: Does not return a result.
            c. Parallelism: The pool size is determined by the number of available processors(default: Runtime.getRuntime().availableProcessors()), but it can be customized.
            
