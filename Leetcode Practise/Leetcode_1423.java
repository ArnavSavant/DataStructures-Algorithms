public class Leetcode_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int score = 0;
        if (k == n) {
            for (int i = 0; i < n; i++) {
                score = score + cardPoints[i];
            }
            return score;
        }
        int maxScore = Integer.MIN_VALUE;
        int i = n - k;
        int j = n - k;
        while (j < (n + k)) {
            score = score + cardPoints[j % n];
            if (j - i + 1 == k) {
                maxScore = Math.max(maxScore, score);
                score = score - cardPoints[i % n];
                i++;
            }
            j++;
        }
        return maxScore;
    }
}
/*
The given code is quite optimized for the problem it is designed to solve. Here are some points considering its optimization:

1. **Time Optimization**:
   - The code avoids unnecessary complexity by transforming the problem into a sliding window one, which can be solved in a single pass through the array. This results in \( O(n) \) time complexity, which is optimal since each element is considered exactly once.
   - The special case where `k == n` is handled upfront, which is a direct sum of the entire array and also takes \( O(n) \) time.

2. **Space Optimization**:
   - Space usage is minimized to \( O(1) \) as there are only a fixed number of variables being used, and there is no additional space being allocated based on the input size.

3. **Loop Efficiency**:
   - The while loop operates with a constant space complexity and iterates for `2k` steps, which is less than or equal to `2n`. Because of the circular nature of the problem (realized through the modulo operation), it can simulate the process of picking up cards from both ends without the need for complex operations.

4. **Modulo Operation**:
   - The use of the modulo operation is a neat trick that efficiently handles the circular condition, allowing the code to reuse the same indices to simulate the circular array.

5. **No Extra Data Structures**:
   - The algorithm does not use any extra data structures like lists or arrays that would increase the space complexity.

6. **Direct Computation**:
   - Instead of computing all possible combinations of card selections, which would be computationally expensive, the algorithm smartly computes the score of the non-selected cards, which is significantly more efficient and requires fewer operations.

### Potential Optimizations:

While the code is already efficient, in terms of both time and space complexity, there are some micro-optimizations that might be considered in specific contexts:

- **Avoiding Modulo Operations**: The modulo operation is more expensive than simple arithmetic operations. If the code is performance-critical, you could avoid modulo operations by manually handling the wrap-around logic.

- **Early Stopping**: If you find a situation where the maximum possible score is achieved (for instance, if all card points are positive and you've reached the sum of the largest `k` card points), you could break early from the loop. However, this situation is already covered by the special case check at the start of the function.

- **Inline Calculations**: The calculation `j - i + 1 == k` could be simplified by incrementing `j` and `i` first and then checking `j - i == k`.

Given the current state of the code, these optimizations are likely to offer only minimal improvements. The code as written is effectively optimized for the general case, providing an optimal solution with a minimal footprint.
 */