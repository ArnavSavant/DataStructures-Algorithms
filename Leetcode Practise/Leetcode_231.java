public class Leetcode_231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        return (n & (n - 1)) == 0 ? true : false;
    }
}
/*
Certainly! The given code is a function that checks if a given integer `n` is a power of two or not. Let's break down the logic and intuition behind the code:

### Intuition:

The fundamental intuition here is based on binary representation.

All powers of two, when represented in binary, have only a single '1' bit at the start. The rest are all '0's. Here are some examples:

```
2^0 = 1           -> 0001
2^1 = 2           -> 0010
2^2 = 4           -> 0100
2^3 = 8           -> 1000
...
```

Now, when you subtract 1 from any power of two, the binary representation flips all bits to the right of the most significant '1' bit:

```
1 - 1           -> 0000
2 - 1           -> 0001
4 - 1           -> 0011
8 - 1           -> 0111
...
```

### Logic:

1. `if (n == 0) return false;`: This line of code checks if the input number is zero. Zero is not a power of two, so the function returns `false` immediately.

2. `(n & (n - 1)) == 0`: This line applies a bitwise AND operation on `n` and `n - 1`. Given the intuition we discussed earlier, if `n` is a power of two, the result will be `0`. If it's not, the result will be a non-zero value.

To illustrate with an example, let's take `n = 8` (which is `2^3`):

```
n = 8       -> 1000
n - 1 = 7  -> 0111

1000        (Binary representation of 8)
&
0111        (Binary representation of 7)
----------
0000        (Result is 0)
```

### Why the code works:

Since all powers of two have only one '1' bit in their binary representation, and `(n-1)` flips all bits to the right of this '1', the bitwise AND operation between `n` and `n-1` will always result in `0` if `n` is a power of two. On the other hand, if `n` is not a power of two, there will be more than one '1' bit in the binary representation, ensuring that the bitwise AND operation between `n` and `n-1` will yield a non-zero value.

In conclusion, the given code utilizes binary representation properties to efficiently determine if an integer is a power of two or not.
 */