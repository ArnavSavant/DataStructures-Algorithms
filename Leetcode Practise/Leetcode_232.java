import java.util.Stack;

public class Leetcode_232 {
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<Integer>();
        }

        public void push(int x) {
            stack2 = new Stack<Integer>();
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
            stack2.add(x);
            while (!stack2.isEmpty()) {
                stack1.add(stack2.pop());
            }
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            return stack1.pop();
        }

        public int peek() {
            if (empty()) {
                return -1;
            }
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.empty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
