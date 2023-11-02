import java.util.Stack;

public class Leetcode_844 {
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private String processString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char x : stack) {
            sb.append(x);
        }
        return sb.toString();
    }
}
/*
### Problem Understanding:

The problem statement here revolves around string manipulation. Given two strings, `s` and `t`, which might contain '#' characters (considered as backspace), the goal is to determine whether they are equal when processed. A character followed by a '#' should be omitted and '#' itself should also be omitted. Therefore, `s = "a#c"` should be treated as `"c"` after processing.

### Method Explanation:

In the provided Java code, there are two primary methods:
1. `boolean backspaceCompare(String s, String t)`: This method checks if the processed versions of `s` and `t` are equal.
2. `String processString(String s)`: This helper method processes a string, implementing the backspace character '#' functionality, and returns the final processed string.

### Code Intuition and Logic:

Let's delve into the `processString` method which forms the core logic of the solution.

The method employs a stack data structure, which is proficient at handling problems involving reversals or where the processing depends on the most recently seen elements. Here, if a character is a '#', it signifies a backspace, so we must remove the most recently added character, which can be done in \(O(1)\) time complexity with a stack. If it's any other character, it's added to the stack.

**Pseudocode of processString:**
```
for each character, c in String s:
    if c equals '#':
        if stack is not empty:
            pop element from stack
    else:
        push c into stack
convert stack to string and return
```

In the for-loop:
- If `c` is '#', and the stack isn’t empty, an element is popped from the stack (reverting the most recent character).
- If `c` is not '#', it’s pushed onto the stack.

The stack thus contains the processed string, which is converted to a `String` type using `StringBuilder` and returned.

### Why This Works:

This approach effectively mimics the behavior of a text editor processing backspaces. By traversing the string and manipulating the stack accordingly, we handle backspaces in \(O(1)\) time, ensuring an efficient solution. By using a stack, we ensure that characters are removed in the correct, LIFO (Last In, First Out) order.

### Complexity Analysis:

**Time Complexity:**
- `processString`: \(O(n)\) for iteration through the string, where \(n\) is the length of the string.
- `backspaceCompare`: Calls `processString` twice, so \(O(n + m)\), where \(n, m\) are the lengths of strings `s` and `t`.

**Space Complexity:**
- `processString`: In worst-case, no '#' appears, so every character is stored in the stack. Thus, space complexity is \(O(n)\).
- `backspaceCompare`: Calls `processString` twice, but as the stacks are not used simultaneously, space complexity is also \(O(n + m)\), not \(2 \times (O(n + m))\).

### Additional Optimizations:

An in-place two-pointer approach can further optimize space to \(O(1)\). By traversing both strings from end to start and keeping track of backspaces, we can compare characters without additional data structures.

### Concluding Note:

The explained solution efficiently tackles the problem by employing a stack to handle backspaces, converting a seemingly complex string manipulation problem into a straightforward stack operation, and highlighting the utility of data structures in problem-solving. Understanding the underlying problem, recognizing suitable data structures, and discerning appropriate methods enable proficient problem-solving in algorithmic contexts.
 */
