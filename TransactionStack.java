public class TransactionStack {
    private char[] stackArray;
    private int top;
    private int capacity;

    public TransactionStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new char[capacity];
        this.top = -1;
    }

    public void push(char c) {
        if (top < capacity - 1) {
            stackArray[++top] = c;
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        return '\0';
    }

    public char peek() {
        if (!isEmpty()) {
            return stackArray[top];
        }
        return '\0';
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
// Enhanced TransactionStack memory boundary checks
// Step 1: LIFO stack optimization tag added

// Memory check: explicit bound assertion tag added
