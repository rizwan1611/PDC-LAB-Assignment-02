public class LinearParallelSearch extends AbstractParallelSearch {

    public LinearParallelSearch(int[] dataset, int target, int threadCount) {
        super(dataset, target, threadCount);
    }

    @Override
    public int executeSearch() {
        Thread[] threads = new Thread[threadCount];
        int chunkSize = (int) Math.ceil((double) dataset.length / threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, dataset.length);

            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    if (found) return; // Early exit if target found by another worker thread
                    if (dataset[j] == target) {
                        synchronized (this) {
                            if (!found) {
                                found = true;
                                targetIndex = j;
                            }
                        }
                        return;
                    }
                }
            }, "SearchWorker-" + i);

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Search worker thread interrupted: " + e.getMessage());
            }
        }

        return targetIndex;
    }
}
// Concrete multi-worker linear array search implementation
