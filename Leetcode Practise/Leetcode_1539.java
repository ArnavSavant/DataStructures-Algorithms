public class Leetcode_1539 {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = high - (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // int more = k - (arr[high] - (high + 1));
        // int ans = arr[high] + more;
        int ans = k + high +1;
        return ans;
    }
}

/*
 Alright, let's break down the given code. It appears to find the \(k^{th}\) smallest positive integer that is missing from the given array `arr`:

```java
public int findKthPositive(int[] arr, int k) {
    ...
}
```

To understand the logic behind this code, let's start with the fundamental idea. Given an array of unique positive integers, we know that if there are no missing numbers, then at index \(i\) (0-based index), the number should be \(i+1\). If there's a gap between the actual number in the array and what should have been there, we can determine the number of missing elements.

Let's break down the code:

1. **Binary Search Initialization**:

```java
int low = 0;
int high = arr.length - 1;
```

Here, `low` and `high` are pointers for binary search. The array `arr` is assumed to be sorted.

2. **Binary Search**:

```java
while (low <= high) {
    int mid = high - (high - low) / 2;  // Finds the middle index
    int missing = arr[mid] - (mid + 1); // Calculates the number of missing integers before arr[mid]
    if (missing < k) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}
```

- The condition `low <= high` ensures that the binary search continues until the pointers cross.
- We calculate the middle index using `mid = high - (high - low) / 2`, which is equivalent to `(low + high) / 2`.
- The expression `arr[mid] - (mid + 1)` calculates the number of positive integers missing before `arr[mid]`. If no numbers were missing, `arr[mid]` would have been equal to `mid + 1`. The difference between them gives the number of missing numbers.
  
  For example, if `arr[mid] = 5` and `mid = 2`, then there are `5 - (2 + 1) = 2` numbers missing before 5 (which are 3 and 4 in this case).
  
- The comparison `missing < k` checks if the number of missing numbers is less than \(k\). If it's less, then the \(k^{th}\) missing number is somewhere to the right in the array. Otherwise, the \(k^{th}\) missing number is to the left.

3. **Finding the kth missing number**:

```java
int ans = k + high +1;
return ans;
```

After the binary search, the `high` pointer would have landed on the last position where the number of missing elements is less than \(k\). To find the exact \(k^{th}\) missing number:

- Add the number of missing elements until that point (`high`).
- Add \(k\) to it.

This is because `arr[high] - (high + 1)` gives us the number of missing numbers before `arr[high]`. Let's say this value is `m`, and you need the \(k^{th}\) missing number where \(k > m\). Then the \(k^{th}\) missing number is \(k - m\) numbers ahead of `arr[high]`.

The answer will be `arr[high] + (k - m)`.

Now, let's understand `k + high +1`:

- \(k\): The \(k^{th}\) missing number.
- `high`: The number of elements in the array until `high` index.
- \(+1\): Since `high` is the last position where the number of missing elements is less than \(k\), we need to consider one extra position for the first missing number after `arr[high]`.

Hence, the \(k^{th}\) missing number is \(k + high +1\).

In summary, this code employs binary search to efficiently locate the \(k^{th}\) smallest positive integer that is missing from the given sorted array `arr`.
 */