import java.util.Stack;

public class Leetocode_84 {
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
Certainly! Let’s delve into the provided code, which aims to find the largest rectangle under a histogram, a classic problem in data structures and algorithms.

### Problem Understanding:

Given an array `heights[]`, where each element represents the height of a bar in a histogram, the objective is to find the largest rectangle formed by adjacent bars. Here, the width of each bar is assumed to be 1.

### Code Logic and Intuition:

The approach in the provided code utilizes a **stack data structure**, specifically to keep track of indices of the bars in the histogram. The main intuition here is to utilize the **stack** to identify the largest area that can be formed using the bars encountered so far in a left-to-right traversal.

### Step-by-Step Explanation:

1. **Initialization**:
   - `maxArea` is initialized to the smallest possible integer value to keep track of the maximum area found during the iteration.
   - A stack (`stack`) is initialized to keep track of the indices of the bars.

2. **Iteration**:
   - We iterate through the `heights[]` array and an additional one step beyond it (`i` from 0 to `heights.length`) to ensure that we compute any remaining rectangles in the stack after we’ve processed all the bars.
   
   - During each iteration, `x` is assigned the height of the current bar, except for the last iteration where it's assigned -1. This -1 will ensure that if any bars remain in the stack, they will be processed (since -1 is smaller than all valid bar heights).
   
3. **Processing Each Bar**:
   - While the stack is not empty and the current bar’s height (`x`) is less than the height of the bar indexed by the top of the stack (`heights[stack.peek()]`), we enter the loop to calculate the area of the rectangle formed using the bar at the top of the stack as height.
   
   - Inside the loop:
     - `currIndex`: Pop the stack and get the index of the bar.
     - `prevIndex`: If the stack is empty, assign -1; else, take the value from the top of the stack. This determines the left boundary of the rectangle.
     - `nextIndex`: It’s equal to `i`. This determines the right boundary of the rectangle.
     - `area`: Calculate the area using the formula \((nextIndex - prevIndex - 1) * heights[currIndex]\) and update `maxArea` if the new area is larger.

   - After exiting the loop, push `i` onto the stack. This action implies that we have considered `heights[i]` as a potential height for a future rectangle.

4. **Result**:
   - After the completion of the loop, `maxArea` holds the maximum rectangular area under the histogram.

### Why the Code Works:

This algorithm efficiently finds the largest rectangle by ensuring that for each bar x, it finds the largest rectangle that uses x as its height without having to explicitly check each possible rectangle. It smartly keeps track of active bars (ones that may be used to form a rectangle with a future bar) using the stack and pops them off when it’s clear they cannot form a larger rectangle.

### Time Complexity:

- The for loop runs `n+1` times (where `n` is the length of `heights`).
- Each index is pushed and popped from the stack exactly once.
  
  Hence, the time complexity is \(O(n)\).

### Space Complexity:

- The stack, in the worst case, might hold all `n` bar indices.

  Therefore, the space complexity is also \(O(n)\).

### Conclusion:

The algorithm is quite efficient, utilizing a linear time complexity and a smart approach to minimizing the number of rectangles it checks by strategically choosing only those that could potentially be a part of a larger rectangle. The usage of the stack, particularly, aids in keeping track of indices in a way that facilitates identifying relevant bars and hence, the correct boundaries for the rectangles, ensuring that the largest one is identified by the time the iteration completes.
 */
