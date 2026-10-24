import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSortTask extends RecursiveAction {
    private static final int THRESHOLD = 2000;
    private int[] array;
    private int left;
    private int right;

    public ParallelMergeSortTask(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if ((right - left) <= THRESHOLD) {
            Arrays.sort(array, left, right + 1);
        } else {
            int mid = left + (right - left) / 2;
            ParallelMergeSortTask leftTask = new ParallelMergeSortTask(array, left, mid);
            ParallelMergeSortTask rightTask = new ParallelMergeSortTask(array, mid + 1, right);

            invokeAll(leftTask, rightTask);
            merge(mid);
        }
    }

    private void merge(int mid) {
        int[] leftArr = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            array[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            array[k++] = rightArr[j++];
        }
    }
}
// Parallel merge sort recursive action implementation
