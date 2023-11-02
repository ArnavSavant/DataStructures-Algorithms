import java.util.Arrays;
import java.util.Stack;

public class Leetcode_85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int heights[] = new int[col];
        int maxArea = Integer.MIN_VALUE;
        Arrays.fill(heights, 0);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= heights.length; i++) {
            int x = (i == heights.length) ? -1 : heights[i];
            int area = 0;
            while (!stack.isEmpty() && heights[stack.peek()] > x) {
                int currIndex = stack.pop();
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                int nextIndex = i;
                area = (nextIndex - prevIndex - 1) * heights[currIndex];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
/*
### Problem Statement:
Given a 2D binary matrix filled with 0's and 1's, the task is to find the largest rectangle containing only 1's and return its area.

### Code Explanation:

The provided Java code is an efficient solution to solve this problem using a dynamic programming approach along with a stack data structure. Let's go through the code step by step to understand the logic and intuition behind it.

### Part 1: Constructing the Height Array

The first function `maximalRectangle(char[][] matrix)` iterates through the rows of the `matrix` and maintains an array named `heights` to keep track of the consecutive '1's from the top at each column. If `matrix[i][j]` is '1', `heights[j]` is incremented by 1, else it is reset to 0.

```java
for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
        if (matrix[i][j] == '1') {
            heights[j] = heights[j] + 1;
        } else {
            heights[j] = 0;
        }
    }
    maxArea = Math.max(maxArea, largestRectangleArea(heights));
}
```

This `heights` array essentially stores the height of the histogram which can be formed by the consecutive '1's at each column. After computing the `heights` array for each row, the function `largestRectangleArea(heights)` is called to find the area of the largest rectangle that can be formed by the histogram defined by `heights`.

### Part 2: Finding the Largest Rectangle in Histogram

The second function `largestRectangleArea(int[] heights)` employs a stack to efficiently find the largest rectangle under a histogram. Here’s how it works:

```java
Stack<Integer> stack = new Stack<Integer>();
for (int i = 0; i <= heights.length; i++) {
    int x = (i == heights.length) ? -1 : heights[i];
    int area = 0;
    while (!stack.isEmpty() && heights[stack.peek()] > x) {
        int currIndex = stack.pop();
        int prevIndex = stack.isEmpty() ? -1 : stack.peek();
        int nextIndex = i;
        area = (nextIndex - prevIndex - 1) * heights[currIndex];
        maxArea = Math.max(maxArea, area);
    }
    stack.push(i);
}
```

- The stack stores indices from the `heights` array and ensures that the heights of the bars in `heights` indexed by the stack elements are always in increasing order.
- For every bar, we pop elements (indices) from the stack until we find a bar of smaller height. For every popped bar, we calculate the area with the popped bar height as the smallest bar and update the `maxArea`.
- We calculate the width of the rectangle using the difference between the current index and the index of the last remaining element in the stack subtracted by 1 (`nextIndex - prevIndex - 1`).
- After calculating the area of the rectangle with the current popped stack element as the smallest bar, we update our maximum area (`maxArea = Math.max(maxArea, area)`).

### Time Complexity:

- Constructing the `heights` array for each row takes \(O(\text{row} \times \text{col})\).
- Finding the largest rectangle in a histogram of length 'n' takes \(O(n)\).
- So, the overall time complexity of the algorithm is \(O(\text{row} \times \text{col}) + \text{row} \times O(\text{col})\) = \(O(\text{row} \times \text{col})\).

### Space Complexity:

- The `heights` array takes \(O(\text{col})\) space.
- The stack in `largestRectangleArea()` also takes \(O(\text{col})\) space in the worst case.
- Therefore, the space complexity of the algorithm is \(O(\text{col})\).

### Conclusion:

This approach efficiently solves the problem by converting it into a well-known problem (Largest Rectangle in Histogram) and utilizes a stack to keep track of the bars in the histogram to calculate the maximal rectangle area in an optimized way. By iterating through the matrix row by row and applying this strategy, we are able to find the largest rectangle containing only 1's in the binary matrix.
 */