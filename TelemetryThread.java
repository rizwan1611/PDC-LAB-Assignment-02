public class TelemetryThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + getName() + "] Telemetry Health Metrics Capture Iteration: " + i + "/5 (CPU: Normal, Memory: Stable)");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.err.println(" The Telemetry Thread Interrupted: " + e.getMessage());
            }
        }
        System.out.println("[" + getName() + "] Telemetry Monitoring Cleaned Up.");
    }
}

// Telemetry metrics string formatting updated
