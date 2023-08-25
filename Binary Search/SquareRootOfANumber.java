public class SquareRootOfANumber {
    public int find(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                high = mid -1;
            }
            else if(mid * mid < n) {
                low = mid + 1;
            }
        }
        return 1;
    }
}

/*
 The provided code is an implementation of a binary search algorithm to find the integer square root of a given number `n`. The integer square root of `n` is the largest integer whose square is less than or equal to `n`.

Let's break down the code and understand its logic and intuition.

### Goal:
Given an integer `n`, find its integer square root.

### Example:
For `n = 16`, the answer is `4` because 4^2 = 16.  
For `n = 8`, the answer is `2` because 3^2 = 9 which is greater than 8, and 2^2 = 4 is the largest square less than 8.

### Code Explanation:

1. **Initialization**:
    ```java
    int low = 1;
    int high = n;
    ```
    * `low` and `high` initialize the search space. At the beginning, `low` is 1 and `high` is the number `n` itself. This is because the integer square root of `n` is at least 1 and at most `n` (but typically much less than `n` unless `n` is 2 or 1).

2. **Binary Search**:
    ```java
    while (low <= high) {
        ...
    }
    ```
    The main logic of the function revolves around a binary search. Here's how the binary search works:

    * **Middle Element Calculation**:
        ```java
        int mid = high - (high - low) / 2;
        ```
        This line calculates the middle element of the current search space. This is a standard formula for binary search and ensures that we don't face overflow issues which might arise if we used `(high + low) / 2`.

    * **Check if `mid` is the square root**:
        ```java
        if (mid * mid == n) {
            return mid;
        }
        ```
        If the square of `mid` is equal to `n`, then `mid` is the integer square root of `n`.

    * **Move to the Left Half**:
        ```java
        else if (mid * mid > n) {
            high = mid -1;
        }
        ```
        If the square of `mid` is greater than `n`, it implies that our answer lies in the left half of our search space. So, we update the `high` pointer to `mid - 1`.

    * **Move to the Right Half**:
        ```java
        else if(mid * mid < n) {
            low = mid + 1;
        }
        ```
        If the square of `mid` is less than `n`, it implies that our answer lies in the right half of our search space. So, we update the `low` pointer to `mid + 1`.

3. **Return Default Value**:
    ```java
    return 1;
    ```
    If the loop exits without returning a value (i.e., there isn't an exact square root), it defaults to returning `1`. However, this is a bit misleading. It might make more sense to return `low - 1` which will be the largest integer whose square is less than `n`.

### Intuition:
The underlying intuition of the binary search approach is the monotonic property of the function: as numbers increase, their squares also increase. By using a binary search, we significantly reduce the number of calculations needed compared to a linear search. This optimization changes the complexity from O(n) in linear search to O(log n) in binary search.
 */
