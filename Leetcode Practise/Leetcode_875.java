public class Leetcode_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        int k = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            int hours = hours(mid, piles);
            if (hours <= h) {
                k = Math.min(mid, k);
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return k;
    }
    public int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            max=Math.max(max, arr[i]);
        }
        return max;
    }
    public int hours(int x, int[] piles) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours = hours + (int) Math.ceil(1.0 * piles[i] / x);
        }
        return hours;
    }
}

/*
Certainly! This code is solving the problem of finding the minimum eating speed (K bananas per hour) to eat all bananas in `piles` within `h` hours.

Let's break it down step-by-step:

### Problem Description:
You are given `piles` of bananas where each pile contains some number of bananas. You can eat `K` bananas per hour. The task is to determine the minimum integer `K` such that you can eat all the bananas within `h` hours.

### Intuition:
The solution employs a binary search strategy over the possible values of K. Instead of testing each possible speed one-by-one, the binary search technique drastically reduces the number of tests needed. The range of possible speeds is [1, max(piles)], i.e., the slowest you can eat is 1 banana per hour, and the fastest is to eat the biggest pile in an hour.

### Code Explanation:

1. **findMax function**:
   - This function finds the maximum number of bananas in any pile. This gives the upper limit for the binary search.

2. **hours function**:
   - Given a speed `x` (bananas per hour), this function computes how many hours it would take to eat all the bananas in the `piles`.
   - For each pile, it calculates hours as `piles[i] / x`. Since it's not always an integer, we round up using `Math.ceil`. If a pile has 5 bananas and x is 3, you'll need 2 hours to finish it.

3. **minEatingSpeed function**:
   - This is where the main logic resides. We perform a binary search over the possible values of K (eating speeds).
   - `low` is initialized to 1 (slowest possible eating speed) and `high` is initialized to the maximum number of bananas in any pile (from the `findMax` function).
   - `k` is initialized to the maximum integer value. It will eventually store the result.
   - Within the `while` loop (the binary search loop):
      * `mid` represents a possible value of K (eating speed).
      * We calculate the total hours it would take to eat all the bananas at this speed using the `hours` function.
      * If `hours` is less than or equal to `h`, it means this speed or even slower can work. So, we update `k` with the minimum of the current `k` and `mid` and adjust `high` to search for a potentially smaller value of K.
      * If `hours` is greater than `h`, this speed is too slow, so we adjust `low` to search for a faster speed.
   - The loop continues until `low` exceeds `high`, at which point we have found our answer in `k`.

### Conclusion:
The strategy here is a classic application of binary search on the answer. Instead of the regular binary search where you're looking for a target in a sorted list, here you're determining the feasibility of a number (eating speed) against a certain condition (can eat all bananas in h hours).
 */
