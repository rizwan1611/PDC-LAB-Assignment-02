public class TelemetryThread extends Thread {

    @Override
    public void run() {
        for (int cycle = 1; cycle <= 5; cycle++) {
            System.out.println(" [" + getName() + "] Collecting system status [Cycle " + cycle + "/5] -> RAM & CPU OK");
            
            try {
                // Pause task execution for 800ms
                Thread.sleep(800);
            } catch (InterruptedException err) {
                System.out.println("Telemetry background thread interrupted: " + err.getMessage());
                break;
            }
        }
        
        System.out.println(">>> [" + getName() + "] Background telemetry monitor stopped.");
    }

}