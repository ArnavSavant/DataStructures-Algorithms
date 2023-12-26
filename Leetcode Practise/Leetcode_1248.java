public class Leetcode_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }

    public int atmost(int nums[], int k) {
        int i = 0;
        int j = 0;
        int countOfAtmostK = 0;
        int countOfOddNUmbers = 0;
        while (j < nums.length) {
            if (nums[j] % 2 == 1) {
                countOfOddNUmbers++;
            }
            while (i <= j && countOfOddNUmbers > k) {
                if (nums[i] % 2 == 1) {
                    countOfOddNUmbers--;
                }
                i++;
            }
            countOfAtmostK = countOfAtmostK + (j - i + 1);
            j++;
        }
        return countOfAtmostK;
    }
}
/*
Let's delve into this interesting piece of code.

**Objective**:
The given code aims to find the number of subarrays in the provided array `nums` that contain exactly `k` odd numbers.

**Intuition**:
If you can figure out how many subarrays contain at most `k` odd numbers (`atmost(nums, k)`) and how many subarrays contain at most `k-1` odd numbers (`atmost(nums, k-1)`), then the difference between these two counts will give you the number of subarrays that contain exactly `k` odd numbers. Why? Because subarrays that contain exactly `k` odd numbers are included in `atmost(nums, k)` but not in `atmost(nums, k-1)`.

**Detailed Breakdown**:

**1. numberOfSubarrays**:
This method computes the number of subarrays with exactly `k` odd numbers by subtracting the number of subarrays with at most `k-1` odd numbers from the number of subarrays with at most `k` odd numbers.

**2. atmost**:
This method calculates the number of subarrays that contain at most `k` odd numbers.

- Two pointers, `i` and `j`, are used to maintain a sliding window.
  
- We start by expanding our window to the right (increasing `j`). If the current number (`nums[j]`) is odd, we increase the `countOfOddNUmbers`.
  
- If the count of odd numbers in the current window (`countOfOddNUmbers`) exceeds `k`, we move our left pointer `i` to the right until the count becomes less than or equal to `k`, decrementing `countOfOddNUmbers` for each odd number we skip.
  
- For any position `j`, the number of subarrays that end at `j` and contain at most `k` odd numbers is given by `(j - i + 1)`. This is because you can select any start position from `i` to `j` to form such a subarray. We accumulate this count in `countOfAtmostK`.

**Why This Works**:
- The inner while loop ensures that our current sliding window (from `i` to `j`) always contains at most `k` odd numbers.
  
- For each such window, there are multiple subarrays ending at `j` that contain at most `k` odd numbers. This count is given by `(j - i + 1)`.
  
- By calculating `atmost(nums, k)` and `atmost(nums, k-1)` and subtracting the two, we're effectively isolating the subarrays that contain exactly `k` odd numbers.

**Time Complexity**:
Both `i` and `j` traverse the array once. The inner loop with `i` ensures that each element of the array is processed at most twice (once by `j` and once by `i`). Thus, the time complexity of the `atmost` function is O(n), where n is the length of `nums`. Since `numberOfSubarrays` calls `atmost` twice, its time complexity remains O(n).

In essence, the provided solution uses a sliding window technique to efficiently calculate the number of subarrays that have at most `k` odd numbers and leverages this to find the number of subarrays with exactly `k` odd numbers.
 */
