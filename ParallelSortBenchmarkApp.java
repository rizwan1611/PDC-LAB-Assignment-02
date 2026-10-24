import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ParallelSortBenchmarkApp {
    public static void main(String[] args) {
        int arraySize = 500000;
        int[] originalArray = new int[arraySize];
        Random rand = new Random(2024);

        for (int i = 0; i < arraySize; i++) {
            originalArray[i] = rand.nextInt(1000000);
        }

        int[] sequentialArray = Arrays.copyOf(originalArray, arraySize);
        int[] parallelArray = Arrays.copyOf(originalArray, arraySize);

        System.out.println("=== PARALLEL SORTING & PERFORMANCE BENCHMARK ENGINE ===");
        System.out.println("Dataset Size: " + arraySize + " random integers\n");

        // 1. Sequential Sort Benchmark
        long startSeq = System.nanoTime();
        Arrays.sort(sequentialArray);
        long endSeq = System.nanoTime();
        double seqTimeMs = (endSeq - startSeq) / 1e6;
        System.out.println("1. Sequential Arrays.sort() Execution Time : " + String.format("%.3f", seqTimeMs) + " ms");

        // 2. Parallel Merge Sort Benchmark
        ForkJoinPool pool = ForkJoinPool.commonPool();
        long startPar = System.nanoTime();
        ParallelMergeSortTask sortTask = new ParallelMergeSortTask(parallelArray, 0, parallelArray.length - 1);
        pool.invoke(sortTask);
        long endPar = System.nanoTime();
        double parTimeMs = (endPar - startPar) / 1e6;
        System.out.println("2. Parallel Merge Sort Execution Time       : " + String.format("%.3f", parTimeMs) + " ms");

        // 3. Performance Metrics
        double speedup = seqTimeMs / parTimeMs;
        System.out.println("\n=== PERFORMANCE PROFILE VERDICT ===");
        System.out.println("Speedup Factor achieved: " + String.format("%.2f", speedup) + "x faster");
        System.out.println("Array Sort Verification: " + (Arrays.equals(sequentialArray, parallelArray) ? "MATCHED (SUCCESS)" : "MISMATCH (FAILED)"));
    }
}
// Application driver for parallel sorting benchmark and profiling
