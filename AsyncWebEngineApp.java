
public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("........ASYNCHRONOUS WEB ENGINE INITIALIZATION.........");
        System.out.println(" The Default Master JVM Thread Name: " + Thread.currentThread().getName());
        System.out.println(" The Spawning concurrent telemetry and log processing workers...\n");

        TelemetryThread telemetryWorker = new TelemetryThread();
        telemetryWorker.setName("Telemetry-Worker");

        LogProcessorTask logTask = new LogProcessorTask();
        Thread logWorker = new Thread(logTask, "Log-Workker");

        telemetryWorker.start();
        logWorker.start();

        System.out.println(" The Worker threads started. Master main() thread continuing non-blocking operations.\n");
    }
}
// Master thread logger header updated
