/**
 * Deadlock: its a situation, where 2 or more threads are blocked forever, waiting for each other.
 * Deadlock occurs when multiple threads need the same locks but obtain them in different order.
 * 
 * A java multithreaded program may suffer from deadlock condition b/c the synchronized keyword causes the executing thread to block while waiting
 * for the lock, or monitor, associated with the speicifed Object.
 * Ho
 */

/**
 * How to prevent or Handle Deadlock in java?
 * 1. Avoid Nested Locks/Lock Ordering: Always acquire locks in a consistent global order to prevent circular waiting.
 *          # Example:
 *             synchronized (lockA){
 *              synchronized (lockB){
 *              }
 *             }
 * NOTE: Make Sure all threads follow the same Order: lockA->lockB
 * 
 * 2. Use tryLock() with Timeout(from java.util.concurrent.locks)
 *  => Instead of blocking forever, tryLock(), lets you attempt a lock with a timeout.
 *  # Example:
 *  Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    if (lock1.tryLock(1, TimeUnit.SECONDS)) {
        try {
            if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    // critical section
                } finally {
                    lock2.unlock();
                }
            } else {
                // could not acquire lock2
            }
        } finally {
            lock1.unlock();
        }
    } else {
        // could not acquire lock1
    }
 * 
 * 3. Minimize Lock Scope.
 * 4. Avoid unnecessary Locks.
 */ 