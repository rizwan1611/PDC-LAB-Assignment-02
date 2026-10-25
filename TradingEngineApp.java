public class TradingEngineApp {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();

        // Polymorphic instantiation using TradeEvent superclass reference variables
        TradeEvent fixOrder = new FIXOrderEvent("FIX_ADAPTER_01", currentTime, 1500.00, "ORD-99823");
        TradeEvent reutersQuote = new ReutersQuoteEvent("REUTERS_GATEWAY_02", currentTime + 50, 1500.00, 1499.50, 1500.25);

        System.out.println("Starting Dynamic Complex Event Processing (CEP) Engine...\n");

        // Executing dispatch() polymorphically
        fixOrder.dispatch();
        System.out.println();
        reutersQuote.dispatch();
    }
}
// Tag: CEP engine driver updated
