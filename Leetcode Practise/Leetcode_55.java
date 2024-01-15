public class Leetcode_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int currGoal = n - 1;
        for (int i = n - 2; i > 0; i--) {
            if (nums[i] + i >= currGoal) {
                currGoal = i;
            }
        }
        return currGoal == 0 ? true : false;
    }
}
/*
The Java method `canJump(int[] nums)` is designed to solve another variation of the jump game problem. This time, the goal is to determine whether it's possible to reach the last index of the array starting from the first index, given that each element in the array represents the maximum jump length from that position.

### 1. **Code Explanation**

- **Initialization**: 
  - `n`: Length of the `nums` array.
  - `currGoal`: Initially set to the last index of the array (`n - 1`). It represents the current target index that we are trying to reach.

- **Backward Iteration**:
  - The loop starts from the second last element (`n - 2`) and iterates backward.
  - In each iteration, it checks if the current position `i` can reach or surpass `currGoal`. 
  - If it can, `currGoal` is updated to be the current index `i`.

- **Return Statement**: 
  - The method returns `true` if `currGoal` is 0 at the end of the loop, meaning the first index can reach the last index. Otherwise, it returns `false`.

### 2. **Logic of the Code**
The key idea is to work backward from the last index. By updating the `currGoal` to the leftmost index from which the current `currGoal` can be reached, the method checks if it's possible to "jump" all the way back to the start. If the start can reach the first `currGoal`, the end is reachable from the start.

### 3. **Developing Intuition and Identifying Correct Approaches**
- **Recognizing the Problem Type**: This problem fits the greedy algorithm paradigm, where you make decisions based on the current state without considering the future.
- **Algorithm Choice**: The method uses a backward iteration approach, which is effective for problems where reaching the end goal can be deduced by working backward from it.

### 4. **Why the Code Works**
- **Backward Checking**: By checking from the end of the array towards the start, the method efficiently determines whether earlier steps can contribute to reaching the end.
- **Simplifying the Problem**: The method reduces the problem to a series of smaller decisions: can this index reach the current goal?

### 5. **Time and Space Complexity Calculations**
- **Time Complexity**: 
  - The function iterates once through the array backward, so the time complexity is O(n).
- **Space Complexity**:
  - The space complexity is O(1), as it only uses a few variables and no additional data structures dependent on the input size.

This approach is a clean and efficient way to solve the problem, utilizing the principles of greedy algorithms and working backward from the goal.
 */