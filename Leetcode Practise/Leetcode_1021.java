public class Leetcode_1021 {
    public String removeOuterParentheses(String s) {
        boolean isOpen = false;
        int count = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (isOpen) {
                    ans = ans + '(';
                    count++;
                } else {
                    isOpen = true;
                }
            } else if (s.charAt(i) == ')') {
                if (count > 0) {
                    ans = ans + ')';
                    count--;
                } else {
                    isOpen = false;
                }
            }
        }
        return ans;
    }
}

/*
 Ah, this is an intriguing piece of code that deals with the parsing of parentheses. Let's delve deep into its nuances.

### Problem Understanding:

The problem aims to remove the outermost parentheses of every primitive string in the given input string "s". 

A primitive string is a string that is non-empty, has balanced parentheses (every opening '(' has a closing ')'), and cannot be partitioned into two smaller primitive strings.

For example, if the input is `s = "(()())(())"`, the output should be `()()()`, because:
- The first set of outer parentheses encloses `()()`, which is itself a primitive string. So we remove the outermost parentheses, and we get `()()`.
- The second set of outer parentheses encloses `()`, which is a primitive string. So we remove the outermost parentheses, and we get `()`.

So combined, the output is `()()()`.

### Logic and Explanation:

1. **Variables:**
   - `isOpen`: This boolean variable is used to track if we've encountered the start of a primitive string.
   - `count`: Keeps track of the balance between opening and closing parentheses. This helps in identifying the end of a primitive string.
   - `ans`: This is our answer string where we'll store the final result.

2. **Traversing the Input String:**
   We loop through each character in the string `s`.

3. **Encountering '(' (opening parenthesis):**
   - If `isOpen` is `false`, it means we've just encountered the start of a primitive string. We don't add this parenthesis to our answer string as it's the outermost one.
   - If `isOpen` is `true`, it means we're within a primitive string, and we add this parenthesis to our result.

4. **Encountering ')' (closing parenthesis):**
   - If `count` is greater than `0`, it means we're still within a primitive string. We add this parenthesis to our result.
   - If `count` is `0`, it means we've just encountered the end of a primitive string. We don't add this parenthesis to our answer string.

### Intuition:

The intuition behind this code is to use a flag (`isOpen`) and a counter (`count`) to recognize the beginning and end of a primitive string.

The flag tells us if we're inside a primitive string or not. If we are inside, then every opening parenthesis (except the very first) contributes to the final answer. Similarly, every closing parenthesis (except the one that balances the very first opening parenthesis) contributes to the final answer.

The counter (`count`) keeps track of how "deep" we are within nested parentheses. This is important because it helps us determine when we've encountered the closing parenthesis that matches the very first opening parenthesis (i.e., the outermost parentheses).

By the end of our traversal, we'll have constructed a new string without any outer parentheses, as required.

### Conclusion:

This approach is efficient, elegant, and leverages the properties of balanced parentheses to identify and strip away the outermost layers. With a single pass through the string and constant-time operations for each character, this solution is very optimal and runs in O(n) time, where n is the length of the input string.
 */
