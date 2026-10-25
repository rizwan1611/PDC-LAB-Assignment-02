public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015; // 0.15% fee
        double totalPrice = basePrice + fee;

        System.out.println("========================================");
        System.out.println("[FIX GATEWAY ORDER DISPATCHED]");
        System.out.println("Client Order ID : " + clOrdId);
        System.out.println("Sender ID       : " + senderId);
        System.out.println("Timestamp       : " + timestamp + " ms");
        System.out.println("Base Price      : $" + String.format("%.2f", basePrice));
        System.out.println("Exchange Fee    : $" + String.format("%.4f", fee) + " (0.15%)");
        System.out.println("Total Execution : $" + String.format("%.2f", totalPrice));
        System.out.println("========================================");
    }
}
// Tag: FIX adapter fee logic verified
