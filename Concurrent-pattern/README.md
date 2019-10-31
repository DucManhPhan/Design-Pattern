


## Synchronization patterns
1. Scoped locking

    ensures that a lock is required when control enters a scope and released automatically when control leaves the scope, regardless of the return path from the scope.

    --> Known as Synchornized block, RAII, Guard, Execute Around Object.

    In Java, we can use ```synchronized``` keyword for method or block.

    In C++, ```std::mutex``` will be applied.


2. Strategized locking



3. Thread-safe interface




4. Double-checked locking optimization



5. Code locking and Data locking



6. Reader/Writer locking



7. Object synchronizer




8. Balking and Guarded Suspension




<br>

## 