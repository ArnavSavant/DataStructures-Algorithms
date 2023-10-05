import java.util.Stack;

public class Leetcode_2104 {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        sum = sumOfMax(nums) + sumOfMin(nums);
        return sum;
    }

    public long sumOfMax(int[] nums) {
        long sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= nums.length; i++) {
            int x = (i == nums.length) ? Integer.MAX_VALUE : nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] <= x) {
                int currIndex = stack.pop();
                int prevGreaterIndex = stack.isEmpty() ? -1 : stack.peek();
                int nextGreaterIndex = i;
                sum = sum + (long)((nextGreaterIndex - currIndex + 1) * (currIndex - prevGreaterIndex + 1)) * nums[currIndex];
            }
            stack.push(i);
        }
        return sum;
    }

    public long sumOfMin(int[] nums) {
        long sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= nums.length; i++) {
            int x = (i == nums.length) ? Integer.MIN_VALUE : nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] > x) {
                int currIndex = stack.pop();
                int prevSmallerIndex = stack.isEmpty() ? -1 : stack.peek();
                int nextSmallerIndex = i;
                sum = sum + (long)((nextSmallerIndex - currIndex + 1) * (currIndex - prevSmallerIndex + 1)) * nums[currIndex];
            }
            stack.push(i);
        }
        return sum;
    }
}

/*
Alright, let's dive into this code. This implementation seeks to calculate the sum of the ranges (difference between maximum and minimum values) of all subarrays of a given array `nums`. The general approach to solve this utilizes the stack data structure, and the solution comprises three methods: `subArrayRanges(int[] nums)`, `sumOfMax(int[] nums)`, and `sumOfMin(int[] nums)`. Here’s a breakdown:

### `subArrayRanges(int[] nums)`

**Purpose**: Calculates the sum of all subarray ranges within `nums`.

**Logic**: It calls two methods - `sumOfMax(nums)` and `sumOfMin(nums)`, and returns their sum. The expectation here might be that `sumOfMax(nums)` calculates a certain cumulative value considering each element as a maximum in its possible subarrays, and `sumOfMin(nums)` does similarly considering each element as a minimum. Summing these two quantities yields the desired result.

### `sumOfMax(int[] nums)` and `sumOfMin(int[] nums)`

These two methods share a similar logic and structure, except with different comparison logic due to their different purposes.

**Purpose**: Each method calculates a cumulative value where every element of `nums` is considered as the maximum (`sumOfMax`) or minimum (`sumOfMin`) of all possible subarrays it belongs to.

**Logic**:
- **For Loop**: Iterates through each element in `nums` (plus an additional iteration via `i <= nums.length`).
- **Stack**: Utilized to keep track of indexes of elements in `nums`, aiding in efficiently finding the previous and next smaller (or larger) elements.
- **While Loop** (inside the for loop): Pops elements from the stack under certain conditions (related to whether they are smaller/larger than the current element). When popping an element, it calculates how many subarrays `nums[currIndex]` can be the maximum (or minimum) of and accumulates the multiplied value into `sum`.
- **Calculating Subarray Count**: `(nextIndex - currIndex + 1) * (currIndex - prevIndex + 1)` calculates the number of subarrays for which `nums[currIndex]` is the minimum or maximum, considering the distance to the next and previous smaller (or larger) elements.
- **Pushing Index**: The index `i` is pushed onto the stack, preserving the potential for the next larger (or smaller) element discovery.

### Why It Works & Complexity

**Why It Works**:
- **Count of Subarrays**: For each element, finding the count of subarrays it can be minimum or maximum of and accumulating its multiplied value gives a means to efficiently calculate the cumulative value for all elements.
- **Stack Utility**: The stack helps manage indexes in a way that allows efficient retrieval of the "next" and "previous" larger (or smaller) elements, critical for determining the subarray count.
- **Summing Values**: The final cumulative values, when summed, should provide the sum of all possible subarray ranges, assuming `sumOfMax` and `sumOfMin` accurately represent cumulative values where each element is treated as a max and min, respectively.

**Complexity**:
- **Time Complexity**: O(N), where N is the length of `nums`. Despite the nested loops, each element is pushed and popped from the stack exactly once, leading to linear complexity.
- **Space Complexity**: O(N), due to additional data structure (stack) utilization, which, in the worst case, might store all elements of `nums`.

### Caveats

Without an explicit problem statement or expected output, we need to be mindful of potential discrepancies between this explanation and the exact problem intent. Nonetheless, this analysis should give you a solid understanding of the provided code and its general operation.

If there are specific cases where it fails or behaves unexpectedly, further scrutiny and possible adjustment of the logic may be necessary.
 */