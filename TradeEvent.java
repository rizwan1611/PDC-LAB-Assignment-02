public class TradeEvent {
    protected String senderId;
    protected long timestamp;
    protected double basePrice;

    public TradeEvent(String senderId, long timestamp, double basePrice) {
        this.senderId = senderId;
        this.timestamp = timestamp;
        this.basePrice = basePrice;
    }

    public void dispatch() {
        System.out.println("[GENERIC EVENT LOG]");
        System.out.println("Sender ID : " + senderId);
        System.out.println("Timestamp : " + timestamp + " ms");
        System.out.println("Base Price: $" + String.format("%.2f", basePrice));
    }
}

// Tag: Base class documentation updated

// Tag: Base class documentation updated

/** JavaDoc: Abstract event structure for trading gateways */
