public class ImplementStackUsingArray {
    static class Stack {
        int stack[];
        int top = -1;
        int size = 0;

        Stack(int capacity) {
            stack = new int[capacity];
            size = capacity;
        }

        public void push(int num) {
            if (top == size - 1) {
                return;
            }
            top++;
            stack[top] = num;
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            return stack[top--];
        }

        public int top() {
            if (top == -1) {
                return -1;
            }
            return stack[top];
        }

        public int isEmpty() {
            if (top == -1) {
                return 1;
            } else {
                return 0;
            }
        }

        public int isFull() {
            if (top == size - 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
