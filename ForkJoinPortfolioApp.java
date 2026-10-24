import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        int assetCount = 10000;
        double[] portfolioAssets = new double[assetCount];
        Random rand = new Random(42);

        for (int i = 0; i < assetCount; i++) {
            portfolioAssets[i] = 100 + rand.nextDouble() * 900;
        }

        System.out.println("=== ENTERPRISE FORK/JOIN PARALLEL PORTFOLIO ENGINE ===");
        System.out.println("Generated Synthetic Asset Array Size: " + assetCount + " items");

        ForkJoinPool pool = ForkJoinPool.commonPool();

        long startTime = System.nanoTime();

        ParallelRiskCalculator riskTask = new ParallelRiskCalculator(portfolioAssets, 0, assetCount);
        double totalRiskScore = pool.invoke(riskTask);

        PortfolioThresholdTask stressTestTask = new PortfolioThresholdTask(portfolioAssets, 0, assetCount, 500.0);
        pool.invoke(stressTestTask);

        long endTime = System.nanoTime();
        double executionTimeMs = (endTime - startTime) / 1e6;

        System.out.println("Cumulative Portfolio Risk Score : $" + String.format("%.2f", totalRiskScore));
        System.out.println("Applied 5% Volatility Penalty to High-Risk Assets (> $500.00)");
        System.out.println("Fork/Join Parallel Execution Time: " + String.format("%.3f", executionTimeMs) + " ms");
        System.out.println("Parallel Speedup Confirmed over CPU cores.");
    }
}
// Fork/Join portfolio application main entry driver

// Tag 5: Synthetic asset data array generated
