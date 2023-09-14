public class Leetcode_50 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return myPow(x * x, Integer.MIN_VALUE / 2);
        }
        if (n > 0) {
            return Pow(x, n);
        } else {
            return 1 / Pow(x, n * -1);
        }
    }

    public double Pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        return (n % 2 == 0) ? Pow(x * x, n / 2) : x * Pow(x, n - 1);
    }
}
/*
This code represents an algorithm to calculate the power of a number using the "divide and conquer" strategy, which is a technique often employed in algorithms to break problems into smaller subproblems until they become simple enough to solve directly. The function `myPow(x, n)` is designed to compute \( x^n \).

Let's break down the logic and intuition:

### Intuition:
The basic idea is to reduce the number of multiplications needed to find \( x^n \). Instead of multiplying `x` by itself `n` times, the algorithm efficiently reduces the multiplications by repeatedly squaring.

For instance:
- \( x^4 \) is \( x \times x \times x \times x \)
- But, \( x^4 \) is also \( (x^2) \times (x^2) \)

The latter requires fewer multiplications. This algorithm leverages this idea for all powers.

### `myPow` function:

1. **Base Cases**:
    - If \( n = 0 \) or \( x = 1 \), the result is 1 because any number to the power of 0 is 1, and 1 to the power of any number is 1.
    - If \( n \) is `Integer.MIN_VALUE` (the smallest 32-bit integer, which has a special consideration because its positive counterpart exceeds the 32-bit integer range), we modify the base and halve the power to avoid numeric overflow.
  
2. **Recursive Case**:
    - If \( n > 0 \), the function uses the helper function `Pow` to compute \( x^n \).
    - If \( n < 0 \), it computes the inverse of \( x^{-n} \) using the helper function `Pow`. This is based on the property \( x^{-n} = \frac{1}{x^n} \).

### `Pow` function:

1. **Base Case**:
    - If \( n = 1 \), it simply returns \( x \).
  
2. **Recursive Cases**:
    - If \( n \) is even, it computes \( x^n \) as \( (x^2)^{\frac{n}{2}} \). This reduces the number of multiplications, as explained in the intuition.
    - If \( n \) is odd, it computes \( x^n \) as \( x \times x^{n-1} \).

### Why it works:
1. **Efficiency**: By dividing the power by 2 at each step, the total number of recursive calls is reduced drastically, making the algorithm log(n) in terms of complexity.
  
2. **Handling of Negatives**: The function effectively handles negative powers by computing the positive power first and then taking its reciprocal.
  
3. **Handling Edge Cases**: The special condition for `Integer.MIN_VALUE` ensures there's no numeric overflow, as directly negating it would exceed the range of 32-bit integers.

4. **Versatility**: This recursive approach can handle both fractional and whole values of `x`, as well as both positive and negative values of `n`.

In summary, this divide and conquer algorithm efficiently calculates powers by breaking them down into smaller powers and reusing results, thus performing fewer multiplications and speeding up the calculation.
 */
