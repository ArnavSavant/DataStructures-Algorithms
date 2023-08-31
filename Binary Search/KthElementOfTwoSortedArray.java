import java.util.ArrayList;

public class KthElementOfTwoSortedArray {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        if (n < m) {
            return findElement(arr1, arr2, k);
        } else {
            return findElement(arr2, arr1, k);
        }
    }

    public static int findElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int k) {
        int n1 = arr1.size();
        int n2 = arr2.size();
        int low = Math.max(k - n2, 0);
        int high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = high - (high - low) / 2;
            int mid2 = k - mid1;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : arr1.get(mid1 - 1);
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : arr2.get(mid2 - 1);
            int r1 = mid1 == n1 ? Integer.MAX_VALUE : arr1.get(mid1);
            int r2 = mid2 == n2 ? Integer.MAX_VALUE : arr2.get(mid2);

            if (l1 > r2) {
                high = mid1 - 1;
            } else if (l2 > r1) {
                low = mid1 + 1;
            } else {
                return Math.max(l1, l2);
            }
        }
        return -1;
    }
}

/*
Certainly! The code provided is an implementation for finding the kth element in two sorted arrays (`arr1` and `arr2`). Let's delve into its beauty step by step.

## Overview:

When dealing with two sorted arrays and the task of finding the kth element, a direct approach might involve merging the two arrays and then accessing the kth index. However, that's an O(n+m) operation. We can use the properties of sorted arrays and binary search to reduce the complexity.

## Intuition:

The idea is to partition the two arrays such that the total number of elements in the first half is k. Based on this partition, we can then infer the kth element by comparing the elements immediately before and after the partition.

## Function Explanation:

1. **kthElement Function**:

This function ensures that `arr1` is the smaller array. If `arr1` is not smaller, it swaps the arrays. This is to guarantee that our binary search is performed on the smaller array, which helps in reducing the search space and thus, time complexity.

2. **findElement Function**:

- `n1` and `n2` get the sizes of `arr1` and `arr2` respectively.
  
- `low` and `high` determine the possible range where our desired partition can be in `arr1`. Note that:
  - The minimum partition can be `k - n2` since, in the worst case, we might have to take almost all elements from `arr2`.
  - The maximum partition can be `k` since we can't have more than `k` elements in the first half of our merged array.

- The binary search proceeds as:

  1. `mid1` is the midpoint of the current search range in `arr1`. `mid2` represents how many elements we would then need from `arr2` to make the total count `k`.

  2. We then determine the elements just before (`l1` and `l2`) and just after (`r1` and `r2`) our current partition.

  3. Now, the conditions:
     - If `l1` > `r2`: This means the current partition in `arr1` is too far right, and we need to move left.
     - If `l2` > `r1`: This means the current partition in `arr1` is too far left, and we need to move right.
     - Otherwise, we've found a correct partition. The kth element, in the merged view of the arrays, would be the greater of `l1` and `l2`.

  4. If the binary search exits without finding the element, we return `-1`, indicating an error (though in a properly posed problem this shouldn't happen).

## Logic and Intuition Behind The Binary Search:

Remember, we're trying to find the partition such that we have `k` elements in total on the left side of both arrays combined. If you find such a partition, the kth element will be the larger of the two elements immediately preceding the partition from both arrays.

The conditions within the binary search (i.e., `l1 > r2` and `l2 > r1`) help navigate the search space. The beauty of this approach is that it only needs to "focus" on one array (`arr1`, the smaller one) to determine the kth element. By checking if an element in `arr1` is greater than an element in `arr2`, we can determine if our current partition has too many elements from `arr1` or too few.

In essence, this is a masterful way of leveraging the properties of sorted arrays and binary search to efficiently determine the kth element in two sorted arrays.
 */
