import java.util.Random;

public class ParallelSearchApp {
    public static void main(String[] args) {
        int arraySize = 100000;
        int[] dataArray = new int[arraySize];
        Random rand = new Random(101);

        for (int i = 0; i < arraySize; i++) {
            dataArray[i] = rand.nextInt(1000000);
        }

        int targetValue = 77777;
        dataArray[65432] = targetValue; // Plant target at specific index

        int workerThreads = 4;
        System.out.println("=== ABSTRACT PARALLEL ARRAY SEARCH ENGINE ===");
        System.out.println("Dataset Size: " + arraySize + " integers | Target Value: " + targetValue);
        System.out.println("Configured Worker Threads: " + workerThreads);

        LinearParallelSearch searchEngine = new LinearParallelSearch(dataArray, targetValue, workerThreads);

        long startTime = System.nanoTime();
        int foundIdx = searchEngine.executeSearch();
        long endTime = System.nanoTime();

        double executionTimeMs = (endTime - startTime) / 1e6;

        if (searchEngine.isFound()) {
            System.out.println("TARGET FOUND: Value " + targetValue + " located at Array Index [" + foundIdx + "]");
        } else {
            System.out.println("TARGET NOT FOUND in dataset.");
        }

        System.out.println("Parallel Search Execution Time: " + String.format("%.3f", executionTimeMs) + " ms");
    }
}
// Application driver for abstract parallel array search engine

// Tag 5: Dataset generated
