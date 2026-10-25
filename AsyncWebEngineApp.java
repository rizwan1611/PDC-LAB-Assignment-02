public class AsyncWebEngineApp {

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  Starting Web Telemetry Engine...");
        System.out.println("  Current Executing Thread: " + Thread.currentThread().getName());
        System.out.println("===========================================\n");

        // Set up background telemetry monitor
        TelemetryThread telemetryWorker = new TelemetryThread();
        telemetryWorker.setName("Telemetry-Service");

        // Set up log processor task
        LogProcessorTask logTask = new LogProcessorTask();
        Thread logWorker = new Thread(logTask, "LogProcessor-Service");

        // Launch worker threads
        System.out.println("Spawning background worker threads...\n");
        telemetryWorker.start();
        logWorker.start();

        System.out.println("Main thread execution continuing in non-blocking mode.\n");
    }
}

// Tag 3: Header formatting updated
