import java.util.Stack;

public class Leetcode_3174 {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x >= '0' && x <= '9') {
                stack.pop();
            } else {
                stack.push(x);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
