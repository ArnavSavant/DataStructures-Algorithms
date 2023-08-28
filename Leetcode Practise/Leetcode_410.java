public class Leetcode_410 {
    public int splitArray(int[] nums, int k) {
        int low = findMax(nums);
        int high = findSum(nums);
        int minSum = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            int splits = findSplits(nums, mid);
            if (splits <= k) {
                minSum = Math.min(mid, minSum);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minSum;
    }

    private int findSplits(int[] nums, int sum) {
        int currSum = 0;
        int split = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currSum + nums[i] <= sum) {
                currSum = currSum + nums[i];
            } else {
                split++;
                currSum = nums[i];
            }
        }
        split++;
        return split;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    private int findSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
/*
 All right, Professor ChatGPT at your service! Let's dissect this piece of code. It looks like a solution to a classic problem called the **Split Array Largest Sum**.

### **Problem Statement**:
Given an array of non-negative integers `nums` and an integer `k`, divide this array into `k` non-empty subsets to minimize the maximum sum among these subsets.

### **Understanding the Code**:

1. **Boundaries**:
    - The code starts by determining two crucial boundaries: 
        - `low` as the maximum individual element in the array. This is because no matter how we split the array, the maximum sum in a subset cannot be less than the maximum single element.
        - `high` as the sum of all the elements. This represents the scenario where we only have one subset containing all elements.

    The solution to the problem lies between these two boundaries.

2. **Binary Search**:
    The `while` loop is the binary search process, honing in on the potential solution. `mid` represents a candidate for the maximum sum across the subsets. If we can achieve the split with a maximum sum less than or equal to `mid`, then `mid` is a feasible candidate.

3. **Feasibility Check - findSplits()**:
    This function counts the number of splits required to divide the array such that the sum of elements in each subset does not exceed `sum` (which is `mid` in our main function). If the sum exceeds, we reset the `currSum` and increase the `split` count, signaling the start of a new subset.

4. **Binary Search Update**:
    If `splits <= k`, it means that `mid` is a feasible solution since we can split the array into `k` or fewer subsets without any subset sum exceeding `mid`. But we can potentially lower `mid`, so we adjust `high`. Else, `mid` is too small, so we adjust `low`.

5. **Final Answer**:
    The goal is to minimize the maximum sum. Thus, during our feasible checks, we update `minSum` whenever we find a feasible `mid` that is less than our current best `minSum`.

### **Intuition**:

Imagine you're trying to fill water into `k` buckets using water packets of varying quantities (the array elements). You want to make sure that no bucket overflows, but at the same time, you want to keep the water level (sum of the packets) in the fullest bucket as low as possible to ensure fairness.

1. **Worst Case**:
    You put all water packets into a single bucket. This bucket will have the most water (sum of all packets). But that's not what we want, especially if k > 1.

2. **Best Case**:
    The bucket with the most water has only the largest water packet. But this isn't always feasible since we might have more packets than buckets.

Our aim lies between these two cases. We are guessing (using `mid`) how full the most filled bucket will be and checking if that guess allows us to use all the water packets in `k` buckets.

### **Why Binary Search?**:
Binary search is applied because the relationship between the `mid` value and the resulting number of splits is monotonic. If a certain `mid` results in too many splits, a greater value of `mid` will either result in the same number of splits or fewer. This monotonic property is crucial for binary search to work.

In essence, this problem beautifully encapsulates the concept of **binary search on the answer space**. Instead of searching for a particular element in a list, we're searching for the most optimal maximum sum for our subsets within a defined boundary, leveraging the efficiency of binary search to narrow down our answer.
 */
