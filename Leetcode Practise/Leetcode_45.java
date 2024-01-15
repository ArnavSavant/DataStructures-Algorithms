public class Leetcode_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int minimumJumps = 1;
        while (right < n) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            if (farthest >= n - 1) {
                break;
            }
            left = right + 1;
            right = farthest;
            minimumJumps++;
        }
        return minimumJumps;
    }
}
/*
This Java method `jump(int[] nums)` is designed to solve a classic problem in dynamic programming and greedy algorithms, often referred to as the "jump game". The goal is to find the minimum number of jumps needed to reach the end of an array, where each element in the array represents the maximum jump length at that position.

Let's analyze the code:

### 1. **Code Explanation**

- **Initialization**: 
  - `n`: Length of the `nums` array.
  - `left` and `right`: Variables to keep track of the current range of positions that can be reached with the current number of jumps.
  - `minimumJumps`: Stores the minimum number of jumps needed to reach the end. Starts at 1 because a jump is required to leave the first position.

- **Main Loop**: 
  - The loop continues until the rightmost reachable position is less than `n`.
  - `farthest`: Tracks the farthest position that can be reached from the current range (`left` to `right`).

- **Within the Loop**: 
  - Iterates from `left` to `right`, updating `farthest` with the maximum distance that can be reached from these positions.
  - If `farthest` reaches or exceeds the last index (`n - 1`), the loop breaks, as the end has been reached.
  - Updates `left` and `right` for the next set of jumps and increments `minimumJumps`.

### 2. **Logic of the Code**
The logic is based on the greedy approach. The method calculates the farthest point that can be reached with the current number of jumps and then updates the range of the next jump based on this information. This way, it always makes the optimal choice at each step to reach the end with the minimum jumps.

### 3. **Developing Intuition and Identifying Correct Approaches**
- **Recognizing the Problem Type**: This problem is a variant of the greedy algorithm where you make the locally optimal choice at each step.
- **Choosing the Data Structure**: An array is used, and no additional complex data structures are needed.
- **Algorithm**: The method uses a greedy approach by always jumping to the position that allows the farthest travel in the next step.

### 4. **Why the Code Works**
The code efficiently finds the minimum jumps by always choosing the next jump that provides the maximum reach. This strategy ensures that each jump is optimal, leading to the minimum number of jumps to reach the end.

### 5. **Time and Space Complexity Calculations**
- **Time Complexity**: 
  - The main part of the function is a single loop that goes through the array at most twice (each element is considered in `left` to `right`, and then possibly as part of `farthest`). Therefore, the time complexity is O(n).
- **Space Complexity**:
  - The space complexity is O(1) as the method only uses a fixed number of variables and does not depend on the size of the input array.

In summary, this method is a textbook example of applying a greedy algorithm to solve a problem efficiently by making the locally optimal choice at each step.
 */