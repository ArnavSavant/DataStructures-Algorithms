import java.util.Stack;

public class Leetcode_155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int val) {
            if (minStack.size() == 0 || val <= minStack.peek()) {
                minStack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
