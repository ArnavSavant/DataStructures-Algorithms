import java.util.Stack;

public class Leetcode_1190 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x != ')') {
                stack.push(x);
            } else {
                StringBuffer sb = new StringBuffer();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (char y : sb.toString().toCharArray()) {
                    stack.push(y);
                }
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char x : stack) {
            ans.append(x);
        }
        return ans.toString();
    }
}
