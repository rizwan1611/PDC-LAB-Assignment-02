public abstract class AbstractParallelSearch {
    protected int[] dataset;
    protected int target;
    protected int threadCount;
    protected volatile boolean found;
    protected volatile int targetIndex;

    public AbstractParallelSearch(int[] dataset, int target, int threadCount) {
        this.dataset = dataset;
        this.target = target;
        this.threadCount = threadCount;
        this.found = false;
        this.targetIndex = -1;
    }

    public abstract int executeSearch();

    public boolean isFound() {
        return found;
    }

    public int getTargetIndex() {
        return targetIndex;
    }
}
// Abstract base template for parallel search algorithms

// Tag 1: Search parameters initialized

// Tag 2: Getter methods implemented
