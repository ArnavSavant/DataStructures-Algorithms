import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 0;
        int high = stalls[n - 1];
        int ans = 0;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (canBePlaced(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canBePlaced(int[] stalls, int cows, int distance) {
        int count = 1;
        int last = stalls[0];
        for (int i = 1; i < stalls.length - 1; i++) {
            if ((stalls[i] - last) >= distance) {
                count++;
                last = stalls[i];
            }
            if(count==cows) {
                return true;
            }
        }
        return false;
    }
}

/*
 Of course! The code you've shared is a classic representation of solving the "Aggressive Cows" problem using the binary search. Let's dissect it step by step:

### **Problem Statement**:
Given a number of stalls (represented as integer positions) and a number of cows, the objective is to place the cows in the stalls such that the minimum distance between any two cows is maximized. 

### **High-Level Approach**:
Use binary search on the possible distances between cows, from the smallest possible distance (adjacent stalls) to the largest possible distance (distance between the first and last stall). For each distance (mid), check if it's possible to place all cows in the stalls with at least `mid` distance apart.

### **Code Breakdown**:

1. **Initialization**:
   ```java
   Arrays.sort(stalls);
   int n = stalls.length;
   int low = 0;
   int high = stalls[n - 1];
   int ans = 0;
   ```
   - **`Arrays.sort(stalls);`**: This ensures that the stalls are in increasing order, which is essential for the algorithm.
   - **`low` and `high`**: These are the boundaries for our binary search. `low` is initialized to 0 because it's the smallest possible distance. `high` is initialized to the maximum distance between the first and last stall.
   - **`ans`**: This stores the answer - the maximum possible minimum distance between cows.

2. **Binary Search**:
   ```java
   while (low <= high) {
       int mid = high - (high - low) / 2;
       ...
   }
   ```
   The loop runs as long as `low` is less than or equal to `high`. The value of `mid` is computed as the midpoint between `low` and `high`.

3. **Feasibility Check**:
   ```java
   if (canBePlaced(stalls, cows, mid)) {
       ans = mid;
       low = mid + 1;
   } else {
       high = mid - 1;
   }
   ```
   - **`canBePlaced(stalls, cows, mid)`**: This function checks if it's feasible to place the cows in the stalls such that the minimum distance between any two cows is at least `mid`.
   - If it's feasible (`canBePlaced` returns true), then it means we might be able to increase the distance further. Hence, we move `low` to `mid + 1`. We also update `ans` since `mid` is a feasible solution.
   - If it's not feasible, then we need to decrease the distance. Therefore, `high` is moved to `mid - 1`.

4. **Feasibility Function (canBePlaced)**:
   ```java
   private boolean canBePlaced(int[] stalls, int cows, int distance) {
       ...
   }
   ```
   This function checks if it's possible to place the given number of cows in the stalls such that the distance between any two cows is at least the given `distance`.

   - **Logic**: Start by placing the first cow in the first stall. For every subsequent stall, check if the distance between the current stall and the last stall where a cow was placed is at least `distance`. If yes, place a cow there and move on.
   
   - The loop ends either when all cows are placed or when we've gone through all stalls. If all cows are placed before or by the end of the loop, then it's feasible, and the function returns `true`. Otherwise, it returns `false`.

### **Intuition**:
The intuition behind this approach is the power of binary search to optimize the solution space. We know that the minimum distance will be between 0 and the maximum stall distance. By repeatedly halving the search space, we can quickly converge to the optimal solution. The binary search here is not directly used to find an element in an array but to optimize the solution space of possible distances. 

Remember, the essence of the problem is to balance two objectives: 
- Maximizing the minimum distance between cows
- Ensuring all cows are placed.

By iteratively testing possible distances (via binary search) and verifying their feasibility (using the `canBePlaced` function), we can find the optimal distance that satisfies both objectives.
 */