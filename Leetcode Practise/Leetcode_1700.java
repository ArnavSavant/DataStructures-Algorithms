import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = sandwiches.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int x : students) {
            queue.add(x);
        }
        int count = 0;
        int prevSize = 0;
        while (!stack.isEmpty() && stack.size() != prevSize) {
            prevSize = stack.size();
            for (int i = 0; i < queue.size(); i++) {
                if (queue.peek() == stack.peek()) {
                    queue.poll();
                    stack.pop();
                    count++;
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        return n-count;
    }
}
