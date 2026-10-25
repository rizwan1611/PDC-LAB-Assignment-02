public class LogProcessorTask implements Runnable {
    
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        
        for (int step = 1; step <= 5; step++) {
            System.out.println(" [" + threadName + "] Parsing application log entry " + step + " of 5...");
            
            try {
                // Pause task execution for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException err) {
                System.out.println("Log worker interrupted: " + err.getMessage());
                break;
            }
        }
        
        System.out.println(">>> [" + threadName + "] Finished batch log analysis successfully.");
    }
}
// Tag 1: Custom log string formatting updated
