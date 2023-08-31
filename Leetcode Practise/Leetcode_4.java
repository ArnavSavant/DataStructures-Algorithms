public class Leetcode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 < n2) {
            return findMedian(nums1, nums2);
        } else {
            return findMedian(nums2, nums1);
        }
    }

    public double findMedian(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int low = 0;
        int high = n1;
        int elementsOnLeft = (n + 1) / 2;
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        while (low <= high) {
            int mid1 = high - (high - low) / 2;
            int mid2 = elementsOnLeft - mid1;
            l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            r1 = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1];
            r2 = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2];
            if (l1 > r2) {
                high = mid1 - 1;
            } else if (l2 > r1) {
                low = mid1 + 1;
            } else {
                break;
            }
        }
        if (n % 2 == 0) {
            return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        } else {
            return Math.max(l1, l2);
        }
    }
}

/*
 This code snippet is a solution to the problem of finding the median of two sorted arrays. 

### **Understanding the Problem**:
Given two sorted arrays `nums1` and `nums2`, the task is to find the median element of the combined array without merging the two arrays. This problem can be solved in \(O(\log(\min(m, n)))\) time complexity, where `m` and `n` are the lengths of `nums1` and `nums2`, respectively.

### **Intuition**:
Instead of merging the arrays, we can partition both arrays such that:

1. The number of elements on the left side (combining both arrays) is equal to or one more than the number of elements on the right side.
2. If the largest element on the left side of the partition is less than or equal to the smallest element on the right side, we've found the correct partition.

The median is then:
1. The average of the maximum of the last elements of the left side and the minimum of the first elements of the right side if the combined length is even.
2. The maximum of the last elements of the left side if the combined length is odd.

### **How the Code Works**:

1. **findMedianSortedArrays**: It ensures that the binary search is always performed on the smaller array. This makes the solution more efficient since the complexity is based on the size of the smaller array.

2. **findMedian**: This method actually does the job of finding the median.

   - `elementsOnLeft`: Total elements required on the left side after partitioning the two arrays.
  
   - The binary search is performed on the smaller array (`nums1`). For every possible partition in `nums1`, the partition in `nums2` is `elementsOnLeft - mid1`.

   - `l1`, `l2` are the elements just before the partition on `nums1` and `nums2` respectively. `r1`, `r2` are the elements just after the partition on `nums1` and `nums2` respectively. Special checks ensure that if the partition is at the extreme end, the respective element is taken as Integer.MIN_VALUE or Integer.MAX_VALUE.
    
   - If `l1 > r2`, it means we need to move our binary search to the left of `nums1`, hence `high = mid1 - 1`.
    
   - If `l2 > r1`, it means we need to move our binary search to the right of `nums1`, hence `low = mid1 + 1`.

   - When we find the correct partition, if the total number of elements is even, we return the average of `Math.max(l1, l2)` and `Math.min(r1, r2)`. If odd, we return `Math.max(l1, l2)`.

### **Why This Works**:

Let's consider a partition on both arrays. The conditions we need to satisfy are:

1. The left side has as many or one more element than the right side.
2. Every element on the left side is less than or equal to every element on the right side.

By using binary search on the smaller array and deriving the partition on the larger array based on the first partition, we ensure that we are considering every possible partition across both arrays. When we find the correct partition, the aforementioned conditions will be satisfied. This ensures that we find the median in logarithmic time.

I hope this explanation elucidates the logic and reasoning behind the code!
 */
