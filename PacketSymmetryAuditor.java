public class PacketSymmetryAuditor {
    public static void main(String[] args) {
        String packetPayload = "RADAR";

        int n = packetPayload.length();
        TransactionStack stack = new TransactionStack(n);
        RequestQueue queue = new RequestQueue(n);

        System.out.println("=== ZERO-TRUST EDGE SECURITY GATEWAY [v2.0] ===");
        System.out.println("Ingesting Network Packet Payload: " + packetPayload);

        for (int i = 0; i < n; i++) {
            char ch = packetPayload.charAt(i);
            stack.push(ch);
            queue.enqueue(ch);
        }

        boolean isSymmetrical = true;

        while (!stack.isEmpty() && !queue.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.dequeue();

            if (stackChar != queueChar) {
                isSymmetrical = false;
                break;
            }
        }

        System.out.println("\n=== AUDIT LOG TERMINAL VERIFICATION RESULT ===");
        if (isSymmetrical) {
            System.out.println("VERDICT: Packet Exhibits Bi-Directional Symmetry [PALINDROME PASSED]");
        } else {
            System.out.println("VERDICT: Packet Symmetry Check Failed [TAMPERED LOG DETECTED]");
        }
    }
}
// Edge gateway packet symmetry auditor execution completed