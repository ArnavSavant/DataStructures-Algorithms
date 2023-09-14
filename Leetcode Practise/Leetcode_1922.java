public class Leetcode_1922 {
    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        long x = n / 2, y = n / 2;
        if (n % 2 == 1) {
            x = x + 1;
        }
        return (int) ((posPow(5, x) % 1000000007) * (posPow(4, y) % 1000000007) % 1000000007);
    }

    public long posPow(long x, long n) {
        if (n == 1) {
            return x % 1000000007;
        }
        return (n % 2 == 0 ? (posPow((x * x) % 1000000007, n / 2) % 1000000007)
                : (x * posPow(x % 1000000007, n - 1) % 1000000007));
    }
}
/*
Certainly! Let's start by understanding the problem context (which isn't provided, but I can infer from the code).

**Context**:
The problem likely concerns a number consisting of `n` digits. An even-positioned digit (0-based index) can be one of the numbers: 0, 2, 4, 6, or 8, while an odd-positioned digit can be one of the numbers: 0, 1, 3, 5, 7. We have to count the total number of "good" numbers, which are numbers following the above constraint.

### Logic and Intuition:

1. **Understanding Positional Constraints**:
   - Any digit at even positions (like 0th, 2nd, 4th...) can have 5 possible values (0, 2, 4, 6, 8).
   - Any digit at odd positions (like 1st, 3rd, 5th...) can have 4 possible values (0, 1, 3, 5, 7).

2. **Counting Possibilities**:
   - If there are `x` even positions, there are `5^x` possible values for those positions.
   - If there are `y` odd positions, there are `4^y` possible values for those positions.

3. **Total Good Numbers**: It's the product of the two possibilities, i.e., \(5^x \times 4^y\).

### Code Explanation:

1. **`countGoodNumbers` Function**:
   - It calculates the number of even (`x`) and odd (`y`) positions. Note that if `n` is odd, there will be one more even-positioned digit than odd. That's why there's a check on `n % 2`.
   - It then calculates \(5^x \times 4^y\) modulo `1e9 + 7` and returns it. Modulo is taken to avoid large number overflow.

2. **`posPow` Function** (Power Function with Modular Arithmetic):
   - It computes `x` raised to the power `n` modulo `1e9 + 7`. The function utilizes the property of modular arithmetic and binary exponentiation to compute power efficiently.
   - If `n` is even, \(x^n = (x^2)^{n/2}\). 
   - If `n` is odd, \(x^n = x \times x^{n-1}\).
   - Modulo is used at every step to ensure numbers don't overflow.

### Why This Code Works:
- The core logic is based on counting possibilities, which stems directly from combinatorics principles.
- Modular arithmetic ensures that we work within bounds of integers, avoiding overflow.
- The power function, `posPow`, is optimized using binary exponentiation, making it efficient. Instead of a linear approach to compute power, it breaks the problem down, reducing time complexity.

### Conclusion:
The code efficiently calculates the number of good numbers using principles of combinatorics and binary exponentiation. The modular arithmetic ensures that large numbers are handled effectively, giving the solution in a reasonable time frame.
 */
