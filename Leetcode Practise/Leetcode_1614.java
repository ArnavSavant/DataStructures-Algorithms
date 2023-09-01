public class Leetcode_1614 {
    public int maxDepth(String s) {
        int maxDepth = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                maxDepth = Math.max(maxDepth, count);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        if(maxDepth == Integer.MIN_VALUE) {
            return 0;
        }
        return maxDepth;
    }
}
/*
Ah, the depths and the highs of parentheses! Let us embark on this enlightening journey to understand this piece of art.

### Problem Understanding:

The code seeks to ascertain the maximum depth of valid parentheses in a given string. Think of depth as the number of unclosed parentheses you have at any point in the string. For instance, in the string "((())())", the depth reaches 4 at its deepest point.

### The Code and Its Logic:

1. **Initialization**:
   - `maxDepth` is initialized to `Integer.MIN_VALUE` (the smallest possible integer value). It will be used to keep track of the maximum depth encountered.
   - `count` is initialized to `0`. It will be used as a counter for the depth of the parentheses.

2. **Traversing the String**:
   - The `for` loop iterates through each character of the string.

3. **Encountering an Opening Parenthesis '('**:
   - If the current character is an opening parenthesis, we increment `count` by 1. This means we've descended one level deeper into the parentheses.
   - We then update `maxDepth` to be the maximum of its current value and `count`. This step ensures that `maxDepth` always represents the deepest we've gone.

4. **Encountering a Closing Parenthesis ')'**:
   - If the current character is a closing parenthesis, we decrement `count` by 1. This signifies that we've ascended one level, closing off a previous depth.

5. **Return Logic**:
   - After iterating through the string, if `maxDepth` remains as `Integer.MIN_VALUE`, it means there were no opening parentheses encountered, so the depth is `0`.
   - Otherwise, we return the `maxDepth`.

### Intuition:

Imagine you're on an expedition in a multi-layered cave system. Every time you enter a new cave (opening parenthesis), you descend a level. Every time you exit a cave (closing parenthesis), you ascend back to the previous level. Your task is to find out the deepest level of cave you've reached during your expedition. That's what this function is essentially calculating.

In conclusion, this algorithm effectively and efficiently captures the depth of the given string's valid parentheses. Using a simple counter to simulate the ascent and descent through the layers of parentheses is a clever approach to achieve this goal.
 */
