import java.util.Stack;

public class Leetcode_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int x : asteroids) {
            boolean flag = true;
            while (stack.size() > 0 && stack.peek() > 0 && x < 0) {
                int y = stack.pop();
                if (Math.abs(y) > Math.abs(x)) {
                    x = y;
                } else if (x == -y) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stack.push(x);
            }
        }
        int ans[] = new int[stack.size()];
        while (stack.size() > 0) {
            ans[stack.size() - 1] = stack.pop();
        }
        return ans;
    }
}
/*
Certainly. Let's break down the provided code for the "Asteroid Collisions" problem.

### Problem Context:

Given an array of integers, each integer represents an asteroid. The absolute value of the integer indicates the size of the asteroid, while the sign of the integer determines its direction:
- Positive (+) → Moving to the right.
- Negative (-) → Moving to the left.

If two asteroids collide (one moving to the right and the other to the left), the smaller one (in terms of absolute value) explodes. If they are of equal size, both explode. Asteroids moving in the same direction never collide.

### Code Breakdown:

1. **Stack Initialization**: A stack is initialized to keep track of the asteroids. This stack will help in determining which asteroids survive and which ones explode.

    ```java
    Stack<Integer> stack = new Stack<Integer>();
    ```

2. **Iteration Over Asteroids**: The code then iterates over each asteroid in the given array.

    ```java
    for (int x : asteroids) {
    ```

3. **Asteroid Collision Check**: Inside the loop, if the top of the stack has an asteroid moving to the right (positive value) and the current asteroid `x` is moving to the left (negative value), then a collision is imminent.

    ```java
    while (stack.size() > 0 && stack.peek() > 0 && x < 0) {
    ```

4. **Collision Resolution**: 
    - Pop the top asteroid (`y`) from the stack. 
    - Compare the absolute sizes of `x` and `y`.
        - If `y` is larger, the current asteroid `x` is updated with the value of `y`.
        - If both `x` and `y` are of the same size but in opposite directions, set `flag` to false, indicating that the current asteroid `x` will not survive.

    ```java
    int y = stack.pop();
    if (Math.abs(y) > Math.abs(x)) {
        x = y;
    } else if (x == -y) {
        flag = false;
        break;
    }
    ```

5. **Pushing Surviving Asteroid**: If the `flag` is still true (indicating the current asteroid survived), push the asteroid `x` onto the stack.

    ```java
    if (flag) {
        stack.push(x);
    }
    ```

6. **Populate Result Array**: After processing all asteroids, populate the result array `ans` with the surviving asteroids from the stack.

    ```java
    int ans[] = new int[stack.size()];
    while (stack.size() > 0) {
        ans[stack.size() - 1] = stack.pop();
    }
    ```

### Why it Works:

The stack efficiently tracks the state of asteroids that have not yet been exploded by any subsequent asteroid. By comparing only with the top of the stack, the algorithm avoids unnecessary comparisons with asteroids that would never collide with the current asteroid. 

The process ensures that by the end of the loop, only the surviving asteroids (those which didn't explode) remain in the stack. The stack's order represents the order of asteroids as they appear in the final state.

### Time and Space Complexity:

**Time Complexity**: O(n), where n is the number of asteroids. Each asteroid is pushed onto the stack once, and in the worst case, we might pop each asteroid once as well.

**Space Complexity**: O(n) for the stack, in the worst case scenario when all asteroids are moving in the same direction.

In conclusion, the given code uses a stack data structure to efficiently determine the outcome after all possible asteroid collisions, achieving a linear time and space solution.  
 */
