public class Leetcode_42 {
    public int trap(int[] heights) {
        int tappedWater = 0;
        int left = 0;
        int right = heights.length - 1;
        int leftMax = heights[left];
        int rightMax = heights[right];
        while (left <= right) {
            if (heights[left] <= heights[right]) {
                leftMax = Math.max(leftMax, heights[left]);
                tappedWater = tappedWater + (leftMax - heights[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, heights[right]);
                tappedWater = tappedWater + (rightMax - heights[right]);
                right--;
            }
        }
        return tappedWater;
    }
}

/*
Certainly! This problem and the given code is a popular solution to the "Trapping Rain Water" problem. The problem statement is to compute how much water can be trapped between the blocks, given an array where each element represents a block's height.

Here's the intuition, explanation of the code, and its logic:

**Intuition**:
The trapped water at any index `i` is determined by the minimum of the maximum height on its left and the maximum height on its right minus the height of the current block. If you think about it, for a block to hold water, it needs a taller block both to its left and its right side.

**Code Walkthrough**:

1. **Initialization**:
   ```java
   int tappedWater = 0;
   int left = 0;
   int right = heights.length - 1;
   int leftMax = heights[left];
   int rightMax = heights[right];
   ```
   Here we initialize two pointers, `left` and `right`, to the start and end of the `heights` array, respectively. `leftMax` keeps track of the maximum height seen from the left side, and `rightMax` keeps track of the maximum height seen from the right side. The variable `tappedWater` will store the result.

2. **Traversal**:
   ```java
   while (left <= right) {
   ```
   We traverse the heights using a two-pointer approach. We process from both ends of the array towards the center.

3. **Processing the left side**:
   ```java
   if (heights[left] <= heights[right]) {
      leftMax = Math.max(leftMax, heights[left]);
      tappedWater = tappedWater + (leftMax - heights[left]);
      left++;
   }
   ```
   If the height at `left` is less than or equal to the height at `right`, then we process the left side. The logic here is that since the height on the right side is taller, the water trapping on the left side is determined by `leftMax` (the tallest block we've seen so far from the left). We then update the `leftMax` to be the maximum of the current `leftMax` and the current height, and add the trapped water (which is `leftMax - heights[left]`). Finally, we move the left pointer to the right.

4. **Processing the right side**:
   ```java
   else {
      rightMax = Math.max(rightMax, heights[right]);
      tappedWater = tappedWater + (rightMax - heights[right]);
      right--;
   }
   ```
   Similarly, if the height at `right` is taller, we process the right side. We update the `rightMax` and add the trapped water which is `rightMax - heights[right]`. Then we move the right pointer to the left.

5. **Return the result**:
   ```java
   return tappedWater;
   ```

**Why does this code work?**

The main principle is to understand that, for any index `i`, the water trapped is determined by the minimum of the tallest block on its left and the tallest block on its right. The two-pointer approach efficiently calculates this without having to iterate for each index. Whenever we process from the left or the right, we're essentially saying "this is the tallest block we've seen from this direction so far, and it'll determine how much water this current block can trap."

In conclusion, this two-pointer approach avoids the need to compute the left and right maximums for every index individually, resulting in a time complexity of O(n) and a space complexity of O(1).
 */