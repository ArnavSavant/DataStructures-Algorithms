import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    static class Stack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public Stack() {
            queue1 = new LinkedList<Integer>();
        }

        public int getSize() {
            return queue1.size();
        }

        public boolean isEmpty() {
            return queue1.isEmpty();
        }

        public void push(int element) {
            queue2 = new LinkedList<Integer>();
            queue2.add(element);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            queue1 = queue2;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return queue1.poll();
        }

        public int top() {
            if (isEmpty()) {
                return -1;
            }
            return queue1.peek();
        }
    }
}
