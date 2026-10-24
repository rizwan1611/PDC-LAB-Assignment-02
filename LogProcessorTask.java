public class LogProcessorTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] Batch Log Analysis Iteration: " + i + "/5");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Log Processor Interrupted: " + e.getMessage());
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Log Analysis Batch Completed.");
    }
}