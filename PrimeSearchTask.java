import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeSearchTask implements Callable<List<Integer>> {
    private final int start;
    private final int end;

    public PrimeSearchTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    @Override
    public List<Integer> call() {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}
// Callable prime identification task for thread pool execution

// Tag 1: Primality trial division logic added
