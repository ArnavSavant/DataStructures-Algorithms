public class PaintersPartitions {
    public int findMinimumTime(int[] boards, int k) {
        int low = findMax(boards);
        int high = findSum(boards);
        int minTime = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            int noOfPainters = findNoOfPainters(boards, mid);
            if (noOfPainters <= k) {
                high = mid - 1;
                minTime = Math.min(minTime, mid);
            } else {
                low = mid + 1;
            }
        }
        return minTime;
    }

    private int findNoOfPainters(int[] boards, int time) {
        int noOfPainters = 0;
        int timeUsed = 0;
        for (int i = 0; i < boards.length; i++) {
            if (timeUsed + boards[i] <= time) {
                timeUsed = timeUsed + boards[i];
            } else {
                noOfPainters++;
                timeUsed = boards[i];
            }
        }
        noOfPainters++;
        return noOfPainters;
    }

    private int findMax(int[] boards) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < boards.length; i++) {
            max = Math.max(max, boards[i]);
        }
        return max;
    }

    private int findSum(int[] boards) {
        int sum = 0;
        for (int i = 0; i < boards.length; i++) {
            sum += boards[i];
        }
        return sum;
    }
}

/*
Certainly, Professor ChatGPT is here to enlighten! The provided code is a solution to a classic optimization problem often known as **The Painter's Partition Problem**. Let's dive deep into the explanation:

### **Problem Statement**:
Given an array (representing lengths of boards) and an integer `k` (number of painters), find the minimum time required to paint all the boards under the constraint that any painter will only paint contiguous boards. The time taken by a painter to paint a board is equal to its length. 

### **Understanding and Logic**:

1. **Intuition**:
   The problem revolves around the idea of dividing work (i.e., the boards) among `k` painters such that we minimize the maximum time taken by any painter (since all painters work simultaneously).

2. **Boundaries**:
   - **Lower Bound (`low`)**: The minimum time taken will be when the painter paints the board with the maximum length, hence `low` is initialized with the maximum length of any board.
   - **Upper Bound (`high`)**: The maximum time taken will be when only one painter paints all the boards, so `high` is initialized with the sum of lengths of all boards.

3. **Binary Search for Optimization**:
   - The code leverages binary search on the "answer space" to optimize the time. Instead of searching for a specific element in an array, we are searching for the optimal (minimum) time within our defined `low` and `high` boundaries.
   - The midpoint (`mid`) of the current search space represents a candidate time.
   - We then determine how many painters would be required if we constrain them to painting for at most `mid` units of time.

4. **Determining Number of Painters**:
   - `findNoOfPainters` determines the number of painters needed for a given maximum allowable time (`mid`).
   - This is done by iterating through the boards and accumulating their lengths until the sum becomes more than `mid`, at which point we increment our painter count, and reset our accumulator. 
   - We're essentially assigning boards to painters until a painter's allotment exceeds `mid`, then we move to the next painter.

5. **Binary Search Update**:
   - If the number of painters required (`noOfPainters`) is less than or equal to `k`, it indicates that it's possible to paint the boards within time `mid`. Since we're looking for the minimum time, we should reduce our search space to `[low, mid-1]` to explore if a smaller time might work.
   - If the number of painters required is more than `k`, it indicates that we've been too optimistic with our time estimate. The time (`mid`) is too short to paint all the boards with only `k` painters. Hence, we should increase our lower boundary, making our new search space `[mid+1, high]`.

6. **Final Answer**:
   - The goal is to find the minimum maximum time taken by a painter. Hence, every time we find a feasible time (`mid`), we check if it's the smallest we've found so far.

### **Why It Works?**:
- The monotonic nature of the problem (if `k` painters can paint the boards in time `t`, then they can also do so in `t+1, t+2, ...`) allows us to apply binary search.
- By iteratively checking how many painters are needed for different values of `mid` (which represents the maximum time), we effectively search for the lowest value of `mid` where the number of painters required is `<= k`.
- As with most optimization problems, it's about balancing resources. If we have too few painters for a short time, the work can't be done. As the time increases, fewer painters are needed. We want to find that sweet spot where the time is minimized and the painter count does not exceed `k`.

In essence, this problem is a brilliant mix of partitioning and optimization, combined with the efficiency of binary search, to deliver a time-efficient solution.
 */