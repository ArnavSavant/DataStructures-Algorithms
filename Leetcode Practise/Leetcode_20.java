import java.util.Stack;

public class Leetcode_20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char y = stack.pop();
                if ((x == ')' && y != '(') || (x == ']' && y != '[') || (x == '}' && y != '{')) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
/*
Certainly! Let's analyze this code, which is designed to verify the validity of strings containing only three types of parentheses: '()', '{}', and '[]'.

### Objective:

The purpose of the code is to determine if the given string `s` has balanced parentheses. That is, for every opening parenthesis, there must be a corresponding closing parenthesis in the appropriate order.

### Logic and Intuition:

1. **Odd Length Strings**:
   - If the length of the string `s` is odd, it can't be balanced because there would be one unmatched parenthesis.
   - For instance, "({[)]" has odd length and is unbalanced.

2. **Use of Stack**:
   - Stacks are useful data structures for problems like this because they follow the Last-In-First-Out (LIFO) principle. This means that you can push every opening parenthesis onto the stack as you encounter them, and then pop them off when you find a corresponding closing parenthesis.
   - This way, the last opening parenthesis you encounter (and thus the first one on the stack) should match the first closing parenthesis you find, and so on.

3. **Processing the String**:
   - The code processes each character `x` of the string from left to right.
   - If `x` is an opening parenthesis ('(', '{', or '['), it is pushed onto the stack.
   - If `x` is a closing parenthesis, the code checks whether the stack is empty. An empty stack would imply there's no corresponding opening parenthesis for this closing parenthesis, thus returning `false`.
   - The top character `y` of the stack is then popped and checked against `x` to see if they form a valid pair of opening-closing parentheses. If they don't, the string isn't balanced, and the function returns `false`.

4. **Final Check**:
   - After processing the entire string, the stack should be empty if the string is balanced (because every opening parenthesis would have a matching closing parenthesis).
   - If the stack isn't empty, it means some opening parentheses don't have corresponding closing ones.

### Why It Works:

The use of the stack is key to the solution. The stack ensures that for every closing parenthesis we encounter, we are matching it against the most recent unmatched opening parenthesis (which is the essence of the problem). This naturally follows the LIFO order of the stack.

For example, consider the string "({[]})":

1. Encounter '(': push onto stack -> Stack: '('
2. Encounter '{': push onto stack -> Stack: '(', '{'
3. Encounter '[': push onto stack -> Stack: '(', '{', '['
4. Encounter ']': pop from stack and match with '[' -> Stack: '(', '{'
5. Encounter '}': pop from stack and match with '{' -> Stack: '('
6. Encounter ')': pop from stack and match with '(' -> Stack is empty

The stack is empty after processing the entire string, which means every opening parenthesis had a corresponding closing parenthesis in the correct order.

In conclusion, the code efficiently checks for balanced parentheses using the properties of the stack data structure. Its design ensures that both the order and type of parentheses are correct for a string to be considered valid.
 */
