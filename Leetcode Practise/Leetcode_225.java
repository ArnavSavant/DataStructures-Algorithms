import java.util.Queue;
import java.util.LinkedList;

public class Leetcode_225 {

    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return (queue.size() == 0 ? true : false);
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
