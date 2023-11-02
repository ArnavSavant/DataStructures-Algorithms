public class Leetcode_1004 {
    public int longestOnes(int[] nums, int k) {
        int countOfZeros = 0;
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                countOfZeros++;
            }
            if (countOfZeros <= k) {
                ans = Math.max(ans, j - i + 1);
            } else {
                while (countOfZeros > k) {
                    if (nums[i] == 0) {
                        countOfZeros--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
/*
Ah, a fine piece of code you've presented here! It's a sliding window algorithm. Let's delve into it, shall we?

**Intuition and Logic:**
The code is trying to find the longest continuous subarray of 1s that can be obtained by at most flipping 'k' zeros. 

The key concept here is that if you are allowed to flip 'k' zeros to ones, then you are essentially looking for a window (i.e., a subarray) of numbers which has no more than 'k' zeros.

**How does the code do that?**
1. We maintain two pointers `i` and `j`, which initially point to the beginning of the array. `i` is the start of our window, and `j` is the end.
2. We expand our window to the right by incrementing `j` and counting the number of zeros we encounter.
3. If the count of zeros (`countOfZeros`) within our window (from `i` to `j`) is less than or equal to `k`, we calculate the length of the current window (`j - i + 1`) and update our answer (`ans`).
4. If `countOfZeros` exceeds `k`, we then need to shrink our window from the left by incrementing `i`. We keep shrinking until our window again contains no more than `k` zeros.
5. We repeat this process, expanding and shrinking our window, until `j` reaches the end of the array.

**Why does this work?**
The beauty of the sliding window is its ability to efficiently explore all potential subarrays. By maintaining a window of no more than `k` zeros, we ensure that within that window, we can always flip the zeros to ones, thus obtaining a subarray of pure ones. As we slide the window through the entire array, we can confidently say we've considered all possible subarrays that can be formed by flipping at most `k` zeros.

**Time Complexity:**
Although there are nested loops in the code, each element of the array is processed only twice at most (once by the outer loop and once by the inner loop). Therefore, the time complexity of the code is O(2n), which simplifies to O(n), where n is the length of the `nums` array.

In simpler terms, imagine there's a door that can only let one person in at a time. As one person enters (j moves right), another leaves (i moves right). Hence, the total number of operations are linear relative to the size of the array, making it O(n).
 */