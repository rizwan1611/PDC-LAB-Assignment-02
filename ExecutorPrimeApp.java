import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorPrimeApp {
    public static void main(String[] args) {
        int maxRange = 50000;
        int threadPoolSize = 4;
        int chunkSize = maxRange / threadPoolSize;

        System.out.println("=== EXECUTORSERVICE PARALLEL PRIME NUMBER FINDER ===");
        System.out.println("Range: 1 to " + maxRange + " | Fixed Thread Pool Size: " + threadPoolSize);

        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<List<Integer>>> futureList = new ArrayList<>();

        long startTime = System.nanoTime();

        // Submit chunked Callable tasks to thread pool
        for (int i = 0; i < threadPoolSize; i++) {
            int start = i * chunkSize + 1;
            int end = (i == threadPoolSize - 1) ? maxRange : (i + 1) * chunkSize;
            PrimeSearchTask task = new PrimeSearchTask(start, end);
            futureList.add(executor.submit(task));
        }

        int totalPrimesFound = 0;
        try {
            for (Future<List<Integer>> future : futureList) {
                List<Integer> subList = future.get(); // Blocking wait for task completion
                totalPrimesFound += subList.size();
            }
        } catch (Exception e) {
            System.err.println("Execution Error during prime extraction: " + e.getMessage());
        } finally {
            executor.shutdown(); // Gracefully terminate worker thread pool
        }

        long endTime = System.nanoTime();
        double executionTimeMs = (endTime - startTime) / 1e6;

        System.out.println("\n=== SUMMARY VERDICT ===");
        System.out.println("Total Prime Numbers Found: " + totalPrimesFound);
        System.out.println("Parallel Pool Processing Time: " + String.format("%.3f", executionTimeMs) + " ms");
        System.out.println("ExecutorService thread pool gracefully shut down.");
    }
}
// Application driver for parallel prime calculation using ExecutorService

// Tag 3: Thread pool initialized

// Tag 4: Range partitioning added
