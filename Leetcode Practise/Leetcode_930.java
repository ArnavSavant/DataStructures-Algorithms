public class Leetcode_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal - 1);
    }

    private int atmost(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 0;
        while (j < nums.length) {
            sum = sum + nums[j];
            while (i <= j && sum > goal) {
                sum = sum - nums[i];
                i++;
            }
            count = count + (j - i + 1);

            j++;
        }
        return count;
    }
}
/*
 * Alright, let's dive deep into this concept with respect to the sliding window
 * technique in Data Structures and Algorithms.
 ** 
 * Sliding Window Technique:**
 * The sliding window technique is used to maintain a subarray or subrange of an
 * array, where the subarray is variable in length and "slides" across the main
 * array. This technique is highly efficient as it allows us to avoid
 * re-computation by just considering the change that happens with each slide
 * (i.e., a new element is included at the end, and an old one might be
 * discarded from the start).
 ** 
 * The Formula: exact(k) = atmost(k) - atmost(k-1)**
 * 
 * To understand the formula, let's first break down its components:
 * 
 * 1. **atmost(k)**: This represents the number of subarrays whose sum is less
 * than or equal to `k`.
 * 
 * 2. **atmost(k-1)**: This represents the number of subarrays whose sum is less
 * than or equal to `k-1`.
 * 
 * Now, the difference between these two, `exact(k)`, will give us the number of
 * subarrays whose sum is **exactly** `k`.
 ** 
 * Intuition with respect to Sliding Window:**
 * 
 * Imagine you are using the sliding window technique to compute `atmost(k)`:
 * 
 * 1. As you slide the window, you count every valid subarray ending at the
 * current position whose sum is less than or equal to `k`. Remember, there can
 * be multiple starting points for the window (all positions from `i` to `j`,
 * inclusive, where `i` is the start and `j` is the end of the current window)
 * that produce valid subarrays.
 * 
 * 2. Now, within these subarrays, some have a sum that is less than or equal to
 * `k-1`. If you find the difference between the total number of subarrays
 * ending at this position with a sum less than or equal to `k` and those with a
 * sum less than or equal to `k-1`, you get the subarrays ending at this
 * position with a sum of exactly `k`.
 * 
 * 3. This is the essence of the formula. With the sliding window, you are
 * efficiently computing these quantities, and the formula then extracts the
 * exact count from them.
 ** 
 * Example:**
 * 
 * Consider the array `[1, 2, 1, 1, 3]` and you want to find subarrays with a
 * sum exactly equal to `3`.
 * 
 * Using the sliding window approach,
 * - `atmost(3)` will consider subarrays like `[1], [2], [1, 2], [1], [2, 1],
 * [1, 1], [1, 1, 1], [3]` (8 subarrays).
 * - `atmost(2)` will consider `[1], [2], [1, 2], [1], [2, 1], [1, 1]` (6
 * subarrays).
 * 
 * So, `exact(3) = 8 - 6 = 2`, which corresponds to subarrays `[1, 1, 1]` and
 * `[3]`.
 * 
 * This example illustrates how the formula derives the correct count of
 * subarrays with a sum exactly equal to `k` by leveraging the efficiency of the
 * sliding window technique.
 */