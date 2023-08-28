public class Leetcode_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = Integer.MAX_VALUE;
        int low = 1;
        int high = findMax(nums);
        while (low <= high) {
            int mid = high - (high - low) / 2;
            int sum = sum(mid, nums);
            if (sum <= threshold) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public int sum(int x, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + (int) Math.ceil(1.0 * arr[i] / x);
        }
        return sum;
    }
}

/*
Certainly! This code aims to find the smallest divisor such that the division of each number in the given array (`nums`) by this divisor and taking their ceiling values, results in a sum that is less than or equal to the given threshold.

Let's break down the code and its logic:

### 1. Purpose:

Given an array `nums` and an integer `threshold`, you want to determine the smallest integer `x` such that:
    
    Math.ceil(nums[0]/x) + Math.ceil(nums[1]/x) + ... + Math.ceil(nums[nums.length-1]/x) <= threshold

### 2. Method:

A binary search approach is used to find the smallest possible divisor.

### 3. Details:

#### a. `findMax` method:

It simply finds the maximum element of the input array `arr`.
  
    - Iterate through each element in `arr`.
    - Keep track of the maximum value found so far.
    - Return the maximum value.

#### b. `sum` method:

Given a divisor `x` and an array `arr`, this method calculates the sum of the ceiling values of each element in the array divided by `x`.

    - Iterate through each element in `arr`.
    - For each element, divide it by `x` and round up (ceiling).
    - Add the result to a running sum.
    - Return the total sum.

#### c. `smallestDivisor` method:

This is the primary method that finds the desired divisor using binary search.

    - Start with the possible divisor range: `low` is 1 (because dividing by any number smaller than 1 would not make sense) and `high` is the maximum number in the `nums` array. The rationale for setting the maximum value of `high` to the maximum value in the array is that dividing the maximum number in the array by 1 (itself) would produce the largest possible ceiling sum, and you won't need a divisor greater than this maximum value.

    - The binary search process:
        1. Compute the mid-value: `mid = high - (high - low) / 2` (This is equivalent to `(high + low) / 2` but is sometimes written this way to avoid overflow).
        
        2. Compute the sum of the elements in the `nums` array when divided by this mid-value using the `sum` method.
        
        3. If this sum is less than or equal to the `threshold`, then `mid` is a potential answer. You'll update `ans` with the minimum of the current `ans` and `mid` and search in the lower half by setting `high` to `mid - 1`.
        
        4. If the sum is greater than the threshold, it means that `mid` is too small a divisor and would result in a sum exceeding the threshold. Hence, you need to search in the upper half by setting `low` to `mid + 1`.

    - The loop continues until `low` exceeds `high`, ensuring all possible divisor values have been checked.

    - The method returns the smallest divisor (`ans`) found during the binary search.

### 4. Intuition:

The intuition here is that:

- If a larger divisor is chosen, the resulting sum becomes smaller. 
- If a smaller divisor is chosen, the resulting sum becomes larger.

The problem is essentially transformed into a monotonic function. The binary search exploits this property by trying to find the point (divisor) where the sum of the ceiling values just crosses the threshold.
 */
