import java.util.Stack;

public class Leetcode_402 {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || num.charAt(i) != '0') {
                stack.push(num.charAt(i));
            }
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (char x : stack) {
            sb.append(x);
        }

        return sb.toString();
    }
}
/*
 Greetings, students of the Data Structure and Algorithms Institute! Today, let’s delve into the logic, intuition, and complexity of a particular code snippet that addresses the problem: "Remove K digits from a non-negative integer to get the smallest possible integer."

**Problem Statement:**
Given a string `num` representing a non-negative integer and an integer `k`, return the smallest possible integer after removing `k` digits from `num`.

**Intuition:**
The intuition behind the solution is straightforward: To obtain the smallest possible number, we should remove the larger digits that appear before the smaller digits. For example, in the number `542`, we should remove `5` because `4` (which is smaller and to the right of `5`) will have a lesser place value if `5` is removed.

**Approach Explanation:**
Let’s break down the provided code:

```java
public String removeKdigits(String num, int k) {
```
We define a function named `removeKdigits` which takes a `String num` and an `int k` as arguments.

```java
        if (k == num.length()) {
            return "0";
        }
```
If `k` is equal to the length of `num`, we should remove all digits, so we return "0".

```java
        Stack<Character> stack = new Stack<Character>();
```
We use a `Stack` to keep track of the digits we have considered so far.

```java
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
```
For each character `i` in `num`, we check if it is smaller than the top element of the stack (i.e., if removing the previous number would result in a smaller number) and whether we can still remove digits (`k > 0`). If both conditions are true, we `pop` elements from the stack and decrement `k`.

```java
            if (!stack.isEmpty() || num.charAt(i) != '0') {
                stack.push(num.charAt(i));
            }
        }
```
We push `num.charAt(i)` onto the stack unless the stack is empty and this digit is a `0` (which would result in a leading zero in the final number).

```java
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
```
After considering all digits in `num`, if `k > 0`, we pop `k` additional elements from the stack.

```java
        if (stack.isEmpty()) {
            return "0";
        }
```
If the stack is empty, all digits have been removed, so we return "0".

```java
        StringBuilder sb = new StringBuilder();
        for (char x : stack) {
            sb.append(x);
        }
        return sb.toString();
    }
```
Finally, we use a `StringBuilder` to build and return the final string from the characters remaining in the stack.

**Complexity Analysis:**
- **Time Complexity**: O(N), where N is the length of `num`. We process each digit in `num` once.
  
- **Space Complexity**: O(N), due to the additional space utilized by the stack.

**Why does this work?**
We're essentially employing a Greedy Algorithm here, where we prioritize immediate optimization – i.e., we're always removing the largest preceding digit whenever a smaller digit is found. This method ensures the resulting number is the smallest possible after `k` removals.

This code gives us a real-world application of stacks and demonstrates the practicality of greedy algorithms in problem-solving. Do explore variations of this problem for practice and let's reconvene in the next class to dive into more fascinating problems and solutions!
 */
