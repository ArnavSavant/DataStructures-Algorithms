public class Leetcode_191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int rightMostSetBitMask = n & (-n);
            n = n - rightMostSetBitMask;
            count++;
        }
        return count;
    }
}
/*
 Alright! The given code is used to determine the number of '1' bits (also known as the Hamming weight) in the binary representation of an integer `n`. 

Let's break down the logic, intuition, and reason behind each step:

### Logic and Intuition:

1. **Goal**: Count the number of set bits (bits that are '1') in the binary representation of `n`.

2. **Two's Complement**: `-n` is the two's complement of `n`. In two's complement, the representation of a negative number is obtained by flipping all the bits of the positive number (0 becomes 1 and vice versa) and then adding 1 to the result. This means if `n` has a least significant bit of '1', `-n` will also have its least significant bit as '1', and all other bits till the first '0' in `n` will remain the same.

3. **Bitwise AND Operation**: The operation `(n & -n)` will result in a binary number that has only the rightmost set bit of `n` as '1' and all other bits as '0'. This is the `rightMostSetBitMask`.

4. **Resetting the Rightmost Set Bit**: When you subtract the `rightMostSetBitMask` from `n`, you're effectively turning off (or resetting) the rightmost '1' bit in `n`.

5. **Counting the Set Bits**: The loop will run for as many times as there are '1' bits in `n`. Each iteration, the rightmost '1' bit is identified and then reset, and `count` is incremented.

### Why it works:

1. **Rightmost Set Bit Identification**: As explained above, the operation `(n & -n)` will always yield a number that represents only the rightmost set bit of `n`.

2. **Efficiency**: Instead of checking every bit of the number (which would always be 32 iterations for a 32-bit integer), this code only runs as many iterations as there are set bits in the number. For a number with fewer set bits, this can be significantly faster.

3. **Loop Termination**: As we keep turning off the rightmost set bit in each iteration, `n` will eventually become 0, ensuring the loop terminates.

### Example:

Take `n = 13`, which is `1101` in binary.
- First iteration: 
  - `rightMostSetBitMask` = `1101 & 0011` = `0001`
  - `n` becomes `1100`
- Second iteration: 
  - `rightMostSetBitMask` = `1100 & 0100` = `0100`
  - `n` becomes `1000`
- Third iteration: 
  - `rightMostSetBitMask` = `1000 & 1000` = `1000`
  - `n` becomes `0000`
  
So, the `count` is 3, which is the number of '1' bits in the binary representation of 13.

### Conclusion:

The given code is a clever approach to efficiently determine the Hamming weight (number of '1' bits) of a number. It leverages properties of binary arithmetic and bitwise operations to pinpoint and count each '1' bit without having to inspect every single bit of the number.
 */
