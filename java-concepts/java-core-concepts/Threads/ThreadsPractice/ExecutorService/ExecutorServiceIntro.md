## ExecutorService:
        =>
        ExecutorService is an interface in the java.util.concurrent package that provides a high-level framework for managing and controlling threads, It is part of the java Concurrency utilities.

## ExecutorService Purpose:
        =>
        1. It decouples task submission from task execution, allowing you to manage how tasks are executed without dealing directly with thread creation and management.

## Key Features:
        =>
        1. Thread Pool Management: It manages a pool of threads, reusing them to execute multiple tasks, which improves performance and reduces overhead.
        2. Task Submission: 
            2.1. execute(Runnable command): Executes a task without returning a result.
            2.2. submit(Callable or Runnable): Submits a task and returns a Future that can be used to retrieve the result or check the status.
        3. Graceful Shutdown:
            3.1. shutdown() -> initiates an orderly shutdown; previously submitted tasks are executed, but no new tasks are accepted.
            3.2. shutdownNow()  -> Attemps to stop all actively executing tasks immediately.
        4. Task Management Utilities:
            4.1. invokeAll() -> Submits a collections of tasks and returns a list of Futures.
            4.2. invokeAny() -> Submits a collections of tasks and returns the result of one that completes successfully.


## Resources:
https://www.javaguides.net/2018/09/executorservice-interface-in-java.html

https://www.geeksforgeeks.org/java-util-concurrent-executorservice-interface-with-examples/