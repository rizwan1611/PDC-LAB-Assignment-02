
public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("=== ASYNCHRONOUS WEB ENGINE INITIALIZATION ===");
        System.out.println("Default Master JVM Thread Name: " + Thread.currentThread().getName());
        System.out.println("Spawning concurrent telemetry and log processing workers...\n");

        TelemetryThread telemetryWorker = new TelemetryThread();
        telemetryWorker.setName("Telemetry-Worker");

        LogProcessorTask logTask = new LogProcessorTask();
        Thread logWorker = new Thread(logTask, "Log-Worker");

        telemetryWorker.start();
        logWorker.start();

        System.out.println("Worker threads started. Master main() thread continuing non-blocking operations.\n");
    }
}